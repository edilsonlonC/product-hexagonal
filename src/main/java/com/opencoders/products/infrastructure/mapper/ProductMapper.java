package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.Product;
import com.opencoders.products.infrastructure.database.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product productEntityToProduct(ProductEntity product);
    ProductEntity productToProductEntity(Product product);
}
