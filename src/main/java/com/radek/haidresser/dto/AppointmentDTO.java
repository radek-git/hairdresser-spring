package com.radek.haidresser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO implements Serializable {

    private Long id;
    private Long clientId;
    private Long employeeId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private BigDecimal totalPrice;

    private List<Long> appointmentServices = new ArrayList<>();

}

