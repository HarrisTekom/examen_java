package e_commerce_electronique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;   // <-- à ajouter
import java.util.List;       // <-- optionnel mais propre

public class CreationClients {

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

        // Liste pour stocker tous les clients
        List<Clients> listeClients = new ArrayList<>();

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
            String sql = "SELECT * FROM clients"; // On récupère la table client
            System.out.println("✓ Requête exécutée : " + sql);

            rs = st.executeQuery(sql);

            // Étape 5 : Parcours du ResultSet
            System.out.println("\n----------- Récupération des données -----------");

            while (rs.next()) {
                Clients monclient = new Clients(
                		rs.getInt("id_client"),
                		rs.getString("nom_client"),
                        rs.getString("prenom_client"),
                        rs.getString("email_client"),
                        rs.getString("telephone_client"),
                		rs.getDate("date_inscription_client"),
                		rs.getString("adresse"),
                		rs.getString("ville"),
                		rs.getString("region"),
                		rs.getString("statut_client")
                );

                // On l'ajoute à la liste
                listeClients.add(monclient);

                // Affichage immédiat (optionnel)
                System.out.println(monclient);
                System.out.println("********* ");
            }

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

        System.out.println("\n******** Fin du programme : la base de donnée est fermée ********");

        // Exemple : afficher tous les clients depuis l'ArrayList
        System.out.println("Nombre de clients dans la liste : " + listeClients.size());
        for (Clients c : listeClients) {
            System.out.println(c);
        }
    }
}
