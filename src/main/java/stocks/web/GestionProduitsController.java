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

	@RequestMapping(value = "/produit", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void creeProduit(@RequestBody Produit produit) {
		gestionProduit.creerProduit(produit.getQte(), produit.getNom(),produit.getProduitCategorie(),produit.getIdStock());
	}
	

	@RequestMapping(value = "/produit/{stockId}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Produit listerProduit(@PathVariable("stockId") int stockId) {
		System.out.println(stockId+"ididididiididid");
		return gestionProduit.listerProduit(stockId);

	}
	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Produit> listerProduits() {
		return gestionProduit.listerProduits();

	}


	
}
