package stocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import stocks.domain.Customer;
import stocks.domain.CustomerRepository;
import stocks.domain.Produit;
import stocks.domain.ProduitRepository;

@SpringBootApplication
public class GestionStocksApplication implements CommandLineRunner {
	@Autowired
	public CustomerRepository repository;
	@Autowired
	public ProduitRepository repository2;

	public static void main(String[] args) {
		SpringApplication.run(GestionStocksApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

}