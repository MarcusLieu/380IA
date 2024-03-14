package edu.ucalgary.oop;

import java.io.*;
import java.util.ArrayList;

public class GenderRetrieval {
    private ArrayList<String> genderOptions;
    private String fileName;

    public GenderRetrieval(String fileName) {
        this.fileName = fileName;
        this.genderOptions = new ArrayList<String>();
        this.readFromFile(fileName);
    }

    public void readFromFile(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = in.readLine()) != null) {
                this.genderOptions.add(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getGenderOptions() {
        return this.genderOptions;
    }

}
