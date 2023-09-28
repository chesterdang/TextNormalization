/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Validation;
import Model.CountryList;
import View.Menu;


/**
 *
 * @author danhv
 */


public class ManageEastAsiaCountries extends Menu<String> {
    static String[] searchChoice = {"1. Input the information of 11 countries in East Asia", "2. Display the information of country you've just input", "3. Search the information of country by user-entered name","4. Display the information of countries sorted name in ascending order ","5. Exit "};
    protected Validation lib;
    protected CountryList list;
    public ManageEastAsiaCountries () {
        super("EAST ASIA COUNTRIES MANAGEMENT", searchChoice);
        lib = new Validation();
        list = new CountryList();
    
    }

    @Override
    public void execute(int n) {
        int x;
        switch (n) {
            case 1: 
                list.addCountryInformation();
                break;
            case 2: 
                list.getRecentlyEnteredOrder();
                break;
            case 3: 
                list.searchInformationByName();
                break;
            case 4: 
                list.sortInformationByAscendingOrder();
                break;
            case 5: 
                System.exit(0);
        }
    }
}
