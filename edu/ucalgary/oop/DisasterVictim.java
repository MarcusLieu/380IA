

package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum DietaryRestrictions {
    AVML,
    DBML,
    GFML,
    KSML,
    LSML,
    MOML,
    PFML,
    VGML,
    VJML
}
/**
 * A victim with a unique id, medical records, relations, allocated supplies
 */
public class DisasterVictim extends Person implements DateFormat{
    private String comments;
    private int ASSIGNED_SOCIAL_ID;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<FamilyRelation> familyConnections;
    private String ENTRY_DATE;
    private ArrayList<Supply> personalBelongings;
    private String gender;
    private static int counter;
    private ArrayList<String> dietaryRestrictions;

    public DisasterVictim(String firstName, String ENTRY_DATE) throws IllegalArgumentException{
        this.firstName = firstName.trim();
        this.ASSIGNED_SOCIAL_ID = counter;
        counter++;
        String validatedDate = validateDate(ENTRY_DATE);
        this.ENTRY_DATE = validatedDate;
    }

    
    /** 
     * gets the date of birth of a disaster victim
     * @return birth date as String
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    /** 
     * gets the comments of a disaster victim
     * @return comments as String
     */
    public String getComments() {
        return this.comments;
    }
    
    /** 
     * gets the list of medical records of a disaster victim
     * @return medical records as array list
     */
    public ArrayList<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }
    
    /** 
     * gets the entry date of a disaster victim
     * @return entry date as String
     */
    public String getEntryDate() {
        return this.ENTRY_DATE;
    }
    
    /** 
     * gets the unique id of a disaster victim
     * @return assigned social id as int
     */
    public int getAssignedSocialID() {
        return this.ASSIGNED_SOCIAL_ID;
    }
    
    /** 
     * gets the list of personal belongings of a disaster victim
     * @return personal belongings as array list
     */
    public ArrayList<Supply> getPersonalBelongings() {
        return this.personalBelongings;
    }
    
    /** 
     * gets the list of family relations of a disaster victim
     * @return family connectuons as array list
     */
    public ArrayList<FamilyRelation> getFamilyConnections() {
        return this.familyConnections;
    }
    
    /** 
     * gets the gender of a disaster victim
     * @return gender as String
     */
    public String getGender() {
        return this.gender;
    }
    
    /** 
     * gets the age of a disaster victim
     * @return age as int
     */
    public int getAge() {
        return this.age;
    }

    
    /** 
     * gets the list of dietary restrictions of a disaster victim
     * @return dietary restrictions as array list
     */
    public ArrayList<String> getDietaryRestrictions() {
        return this.dietaryRestrictions;
    }
    
    /** 
     * validates if a date of birth follows the format xxxx-xx-xx where x is a number and sets it only if age is not already set
     * @param dateOfBirth a string 
     * @throws IllegalArgumentException is thrown if date does not follow specified format
     */
    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        String validatedDate = validateDate(dateOfBirth);
        if (this.age == 0) {
            this.dateOfBirth = validatedDate;
            return;
        }
        throw new IllegalArgumentException();
    }
    
    /** 
     * sets comment field of disaster victim
     * @param comments a string
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /** 
     * sets the medicalRecord field of a disaster victim
     * @param medicalRecords an arraylist of medical records
     */
    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
    
    /** 
     * sets the supplies field of a disaster victim
     * @param supplies an arraylist of supplies
     */
    public void setPersonalBelongings(ArrayList<Supply> supplies) {
        this.personalBelongings = supplies;
    }
    
    /** 
     * sets the familyConnections field of a disaster victim
     * @param familyConnections an arraylist of familyConnections
     */
    public void setFamilyConnections(ArrayList<FamilyRelation> familyConnections) {
        this.familyConnections = familyConnections;
    }
    
    
    /** 
     * reads from a text file and checks if the gender attempting to be set matches one in the file
     * @param gender a string
     * @param genderFile a GenderRetrieval object
     * @throws IllegalArgumentException if gender string is not the same as any of the available genders in the file being read
     */
    public void setGender(String gender, GenderRetrieval genderFile) throws IllegalArgumentException{
        ArrayList<String> genderList = genderFile.getGenderOptions();
        gender = gender.toLowerCase();
        if (genderList.contains(gender)) {
            this.gender = gender;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    
    /** 
     * sets the age field of a disaster victim only if their birthdate is not already set
     * @param age
     * @throws IllegalArgumentException
     */
    public void setAge(int age) throws IllegalArgumentException{
        if (age > 0 && this.dateOfBirth == null) {
            this.age = age;
            return;
        }
        throw new IllegalArgumentException();
    }

    
    /** 
     * adds an element to personal belongings arraylist of disaster victim only if it is available at the location specified
     * @param supply a supply object
     * @param location a location object
     */
    public void addPersonalBelonging(Supply supply, Location location) {
        if (this.personalBelongings == null) {
            this.personalBelongings = new ArrayList<Supply>();
        }

        if (location.getOccupants().contains(this) && location.getSupplies().contains(supply)) {
            this.personalBelongings.add(supply);
            int position = location.getSupplies().indexOf(supply);
            location.getSupplies().get(position).setQuantity(location.getSupplies().get(position).getQuantity() - 1);
            if (location.getSupplies().get(position).getQuantity() == 0) {
                location.removeSupply(supply);
            }
        }
    }
    
    /** 
     * removes an element from personal belongings arraylist of a disaster victim only if its personal belongings is not already empty
     * @param supply
     */
    public void removePersonalBelonging(Supply supply) {
        if (this.personalBelongings != null) {
            this.personalBelongings.remove(supply);
        }
    }
    
    /** 
     * adds an element to familyConnections of a disaster victim only if the disaster victim being linked to already exists, and does not already have a pre-existing relationship with the current disaster victim
     * @param familyConnection a familyConnection object
     * @throws IllegalArgumentException is thrown if disaster victim being linked to does not exist, or if relationship already exists between the 2
     */
    public void addFamilyConnection(FamilyRelation familyConnection) throws IllegalArgumentException {
        if (familyConnection.getPersonOne().getFamilyConnections() == null && familyConnection.getPersonTwo().getFamilyConnections() == null) {

            if (this.familyConnections == null) {
                this.familyConnections = new ArrayList<FamilyRelation>();
                this.familyConnections.add(familyConnection);
            }
            else {
                this.familyConnections.add(familyConnection);
            }

            if (this == familyConnection.getPersonOne()) {
                if (familyConnection.getPersonTwo().getFamilyConnections() == null) {
                    ArrayList<FamilyRelation> newRelation = new ArrayList<FamilyRelation>();
                    familyConnection.getPersonTwo().setFamilyConnections(newRelation);
                    familyConnection.getPersonTwo().getFamilyConnections().add(familyConnection);
                }
                else {
                    familyConnection.getPersonTwo().getFamilyConnections().add(familyConnection);
                }
            }
            else {
                if (familyConnection.getPersonOne().getFamilyConnections() == null) {
                    ArrayList<FamilyRelation> newRelation = new ArrayList<FamilyRelation>();
                    familyConnection.getPersonOne().setFamilyConnections(newRelation);
                    familyConnection.getPersonOne().getFamilyConnections().add(familyConnection);
                }
                else {
                    familyConnection.getPersonOne().getFamilyConnections().add(familyConnection);
                }
            }
            return;
        }

        if (familyConnection.getPersonOne().getFamilyConnections() != null) {
            for (int i = 0; i < familyConnection.getPersonOne().getFamilyConnections().size(); i++) {
                if (familyConnection.getPersonOne().getFamilyConnections().get(i).getPersonOne() != familyConnection.getPersonTwo() && familyConnection.getPersonOne().getFamilyConnections().get(i).getPersonTwo() != familyConnection.getPersonTwo() ) {
                    if (this.familyConnections == null) {
                        this.familyConnections = new ArrayList<FamilyRelation>();
                        this.familyConnections.add(familyConnection);
                    }
                    else {
                        this.familyConnections.add(familyConnection);
                    }
        
                    if (this == familyConnection.getPersonOne()) {
                        if (familyConnection.getPersonTwo().getFamilyConnections() == null) {
                            ArrayList<FamilyRelation> newRelation = new ArrayList<FamilyRelation>();
                            familyConnection.getPersonTwo().setFamilyConnections(newRelation);
                            familyConnection.getPersonTwo().getFamilyConnections().add(familyConnection);
                        }
                        else {
                            familyConnection.getPersonTwo().getFamilyConnections().add(familyConnection);
                        }
                    }
                    else {
                        if (familyConnection.getPersonOne().getFamilyConnections() == null) {
                            ArrayList<FamilyRelation> newRelation = new ArrayList<FamilyRelation>();
                            familyConnection.getPersonOne().setFamilyConnections(newRelation);
                            familyConnection.getPersonOne().getFamilyConnections().add(familyConnection);
                        }
                        else {
                            familyConnection.getPersonOne().getFamilyConnections().add(familyConnection);
                        }
                    }
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < familyConnection.getPersonTwo().getFamilyConnections().size(); i++) {
                if (familyConnection.getPersonTwo().getFamilyConnections().get(i).getPersonOne() != familyConnection.getPersonOne() && familyConnection.getPersonTwo().getFamilyConnections().get(i).getPersonTwo() != familyConnection.getPersonOne()) {
                    if (this.familyConnections == null) {
                        this.familyConnections = new ArrayList<FamilyRelation>();
                        this.familyConnections.add(familyConnection);
                    }
                    else {
                        this.familyConnections.add(familyConnection);
                    }
        
                    if (this == familyConnection.getPersonOne()) {
                        if (familyConnection.getPersonTwo().getFamilyConnections() == null) {
                            ArrayList<FamilyRelation> newRelation = new ArrayList<FamilyRelation>();
                            familyConnection.getPersonTwo().setFamilyConnections(newRelation);
                            familyConnection.getPersonTwo().getFamilyConnections().add(familyConnection);
                        }
                        else {
                            familyConnection.getPersonTwo().getFamilyConnections().add(familyConnection);
                        }
                    }
                    else {
                        if (familyConnection.getPersonOne().getFamilyConnections() == null) {
                            ArrayList<FamilyRelation> newRelation = new ArrayList<FamilyRelation>();
                            familyConnection.getPersonOne().setFamilyConnections(newRelation);
                            familyConnection.getPersonOne().getFamilyConnections().add(familyConnection);
                        }
                        else {
                            familyConnection.getPersonOne().getFamilyConnections().add(familyConnection);
                        }
                    }
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }
    
    /** 
     * removes element from familyConnections of disastser victim only if their familyConnections is not already empty, also works two ways so the other disaster victim being linked to also has their relationship removed
     * @param familyConnection a familyConnection object
     */
    public void removeFamilyConnection(FamilyRelation familyConnection) {
        if (this.familyConnections != null) {
            if (this == familyConnection.getPersonOne()) {
                this.familyConnections.remove(familyConnection);
                familyConnection.getPersonTwo().getFamilyConnections().remove(familyConnection);
            }
            else {
                this.familyConnections.remove(familyConnection);
                familyConnection.getPersonOne().getFamilyConnections().remove(familyConnection);
            }
        }
    }
    
    /** 
     * adds an element to medicalRecord arraylist of disaster victim
     * @param medicalRecord a medicalRecord object
     */
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        if (this.medicalRecords == null)  {
            this.medicalRecords = new ArrayList<MedicalRecord>();
            this.medicalRecords.add(medicalRecord);
        }
        else {
            this.medicalRecords.add(medicalRecord);
        }
    }
    
    /** 
     * adds an element to DietaryRestriction arraylist of disaster victim only if the value being added matches a value in the enumerate
     * @param diet a String
     * @throws IllegalArgumentException thrown if diet being added is not in enumeration
     */
    public void addDietraryRestriction(String diet) throws IllegalArgumentException {
        for (DietaryRestrictions d : DietaryRestrictions.values()) {
            String a = diet;
            String b = d.toString();
            if (a == b) {
                if (this.dietaryRestrictions == null) {
                    this.dietaryRestrictions = new ArrayList<String>();
                }
                this.dietaryRestrictions.add(diet.toUpperCase());
                return;
            }
        }
        throw new IllegalArgumentException();
    }
    
    /** 
     * removes element from DietaryRestriction arraylist of disaster victim only if the arraylist is not already empty
     * @param diet a String
     */
    public void removeDietaryRestriction(String diet) {
        if (this.dietaryRestrictions != null) {
            this.dietaryRestrictions.remove(diet);
        }
    }

    
    /** 
     * checks if entered date follows format xxxx-xx-xx where x is a number
     * @param date a String
     * @return validated date as String 
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