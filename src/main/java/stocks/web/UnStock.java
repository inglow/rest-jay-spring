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

	public UnStock() {
		super();
	}

	public int getId() {
		return id;
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
