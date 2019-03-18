package com.radek.haidresser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "user_type_id"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends AbstractEntity {

    private String name;
    private String surname;
    private String username;
    private String password;

}
