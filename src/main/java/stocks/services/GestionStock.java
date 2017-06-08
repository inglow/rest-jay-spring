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
public class GestionStock  {
	List<UnStock> unStock = new ArrayList<UnStock>();
	List<Stock> stocks =new ArrayList<Stock>();
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation =
            (MongoOperations) ctx.getBean("mongoTemplate");

	public String createStock(int id, int qte,String nom) {
	/*	for (Produit produit : produits.getProduits()) {
			// personService.save(person);
			System.out.println(produit.getProduitCategorie());
			System.out.println("je suis la");
			mongoOperation.save(produit);
			
		}
		*/
		
		
			UnStock stock = new UnStock();
			stock.setNom(nom);
			stock.setId(id);
			stock.setQte(qte);
			mongoOperation.save(stock);
			return "Le produit a déja été crée";
		
	}

	public List<Stock> listerStocks() {
return stocks;
	}



}
