/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Employee;
import responsitory.EmployeeResponsitory;
import view.Menu;

/**
 *
 * @author danhv
 */

public class Program extends Menu<String> {

    private ArrayList<Employee> list = new ArrayList<>();
    private EmployeeResponsitory er = new EmployeeResponsitory();

    public Program() {
        super("Salary MANAGEMENT", new String[]{"Add employee", "Up salary", "Down salary", "Display update", "Exit"});
    }

    @Override
    public void excute(int n) {
        switch (n) {
            case 1:
                er.addEmployee(list);
                break;
            case 2:
                er.updateSalary(list, 1);
                break;
            case 3:
                er.updateSalary(list, -1);
                break;
            case 4: 
                er.displayUpdateSalary(list);
                break;
            case 5: 
                System.exit(0);
        }
    }

}