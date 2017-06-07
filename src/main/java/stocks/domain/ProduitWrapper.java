package stocks.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProduitWrapper {

    private List<Produit> produits;

    /**
     * @return the persons
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * @param persons the persons to set
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}