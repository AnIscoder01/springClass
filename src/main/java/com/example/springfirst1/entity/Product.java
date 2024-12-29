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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   long price;
   String description;

    @OneToMany(mappedBy = "product")
    private List<Subcategory> subcategory;

    @ManyToMany(mappedBy = "products")
    private List<Orderr>orderrs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;


}
