package com.radek.haidresser.mapper;

import com.radek.haidresser.dto.EmployeeDTO;
import com.radek.haidresser.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toDTO(Employee employee);

    Employee toEntity(EmployeeDTO employeeDTO);

    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employees);

    List<Employee> toEmployeeList(List<EmployeeDTO> employeeDTOList);
}
