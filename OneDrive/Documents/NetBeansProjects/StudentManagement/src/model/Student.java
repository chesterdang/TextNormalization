/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danhv
 */
public class Student implements Comparable<Student>{
    private String id;
    private String name; 
    private String course;
    private String semester;

    public Student(String id, String name, String course, String semester) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", course=" + course + ", semester=" + semester + '}';
    }

    
    @Override
    public int compareTo(Student o) {

        return this.getName().compareTo(o.getName());
    }
    
    
}
