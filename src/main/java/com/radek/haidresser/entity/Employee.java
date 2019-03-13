package com.radek.haidresser.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("2")
public class Employee extends User {

    public Employee(String name, String surname, String username) {
        super(name, surname, username);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Appointment> appointments = new ArrayList<>();
}

