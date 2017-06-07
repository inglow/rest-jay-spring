package stocks.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Stock{


	ArrayList<Produit> produits = new ArrayList<Produit>();
	public Stock(ArrayList<Produit> produits) {
		super();
		this.produits = produits;
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

}
