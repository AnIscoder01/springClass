package com.example.springfirst1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@FieldDefaults(level = AccessLevel.PUBLIC)


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    String name;
    long salary;
    long phone;
    int age;
    String email;
    String password;



}
