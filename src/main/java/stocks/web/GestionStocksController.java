package stocks.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
public class GestionStocksController {
	
	GestionStock gestionStock = new GestionStock();
	GestionProduit gestionProduit = new GestionProduit();
	@RequestMapping(value="/produit", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void creeProduit(@RequestBody Produit produit){
		gestionProduit.creerProduit(produit.getQte(), produit.getNom());
	}
	
	@RequestMapping(value="/stocks", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Stock> listerStocks(){		
		return gestionStock.listerStocks();
	}
	@RequestMapping(value="/produits", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Produit> listerProduits (){		
		return gestionProduit.listerProduit();
		
	}
	@RequestMapping(value="/stocks", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void creerStock(@RequestBody UnStock unStock){
		gestionStock.creerStock(unStock.getQte(),unStock.getQte(), unStock.getNom());
	}
}
