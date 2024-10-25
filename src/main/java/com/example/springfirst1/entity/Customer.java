package com.example.springfirst1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@FieldDefaults(level = AccessLevel.PUBLIC)

public class Customer extends User {
    String adresse;
    String city;

@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
private List<Orderr>orderrs = new ArrayList<>();


}
