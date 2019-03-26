package com.radek.haidresser.service;

import com.radek.haidresser.dto.ClientDTO;
import com.radek.haidresser.entity.Client;
import com.radek.haidresser.repository.ClientRepository;
import com.radek.haidresser.specification.ClientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Client> findAll(ClientSpecification clientSpecification, Pageable pageable) {
        return clientRepository.findAll(clientSpecification, pageable);
    }

    public Client findByName(String name) {
        return clientRepository.findByName(name).orElseThrow(() -> new RuntimeException("Nie ma użytkownika o podanym imieniu"));
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }

    public Client update(ClientDTO clientDTO) {
        Client client = clientRepository.findById(clientDTO.getId())
                .orElseThrow(() -> new RuntimeException("Nie ma takiego użytkownika"));

        if (clientDTO.getName() != null) {
            client.setName(clientDTO.getName());
        }

        if (clientDTO.getSurname() != null) {
            client.setSurname(clientDTO.getSurname());
        }

        if (clientDTO.getUsername() != null) {
            client.setUsername(clientDTO.getUsername());
        }

        clientRepository.save(client);

        return client;
    }

    public Client findByUsername(String username) {

        return clientRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Nie ma użytkownika o podanej nazwie"));
    }
}
