package com.grego.Clase_38A_MongoDB_SpringWeb.controller;

import com.grego.Clase_38A_MongoDB_SpringWeb.model.Product;
import com.grego.Clase_38A_MongoDB_SpringWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")


public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/all")
    public Iterable<Product> getAllProducts() {
        return productService.findAll();
    }
    @GetMapping("/id={id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.findById(id);
    }
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }
    @DeleteMapping("/id={id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
    }

}
