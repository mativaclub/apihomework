package com.apihomework.apihomework.service;

import com.apihomework.apihomework.data.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();

    String getKey(String firstName, String lastName);

    void validateNames(String... names);
}
