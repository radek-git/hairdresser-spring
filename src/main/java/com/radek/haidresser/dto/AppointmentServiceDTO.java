package com.radek.haidresser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentServiceDTO implements Serializable {

    private Long appointmentId;
    private Long serviceId;
    private String serviceName;
    private BigDecimal price;
}
