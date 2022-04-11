package com.apihomework.apihomework.service;

import com.apihomework.apihomework.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee employeeWithMaxSalary(int departmentId);

    Employee employeeWithMinSalary(int departmentId);

    Collection<Employee> findEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllEmployees();
}
