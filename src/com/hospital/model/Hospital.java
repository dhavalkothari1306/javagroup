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

    public String getHospitalName() {
        return hospitalName;
    }

    public void showHospitalDetails() {
        System.out.println("\n========================================");
        System.out.println("Hospital: " + hospitalName);
        System.out.println("========================================");

        System.out.println("\nDoctors:");
        if (doctors.isEmpty()) {
            System.out.println("  No doctors registered.");
        } else {
            for (Doctor d : doctors) {
                System.out.println("  - " + d.getName() + " | " + d.getDetails());
            }
        }

        System.out.println("\nPatients:");
        if (patients.isEmpty()) {
            System.out.println("  No patients admitted.");
        } else {
            for (Patient p : patients) {
                System.out.println("  - " + p.getName() + " | " + p.getDetails() + " | Bill: Rs." + p.calculateBill());
            }
        }
        System.out.println();
    }
}
