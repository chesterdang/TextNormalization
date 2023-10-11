/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DAO.PointDAO;
import common.Validation;
import java.util.ArrayList;
import model.Point;

/**
 *
 * @author danhv
 */
public class GarbageRespository implements IGarbageRespositoy {
    Validation lib = new Validation();
    @Override
    public boolean addPoint(ArrayList<Point> list) {
       try {
           while (true) {               
               PointDAO.getInstance().add(list);
               String c = lib.getString("Continue? (Y/N): ");
               if (!c.equalsIgnoreCase("y")) {
                  break; 
               }
               System.out.println("Added!");
           }
         
        } catch (Exception e) {
            System.out.println("Adding failure");
            return false;
        }
           return true;
       }

    @Override
    public void calculateCost(ArrayList<Point> list) {
        int maxweight = 10000;
        int time = 0;
        int num =0;
        int i=0;
        int weight=0;
        while (i<list.size()) {
            
            
                if (weight + list.get(i).getGarbageWeight() <= maxweight) {
                    weight += list.get(i).getGarbageWeight();
                    time +=8;
                    i+=1;
                } else {
                    time += 30;
                    num++;     
                    weight = 0;
                }              
            
            
        }
        num++;
        time += 30;
        double hour = (time/60);
        double cost = (hour*120000) + (57000*num);
        System.out.println("The total cost is: " + cost);
    }
}

    
