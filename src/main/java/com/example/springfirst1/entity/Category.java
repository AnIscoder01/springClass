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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Subcategory> subCategories = new ArrayList();

}
