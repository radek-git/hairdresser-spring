package com.radek.haidresser.controller;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.entity.Appointment;
import com.radek.haidresser.mapper.AppointmentMapper;
import com.radek.haidresser.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private ClientService clientService;

    private AppointmentMapper appointmentMapper;

    @Autowired
    public ClientController(ClientService clientService, AppointmentMapper appointmentMapper) {
        this.clientService = clientService;
        this.appointmentMapper = appointmentMapper;
    }

    @GetMapping("/{id}/appointments")
    public AppointmentDTO appointments(@PathVariable Long id) {
        return appointmentMapper.toDTO(clientService.findById(id).getAppointments().get(0));
    }
}
