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
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GestionProduit  {
	List<Produit> produits = new ArrayList<Produit>();
	ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation =
            (MongoOperations) ctx.getBean("mongoTemplate");
	

	public void creerProduit(int qte, String nom){
		System.out.println("bob");
		
		
		
		Produit produit = new Produit();
			System.out.println(nom+"dddddddddddddd");
			produit.setNom(nom);
			produit.setNom(nom);
			produit.setQte(qte);
			mongoOperation.save(produit);		
	}
	public List<Produit>listerProduit(){
		System.out.println("bob");
		
	
			
			DBCursor cursor = mongoOperation.getCollection("produit").find();
			while (cursor.hasNext()) {
			   DBObject obj = cursor.next();
			   System.out.println(obj.get("nom"));
			   Produit produit = new Produit();
			   produit.setNom((String) obj.get("nom"));
			   produit.setQte((int) obj.get("qte"));
			   produits.add(produit);
			   //do your thing
			}
			return produits;
	}

	



}
