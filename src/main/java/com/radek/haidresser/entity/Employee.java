package com.radek.haidresser.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Employee extends User {

    public Employee(String name, String surname, String username) {
        super(name, surname, username);
    }
}

