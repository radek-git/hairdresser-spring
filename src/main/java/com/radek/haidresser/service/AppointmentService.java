package com.radek.haidresser.service;

import com.radek.haidresser.dto.AppointmentDTO;
import com.radek.haidresser.entity.Appointment;
import com.radek.haidresser.entity.Client;
import com.radek.haidresser.entity.Employee;
import com.radek.haidresser.repository.AppointmentRepository;
import com.radek.haidresser.repository.ClientRepository;
import com.radek.haidresser.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private ClientRepository clientRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Page<Appointment> findAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    public List<Appointment> getByPageNumber(int pageNumber, int size) {
        return appointmentRepository.findAll(PageRequest.of(pageNumber, size)).getContent();
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego użytkownika"));
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

//    public List<Appointment> findByEmployee(Employee employee) {
//        return appointmentRepository.findByEmployee(employee);
//    }
//
//
//    public List<Appointment> findBeforeDate(LocalDateTime dateTime) {
//        return appointmentRepository.findByStartTimeBefore(dateTime);
//    }
//
//    public List<Appointment> findAfterDate(LocalDateTime dateTime) {
//        return appointmentRepository.findByStartTimeAfter(dateTime);
//    }
//
//    public List<Appointment> findBetweenDates(LocalDateTime start, LocalDateTime end) {
//        return appointmentRepository.findByStartTimeAfterAndEndTimeBefore(start, end);
//    }
//
//    public List<Appointment> findByPriceLessThan(BigDecimal totalPrice) {
//        return appointmentRepository.findAllByTotalPriceLessThan(totalPrice);
//    }
//
//    public List<Appointment> findByPriceMoreThan(BigDecimal totalPrice) {
//        return appointmentRepository.findAllByTotalPriceGreaterThan(totalPrice);
//    }

}
