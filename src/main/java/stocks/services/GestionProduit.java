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
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import stocks.SpringMongoConfig;
import stocks.domain.Produit;
import stocks.domain.ProduitCategorie;
import stocks.domain.ProduitRepository;
import stocks.domain.Stock;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GestionProduit {
	List<Produit> produits = new ArrayList<Produit>();
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	public void creerProduit(int qte, String nom, ProduitCategorie produitCategorie, int idStock) {
		System.out.println("bob");

		Produit produit = new Produit();
		ProduitCategorie produitC = new ProduitCategorie();
		System.out.println(nom + "dddddddddddddd");
		produit.setNom(nom);
		produit.setQte(qte);
		produit.setIdStock(idStock);
		produit.setProduitCategorie(produitCategorie);
		produitC.setLibelle(produitCategorie.getLibelle());
		produitC.setNom(produitCategorie.getNom());
		String nomCategorie = produitC.getNom();
		mongoOperation.save(produit);

		DBCursor cursor = mongoOperation.getCollection("produitCategorie").find();
		Boolean existCategorie = false;
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
	
			produitC.setNom((String) obj.get("nom"));
			produitC.setLibelle((String) obj.get("libelle"));
			System.out.println(nomCategorie + produitC.getNom());
			if (nomCategorie.equals(produitC.getNom())) {
				System.out.println("La produit Catégorie existe déjà");
				existCategorie = true;
				break;
			}
	
		}
		if (!existCategorie) {
			System.out.println("Une nouvelle Catégorie à été crée car la catégori n'existe pas.");
			mongoOperation.save(produitC);
		}

	}

	public List<Produit> listerProduits() {
		System.out.println("bob");

		DBCursor cursor = mongoOperation.getCollection("produit").find();
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			System.out.println(obj.get("nom"));
			Produit produit = new Produit();
			produit.setNom((String) obj.get("nom"));
			produit.setQte((int) obj.get("qte"));
			produits.add(produit);
			// do your thing
		}
		return produits;
	}
	public Produit listerProduit(int idStock) {
		System.out.println("bob");
		BasicQuery query1 = new BasicQuery("{idStock : "+idStock+"}");
		Produit produit = mongoOperation.findOne(query1, Produit.class);

		System.out.println("query1 - " + query1.toString());
		System.out.println("userTest1 - " + produit);		
		
			// do your thing
		
		return produit;
	}

}
