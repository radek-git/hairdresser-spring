package com.radek.haidresser.controller;

import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.entity.Service;
import com.radek.haidresser.mapper.ServiceMapper;
import com.radek.haidresser.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/all/id/{id}")
    public ServiceDTO findById(Long id) {
        return serviceMapper.toDTO(serviceService.findById(id));
    }

    @DeleteMapping("/{id{")
    public void deleteById(Long id) {
        serviceService.deleteById(id);
    }

//    @GetMapping("/all/prices/lessThan/{totalPrice}")
//    public List<ServiceDTO> findByPriceLessThan(@PathVariable BigDecimal totalPrice) {
//        return serviceMapper.toDTOList(serviceService.findByPriceIsLessThan(totalPrice));
//    }
//
//    @GetMapping("/all/prices/moreThan/{totalPrice}")
//    public List<ServiceDTO> findByPriceMoreThan(@PathVariable BigDecimal totalPrice) {
//        return serviceMapper.toDTOList(serviceService.findByPriceGreaterThan(totalPrice));
//    }
//
//
//    @GetMapping("/all/prices/near/{totalPrice}")
//    public List<ServiceDTO> findByPriceIsNear(@PathVariable BigDecimal totalPrice) {
//        return serviceMapper.toDTOList(serviceService.findByPriceIsNear(totalPrice));
//    }


}
