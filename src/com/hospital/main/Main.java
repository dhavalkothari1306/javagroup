

import com.hospital.model.*;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Care Hospital");

        Doctor d1 = new Doctor(101, "Dr. Mehta", "Cardiology", 90000);
        Patient p1 = new Patient(201, "Amit", 5, 2000);

        hospital.addDoctor(d1);
        hospital.addPatient(p1);

        hospital.showHospitalDetails();
    }
}
