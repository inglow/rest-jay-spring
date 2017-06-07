package stocks.web;

import java.io.Serializable;
import java.util.List;

import stocks.domain.Produit;

public class UnStock  {

	/**
	 * 
	 */
	int nombreProduits;
	int qte;
	private List<Produit> produits;
	String nom;

	public UnStock() {
		super();
	}

	public UnStock(int qte, int nombreProduits, String nom) {
		super();
		this.qte = qte;
		this.nombreProduits = nombreProduits;
		this.nom = nom;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreProduits() {
		return nombreProduits;
	}

	public void setNombreProduits(int nombreProduits) {
		this.nombreProduits = nombreProduits;
	}

}
