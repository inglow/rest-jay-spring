package stocks.web;

import java.io.Serializable;
import java.util.List;

import stocks.domain.Produit;

public class UnStock {

	/**
	 * 
	 */

	int qte;
	int id;
	String nom;
	public UnStock() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

}
