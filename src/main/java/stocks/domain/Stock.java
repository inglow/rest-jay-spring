package stocks.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Produit> produits = new ArrayList<Produit>();
	public Stock(ArrayList<Produit> produits) {
		super();
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Stock [produits=" + produits + ", getProduits()=" + getProduits() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

}
