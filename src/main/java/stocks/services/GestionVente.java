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
import stocks.domain.UnStock;
import stocks.domain.UneVente;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GestionVente {
	List<UnStock> stocks = new ArrayList<UnStock>();
	List<Produit> produitList = new ArrayList<Produit>();
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	public String succeedVente(UneVente produits) {

		for (Produit produit : produits.getProduits()) {
			mongoOperation.save(produits);
		}

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
		}
		return stocks;
	}

}
