package stocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import stocks.domain.Produit;
import stocks.domain.ProduitRepository;

@SpringBootApplication
public class GestionStocksApplication implements CommandLineRunner {
	



	public static void main(String[] args) {
		SpringApplication.run(GestionStocksApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {


	}

}
