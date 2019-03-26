package com.radek.haidresser.service;


import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.radek.haidresser.entity.Service> findAll() {
        return serviceRepository.findAll();
    }


    public com.radek.haidresser.entity.Service findById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma serwisu o podanym id"));
    }


    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }

    public com.radek.haidresser.entity.Service findByName(String name) {
        return serviceRepository.findByName(name);
    }

//    public List<com.radek.haidresser.entity.Service> findByPriceGreaterThan(BigDecimal totalPrice) {
//        return serviceRepository.findAllByPriceGreaterThan(totalPrice);
//    }
//
//
//    public List<com.radek.haidresser.entity.Service> findByPriceIsLessThan(BigDecimal totalPrice) {
//        return serviceRepository.findAllByPriceIsLessThan(totalPrice);
//    }
//
//
//    public List<com.radek.haidresser.entity.Service> findByPriceIsNear(BigDecimal totalPrice) {
//        return serviceRepository.findAllByPriceIsNear(totalPrice);
//    }


    public com.radek.haidresser.entity.Service add(com.radek.haidresser.entity.Service service) {
        return serviceRepository.save(service);
    }


}
