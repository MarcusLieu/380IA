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
    
    public ArrayList<String> getGenderOptions() {
        return this.genderOptions;
    }

    public void setGenderOptions(ArrayList<String> genderOptions) {
        this.genderOptions = genderOptions;
    }
}
