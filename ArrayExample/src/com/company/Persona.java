package com.company;

public class Persona {
    private String name;
    private String lastName;
    private int age;

    public String getName() {
        return name;
    }

    public Persona(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

}
