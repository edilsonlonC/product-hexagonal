package com.opencoders.products.infrastructure.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDTOResponse {
    private Long id;
    private Integer sku;
    private String displayName;
    private String description;
    private String brand;
}
