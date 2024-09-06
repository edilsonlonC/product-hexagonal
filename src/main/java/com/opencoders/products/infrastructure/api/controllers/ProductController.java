package com.opencoders.products.infrastructure.api.controllers;

import com.opencoders.products.application.products.usecases.ProductUseCase;
import com.opencoders.products.domain.models.Product;
import com.opencoders.products.infrastructure.DTO.ProductDTOCreate;
import com.opencoders.products.infrastructure.DTO.ProductDTOResponse;
import com.opencoders.products.infrastructure.mapper.ProductDTOMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductDTOMapper productDTOMapper;
    private final ProductUseCase productUseCase;

    @PostMapping
    public ResponseEntity<ProductDTOResponse> create(@RequestBody  ProductDTOCreate productDTOCreate) {
        Product product = productDTOMapper.productDTOCreateToProduct(productDTOCreate);
        ProductDTOResponse productDTOResponse = productDTOMapper.productToProductDTOResponse(productUseCase.create(product));
        logger.info("Product was created with sku : {}", product.getSku());
        return new ResponseEntity<>(productDTOResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTOResponse>> getAll () {
        return new ResponseEntity<>(productDTOMapper.productsToProductsDtoResponse(productUseCase.findAll()), HttpStatus.OK);
    }


}
