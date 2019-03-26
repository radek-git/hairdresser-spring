package com.radek.haidresser.mapper;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.entity.Appointment;
import com.radek.haidresser.entity.AppointmentService;
import com.radek.haidresser.entity.Service;
import com.radek.haidresser.repository.ClientRepository;
import com.radek.haidresser.service.ClientService;
import com.radek.haidresser.service.EmployeeService;
import com.radek.haidresser.service.ServiceService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    @Autowired
    protected ClientService clientService;

    @Autowired
    protected EmployeeService employeeService;

    @Autowired
    protected ServiceService serviceService;

//    @Mappings({
//        @Mapping(target = "clientId", source = "client.id"),
//        @Mapping(target = "employeeId", source = "employee.id"),
//        @Mapping(target = "appointmentServices", expression = "java(appointment.getAppointmentServices().stream().map(as -> as.getService().getId()).collect(Collectors.toList()))")
//    })
//    public abstract AppointmentDTO toDTO(Appointment appointment);


    public AppointmentDTO toDTO(Appointment appointment) {
        if (appointment == null) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setEmployeeId(appointment.getEmployee().getId());
        appointmentDTO.setClientId(appointment.getClient().getId());
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setStartTime(appointment.getStartTime());
        appointmentDTO.setEndTime(appointment.getEndTime());
        appointmentDTO.setTotalPrice(appointment.getTotalPrice());

        appointmentDTO.setAppointmentServices(appointment.getAppointmentServices().stream().map(as -> as.getService().getId()).collect(Collectors.toList()));

        return appointmentDTO;
    }

//    @Mappings({
//            @Mapping(target = "client", expression = "java(clientService.findById(appointmentDTO.getClientId()))"),
//            @Mapping(target = "employee", expression = "java(employeeService.findById(appointmentDTO.getEmployeeId()))")
//    })
//    public abstract Appointment toEntity(AppointmentDTO appointmentDTO);

    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        if (appointmentDTO == null) {
            return null;
        }

        Appointment appointment = Appointment.builder()
                .client(clientService.findById(appointmentDTO.getClientId()))
                .employee(employeeService.findById(appointmentDTO.getEmployeeId()))
                .startTime(appointmentDTO.getStartTime())
                .endTime(appointmentDTO.getEndTime())
                .build();

        List<Service> services = appointmentDTO.getAppointmentServices().stream()
                .map(id -> serviceService.findById(id))
                .collect(Collectors.toList());

        List<AppointmentService> appointmentServices = services.stream()
                .map(s -> new AppointmentService(appointment, s, s.getPrice()))
                .collect(Collectors.toList());

        BigDecimal totalPrice =
                appointmentServices.stream().map(AppointmentService::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        appointment.setAppointmentServices(appointmentServices);
        appointment.setTotalPrice(totalPrice);

        return appointment;
    }

    public abstract List<AppointmentDTO> toDTOList(List<Appointment> appointments);

    //List<Appointment> toAppointmentList(List<AppointmentDTO> appointmentDTOList);

    List<Appointment> toAppointmentList(List<AppointmentDTO> appointmentDTOList) {
        return null;
    }
}
