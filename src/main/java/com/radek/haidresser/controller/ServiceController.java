package com.radek.haidresser.controller;

import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.mapper.ServiceMapper;
import com.radek.haidresser.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/services")
public class ServiceController {

    private ServiceMapper serviceMapper;
    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceMapper serviceMapper, ServiceService serviceService) {
        this.serviceMapper = serviceMapper;
        this.serviceService = serviceService;
    }

    @GetMapping("/all")
    public List<ServiceDTO> findAll() {
        return serviceMapper.toDTOList(serviceService.findAll());
    }
}
