package com.radek.haidresser.controller;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.dto.ClientDTO;
import com.radek.haidresser.entity.Client;
import com.radek.haidresser.mapper.AppointmentMapper;
import com.radek.haidresser.mapper.ClientMapper;
import com.radek.haidresser.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private ClientService clientService;

    private AppointmentMapper appointmentMapper;
    private ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, AppointmentMapper appointmentMapper, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.appointmentMapper = appointmentMapper;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/id/{id}/appointments")
    public List<AppointmentDTO> appointments(@PathVariable Long id) {
        return appointmentMapper.toDTOList(clientService.findById(id).getAppointments());
    }

    @GetMapping("/all")
    public List<ClientDTO> getAll() {
//        List<Client> clients = clientService.findAll();
//
//        List<ClientDTO> clientsDTO = clientMapper.toDTOList(clients);
//
//        for (int i = 0; i < clients.size(); i++) {
//            clientsDTO.get(i).setAppointments(appointmentMapper.toDTOList(clients.get(i).getAppointments()));
//        }
//
//        return clientsDTO;

        return clientMapper.toDTOList(clientService.findAll());
    }

    @GetMapping("/name/{name}")
    public ClientDTO findByName(@PathVariable String name) {
        return clientMapper.toDTO(clientService.findByName(name));
    }

    @GetMapping("/id/{id}")
    public ClientDTO findByName(@PathVariable Long id) {
//        Client client = clientService.findById(id);
//
//        ClientDTO clientDTO = clientMapper.toDTO(client);
//        clientDTO.setAppointments(appointmentMapper.toDTOList(client.getAppointments()));
//
//        return clientDTO;

        return clientMapper.toDTO(clientService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody Client client) {
        return clientMapper.toDTO(clientService.add(client));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClientById(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientMapper.toDTO(clientService.update(clientDTO)), HttpStatus.OK);
    }

}
