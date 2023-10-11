/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import common.Validation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author danhv
 */
public class EmployeeDAO {
    
    private static EmployeeDAO instance = null;
    private Validation lib = new Validation();
    
    public static EmployeeDAO getInstance() {
        if (instance == null) {
            synchronized (EmployeeDAO.class) {
                if (instance == null) {
                    instance = new EmployeeDAO();
                }
            }
        }
        return instance;
    }
    
    public void add(ArrayList<Employee> list) {
        String id = lib.getString("Enter id: ");
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)){
                System.out.println("Dupplicate!");
                return;
            }
        }
        String name = lib.getString("Enter name: ");
        int age = lib.getInt("Enter age: ", 18, 50);
        int salary = lib.getInt("Enter salary: ", 0, Integer.MAX_VALUE);
        String location = lib.getString("Enter location: ");
        list.add(new Employee(id,name,age,salary,location));
    }   
    
    public boolean updateSalary(ArrayList<Employee> list, int choice, String id) {
        
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                employee.setStatus(choice);
                int amount = lib.getInt("Enter amount: ", 0, Integer.MAX_VALUE);
                LocalDateTime myDateObj = LocalDateTime.now();  
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
                String formattedDate = myDateObj.format(myFormatObj);
                employee.setDate(formattedDate);
                if (choice == 1) {
                    employee.setSalary(employee.getSalary()+amount);
                } else  employee.setSalary(employee.getSalary()-amount);
                return true;
            }
        }
        return false;
    }
}
