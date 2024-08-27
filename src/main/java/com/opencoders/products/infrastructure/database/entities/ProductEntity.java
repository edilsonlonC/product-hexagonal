package com.opencoders.products.infrastructure.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer sku;
    private String displayName;
    private String description;
    private String brand;
//    @ManyToMany()
//    private List<CategoryEntity> categories;

}
