package e_commerce_electronique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;   // <-- à ajouter
import java.util.List;       // <-- optionnel mais propre

public class CreactionProduit {

	public static void main(String[] args) {

        System.out.println("******** Récupération des produits ********");
        System.out.println("Connexion à la base e_commerce_electroniquedb");

        String url = "jdbc:mysql://localhost:3306/e_commerce_electroniquedb?useSSL=false&serverTimezone=UTC";
        String login = "root";
        String passwd = "T1ekom123@/."; 

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        List<Produits> listeProduits = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver chargé");

            cn = DriverManager.getConnection(url, login, passwd);
            System.out.println("✓ Connexion établie");

            st = cn.createStatement();

            String sql = "SELECT * FROM produits";   // nom exact de ta table
            System.out.println("✓ Requête exécutée : " + sql);

            rs = st.executeQuery(sql);

            System.out.println("\n----------- Récupération des données PRODUITS -----------");

            while (rs.next()) {
                // Attention : utilise exactement les noms de colonnes de ta table
                Produits p = new Produits(
                        rs.getInt("id_produit"),
                        rs.getString("nom_produit"),
                        rs.getString("description_produit"),
                        rs.getDouble("prix"),
                        rs.getInt("stock_disponible"),
                        rs.getInt("id_fournisseur")
                );

                listeProduits.add(p);
                System.out.println(p);
                System.out.println("********* ");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Driver MySQL non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
                System.out.println("✓ Ressources fermées");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n******** Fin du programme PRODUITS ********");
        System.out.println("Nombre de produits dans la liste : " + listeProduits.size());
        for (Produits p : listeProduits) {
            System.out.println(p);
        }
    }
}
