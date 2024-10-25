package com.example.springfirst1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@FieldDefaults(level= AccessLevel.PUBLIC)
public class Provider extends User{

    String matriclule;
    String service;
    String company;


    @OneToMany(mappedBy = "provider",cascade = CascadeType.ALL)
    List<Product>products=new ArrayList<>();


}
