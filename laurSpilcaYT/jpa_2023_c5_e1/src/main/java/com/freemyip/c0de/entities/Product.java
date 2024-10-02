package com.freemyip.c0de.entities;

import org.hibernate.annotations.GenericGenerator;

import com.freemyip.c0de.entities.generators.ProductIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GenericGenerator(name = "product_id", type = ProductIdGenerator.class)
    @GeneratedValue(generator = "product_id")
    private String productId;

    private String name;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
