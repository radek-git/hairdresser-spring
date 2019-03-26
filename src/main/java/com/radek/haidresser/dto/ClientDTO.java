package com.radek.haidresser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String username;
    //private List<AppointmentDTO> appointments;

}
