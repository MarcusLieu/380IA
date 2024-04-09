package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalRecord implements DateFormat{
    private Location location; 
    private String treatmentDetails;
    private String dateOfTreatment; 

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException{
        String validatedDate = validateDate(dateOfTreatment);
        this.location = location;
        this.treatmentDetails = new String(treatmentDetails);
        this.dateOfTreatment = new String(validatedDate);
    }
     
    
    /** 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }

    
    /** 
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    
    
    /** 
     * @return String
     */
    public String getTreatmentDetails() {
        return this.treatmentDetails;
    }

    
    /** 
     * @param treatmentDetails
     */
    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = new String(treatmentDetails);
    }

   
    
    /** 
     * @return String
     */
    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    
    /** 
     * @param dateOfTreatment
     */
    public void setDateOfTreatment(String dateOfTreatment) {
        String validatedDate = validateDate(dateOfTreatment);
        this.dateOfTreatment = validatedDate;
    }

    
    /** 
     * @param date
     * @return String
     */
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
