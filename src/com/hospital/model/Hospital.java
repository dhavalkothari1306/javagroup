package com.hospital.model;

import java.util.ArrayList;

public class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void showHospitalDetails() {
        System.out.println("\nHospital: " + hospitalName);

        System.out.println("\nDoctors:");
        for (Doctor d : doctors) {
            System.out.println(d.getName() + " | " + d.getDetails());
        }

        System.out.println("\nPatients:");
        for (Patient p : patients) {
            System.out.println(p.getName() + " | Bill: " + p.calculateBill());
        }
    }
}
