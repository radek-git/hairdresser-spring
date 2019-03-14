package com.radek.haidresser.mapper;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mappings({
//        @Mapping(target = "clientId", source = "client.id"),
//        @Mapping(target = "employeeId", source = "employee.id")
            @Mapping(target = "employeeId", source = "id")
    })
    AppointmentDTO toDTO(Appointment appointment);

    Appointment toEntity(AppointmentDTO appointmentDTO);
}
