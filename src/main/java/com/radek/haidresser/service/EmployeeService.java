package com.radek.haidresser.service;

import com.radek.haidresser.dto.EmployeeDTO;
import com.radek.haidresser.entity.Employee;
import com.radek.haidresser.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma pracownika o takim ID"));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }


    public List<Employee> findByNameAndSurname(String name, String surname) {
        return employeeRepository.findByNameAndSurname(name, surname);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(() -> new RuntimeException("Nie ma takiego użytkownika"));

        if (employeeDTO.getName() != null) {
            employee.setName(employeeDTO.getName());
        }

        if (employeeDTO.getSurname() != null) {
            employee.setSurname(employeeDTO.getSurname());
        }

        if (employeeDTO.getUsername() != null) {
            employee.setUsername(employeeDTO.getUsername());
        }

        employeeRepository.save(employee);

        return employee;
    }
}
