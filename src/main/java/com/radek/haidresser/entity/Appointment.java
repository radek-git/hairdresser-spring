package com.radek.haidresser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Employee employee;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private BigDecimal price;

}