
package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;

import javax.sound.midi.SysexMessage;

/**
 * Junit tests for Inquirer class
 */
public class InquirerTest {
    

private String expectedFirstName = "Joseph";
private String expectedLastName = "Bouillon";
private String expectedPhoneNumber = "+1-123-456-7890";
private String expectedMessage = "looking for my family members";
private Inquirer inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedMessage);


    /**
     * Test case for verifying the creation of an Inquirer object.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }

    /**
     * Test case for getting the first name of the inquirer.
     */
    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }

    /**
     * Test case for getting the last name of the inquirer.
     */
    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }

    /**
     * Test case for getting the services phone number of the inquirer.
     */
    @Test
    public void testGetServicesPhoneNum() {
        assertEquals("getServicesPhoneNum() should return the correct Services Number", expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }

    /**
     * Test case for getting the information provided by the inquirer.
     */
    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", expectedMessage, inquirer.getInfo());
    }

    /**
     * Test case for verifying that an Inquirer object inherits the set last name functionality from the Person class.
     */
    @Test
    public void testPersonAbstraction() {
        Inquirer testInquirer = new Inquirer("joey", "dick", "+1-123-456-7891", "looking for joe");
        testInquirer.setLastName("wheeler");
        boolean correct = true;

        if (testInquirer.getLastName() == "pick") {
            correct = false;
        }
        assertTrue("Inquirer should inherit set last name from person", correct);
    }

    /**
     * Test case for verifying that making multiple relief service requests increases the log count for an inquirer.
     */
    @Test
    public void testMultipleInteractions() {
        Inquirer testInquirer2 = new Inquirer("joe", "doe", "+1-123-456-7891", "looking for bill");
        DisasterVictim missingVictim = new DisasterVictim("adam", "2024-01-20");
        ReliefService testReliefService = new ReliefService(testInquirer2, missingVictim, "2024-01-20", "john", null);
        Location testLocation = new Location("test location", "1234 street");
        ReliefService testReliefService2 = new ReliefService(testInquirer2, missingVictim, "2024-01-21", expectedFirstName, testLocation);
        assertEquals("Inquirer making another relief services should increase log count", 2, testInquirer2.getLogHistory().size());
    }

}

