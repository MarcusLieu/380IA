package edu.ucalgary.oop;

import java.io.*;
import java.util.ArrayList;

public class GenderRetrieval {
    private ArrayList<String> genderOptions;
    private String fileName;

    public GenderRetrieval(String fileName) {
        this.fileName = fileName;
        ArrayList<String> genders = readFromFile(this.fileName);
        this.setGenderOptions(genders);
    }

    
    /** 
     * @param path
     * @return array list of genders read from file
     */
    public ArrayList<String> readFromFile(String path) {
        ArrayList<String> linesRead = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {
                linesRead.add(line.trim().toLowerCase());
            }
        } catch (IOException error) {
            error.printStackTrace();
        } 
        return linesRead;
    }
    
    
    /** 
     * @return array list of gender strings
     */
    public ArrayList<String> getGenderOptions() {
        return this.genderOptions;
    }

    
    /** 
     * set gender options field
     * @param genderOptions an array list of strings
     */
    public void setGenderOptions(ArrayList<String> genderOptions) {
        this.genderOptions = genderOptions;
    }
}
