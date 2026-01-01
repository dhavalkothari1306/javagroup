# Hospital Management System

A simple Java project demonstrating Object-Oriented Programming concepts.

## Project Description

This project simulates a basic hospital management system where we can manage doctors and patients. It demonstrates key OOP concepts learned in Java programming.

## OOP Concepts Demonstrated

1. **Inheritance**: `Doctor` and `Patient` classes inherit from `Person` class
2. **Abstraction**: `Person` is an abstract class with abstract method `getDetails()`
3. **Encapsulation**: Private fields with public getter methods
4. **Polymorphism**: Method overriding in `getDetails()` method
5. **Interface**: `Billable` interface implemented by `Patient` class

## Project Structure

```
src/
├── com/
│   └── hospital/
│       ├── interfaces/
│       │   └── Billable.java
│       ├── main/
│       │   └── Main.java
│       └── model/
│           ├── Person.java
│           ├── Doctor.java
│           ├── Patient.java
│           └── Hospital.java
```

## Classes Overview

- **Person**: Abstract base class with id and name
- **Doctor**: Extends Person, has specialization and salary
- **Patient**: Extends Person and implements Billable, has days admitted and charge per day
- **Hospital**: Manages collection of doctors and patients
- **Billable**: Interface for calculating bills

## How to Run

See `HOW_TO_RUN.md` for detailed instructions.

## Output

The program displays:
- Hospital name
- List of all doctors with their details
- List of all patients with their bills

