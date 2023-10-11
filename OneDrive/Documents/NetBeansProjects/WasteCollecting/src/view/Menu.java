/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import common.Validation;
import java.util.ArrayList;

/**
 *
 * @author danhv
 */

public abstract class Menu <T> {
    protected String title;
    protected ArrayList<T> menuChoice;
    Validation lib = new Validation();
    
    public Menu() {
        menuChoice = new ArrayList<>();
    }
    
    public Menu(String title, String menuString[]) {
        this.title = title;
        menuChoice = new ArrayList<>();
        for (String line : menuString) {
            menuChoice.add((T)line);
        }
    }
    
    public void display() {
        System.out.println(title);
        System.out.println("--------------------");
        for (T t : menuChoice) {
            System.out.println(t);
        }
        System.out.println("--------------------");
    }
    
    public int getChoice() {
        display();
        return lib.getInt("Enter your choice: ",1,menuChoice.size()+1);
    }
    
    public abstract void execute(int n);
    
    public void run() {
        while (true) {
            int n=getChoice();
            execute(n);
            if (n>menuChoice.size()) break;
        }
    }
}
