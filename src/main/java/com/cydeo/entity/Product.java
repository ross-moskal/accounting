package com.cydeo.entity;

import com.cydeo.enums.ProductUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseEntity {
    private String name;
    private int quantityInStock;
    private int lowLimitAlert;

    @Enumerated(EnumType.STRING)
    private ProductUnit productUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
