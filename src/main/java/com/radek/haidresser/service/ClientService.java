package com.radek.haidresser.service;

import com.radek.haidresser.entity.Client;
import com.radek.haidresser.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findByName(String name) {
        return clientRepository.findByName(name).orElseThrow(() -> new RuntimeException("Nie ma użytkownika o podanym imieniu"));
    }
}
