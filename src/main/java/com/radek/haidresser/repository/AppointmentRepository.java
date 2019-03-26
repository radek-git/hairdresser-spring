package com.radek.haidresser.repository;

import com.radek.haidresser.entity.Appointment;
import com.radek.haidresser.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

//    List<Appointment> findByEmployee(Employee employee);
//
//    List<Appointment> findByStartTimeAfter(LocalDateTime dateTime);
//
//    List<Appointment> findByStartTimeBefore(LocalDateTime dateTime);
//
//    List<Appointment> findByStartTimeAfterAndEndTimeBefore(LocalDateTime startTime, LocalDateTime endTime);
//
//    List<Appointment> findAllByTotalPriceLessThan(BigDecimal totalPrice);
//
//    List<Appointment> findAllByTotalPriceGreaterThan(BigDecimal totalPrice);
}
