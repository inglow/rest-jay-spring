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
import stocks.services.GestionVente;
import stocks.domain.Produit;
import stocks.domain.Stock;
import stocks.domain.UnStock;
import stocks.domain.UneVente;

@Controller
public class GestionVentesController {

	GestionVente gestionVente = new GestionVente();



	@RequestMapping(value = "/ventes", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UnStock> listerStocks() {
		return gestionVente.listerStocks();
	}


	@RequestMapping(value = "/ventes", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String creeStock(@RequestBody UneVente produit) {
		System.out.println(produit);
	return gestionVente.succeedVente(produit);
	
	}

	
}
