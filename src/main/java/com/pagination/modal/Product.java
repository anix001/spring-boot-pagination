package com.pagination.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="product_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private long quantity;
    private long price;

    public Product(String s, long nextLong, long nextLong1) {
        this.name = s;
        this.quantity = nextLong;
        this.price = nextLong1;
    }
}
