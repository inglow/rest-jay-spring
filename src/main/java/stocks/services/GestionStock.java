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

import stocks.SpringMongoConfig;
import stocks.domain.Produit;
import stocks.domain.ProduitRepository;
import stocks.domain.Stock;
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GestionStock  {
	@Autowired ProduitRepository repository2;
	List<Stock> stocks = new ArrayList<Stock>();
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation =
            (MongoOperations) ctx.getBean("mongoTemplate");
	public void creerStock(int j, int nombreProduits){
		System.out.println("bob");
		ArrayList<Produit> produits = new ArrayList<Produit>();
		
		Stock stock = new Stock();
		for(int i=0; i<nombreProduits; i++){
			Produit produit = new Produit(j); 

			produits.add(produit);			
			produit.setStock(stock);
			mongoOperation.save(new Produit(4));
		}
		stock.setProduits(produits);
		
		
		
		stocks.add(stock);
		
		
	}

	public List<Stock> listerStocks() {
		return stocks;
	}



}
