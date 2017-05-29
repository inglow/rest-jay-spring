package stocks.web;

public class UnStock {
	
	int typeProduit;
	int nombreProduits;
	
	public UnStock() {
		super();
	}

	public UnStock(int typeProduit, int nombreProduits) {
		super();
		this.typeProduit = typeProduit;
		this.nombreProduits = nombreProduits;
	}

	public int getTypeProduit() {
		return typeProduit;
	}
	
	public void setTypeProduit(int typeProduit) {
		this.typeProduit = typeProduit;
	}
	
	public int getNombreProduits() {
		return nombreProduits;
	}
	
	public void setNombreProduits(int nombreProduits) {
		this.nombreProduits = nombreProduits;
	}
	
	

}
