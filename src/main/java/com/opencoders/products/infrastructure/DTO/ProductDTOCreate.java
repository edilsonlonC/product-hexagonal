package com.opencoders.products.infrastructure.DTO;


import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDTOCreate {
    private Integer sku;
    private String displayName;
    private String description;
    private String brand;
}
