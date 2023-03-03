package com.corecodeqa.model;

public class Employee {
    public enum WorkShift {DAY, NIGHT}

    public enum State {INACTIVE, ACTIVE}

    private int empId;
    private String firstName;
    private String lastName;
    private WorkShift workShift;
    private State state;
    private int workingHours;
    private double basicSalary;

    public Employee() {
    }

    public Employee(int empId, String firstName, String lastName, WorkShift workShift, int workingHours) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workShift = workShift;
        this.workingHours = workingHours;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public WorkShift getWorkShift() {
        return workShift;
    }

    public void setWorkShift(WorkShift workShift) {
        this.workShift = workShift;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
