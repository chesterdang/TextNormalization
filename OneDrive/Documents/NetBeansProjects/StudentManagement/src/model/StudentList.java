/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Library;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author danhv
 */
public class StudentList {
    private ArrayList<Report> report;
    private ArrayList<Student> list;
    private Library lib;
    public StudentList(ArrayList<Student> list) {
        this.list = new ArrayList<Student>();
    }
    
    public void add() {
        int k = list.size() +10;
        while (list.size() < k) {
            String id = lib.getString("Enter id: ");
            String name =lib.getString("Enter name: ");
            int c = lib.getInt("Enter course (1:Java, 2:.Net, 3:C# : ", 1, 3);
            String course="";
            switch(c) {
                case 1: 
                    course = "Java";
                    break;
                case 2: 
                    course = ".Net";
                    break;
                case 3:
                    course = "C#";
                    break;
            }
            String semester = lib.getString("Enter semester: ");
            list.add(new Student(id,name,course,semester));
            for (Report r : report) {
                if (r.getId().equalsIgnoreCase(id) 
                        && r.getName().equalsIgnoreCase(name) 
                        && r.getCourse().equalsIgnoreCase(course)) 
                r.setTotal(r.getTotal()+1);
            } 
        }
            String choice = lib.getString("Continue (Y/N): ");
            if (choice == "Y" || choice == "y") add();
    }
    
    public void findNSort() {
        Collections.sort(list);
        System.out.println("Student List: ");
        for (Student student : list) {
            System.out.println(student.toString());
        }
        String name = lib.getString("Enter name or part of name: ");
        for (Student student : list) {
            if (student.getName().contains(name)) System.out.println(student.toString());
        }
    }
    
    public void upOrDelete() {
        for (int i=0; i<list.size(); i++) {
            System.out.println(i+1 + list.get(i).toString());
        }
        int num = lib.getInt("Enter the numerical order of student to update or delete", 1, list.size());
        String choice;
        while (true) {
            choice = lib.getString("Enter U (update) or D (delete): ");
            if (choice.equalsIgnoreCase("u") || choice.equalsIgnoreCase("d")) break;
        }
        if (choice.equalsIgnoreCase("u")) {
            String name = lib.getString("Enter name: ");
            String semester = lib.getString("Enter semester: ");
            int c = lib.getInt("Enter course (1:Java, 2:.Net, 3:C# : ", 1, 3);
            String course="";
            switch(c) {
                case 1: 
                    course = "Java";
                    break;
                case 2: 
                    course = ".Net";
                    break;
                case 3:
                    course = "C#";
                    break;
            }
            list.get(num-1).setName(name);
            list.get(num-1).setCourse(course);
            list.get(num-1).setSemester(semester);
            System.out.println("Update success!");
        } else {
            list.remove(list.get(num-1));
            System.out.println("Delete success!");
        }
        
    }
    
    
}
