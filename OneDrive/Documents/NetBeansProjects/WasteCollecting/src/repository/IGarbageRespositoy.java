/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.Point;

/**
 *
 * @author danhv
 */
public interface IGarbageRespositoy {
    public boolean addPoint(ArrayList<Point> list);
    public void calculateCost(ArrayList<Point> list);
}
