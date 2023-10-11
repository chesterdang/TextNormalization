/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author danhv
 */
public interface IEmployeeResponsitory {
    boolean addEmployee(ArrayList<Employee> list);
    public void displayUpdateSalary(ArrayList<Employee> list);
    public boolean updateSalary(ArrayList<Employee> list, int choice);
}
