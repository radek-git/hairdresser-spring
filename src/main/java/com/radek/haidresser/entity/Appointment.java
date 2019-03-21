package com.radek.haidresser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
    private List<AppointmentService> appointmentServices = new ArrayList<>();

}
