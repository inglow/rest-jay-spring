package stocks.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import stocks.SpringMongoConfig;
import stocks.domain.Produit;
import stocks.domain.ProduitRepository;
import stocks.domain.Stock;
import stocks.web.UnStock;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GestionStock {
	List<UnStock> stocks = new ArrayList<UnStock>();
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	public String createStock(int id, int qte, String nom) {
		/*
		 * for (Produit produit : produits.getProduits()) { //
		 * personService.save(person);
		 * System.out.println(produit.getProduitCategorie());
		 * System.out.println("je suis la"); mongoOperation.save(produit);
		 * 
		 * }
		 */

		UnStock stock = new UnStock();
		stock.setNom(nom);
		stock.setId(id);
		stock.setQte(qte);
		mongoOperation.save(stock);
		return "Le stock a été crée";

	}

	public List<UnStock> listerStocks() {
		DBCursor cursor = mongoOperation.getCollection("produit").find();

		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			System.out.println(obj.get("nom"));
			UnStock unStock = new UnStock();
			unStock.setNom((String) obj.get("nom"));
			unStock.setQte((int) obj.get("qte"));

			stocks.add(unStock);
			// do your thing
		}
		return stocks;
	}

}
