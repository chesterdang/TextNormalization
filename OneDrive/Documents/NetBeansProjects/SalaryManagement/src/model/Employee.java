/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;



/**
 *
 * @author danhv
 */
public class Employee {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String location;
    private int status;
    private String date;

    public Employee() {
    }

    public Employee(String id, String name, int age, int salary, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
        this.status = 0;
        this.date = null;
    }

    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void display() {
        String s;
        if (this.getStatus() == 1) {
            s = "Up";
        } else {
            s = "Down";
        }
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",this.getId(),this.getName(),this.getAge(), this.getSalary(),s,this.getDate());
    }
    
    
}
