package com.radek.haidresser.controller;


import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.dto.EmployeeDTO;
import com.radek.haidresser.mapper.AppointmentMapper;
import com.radek.haidresser.mapper.EmployeeMapper;
import com.radek.haidresser.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private AppointmentMapper appointmentMapper;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AppointmentMapper appointmentMapper, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.appointmentMapper = appointmentMapper;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/id/{id}")
    public EmployeeDTO findById(Long id) {
        return employeeMapper.toDTO(employeeService.findById(id));
    }

    @GetMapping("/all")
    public List<EmployeeDTO> findAll() {
        return employeeMapper.toEmployeeDTOList(employeeService.findAll());
    }

    @GetMapping("/id/{id}/appointments")
    public List<AppointmentDTO> getAppointments(Long id) {
        return appointmentMapper.toDTOList(employeeService.findById(id).getAppointments());
    }

}
