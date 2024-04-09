
package edu.ucalgary.oop;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReliefService implements DateFormat{
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;
    
    public ReliefService( Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, 
    String infoProvided, Location lastKnownLocation){
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
        inquirer.addLog(this);
    }
    
    /** 
     * @param inquirer
     */
    public void setInquirer( Inquirer inquirer){
        this.inquirer = inquirer;
    }

    
    /** 
     * @param missingPerson
     */
    public void setMissingPerson( DisasterVictim missingPerson){
        this.missingPerson = missingPerson;
    }

    
    /** 
     * @param dateOfInquiry
     * @throws IllegalArgumentException
     */
    public void setDateOfInquiry(String dateOfInquiry) throws IllegalArgumentException{
        String validatedDate = validateDate(dateOfInquiry);
        this.dateOfInquiry = validatedDate;
    }


    
    /** 
     * @param infoProvided
     */
    public void setInfoProvided( String infoProvided){
        this.infoProvided = infoProvided;
    }

    
    /** 
     * @param lastKnownLocation
     */
    public void setLastKnownLocation(Location lastKnownLocation){
        this.lastKnownLocation = lastKnownLocation;
    }
    
    
    /** 
     * @return Inquirer
     */
    //getters
    public Inquirer getInquirer(){
        return inquirer;
    }

    
    /** 
     * @return DisasterVictim
     */
    public DisasterVictim getMissingPerson(){
        return missingPerson;
    }

    
    /** 
     * @return String
     */
    public String getDateOfInquiry(){
        return dateOfInquiry;
    }

    
    /** 
     * @return String
     */
    public String getInfoProvided(){
        return infoProvided;
    }

    
    /** 
     * @return Location
     */
    public Location getLastKnownLocation(){
        return lastKnownLocation;
    }

    
    /** 
     * @return String
     */
    public String getLogDetails(){
        Inquirer inquirer = getInquirer();
        DisasterVictim missingPerson = getMissingPerson();
        String dateOfInquiry = getDateOfInquiry();
        String infoProvided = getInfoProvided();
        Location lastKnownLocation = getLastKnownLocation();

        return "Inquirer: " + inquirer.getFirstName() +", "+
               "Missing Person: " + missingPerson.getFirstName() + ", "+
               "Date of Inquiry: " + dateOfInquiry +", "+ 
               "Info Provided: " + infoProvided +", "+
               "Last Known Location: " + lastKnownLocation.getName();
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
