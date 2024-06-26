/*
code to run test:
 javac -cp ".:junit-4.13.2.jar:hamcrest-core-1.3.jar" "edu/ucalgary/oop/DisasterVictim.java" "edu/ucalgary/oop/DisasterVictimTest.java" "edu/ucalgary/oop/FamilyRelation.java" "edu/ucalgary/oop/FamilyRelationTest.java" "edu/ucalgary/oop/Inquirer.java" "edu/ucalgary/oop/InquirerTest.java" "edu/ucalgary/oop/Location.java" "edu/ucalgary/oop/LocationTest.java" "edu/ucalgary/oop/MedicalRecord.java" "edu/ucalgary/oop/MedicalRecordTest.java" "edu/ucalgary/oop/ReliefService.java" "edu/ucalgary/oop/ReliefServiceTest.java" "edu/ucalgary/oop/Supply.java" "edu/ucalgary/oop/SupplyTest.java"
 java -cp ".:junit-4.13.2.jar:hamcrest-core-1.3.jar" org.junit.runner.JUnitCore "edu.ucalgary.oop.DisasterVictimTest" "edu.ucalgary.oop.FamilyRelationTest" "edu.ucalgary.oop.InquirerTest" "edu.ucalgary.oop.LocationTest" "edu.ucalgary.oop.MedicalRecordTest" "edu.ucalgary.oop.ReliefServiceTest" "edu.ucalgary.oop.SupplyTest"
 */

package edu.ucalgary.oop;

import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.helpers.LocatorImpl;
/**
 * Junit tests for DisasterVictim class
 */
public class DisasterVictimTest {
    private DisasterVictim victim;
    private ArrayList<Supply> suppliesToSet; 
    private ArrayList<FamilyRelation> familyRelations; 
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female"; 
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    /**
     * Sets up the test environment before each test case.
     */
    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
    }
    /**
     * Test case for constructing a DisasterVictim with a valid entry date.
     */
    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }
    /**
     * Test case for constructing a DisasterVictim with an invalid entry date format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    /**
     * Test case for setting the date of birth of a DisasterVictim.
     */
    @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }
    /**
     * Test case for setting the date of birth of a DisasterVictim with an invalid format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
	/**
    * Test case for setting and getting the first name of a DisasterVictim.
    */
	@Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }
    /**
     * Test case for setting and getting the last name of a DisasterVictim.
     */    
    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }
    /**
     * Test case for getting comments of a DisasterVictim.
     */
    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }
    /**
     * Test case for setting comments of a DisasterVictim.
     */
    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }
    /**
     * Test case for getting the assigned social ID of a DisasterVictim.
     */
    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }
    /**
     * Test case for getting the entry date of a DisasterVictim.
     */
    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    /**
     * Test case for adding a family connection to a DisasterVictim.
     */
    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<>();
        expectedRelations.add(relation);
        victim2.setFamilyConnections(expectedRelations);

        ArrayList<FamilyRelation> testFamily = victim2.getFamilyConnections();
        boolean correct = false;

        if ((testFamily!=null) && (testFamily.get(0) == expectedRelations.get(0))) {
                correct = true;
        }
        assertTrue("addFamilyConnection should add a family relationship", correct);
    }
    /**
     * Test case for adding a personal belonging to a DisasterVictim.
     */
    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        Location location = new Location("test location", "69 ave");
        location.addSupply(newSupply);
        location.addOccupant(victim);
        victim.addPersonalBelonging(newSupply, location);
        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = false;
 
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i) == newSupply) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }
    /**
     * Test case for removing a family connection from a DisasterVictim.
     */
    @Test
    public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);
        //FamilyRelation[] expectedRelations = {relation2};
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<FamilyRelation>();
        expectedRelations.add(relation2);
        //FamilyRelation[] originalRelations = {relation1, relation2};
        ArrayList<FamilyRelation> originalRelations = new ArrayList<FamilyRelation>();
        originalRelations.add(relation1);
        originalRelations.add(relation2);
        victim.setFamilyConnections(originalRelations);

        DisasterVictim victim = new DisasterVictim("Freda", "2024-01-23");
        victim.addFamilyConnection(relation1);
        victim.addFamilyConnection(relation2);
        victim.removeFamilyConnection(relation1);

        ArrayList<FamilyRelation> testFamily = victim.getFamilyConnections();
        boolean correct = true;

        int i;
        for (i = 0; i < testFamily.size(); i++) {
            if (testFamily.get(i) == relation1) {
                correct = false;
            }
        }
    assertTrue("removeFamilyConnection should remove the family member", true);
}  
    /**
     * Test case for removing a personal belonging from a DisasterVictim.
     */
    @Test
    public void testRemovePersonalBelonging() {
    
        Supply supplyToRemove = suppliesToSet.get(0); 
        Location location2 = new Location("test loc2", "THE O") ;
        victim.addPersonalBelonging(supplyToRemove, location2); 
        victim.removePersonalBelonging(supplyToRemove);

        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = true;
 
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i) == supplyToRemove) {
                correct = false;
            }
        }
    assertTrue("removePersonalBelonging should remove the supply from personal belongings", true);
}

    /**
     * Test case for setting a family connection for a DisasterVictim.
     */
    @Test
    public void testSetFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<FamilyRelation>();
        expectedRelations.add(relation);
        victim1.setFamilyConnections(expectedRelations);
        boolean correct = true;

       // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
       ArrayList<FamilyRelation> actualRecords = victim1.getFamilyConnections();
       if (expectedRelations.size() != actualRecords.size()) {
           correct = false;
       } else {    
           int i;
           for (i=0;i<actualRecords.size();i++) {
               if (expectedRelations.get(i) != actualRecords.get(i)) {
                   correct = false;
               }
           }
       }
       assertTrue("Family relation should be set", correct);
    }
    /**
     * Test case for setting medical records for a DisasterVictim.
     */
    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
        boolean correct = true;

        ArrayList<MedicalRecord> newRecords = new ArrayList<MedicalRecord>();
        newRecords.add(testRecord);
        victim.setMedicalRecords(newRecords);
        ArrayList<MedicalRecord> actualRecords = victim.getMedicalRecords();

        // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
        if (newRecords.size() != actualRecords.size()) {
            correct = false;
        } else {
            int i;
            for (i=0;i<newRecords.size();i++) {
                if (actualRecords.get(i) != newRecords.get(i)) {
                    correct = false;
                }
            }
        }
        assertTrue("setMedicalRecords should correctly update medical records", correct);
}

    /**
     * Test case for setting personal belongings for a DisasterVictim.
     */
    @Test
    public void testSetPersonalBelongings() {
        Supply one = new Supply("Tent", 1);
        Supply two = new Supply("Jug", 3);
        ArrayList<Supply> newSupplies = new ArrayList<Supply>();
        newSupplies.add(one);
        newSupplies.add(two);
        boolean correct = true;

        victim.setPersonalBelongings(newSupplies);
        ArrayList<Supply> actualSupplies = victim.getPersonalBelongings();

        // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
        if (newSupplies.size() != actualSupplies.size()) {
            correct = false;
        } else {
            int i;
            for (i=0;i<newSupplies.size();i++) {
                if (actualSupplies.get(i) != newSupplies.get(i)) {
                    correct = false;
                }
            }
        }
        assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
    }
    /**
     * Test case to check the supply size if the supply is not in the location.
     */
    @Test
    public void testSupplySizeIfNotInLocation() {
        Location testLocation = new Location("test shelter", "4321 Shelter Ave");
        Supply a = new Supply("bottle", 1);
        Supply b = new Supply("vape", 1);
        testLocation.addSupply(a);
        DisasterVictim testVictim = new DisasterVictim("joe", "2024-01-20");
        testVictim.addPersonalBelonging(a, testLocation);
        int originalSize = testVictim.getPersonalBelongings().size();
        testVictim.addPersonalBelonging(b, testLocation);
        boolean correct = true;

        if (testVictim.getPersonalBelongings().size() != originalSize) {
            correct = false;
        }
        assertTrue("addPersonalBelongings should correctly update personalBelongings", correct);
    }
    /**
     * Test case to check if the last name is set correctly for a DisasterVictim.
     */
    @Test
    public void testPersonAbstraction() {
        DisasterVictim testVictim = new DisasterVictim("joey", "2024-01-20");
        testVictim.setLastName("wheeler");
        boolean correct = true;

        if (testVictim.getLastName() == null) {
            correct = false;
        }
        assertTrue("Disaster victim should inherit set last name from person", correct);
    }
    /**
     * Test case for checking the date format interface.
     */
    @Test(expected = IllegalArgumentException.class)    
    public void testDateFormatInterface() {
        DisasterVictim invalidVictim = new DisasterVictim("bob", "98/01/2024");
    }
    /**
     * Test case for setting and getting the gender for a DisasterVictim.
     */
    @Test
    public void testSetAndGetGender() {
        GenderRetrieval genderFile = new GenderRetrieval("edu/ucalgary/oop/GenderOptions.txt");
        String newGender = genderFile.getGenderOptions().get(0);
        victim.setGender(newGender, genderFile);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }
    /**
     * Test case for checking if an invalid gender is provided.
     */
    @Test(expected = IllegalArgumentException.class)    
    public void testInvalidGender() {
        String newGender = "dragon";
        GenderRetrieval genderFile = new GenderRetrieval("edu/ucalgary/oop/GenderOptions.txt");
        victim.setGender(newGender, genderFile);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }
    /**
     * Test case for setting the age and then the birthdate.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAgethenBirthdate() {
        DisasterVictim testVictim1 = new DisasterVictim("bill", "2024-01-20");
        testVictim1.setAge(19);
        testVictim1.setDateOfBirth("1987-05-21");
    } 
    /**
     * Test case for setting the birthdate and then the age.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBirthDatethenAge() {
        DisasterVictim testVictim1 = new DisasterVictim("bill", "2024-01-20");
        testVictim1.setDateOfBirth("1987-05-21");
        testVictim1.setAge(19);
    } 
    /**
     * Test case for adding dietary restrictions to a DisasterVictim.
     */
    @Test
    public void testAddDietaryRestriction() {
       DisasterVictim dietVictim = new DisasterVictim("joe", "2024-01-20");
       dietVictim.addDietraryRestriction("MOML");
       dietVictim.addDietraryRestriction("VGML");
       assertEquals("setDietaryRestrictions should correctly set the field if the input is in the enum dietary restrictions class", 2, dietVictim.getDietaryRestrictions().size());
    }
    /**
     * Test case for adding an invalid dietary restriction to a DisasterVictim.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDietaryRestriction() {
        DisasterVictim dietVictim2 = new DisasterVictim("bill", "2024-01-20");
        dietVictim2.addDietraryRestriction("ABCD");;
    }
}






