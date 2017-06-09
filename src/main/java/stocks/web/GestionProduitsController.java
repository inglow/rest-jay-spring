package stocks.web;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import stocks.services.GestionProduit;
import stocks.services.GestionStock;
import stocks.domain.Produit;
import stocks.domain.Stock;

@Controller
public class GestionProduitsController {

	GestionProduit gestionProduit = new GestionProduit();
	@ResponseBody
	@RequestMapping(value = "/produit", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String creeProduit(@RequestBody Produit produit) {
		return gestionProduit.creerProduit(produit.getQte(), produit.getNom(),produit.getProduitCategorie(),produit.getIdStock());
	}
	

	@RequestMapping(value = "/produit/stock/{stockId}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Produit listerProduitStock(@PathVariable("stockId") int stockId) {
		return gestionProduit.listerProduit(stockId);

	}
	@RequestMapping(value = "/produit/id/{nom}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Produit listerProduitId(@PathVariable("nom") String id) {
		return gestionProduit.listerProduitbyId(id);

	}
	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Produit> listerProduits() {
		return gestionProduit.listerProduits();

	}


	
}
