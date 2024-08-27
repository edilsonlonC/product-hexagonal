package com.opencoders.products.infrastructure.database.ports.out;

import com.opencoders.products.infrastructure.database.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ProductJPARepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT p FROM ProductEntity p WHERE p.sku = ?1")
    ProductEntity findBySku(Integer sku);

}
