/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import common.Validation;
import java.util.ArrayList;
import model.Point;

/**
 *
 * @author danhv
 */
public class PointDAO {
    
    private static PointDAO instance = null;
    private Validation lib = new Validation();
    
    public static PointDAO getInstance() {
        if (instance == null) {
            synchronized (PointDAO.class) {
                if (instance == null) {
                    instance = new PointDAO();
                }
            }
        }
        return instance;
    }
    
    public void add(ArrayList<Point> list) {
        int weight = lib.getInt("Enter garbage weight: ", 0, 10000);
        list.add(new Point(weight));
    }
    public void del(ArrayList<Point> list, Point point) {
        list.remove(list.indexOf(point));
    }
}
