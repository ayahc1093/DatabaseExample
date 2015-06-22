package com.example.mcberliner.databaseexample;

/**
 * Created by mcberliner on 6/21/2015.
 */
public class Employee {

    private int id;
    private String name;
    private String email;

    public Employee(int id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empoyee [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
