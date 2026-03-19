package e_commerce_electronique;

import java.sql.Date;

public class Commandes {
		int id_commande;
	    Date date_commande;
	    String statut_commande;
	    double montat_total;
	    String mode_commande;
	    int id_client;
		public Commandes(int id_commande, Date date_commande, String statut_commande, double montat_total,
				String mode_commande, int id_client) {
			super();
			this.id_commande = id_commande;
			this.date_commande = date_commande;
			this.statut_commande = statut_commande;
			this.montat_total = montat_total;
			this.mode_commande = mode_commande;
			this.id_client = id_client;
		}
		@Override
		public String toString() {
			return "Commandes [id_commande=" + id_commande + ", date_commande=" + date_commande + ", statut_commande="
					+ statut_commande + ", montat_total=" + montat_total + ", mode_commande=" + mode_commande
					+ ", id_client=" + id_client + "]";
		}
	    
	    
}
