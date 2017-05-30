package stocks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produit {
	
	@JsonIgnore
	Stock stock;
	int typeProduit;

	public Produit(int typeProduit) {
		super();
		this.typeProduit = typeProduit;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public int getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(int typeProduit) {
		this.typeProduit = typeProduit;
	}
	
	

}
