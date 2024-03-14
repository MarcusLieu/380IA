package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalRecord {
    private Location location; 
    private String treatmentDetails;
    private String dateOfTreatment; 

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException{
        String validatedDate = validateDate(dateOfTreatment);
        this.location = location;
        this.treatmentDetails = new String(treatmentDetails);
        this.dateOfTreatment = new String(validatedDate);
    }
     
    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    
    public String getTreatmentDetails() {
        return this.treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = new String(treatmentDetails);
    }

   
    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) {
        String validatedDate = validateDate(dateOfTreatment);
        this.dateOfTreatment = validatedDate;
    }

    public String validateDate(String date) {
        Pattern dateOfBirth_pat = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher myMatcher = dateOfBirth_pat.matcher(date);
        if(myMatcher.find()) {
            return date;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
