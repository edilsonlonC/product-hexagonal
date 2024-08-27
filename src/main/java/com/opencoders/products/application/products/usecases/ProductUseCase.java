package com.opencoders.products.application.products.usecases;

import com.opencoders.products.domain.models.Product;
import com.opencoders.products.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductUseCase {
    @Autowired
    private ProductRepository productRepository;
    public Product create(Product product){
        return productRepository.create(product);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
