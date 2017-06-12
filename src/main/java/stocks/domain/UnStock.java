package stocks.domain;

import java.io.Serializable;
import java.util.List;

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
