# Hospital Management System - OOP Concepts Demonstration

## 📋 Project Overview

This project is a **Hospital Management System** that demonstrates the core Object-Oriented Programming (OOP) concepts in Java. The system manages doctors and patients in a hospital, showcasing how OOP principles make code more organized, reusable, and maintainable.

---

## 🏗️ Project Structure

```
src/
├── com/
│   └── hospital/
│       ├── interfaces/
│       │   └── Billable.java          (Interface)
│       ├── main/
│       │   └── Main.java              (Entry point)
│       └── model/
│           ├── Person.java            (Abstract class)
│           ├── Doctor.java            (Concrete class)
│           ├── Patient.java           (Concrete class)
│           └── Hospital.java          (Main class)
```

---

## 🎯 OOP Concepts Demonstrated

This project demonstrates **5 key OOP concepts**:

1. **Inheritance** 🔄
2. **Abstraction** 🎭
3. **Encapsulation** 🔒
4. **Polymorphism** 🎨
5. **Interface** 📋

---

## 1️⃣ INHERITANCE

**Definition:** Inheritance allows a class to inherit properties and methods from another class.

### Code Demonstration:

#### Base Class: `Person.java`
```java
public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    
    public abstract String getDetails();
}
```

#### Derived Class: `Doctor.java`
```java
public class Doctor extends Person {  // ← INHERITANCE: Doctor inherits from Person
    private String specialization;
    private double salary;

    public Doctor(int id, String name, String specialization, double salary) {
        super(id, name);  // ← Calls parent class constructor
        this.specialization = specialization;
        this.salary = salary;
    }
    // Doctor inherits: id, name, getId(), getName() from Person
}
```

#### Derived Class: `Patient.java`
```java
public class Patient extends Person {  // ← INHERITANCE: Patient inherits from Person
    private int daysAdmitted;
    private double chargePerDay;

    public Patient(int id, String name, int daysAdmitted, double chargePerDay) {
        super(id, name);  // ← Calls parent class constructor
        this.daysAdmitted = daysAdmitted;
        this.chargePerDay = chargePerDay;
    }
    // Patient inherits: id, name, getId(), getName() from Person
}
```

### Explanation:
- Both `Doctor` and `Patient` **extend** the `Person` class
- They inherit common properties (`id`, `name`) and methods (`getId()`, `getName()`)
- The `super()` keyword calls the parent class constructor
- This eliminates code duplication - we don't need to rewrite `id` and `name` in each class

### Inheritance Hierarchy:
```
        Person (Base Class)
         /    \
        /      \
   Doctor    Patient (Derived Classes)
```

---

## 2️⃣ ABSTRACTION

**Definition:** Abstraction hides complex implementation details and shows only essential features.

### Code Demonstration:

#### Abstract Class: `Person.java`
```java
public abstract class Person {  // ← ABSTRACT keyword
    private int id;
    private String name;

    // Concrete methods (have implementation)
    public int getId() { return id; }
    public String getName() { return name; }

    // Abstract method (no implementation - must be overridden)
    public abstract String getDetails();  // ← ABSTRACTION
}
```

#### Implementation in `Doctor.java`:
```java
@Override
public String getDetails() {  // ← Must provide implementation
    return "Specialization: " + specialization;
}
```

#### Implementation in `Patient.java`:
```java
@Override
public String getDetails() {  // ← Must provide implementation
    return "Days Admitted: " + daysAdmitted;
}
```

### Explanation:
- `Person` is an **abstract class** - it cannot be instantiated directly
- The `getDetails()` method is **abstract** - it has no body, only a signature
- Child classes **must** override this method with their own implementation
- This ensures that every `Person` (Doctor or Patient) has a way to show their details, but each shows different information

### Why Use Abstraction?
- Forces child classes to implement required methods
- Provides a common interface for different types of objects
- Hides implementation details from the user

---

## 3️⃣ ENCAPSULATION

**Definition:** Encapsulation is the bundling of data and methods together, and restricting direct access to data.

### Code Demonstration:

#### Example from `Person.java`:
```java
public abstract class Person {
    private int id;        // ← PRIVATE: Cannot be accessed directly
    private String name;   // ← PRIVATE: Cannot be accessed directly

    // Public getter methods - controlled access
    public int getId() { return id; }           // ← ENCAPSULATION
    public String getName() { return name; }    // ← ENCAPSULATION
}
```

#### Example from `Doctor.java`:
```java
public class Doctor extends Person {
    private String specialization;  // ← PRIVATE data
    private double salary;           // ← PRIVATE data

    // Public getters - provide controlled access
    public String getSpecialization() { return specialization; }  // ← ENCAPSULATION
    public double getSalary() { return salary; }                  // ← ENCAPSULATION
}
```

#### Example from `Hospital.java`:
```java
public class Hospital {
    private String hospitalName;                    // ← PRIVATE
    private ArrayList<Doctor> doctors;               // ← PRIVATE
    private ArrayList<Patient> patients;             // ← PRIVATE

    // Public methods to interact with private data
    public void addDoctor(Doctor d) {               // ← ENCAPSULATION
        doctors.add(d);
    }
    
    public void addPatient(Patient p) {             // ← ENCAPSULATION
        patients.add(p);
    }
}
```

### Explanation:
- **Private fields** (`private int id`) cannot be accessed directly from outside the class
- **Public methods** (getters/setters) provide controlled access to the data
- This protects data from being modified incorrectly
- Example: You can't do `doctor.id = 999` directly - you must use proper methods

### Benefits:
- **Data Protection:** Prevents unauthorized access
- **Data Validation:** Can add checks in setter methods
- **Flexibility:** Can change internal implementation without affecting other code

---

## 4️⃣ POLYMORPHISM

**Definition:** Polymorphism allows objects of different types to be treated as objects of a common base type.

### Code Demonstration:

#### Method Overriding in `Doctor.java`:
```java
@Override
public String getDetails() {  // ← Overrides abstract method from Person
    return "Specialization: " + specialization;
}
```

#### Method Overriding in `Patient.java`:
```java
@Override
public String getDetails() {  // ← Overrides abstract method from Person
    return "Days Admitted: " + daysAdmitted;
}
```

#### Polymorphism in Action - `Hospital.java`:
```java
public void showHospitalDetails() {
    // Both Doctor and Patient are treated as Person objects
    for (Doctor d : doctors) {
        System.out.println(d.getName() + " | " + d.getDetails());  
        // ↑ Calls Doctor's getDetails() - returns specialization
    }

    for (Patient p : patients) {
        System.out.println(p.getName() + " | " + p.getDetails());  
        // ↑ Calls Patient's getDetails() - returns days admitted
    }
}
```

#### Polymorphism in `Main.java`:
```java
// Both Doctor and Patient can be stored in Person reference
Person doctor = new Doctor(101, "Dr. Mehta", "Cardiology", 90000);
Person patient = new Patient(201, "Amit", 5, 2000);

// Same method call, different behavior
System.out.println(doctor.getDetails());  // Shows specialization
System.out.println(patient.getDetails()); // Shows days admitted
```

### Explanation:
- **Method Overriding:** Both `Doctor` and `Patient` override the `getDetails()` method
- **Same method name, different behavior:** `getDetails()` returns different information for Doctor vs Patient
- **Runtime Polymorphism:** Java decides which method to call based on the actual object type
- The `@Override` annotation ensures we're actually overriding a method

### Types of Polymorphism:
1. **Compile-time (Method Overloading):** Same method name, different parameters
2. **Runtime (Method Overriding):** Same method signature, different implementation in child classes

---

## 5️⃣ INTERFACE

**Definition:** An interface defines a contract that classes must follow - it specifies what methods a class must implement.

### Code Demonstration:

#### Interface Definition: `Billable.java`
```java
public interface Billable {  // ← INTERFACE keyword
    double calculateBill();  // ← Abstract method (no body)
}
```

#### Implementation in `Patient.java`:
```java
public class Patient extends Person implements Billable {  // ← IMPLEMENTS interface
    private int daysAdmitted;
    private double chargePerDay;

    @Override
    public double calculateBill() {  // ← Must implement interface method
        return daysAdmitted * chargePerDay;
    }
}
```

#### Usage in `Hospital.java`:
```java
for (Patient p : patients) {
    System.out.println("Bill: Rs." + p.calculateBill());  
    // ↑ Uses interface method
}
```

### Explanation:
- `Billable` is an **interface** - it defines a contract
- `Patient` **implements** the `Billable` interface
- The `calculateBill()` method **must** be implemented in `Patient`
- Interfaces allow multiple inheritance (a class can implement multiple interfaces)
- Unlike abstract classes, interfaces cannot have instance variables or constructors

### Interface vs Abstract Class:
| Interface | Abstract Class |
|-----------|----------------|
| Only abstract methods | Can have both abstract and concrete methods |
| Multiple inheritance | Single inheritance |
| No instance variables | Can have instance variables |
| All methods are public | Can have any access modifier |

### Why Use Interfaces?
- **Contract Enforcement:** Ensures classes implement required methods
- **Multiple Inheritance:** A class can implement multiple interfaces
- **Loose Coupling:** Code depends on interface, not implementation

---

## 🔄 How It All Works Together

### Complete Flow in `Main.java`:

```java
public class Main {
    public static void main(String[] args) {
        // 1. Create Hospital object (Encapsulation)
        Hospital hospital = new Hospital("City Care Hospital");

        // 2. Create Doctor objects (Inheritance from Person)
        Doctor d1 = new Doctor(101, "Dr. Mehta", "Cardiology", 90000);
        Doctor d2 = new Doctor(102, "Dr. Sharma", "Neurology", 95000);

        // 3. Create Patient objects (Inheritance from Person + Interface implementation)
        Patient p1 = new Patient(201, "Amit", 5, 2000);
        Patient p2 = new Patient(202, "Priya", 3, 2500);

        // 4. Add to hospital (Encapsulation - using public methods)
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // 5. Display details (Polymorphism - same method, different behavior)
        hospital.showHospitalDetails();
    }
}
```

### Output:
```
========================================
Hospital: City Care Hospital
========================================

Doctors:
  - Dr. Mehta | Specialization: Cardiology
  - Dr. Sharma | Specialization: Neurology

Patients:
  - Amit | Days Admitted: 5 | Bill: Rs.10000.0
  - Priya | Days Admitted: 3 | Bill: Rs.7500.0
```

---

## 📊 OOP Concepts Summary Table

| Concept | Demonstrated In | Key Code Element |
|---------|----------------|------------------|
| **Inheritance** | `Doctor extends Person`<br>`Patient extends Person` | `extends` keyword |
| **Abstraction** | `abstract class Person`<br>`abstract String getDetails()` | `abstract` keyword |
| **Encapsulation** | `private` fields with `public` getters | `private`, getter methods |
| **Polymorphism** | `@Override getDetails()` in Doctor & Patient | `@Override` annotation |
| **Interface** | `Patient implements Billable` | `implements` keyword |

---

## 🎓 Learning Outcomes

By studying this project, you understand:

1. ✅ How to create a class hierarchy using inheritance
2. ✅ How to use abstract classes to enforce method implementation
3. ✅ How to protect data using encapsulation
4. ✅ How polymorphism allows flexible code design
5. ✅ How interfaces define contracts for classes
6. ✅ How all OOP concepts work together in a real-world application

---

## 🚀 Running the Project

See `HOW_TO_RUN.md` for detailed instructions on running this project in VS Code.

---

## 📝 Project Features

- ✅ Clean code structure with proper packages
- ✅ Demonstrates all 5 core OOP concepts
- ✅ Well-commented code for easy understanding
- ✅ Real-world hospital management scenario
- ✅ Beginner-friendly implementation

---

## 👨‍💻 Author

**Experiential Learning Project**  
Demonstrating Object-Oriented Programming concepts in Java

---

## 📚 References

- Java OOP Documentation
- Object-Oriented Programming Principles
- Java Inheritance, Abstraction, Encapsulation, Polymorphism, and Interfaces

---

**Happy Learning! 🎉**
