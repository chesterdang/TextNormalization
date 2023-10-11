/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.Point;
import repository.GarbageRespository;
import view.Menu;

/**
 *
 * @author danhv
 */

public class Program extends Menu<String> {

    private ArrayList<Point> list;
    private GarbageRespository dr = new GarbageRespository();

    public Program() {
        super("WAST COLLECTING PROGRAM", new String[]{"Add garbage point", "Calculatate cost", "Exit"});
        this.list = new ArrayList<Point>();
    }

    @Override
    public void execute(int n) {
        
        switch (n) {
            case 1:
                dr.addPoint(list);
                break;
            case 2:
                dr.calculateCost(list);
                break;
            case 3:  
                System.exit(0);
        }
    }

   
    

}