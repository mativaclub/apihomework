package com.apihomework.apihomework.service.impl;

import com.apihomework.apihomework.exceptions.EmployeeNotFoundException;
import com.apihomework.apihomework.data.Employee;
import com.apihomework.apihomework.service.DepartmentService;
import com.apihomework.apihomework.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeWithMaxSalary(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee not found"));
    }

    @Override
    public Employee employeeWithMinSalary(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee not found"));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployees() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}
