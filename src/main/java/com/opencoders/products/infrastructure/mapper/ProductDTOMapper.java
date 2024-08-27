package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.Product;
import com.opencoders.products.infrastructure.DTO.ProductDTOCreate;
import com.opencoders.products.infrastructure.DTO.ProductDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {
   ProductDTOMapper INSTANCE = Mappers.getMapper(ProductDTOMapper.class);
   Product productDTOCreateToProduct(ProductDTOCreate productDTOCreate);
   ProductDTOResponse productToProductDTOResponse(Product product);
   List<ProductDTOResponse> productsToProductsDtoResponse(List<Product> products);
}
