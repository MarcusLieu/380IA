
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Junit tests for ReliefServiceTest class
 */
public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String validDate = "2024-02-10";
    private String invalidDate = "2024/02/10";
    private String expectedInfoProvided = "Looking for family member";
    private String expectedLogDetails = "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2024-02-10, Info Provided: Looking for family member, Last Known Location: University of Calgary"; 

    /**
     * Sets up the test environment by initializing required objects before each test method.
     * In this case, it initializes an Inquirer, a DisasterVictim, a Location, and a ReliefService object.
     */
    @Before
    public void setUp() {
        inquirer = new Inquirer("John", "Alex", "1234567890", "Looking for family member");
        missingPerson = new DisasterVictim("Jane Alex", "2024-01-25");
        lastKnownLocation = new Location("University of Calgary", "2500 University Dr NW");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    /**
     * Test case to verify that a ReliefService object is created successfully.
     * It checks if the created reliefService object is not null.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    /**
     * Test case to ensure the correctness of the getInquirer method in the ReliefService class.
     * It verifies that getInquirer returns the expected Inquirer.
     */
    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", inquirer, reliefService.getInquirer());
    }

    /**
     * Test case to validate the functionality of the getMissingPerson method in the ReliefService class.
     * It checks if getMissingPerson returns the expected missing person.
     */
    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", missingPerson, reliefService.getMissingPerson());
    }

    /**
     * Test case to verify the correctness of the getDateOfInquiry method in the ReliefService class.
     * It ensures that getDateOfInquiry returns the expected date of inquiry.
     */
    @Test
    public void testGetDateOfInquiry() {
        assertEquals("Date of inquiry should match the one set in setup", validDate, reliefService.getDateOfInquiry());
    }

    /**
     * Test case to validate the functionality of the getInfoProvided method in the ReliefService class.
     * It checks if getInfoProvided returns the expected information provided.
     */
    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided should match the one set in setup", expectedInfoProvided, reliefService.getInfoProvided());
    }

    /**
     * Test case to ensure the correctness of the getLastKnownLocation method in the ReliefService class.
     * It verifies that getLastKnownLocation returns the expected last known location.
     */
    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", lastKnownLocation, reliefService.getLastKnownLocation());
    }

    /**
     * Test case to verify the functionality of the setDateOfInquiry method in the ReliefService class with a valid date.
     * It checks if setDateOfInquiry updates the date of inquiry as expected.
     */
    @Test
    public void testSetDateOfInquiryWithValidDate() {
        reliefService.setDateOfInquiry(validDate);
        assertEquals("Setting a valid date should update the date of inquiry", validDate, reliefService.getDateOfInquiry());
    }

    /**
     * Test case to ensure that setDateOfInquiry method throws an IllegalArgumentException with an invalid date format.
     * It checks if setDateOfInquiry throws an IllegalArgumentException with an invalid date format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        reliefService.setDateOfInquiry(invalidDate); // This should throw IllegalArgumentException due to invalid format
    }

    /**
     * Test case to verify the correctness of the getLogDetails method in the ReliefService class.
     * It ensures that getLogDetails returns the expected log details.
     */
    @Test
    public void testGetLogDetails() {
        assertEquals("Log details should match the expected format", expectedLogDetails, reliefService.getLogDetails());
    }

}
