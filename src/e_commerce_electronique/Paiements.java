package e_commerce_electronique;

import java.sql.Date;

public class Paiements {
	int id_paiement;
    Date date_paiement;
    String statut_paiement;
    double montat_paye;
    String mode_paiement;
    int id_commande;
	public Paiements(int id_paiement, Date date_paiement, String statut_paiement, double montat_paye,
			String mode_paiement, int id_commande) {
		super();
		this.id_paiement = id_paiement;
		this.date_paiement = date_paiement;
		this.statut_paiement = statut_paiement;
		this.montat_paye = montat_paye;
		this.mode_paiement = mode_paiement;
		this.id_commande = id_commande;
	}
	@Override
	public String toString() {
		return "Paiements [id_paiement=" + id_paiement + ", date_paiement=" + date_paiement + ", statut_paiement="
				+ statut_paiement + ", montat_paye=" + montat_paye + ", mode_paiement=" + mode_paiement
				+ ", id_commande=" + id_commande + "]";
	}
    
}
