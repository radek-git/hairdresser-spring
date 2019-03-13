package com.radek.haidresser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("1")
public class Client extends User {

    public Client(String name, String surname, String username) {
        super(name, surname, username);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private List<Appointment> appointments = new ArrayList<>();
}
