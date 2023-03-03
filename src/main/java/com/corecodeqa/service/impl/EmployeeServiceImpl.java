package com.corecodeqa.service.impl;

import com.corecodeqa.model.Employee;
import com.corecodeqa.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee findByEmpId(int empId) {
        // todo should retrieve the employee details from db
        return null;
    }

    @Override
    public void createEmployee(Employee employee) {
        employee.setState(Employee.State.ACTIVE);
        saveEmployee(employee);
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("---< EMPLOYEE RECORD IS SAVED >---");
    }

    @Override
    public double generateBasicSalary(Employee employee) throws Exception {

        if (employee.getWorkingHours() == 0 || employee.getWorkShift() == null) {
            throw new Exception("Employee working details cannot be null");

        } else {
            if (employee.getWorkShift() == Employee.WorkShift.DAY) {
                return employee.getWorkingHours() * 1000;
            } else {
                return employee.getWorkingHours() * 2000;
            }

        }
    }

    @Override
    public double generateGrossSalary(Employee employee, double additions, double deductions) throws Exception {
        if (employee.getBasicSalary() == 0) {
            employee.setBasicSalary(generateBasicSalary(employee));
        }

        return employee.getBasicSalary() + additions - deductions;
    }
}
