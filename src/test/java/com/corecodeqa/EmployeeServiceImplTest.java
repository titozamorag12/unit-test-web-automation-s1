package com.corecodeqa;

import com.corecodeqa.model.Employee;
import com.corecodeqa.service.impl.EmployeeServiceImpl;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


public class EmployeeServiceImplTest {

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test(groups = {"basic"})
    public void testGenerateBasicSalarySuccess() {
        Employee employee = new Employee(114, "Steve", "Hale", Employee.WorkShift.DAY, 6);
        try {
            employeeService.generateBasicSalary(employee);
        } catch (Exception e) {
            fail("This should not be failed since it has all the mandatory data");
        }
    }

    @Test(groups = {"failure-test"})
    public void testGenerateBasicSalaryFailure() {
        Employee employee = new Employee(114, "Steve", "Hale", Employee.WorkShift.DAY, 0);
        try {
            employeeService.generateBasicSalary(employee);
            fail("This should be fail since working hours are not available");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Employee working details cannot be null");
        }
    }

    @Test(groups = {"failure-test"}, enabled = false)
    public void testGenerateBasicSalaryExceptionFailure() {
        Employee employee = new Employee(114, "Steve", "Hale", null, 0);
        try {
            employeeService.generateBasicSalary(employee);
            fail("This should be fail since working hours & shift are not available");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Employee working details missing");
        }
    }

    /*Above two test methods can be replaced with the following method with annotations*/

    @Test(groups = {"failure-test"}, expectedExceptions = Exception.class, expectedExceptionsMessageRegExp = "Employee working details cannot be null")
    public void testGenerateBasicSalaryGeneratedException() throws Exception {
        Employee employee = new Employee(114, "Steve", "Hale", null, 0);
        employeeService.generateBasicSalary(employee);
    }


    /* Parameterized testing */
    @Parameters(value = {"additions", "deductions"})
    @Test(groups = {"with-parameters"})
    public void verifyGrossSalaryCalculation(@Optional("1000.00") double additions,
                                             @Optional("2000.00") double deductions) {
        try {
            Employee employee = new Employee(112, "John", "Doe", Employee.WorkShift.DAY, 8);
            employee.setBasicSalary(8000);
            Double grossSalary = employeeService.generateGrossSalary(employee, additions, deductions);
            assertEquals(7000, grossSalary, 0);
        } catch (Exception e) {
            fail("This should not be failed since it has all the mandatory data");
        }
    }

    /*End of Parameterized testing*/

    /**
     * Parameterized / Data driven testing & Dependencies between groups / methods
     */
    @DataProvider(name = "employee_def")
    public Object[][] createEmployeeData() {
        Employee employee1 = new Employee(112, "John", "Doe", Employee.WorkShift.DAY, 8);
        Employee employee2 = new Employee(113, "Jason", "Doe", Employee.WorkShift.DAY, 3);
        Employee employee3 = new Employee(114, "Mark", "Dave", Employee.WorkShift.DAY, 5);
        return new Object[][]{
                {employee1, 1000, 2000},
                {employee2, 1000, 2000},
                {employee3, 1000, 2000}
        };
    }

    /**
     * simple example for load testing
     */
    @Test(enabled = true, dataProvider = "employee_def", dependsOnMethods = {"testGenerateBasicSalarySuccess"}, threadPoolSize = 3, invocationCount = 50, groups = "extra")
    public void verifyBasicSalaryAndGrossSalaryCalculation(Employee employee, double additions, double deductions) {
        try {
            Double grossSalary = employeeService.generateGrossSalary(employee, additions, deductions);
            Reporter.log("\n value generated : " + String.valueOf(grossSalary));
        } catch (Exception e) {
            fail("This should not be failed since it has all the mandatory data");
        }
    }

    /* End of Parameterized / Data driven testing*/

}
