package e_commerce_electronique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnexion {

public static void main(String[] args) {
        
        System.out.println("******** Récupération des données de la base MySQL ********");
        System.out.println("Connexion à la base e_commerce_electroniquedb");
        
        // À MODIFIER avec vos paramètres
        String url = "jdbc:mysql://localhost:3306/e_commerce_electroniquedb?useSSL=false&serverTimezone=UTC";
        String login = "root";
        String passwd = "T1ekom123@/."; // Mon mot de passe
        
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            // Étape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver chargé");
            
            // Étape 2 : Récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);
            System.out.println("✓ Connexion établie");
            
            // Étape 3 : Création d'un statement
            st = cn.createStatement();
            
            // Étape 4 : Exécution de la requête
            String sql = "SELECT * FROM PRODUITS"; // On récupère la table PRODUITS
            // String sql = "SELECT nom_produit FROM PRODUITS";  // on récupère uniquement le nom des produits
            System.out.println("✓ Requête exécutée : " + sql);
            
            rs = st.executeQuery(sql);
            
            // Étape 5 : Parcours du ResultSet
            System.out.println("\n----------- Récupération des données -----------");
            
            //int compteur = 0;
            while (rs.next()) {
            	//  compteur++;
            	   System.out.println("ID Produit : " + rs.getInt("id_produit"));
            	   System.out.println("Nom : " + rs.getString("nom_produit"));
            	   System.out.println("Catégorie : " + rs.getString("categorie_produit"));
            	   System.out.println("Prix : " + rs.getDouble("prix") + " €");
            	   System.out.println("Stock : " + rs.getInt("stock_disponible"));
            	   //String nomProduit = rs.getString("nom_produit");
            	   //System.out.println(compteur + ". " + nomProduit);
            	   
            }
            // System.out.println("----------------------------------------");
            // System.out.println("Total : " + compteur + " produit(s) trouvé(s)");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Driver MySQL non trouvé !");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Étape 6 : Fermeture des ressources (important !)
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
                System.out.println("✓ Ressources fermées");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n******** Fin du programme ********");
    }

}
