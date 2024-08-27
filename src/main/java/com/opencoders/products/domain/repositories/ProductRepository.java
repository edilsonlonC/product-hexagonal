package com.opencoders.products.domain.repositories;

import com.opencoders.products.domain.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {
    Product create (Product product);
    Product findBySku (Integer sku);
    List<Product> findAll();
}
