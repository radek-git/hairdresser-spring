package com.radek.haidresser.controller;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.dto.AppointmentServiceDTO;
import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.entity.Appointment;
import com.radek.haidresser.mapper.AppointmentMapper;
import com.radek.haidresser.mapper.AppointmentServiceMapper;
import com.radek.haidresser.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping
    public List<AppointmentDTO> getAllAppointments(@PageableDefault(size = 15) Pageable pageable) {
        return appointmentMapper.toDTOList(appointmentService.findAll(pageable).getContent());
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable Long id) {
        return appointmentMapper.toDTO(appointmentService.findById(id));
    }


//    @GetMapping("/{id}/services")
//    public List<ServiceDTO> findServices(@PathVariable Long id) {
//        return appointmentServiceMapper.toServiceDTOList(appointmentService.findById(id).getAppointmentServices());
//    }

    @PostMapping //(dodawanie poprzez ścieżke /appointments)
    public AppointmentDTO add(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentMapper.toDTO(appointmentService.save(appointmentMapper.toEntity(appointmentDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        appointmentService.deleteById(id);
    }

//    @GetMapping("/prices/less/{totalPrice}")
//    public List<AppointmentDTO> findByPriceLessThan(@PathVariable BigDecimal totalPrice) {
//        return appointmentMapper.toDTOList(appointmentService.findByPriceLessThan(totalPrice));
//    }
//
//
//    @GetMapping("/prices/more/{totalPrice}")
//    public List<AppointmentDTO> findByPriceMoreThan(BigDecimal totalPrice) {
//        return appointmentMapper.toDTOList(appointmentService.findByPriceMoreThan(totalPrice));
//    }


}
