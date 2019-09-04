package com.service;

import com.Loggable;
import com.model.Employee;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Loggable
    public Employee createEmployee(String name, String empId) {

        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmpId(empId);
        return emp;
    }

    public void deleteEmployee(String empId) {

    }
}