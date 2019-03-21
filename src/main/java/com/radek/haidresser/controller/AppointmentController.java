package com.radek.haidresser.controller;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.dto.AppointmentServiceDTO;
import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.mapper.AppointmentMapper;
import com.radek.haidresser.mapper.AppointmentServiceMapper;
import com.radek.haidresser.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;
    private AppointmentMapper appointmentMapper;
    private AppointmentServiceMapper appointmentServiceMapper;


    @Autowired
    public AppointmentController(AppointmentService appointmentService,
                                 AppointmentMapper appointmentMapper, AppointmentServiceMapper appointmentServiceMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
        this.appointmentServiceMapper = appointmentServiceMapper;
    }

    @PostMapping(path = "/add")
    public AppointmentDTO add(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentMapper.toDTO(appointmentService.save(appointmentMapper.toEntity(appointmentDTO)));
    }


    @GetMapping("/all")
    public List<AppointmentDTO> findAll () {
        return appointmentMapper.toDTOList(appointmentService.findAll());
    }

    @GetMapping("/{id}/services")
    public List<ServiceDTO> findServices(@PathVariable Long id) {
        return appointmentServiceMapper.toServiceDTOList(appointmentService.findById(id).getAppointmentServices());
    }



}
