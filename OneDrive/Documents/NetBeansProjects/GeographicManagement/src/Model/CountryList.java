/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Common.Validation;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author danhv
 */
public class CountryList {
    protected ArrayList<Country> list;
    protected Validation lib;
    public CountryList(ArrayList<Country> list) {
        this.list = new ArrayList<Country>();
        this.lib = new Validation();
    }

    public CountryList() {
        lib = new Validation();
        list = new ArrayList<Country>();
    }
    
    public void addCountryInformation() {
        String code = lib.getString("Enter code of the country: ");
        String name = lib.getString("Enter name of the country: ");
        float area = lib.getFloat("Enter toal area of the country: ", 0, 1000000000);
        String terrain = lib.getString("Enter terrain of the country; ");
        list.add(new EastAsiaCountries(code,name,area,terrain));
    }
    
    public void getRecentlyEnteredOrder() {
        System.out.printf("%-10s%-15s%-15s%-10s\n","Code","Name","Total Area","Terrain");
        Country o = list.get(list.size()-1);
        o.display();
    }
    
    public void sortInformationByAscendingOrder() {
        ArrayList<Country> list1 = new ArrayList<Country>(list);
        Collections.sort(list1);
        System.out.printf("%-10s%-15s%-15s%-10s","Code","Name","Total Area","Terrain");
        System.out.println("");
        for (Country country : list1) {
            country.display();
        }
    }
    
    public void searchInformationByName() {
        Boolean check = false;
        String name = lib.getString("Enter the name you want to search for: ");
        for (Country country : list) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                if (check ==false) {
                    System.out.printf("%-10s%-15s%-15s%-10s","Code","Name","Total Area","Terrain");
                    System.out.println("");
                    check = true;
                }
                country.display();
            }
        }
        if (check == false) System.out.println("Not found!");
    }
}
