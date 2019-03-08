package com.radek.haidresser.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Client extends User {

    public Client(String name, String surname, String username) {
        super(name, surname, username);
    }

}
