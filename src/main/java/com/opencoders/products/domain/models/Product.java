package com.opencoders.products.domain.models;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private Integer sku;
    private String displayName;
    private String description;
    private String brand;
}
