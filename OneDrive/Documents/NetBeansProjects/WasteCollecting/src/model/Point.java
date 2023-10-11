/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danhv
 */
public class Point {
    private int garbageWeight;

    public Point(int garbageWeight) {
        this.garbageWeight = garbageWeight;
    }

    public int getGarbageWeight() {
        return garbageWeight;
    }

    public void setGarbageWeight(int garbageWeight) {
        this.garbageWeight = garbageWeight;
    }

    @Override
    public String toString() {
        return "Point{" + "garbageWeight=" + garbageWeight + '}';
    }
    
}
