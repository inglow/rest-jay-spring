package stocks;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import stocks.domain.User;
import stocks.services.GestionStock;


public class Main {
	
	public static void main(String[] args) {

		GestionStock gestionStock = new GestionStock();
		int typeProduit = 1;
		int nombreProduits = 5;
		gestionStock.creerStock(typeProduit, nombreProduits);
		
	}

}
