package com.grego.Clase_38A_MongoDB_SpringWeb.service;

import com.grego.Clase_38A_MongoDB_SpringWeb.model.Product;
import com.grego.Clase_38A_MongoDB_SpringWeb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

}





