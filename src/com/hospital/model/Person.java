package com.hospital.model;

public abstract class Person {
    private int id;
    private String name;

    // Encapsulation
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    // Abstraction
    public abstract String getDetails();
}
