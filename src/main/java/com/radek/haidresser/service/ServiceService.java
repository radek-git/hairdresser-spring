package com.radek.haidresser.service;


import com.radek.haidresser.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
