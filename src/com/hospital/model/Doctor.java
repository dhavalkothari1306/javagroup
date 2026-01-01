package com.hospital.model;

public class Doctor extends Person {
    private String specialization;
    private double salary;

    public Doctor(int id, String name, String specialization, double salary) {
        super(id, name);
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public String getDetails() {
        return "Specialization: " + specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSalary() {
        return salary;
    }
}
