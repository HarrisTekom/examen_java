package e_commerce_electronique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;   // <-- à ajouter
import java.util.List;       // <-- optionnel mais propre

public class CreactionCommandes {

	public static void main(String[] args) {

        System.out.println("******** Récupération des commandes ********");
        System.out.println("Connexion à la base e_commerce_electroniquedb");

        String url = "jdbc:mysql://localhost:3306/e_commerce_electroniquedb?useSSL=false&serverTimezone=UTC";
        String login = "root";
        String passwd = "T1ekom123@/."; 

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        List<Commandes> listeCommandes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver chargé");

            cn = DriverManager.getConnection(url, login, passwd);
            System.out.println("✓ Connexion établie");

            st = cn.createStatement();

            String sql = "SELECT * FROM commandes";   // nom exact de ta table
            System.out.println("✓ Requête exécutée : " + sql);

            rs = st.executeQuery(sql);

            System.out.println("\n----------- Récupération des données COMMANDES -----------");

            while (rs.next()) {
                // Attention : utilise exactement les noms de colonnes de ta table
                Commandes C = new Commandes(
                        rs.getInt("id_commande"),
                        rs.getDate("date_commande"),
                        rs.getString("statut_commande"),
                        rs.getDouble("montant_total"),
                        rs.getString("mode_commande"),
                        rs.getInt("id_client")
                );

                listeCommandes.add(C);
                System.out.println(C);
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

        System.out.println("\n******** Fin du programme COMMANDES ********");
		System.out.println("Nombre de commandes dans la liste : " + listeCommandes.size());
        for (Commandes C : listeCommandes) {
            System.out.println(C);
        }
    }
}
