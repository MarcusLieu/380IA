
package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Junit tests for MedicalRecord class
 */
public class MedicalRecordTest {

    Location expectedLocation = new Location("ShelterA", "140 8 Ave NW ");
    private String expectedTreatmentDetails = "Broken arm treated";
    private String expectedDateOfTreatment = "2024-01-19";
    private String validDateOfTreatment = "2024-02-04";
    private String inValidDateOfTreatment = "2024/02/04";
    MedicalRecord medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);

    /**
     * Test case to verify that a MedicalRecord object is created successfully.
     * It checks if the created medicalRecord object is not null.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(medicalRecord);
    }

    /**
     * Test case to verify the correctness of the getLocation method in the MedicalRecord class.
     * It ensures that getLocation returns the expected Location.
     */
    @Test
    public void testGetLocation() {
        assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    /**
     * Test case to verify the functionality of the setLocation method in the MedicalRecord class.
     * It checks if setLocation properly updates the Location of the medical record.
     */
    @Test
    public void testSetLocation() {
        Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
        medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    /**
     * Test case to ensure the correctness of the getTreatmentDetails method in the MedicalRecord class.
     * It verifies that getTreatmentDetails returns the expected treatment details.
     */
    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
    }

    /**
     * Test case to validate the functionality of the setTreatmentDetails method in the MedicalRecord class.
     * It checks if setTreatmentDetails correctly updates the treatment details.
     */
    @Test
    public void testSetTreatmentDetails() {
        String newExpectedTreatment = "No surgery required";
        medicalRecord.setTreatmentDetails(newExpectedTreatment);
        assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }

    /**
     * Test case to verify the correctness of the getDateOfTreatment method in the MedicalRecord class.
     * It ensures that getDateOfTreatment returns the expected date of treatment.
     */
    @Test
    public void testGetDateOfTreatment() {
        assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    /**
     * Test case to validate the functionality of the setDateOfTreatment method in the MedicalRecord class.
     * It checks if setDateOfTreatment updates the date of treatment as expected.
     */
    @Test
    public void testSetDateOfTreatment() {
        String newExpectedDateOfTreatment = "2024-02-05";
        medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
        assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    /**
     * Test case to ensure that setDateOfTreatment method handles a valid date format without throwing an exception.
     * It verifies that setDateOfTreatment with a valid format does not throw any exceptions.
     */
    @Test
    public void testSetDateOfTreatmentWithValidFormat() {
        medicalRecord.setDateOfTreatment(validDateOfTreatment); // Should not throw an exception
    }

    /**
     * Test case to verify that setDateOfTreatment method throws an IllegalArgumentException with an invalid date format.
     * It checks if setDateOfTreatment throws an IllegalArgumentException with an invalid date format.
     */
    @Test
    public void testSetDateOfBirthWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
            medicalRecord.setDateOfTreatment(inValidDateOfTreatment); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            correctValue = true;
        } catch (Exception e) {
            failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    /**
     * Test case to verify that setDateOfTreatment method throws an IllegalArgumentException with non-date input.
     * It ensures that setDateOfTreatment throws an IllegalArgumentException with non-date input.
     */
    @Test
    public void testSetDateOfBirthWithNotADate() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
            medicalRecord.setDateOfTreatment(expectedTreatmentDetails); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            correctValue = true;
        } catch (Exception e) {
            failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid non-date input '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

}

