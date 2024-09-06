package com.opencoders.products.infrastructure.database.ports.out.repositories;

import com.opencoders.products.domain.models.Product;
import com.opencoders.products.domain.repositories.ProductRepository;
import com.opencoders.products.infrastructure.database.entities.ProductEntity;
import com.opencoders.products.infrastructure.database.ports.out.ProductJPARepository;
import com.opencoders.products.infrastructure.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJPARepository productJPARepository;
    private final ProductMapper productMapper;


    @Override
    public Product create(Product product) {
        ProductEntity productEntity = productMapper.productToProductEntity(product);
        return  productMapper.productEntityToProduct(productJPARepository.save(productEntity));
    }

    @Override
    public Product findBySku(Integer sku) {
        return productMapper.productEntityToProduct(productJPARepository.findBySku(sku));

    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productsEntities = productJPARepository.findAll();
        return productsEntities.
                stream().
                map(p ->
                        productMapper.productEntityToProduct(p))
                .collect(Collectors.toList());
    }
}
