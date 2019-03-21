package com.radek.haidresser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "appointment_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentService implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Appointment appointment;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Service service;

    private BigDecimal price;
}
