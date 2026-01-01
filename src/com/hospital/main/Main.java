package com.hospital.main;

import com.hospital.model.*;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital");

        // Creating doctor objects
        Doctor d1 = new Doctor(101, "Dr. Mehta", "Cardiology", 90000);
        Doctor d2 = new Doctor(102, "Dr. Sharma", "Neurology", 95000);

        // Creating patient objects
        Patient p1 = new Patient(201, "Amit", 5, 2000);
        Patient p2 = new Patient(202, "Priya", 3, 2500);

        // Adding doctors to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        // Adding patients to hospital
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Displaying hospital details
        hospital.showHospitalDetails();
    }
}
