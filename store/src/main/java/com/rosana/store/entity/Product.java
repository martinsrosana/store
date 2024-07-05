package com.rosana.store.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column (name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

}
