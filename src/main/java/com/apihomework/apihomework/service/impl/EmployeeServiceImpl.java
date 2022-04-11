package com.apihomework.apihomework.service.impl;

import com.apihomework.apihomework.exceptions.EmployeeExistsException;
import com.apihomework.apihomework.data.Employee;
import com.apihomework.apihomework.exceptions.EmployeeNotFoundException;
import com.apihomework.apihomework.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        String key = getKey(firstName, lastName);
        Employee addEmployee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(key)) {
            throw new EmployeeExistsException("Employee already added");
        }
        employees.put(key, addEmployee);
        return addEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employees.get(key);
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employees.get(key);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }


}
