package com.radek.haidresser.mapper;

import com.radek.haidresser.dto.ClientDTO;
import com.radek.haidresser.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client client);

    Client toEntity(ClientDTO clientDTO);

    List<ClientDTO> toDTOList(List<Client> clients);

    List<Client> toList(List<ClientDTO> clientsDTO);
}
