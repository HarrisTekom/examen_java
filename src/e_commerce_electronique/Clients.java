package e_commerce_electronique;

import java.sql.Date;

public class Clients {
	int id_client;
	String nom_client;
	String prenom_client;
	String email_client;
	String telephone_client;
	Date date_inscription_client;
	String adresse;
	String ville;
	String region;
	String statut_client;
	public Clients(int id_client, String nom_client, String prenom_client, String email_client, String telephone_client,
			Date date_inscription_client, String adresse, String ville, String region, String statut_client) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.email_client = email_client;
		this.telephone_client = telephone_client;
		this.date_inscription_client = date_inscription_client;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.statut_client = statut_client;
	}
	@Override
	public String toString() {
		return "Clients [id_client=" + id_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client
				+ ", email_client=" + email_client + ", telephone_client=" + telephone_client
				+ ", date_inscription_client=" + date_inscription_client + ", adresse=" + adresse + ", ville=" + ville
				+ ", region=" + region + ", statut_client=" + statut_client + "]";
	}
	
	
}
