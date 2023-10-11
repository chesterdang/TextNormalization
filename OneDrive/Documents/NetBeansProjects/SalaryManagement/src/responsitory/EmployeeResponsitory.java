/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import common.Validation;
import dao.EmployeeDAO;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author danhv
 */
public class EmployeeResponsitory implements IEmployeeResponsitory {
    private Validation lib = new Validation();
    @Override
    public boolean addEmployee(ArrayList<Employee> list) {
        try {
            EmployeeDAO.getInstance().add(list);
            System.out.println("Added");
        } catch (Exception e) {
            System.out.println("Adding failure");
            return false;
        }
        return true;
    }

    @Override
    public void displayUpdateSalary(ArrayList<Employee> list) {
        boolean check = false;
        for (Employee employee : list) {
            if (employee.getStatus() != 0) {
                if (check == false) {
                    check = true;
                    System.out.println("---------------Display Information Salary---------------");
                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n","Code","Name","Age", "Salary","Status","Date");
                }
                employee.display();
            }
        }
        if (check == false) {
            System.out.println("Not found!");
        }
    }

    @Override
    public boolean updateSalary(ArrayList<Employee> list, int choice) {
        if (choice == 1) {
            System.out.println("---------------Up Salary---------------");
        } else System.out.println("---------------Down Salary---------------");
        String id = lib.getString("Enter id: ");
        if (EmployeeDAO.getInstance().updateSalary(list, choice, id)) {
            System.out.println("Updated");
        } else {
            System.out.println("Not found!");
            return false;
        }
        return true;
    }
    
}
