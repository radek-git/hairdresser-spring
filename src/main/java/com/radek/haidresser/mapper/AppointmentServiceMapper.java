package com.radek.haidresser.mapper;

import com.radek.haidresser.dto.AppointmentServiceDTO;
import com.radek.haidresser.dto.ServiceDTO;
import com.radek.haidresser.entity.AppointmentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentServiceMapper {

    @Mappings({
            @Mapping(target = "appointmentId", source = "appointment.id"),
            @Mapping(target = "serviceId", source = "service.id"),
            @Mapping(target = "serviceName", source = "service.name")
    })
    AppointmentServiceDTO toDTO(AppointmentService appointmentService);

    @Mappings({
            @Mapping(target = "id", source = "service.id"),
            @Mapping(target = "name", source = "service.name")
    })
    ServiceDTO toServiceDTO(AppointmentService appointmentService);

    List<AppointmentServiceDTO> toDTOList(List<AppointmentService> services);


    List<ServiceDTO> toServiceDTOList(List<AppointmentService> appointmentServices);
}
