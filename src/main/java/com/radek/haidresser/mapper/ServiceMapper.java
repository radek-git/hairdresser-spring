package com.radek.haidresser.mapper;

import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.entity.Service;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceDTO toDTO(Service service);

    List<ServiceDTO> toDTOList(List<Service> services);



}
