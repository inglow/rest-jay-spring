package stocks.domain;

import java.util.ArrayList;
import java.util.List;

public class UneVente{


	int prix;
	String client;
	
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	ArrayList<Produit> produits = new ArrayList<Produit>();
	public UneVente() {
		super();
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produitList) {
		this.produits = produitList;
	}


}
