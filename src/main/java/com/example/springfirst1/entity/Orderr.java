package com.example.springfirst1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String ref;
    long price;
    String date;


    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns=@JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List <Product>products =new ArrayList<>();



    @ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;


}
