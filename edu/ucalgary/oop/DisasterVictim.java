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

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public String getComments() {
        return this.comments;
    }
    public ArrayList<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }
    public String getEntryDate() {
        return this.ENTRY_DATE;
    }
    public int getAssignedSocialID() {
        return this.ASSIGNED_SOCIAL_ID;
    }
    public ArrayList<Supply> getPersonalBelongings() {
        return this.personalBelongings;
    }
    public ArrayList<FamilyRelation> getFamilyConnections() {
        return this.familyConnections;
    }
    public String getGender() {
        return this.gender;
    }
    public int getAge() {
        return this.age;
    }

    public ArrayList<String> getDietaryRestrictions() {
        return this.dietaryRestrictions;
    }
    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        String validatedDate = validateDate(dateOfBirth);
        if (this.age == 0) {
            this.dateOfBirth = validatedDate;
            return;
        }
        throw new IllegalArgumentException();
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
    public void setPersonalBelongings(ArrayList<Supply> supplies) {
        this.personalBelongings = supplies;
    }
    public void setFamilyConnections(ArrayList<FamilyRelation> familyConnections) {
        this.familyConnections = familyConnections;
    }
    
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

    public void setAge(int age) throws IllegalArgumentException{
        if (age > 0 && this.dateOfBirth == null) {
            this.age = age;
            return;
        }
        throw new IllegalArgumentException();
    }

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
    public void removePersonalBelonging(Supply supply) {
        if (this.personalBelongings != null) {
            this.personalBelongings.remove(supply);
        }
    }
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
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        if (this.medicalRecords == null)  {
            this.medicalRecords = new ArrayList<MedicalRecord>();
            this.medicalRecords.add(medicalRecord);
        }
        else {
            this.medicalRecords.add(medicalRecord);
        }
    }
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
    public void removeDietaryRestriction(String diet) {
        if (this.dietaryRestrictions != null) {
            this.dietaryRestrictions.remove(diet);
        }
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