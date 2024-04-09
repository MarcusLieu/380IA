
package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * describes important details relating to a victims medical status
 */
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
     * gets location field
     * @return location as Location object
     */
    public Location getLocation() {
        return this.location;
    }

    
    /** 
     * sets location field
     * @param location as Location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    
    
    /** 
     * gets TreatmentDetails field
     * @return treatment details as String
     */
    public String getTreatmentDetails() {
        return this.treatmentDetails;
    }

    
    /** 
     * sets TreatmentDetails field
     * @param treatmentDetails as string
     */
    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = new String(treatmentDetails);
    }

   
    
    /** 
     * gets DateOfTreatment field
     * @return date of treatment as String
     */
    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    
    /** 
     * sets DateOfTreatment field
     * @param dateOfTreatment as String
     */
    public void setDateOfTreatment(String dateOfTreatment) {
        String validatedDate = validateDate(dateOfTreatment);
        this.dateOfTreatment = validatedDate;
    }

    
    /** 
     * @param date as String
     * @return date as String
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
