/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.Menu;

/**
 *
 * @author danhv
 */

public class NormalizingProgramming extends Menu<String> {

    public NormalizingProgramming() {
        super("Nomarlizing Text", new String[]{"Normalizing", "Exit"});
    }

    @Override
    public void excute(int n) {
        if(n == 1){
           if(writeToFile() == true){
               System.out.println("Normalized");
           }
        }
    }

    //functions for normalizing text
    public String normalize(String line) {
        Pattern pattern;
        Matcher matcher;
        
        // check argument
        if(line.trim().length() == 0) return "";

        // no space in front of comma and dot characters  and add a space after matched string.   
        pattern = Pattern.compile("[ ]+,", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(line);
        if (matcher.find()) {
                line = matcher.replaceAll(", ");
        }
        
        pattern = Pattern.compile("[ ]+\\.", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(line);
        if (matcher.find()) {
                line = matcher.replaceAll(". ");
        }
        
        // convert many space into a space
        pattern = Pattern.compile("[ ]+", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(line);
        if (matcher.find()) {
            line = matcher.replaceAll(" ").trim();
        }
        
        

        // first character of word is  in upppercase
        line = " " + Character.toUpperCase(line.charAt(0)) + line.substring(1);

        // Must have dot at the end of text.
        if (line.charAt(line.length() - 1) != '.') {
            line += ".";
        }

        for (int i = 0; i < line.length(); i++) {

            // upppercase after .
            try {
                if (line.charAt(i) == '.' && line.charAt(i + 1) == ' ' && Character.isLowerCase(line.charAt(+2))) {
                    line = line.substring(0, i + 2) + Character.toUpperCase(line.charAt(i + 2)) + line.substring(i + 3, line.length());
                }
            } catch (Exception e) {
            }

            // normalize ("") 
            try {
                if (line.charAt(i) == '“' & line.charAt(i + 1) == ' ') {
                    line = line.substring(0, i + 1) + line.substring(i + 2, line.length());
                } else if (line.charAt(i) == ' ' && line.charAt(i + 1) == '”') {
                    line = line.substring(0, i) + line.substring(i + 1, line.length());
                }
            } catch (Exception e) {
            }
        }

        return line;
    }
    
    
    // read textFile
    public String readFromFile(){
        String line ="";
        StringBuilder sb = new StringBuilder();
        try {
            FileReader reader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
 
        } catch (IOException e) {
            System.out.println(" \"Read From File\" Error");
        }
        
        return sb.toString();
    }
    
    
    // write to text file
    public boolean writeToFile(){
         try {
            FileWriter writer = new FileWriter("output.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write(normalize(readFromFile()));
 
            bufferedWriter.close();
        } catch (IOException e) {
             System.out.println(" \"Write to File\" Error");
             return false;
        }
         
         return true;
    }

}