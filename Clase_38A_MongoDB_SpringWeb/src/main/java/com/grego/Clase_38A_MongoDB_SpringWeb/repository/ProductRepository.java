package com.grego.Clase_38A_MongoDB_SpringWeb.repository;

import com.grego.Clase_38A_MongoDB_SpringWeb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
