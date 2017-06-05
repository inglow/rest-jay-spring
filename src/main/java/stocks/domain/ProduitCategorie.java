package stocks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProduitCategorie {
	
	@JsonIgnore
	String libelle;
	String nom;

	public ProduitCategorie(String libelle, String nom) {
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

	public void setTypeLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
