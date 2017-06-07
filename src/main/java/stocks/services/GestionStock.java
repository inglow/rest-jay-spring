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
import stocks.web.UnStock;
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GestionStock  {
	List<Stock> stocks = new ArrayList<Stock>();
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation =
            (MongoOperations) ctx.getBean("mongoTemplate");
	public void creerStock(int j, int nombreProduits, String nom){
		System.out.println("bob");
		ArrayList<Produit> produits = new ArrayList<Produit>();
		
		Stock stock = new Stock(produits);
		for(int i=0; i<3; i++){
			System.out.println(nom+"dddddddddddddd");
			Produit produit = new Produit();
			produit.setQte(j);
			produit.setNom("object2");
			produits.add(produit);
			produit.addProduitCategorie(nom, "test");
			produit.setStock(stock);
			mongoOperation.save(produit);
		}
		stock.setProduits(produits);
		
		
		
		stocks.add(stock);
		
		
	}
	public void createStock(UnStock produits) {
		for (Produit produit : produits.getProduits()) {
			// personService.save(person);
			System.out.println(produit.getProduitCategorie());
			System.out.println("je suis la");
			mongoOperation.save(produit);
			mongoOperation.save(produit.getProduitCategorie());

		}
	}

	public List<Stock> listerStocks() {
		return stocks;
	}



}
