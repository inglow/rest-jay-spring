package stocks.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produit  {
	
	/**
	 * 
	 */
	@JsonIgnore
	Stock stock;
	String nom;
	int qte;
	ProduitCategorie produitCategorie;
	public Produit() {
		super();
	}
	public Produit(int qte, String nom) {
		super();
		this.qte = qte;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public ProduitCategorie getProduitCategorie() {
		return produitCategorie;
	}
	public void setProduitCategorie(ProduitCategorie produitCategorie) {
		this.produitCategorie = produitCategorie;
	}
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public void addProduitCategorie(String nom, String libelle) {
		new ProduitCategorie(libelle, nom);
	}

	


	
	

}
