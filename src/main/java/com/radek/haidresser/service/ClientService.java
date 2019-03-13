package com.radek.haidresser.service;

import com.radek.haidresser.entity.Client;
import com.radek.haidresser.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego użytkownika"));
    }
}
