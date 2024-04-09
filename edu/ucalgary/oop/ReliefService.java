
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
     * set inquirer field
     * @param inquirer as Inquirer object
     */
    public void setInquirer( Inquirer inquirer){
        this.inquirer = inquirer;
    }

    
    /** 
     * set missingPerson field
     * @param missingPerson as DisasterVictim object
     */
    public void setMissingPerson( DisasterVictim missingPerson){
        this.missingPerson = missingPerson;
    }

    
    /** 
     * sets dateOfInquiry field only if it follows valid format xxxx-xx-xx where x is a number
     * @param dateOfInquiry as String
     * @throws IllegalArgumentException if date entered does not follow xxxx-xx-xx
     */
    public void setDateOfInquiry(String dateOfInquiry) throws IllegalArgumentException{
        String validatedDate = validateDate(dateOfInquiry);
        this.dateOfInquiry = validatedDate;
    }


    
    /** 
     * sets infoProvided field
     * @param infoProvided as String
     */
    public void setInfoProvided( String infoProvided){
        this.infoProvided = infoProvided;
    }

    
    /** 
     * sets lastKnownLocation field
     * @param lastKnownLocation as Location obeject
     */
    public void setLastKnownLocation(Location lastKnownLocation){
        this.lastKnownLocation = lastKnownLocation;
    }
    
    
    /** 
     * gets Inquirer field
     * @return inquirer as Inquirer object
     */
    public Inquirer getInquirer(){
        return inquirer;
    }

    
    /** 
     * gets missingPerson field
     * @return missing person as DisasterVictim 
     */
    public DisasterVictim getMissingPerson(){
        return missingPerson;
    }

    
    /** 
     * gets dateOfInquiry field
     * @return date of inquiry as String
     */
    public String getDateOfInquiry(){
        return dateOfInquiry;
    }

    
    /** 
     * gets infoProvided field
     * @return info provided as String
     */
    public String getInfoProvided(){
        return infoProvided;
    }

    
    /** 
     * gets lastKnownLocation field
     * @return last known location as Location object
     */
    public Location getLastKnownLocation(){
        return lastKnownLocation;
    }

    
    /** 
     * prints log details which is a combination of all the fields
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
     * checks if date follows format xxxx-xx-xx where x is a number
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
