package e_commerce_electronique;
    
public class Produits {
	    int id_produit;
	    String nom_produit;
	    String description_produit;
	    double prix;
	    int stock_disponible;
	    int id_fournisseur;
	    
	    public Produits(int id_produit, String nom_produit, String description_produit, double prix, int stock_disponible, int id_fournisseur) {
	        this.id_produit = id_produit;
	        this.nom_produit = nom_produit;
	        this.description_produit = description_produit;
	        this.prix = prix;
	        this.stock_disponible = stock_disponible;
	        this.id_fournisseur = id_fournisseur;
	    }

	    @Override
	    public String toString() {
	        return "Produits{" +
	                "id_produit=" + id_produit +
	                ", nom_produit='" + nom_produit + '\'' +
	                ", description_produit='" + description_produit + '\'' +
	                ", prix=" + prix +
	                ", stock_disponible=" + stock_disponible +
	                ", id_fournisseur=" + id_fournisseur +
	                '}';
	    }
}
