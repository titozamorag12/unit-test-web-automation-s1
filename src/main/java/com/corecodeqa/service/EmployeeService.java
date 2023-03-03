package com.corecodeqa.service;

import com.corecodeqa.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Employee findByEmpId(int empId);

    public void createEmployee(Employee employee);

    public void saveEmployee(Employee employee);

    public double generateBasicSalary(Employee employee) throws Exception;

    public double generateGrossSalary(Employee employee, double additions, double deductions) throws Exception;

}
