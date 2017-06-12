package stocks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProduitCategorie {
	
	
	String libelle;
	String nom;
	
	

	public ProduitCategorie() {
		super();
		this.libelle = libelle;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "ProduitCategorie [libelle=" + libelle + ", nom=" + nom + "]";
	}
	
	

}
