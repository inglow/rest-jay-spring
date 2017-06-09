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



	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UnStock> listerStocks() {
		return gestionStock.listerStocks();
	}


	@RequestMapping(value = "/stocks", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String creeStock(@RequestBody UnStock produit) {
		return gestionStock.createStock(produit.getId(),produit.getQte(),produit.getNom());
             
	}

	
}
