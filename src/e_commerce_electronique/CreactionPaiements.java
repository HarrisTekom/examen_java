package e_commerce_electronique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreactionPaiements {
	public static void main(String[] args) {

        System.out.println("******** Récupération des paiements ********");
        System.out.println("Connexion à la base e_commerce_electroniquedb");

        String url = "jdbc:mysql://localhost:3306/e_commerce_electroniquedb?useSSL=false&serverTimezone=UTC";
        String login = "root";
        String passwd = "T1ekom123@/."; 

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        List<Paiements> listePaiements = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver chargé");

            cn = DriverManager.getConnection(url, login, passwd);
            System.out.println("✓ Connexion établie");

            st = cn.createStatement();

            String sql = "SELECT * FROM paiements";   // nom exact de ta table
            System.out.println("✓ Requête exécutée : " + sql);

            rs = st.executeQuery(sql);

            System.out.println("\n----------- Récupération des données PAIEMENTS -----------");

            while (rs.next()) {
                // Attention : utilise exactement les noms de colonnes de ta table
                Paiements P = new Paiements(
                        rs.getInt("id_paiement"),
                        rs.getDate("date_paiement"),
                        rs.getString("statut_paiement"),
                        rs.getDouble("montant_paye"),
                        rs.getString("mode_paiement"),
                        rs.getInt("id_commande")
                );

                listePaiements.add(P);
                System.out.println(P);
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

        System.out.println("\n******** Fin du programme PAIEMENTS ********");
		System.out.println("Nombre de paiements dans la liste : " + listePaiements.size());
        for (Paiements p : listePaiements) {
            System.out.println(p);
        }
    }

}
