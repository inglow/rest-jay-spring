package stocks.domain;


import org.springframework.data.annotation.Id;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit, Integer> {

    public List<Produit> findBytypeProduit(int typeProduit);

}