package com.hospital.model;

import com.hospital.interfaces.Billable;

public class Patient extends Person implements Billable {
    private int daysAdmitted;
    private double chargePerDay;

    public Patient(int id, String name, int daysAdmitted, double chargePerDay) {
        super(id, name);
        this.daysAdmitted = daysAdmitted;
        this.chargePerDay = chargePerDay;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * chargePerDay;
    }

    @Override
    public String getDetails() {
        return "Days Admitted: " + daysAdmitted;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public double getChargePerDay() {
        return chargePerDay;
    }
}
