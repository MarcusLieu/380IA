
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;
/**
 * Junit tests for Location class
 */
public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;

/**
     * Set up method to initialize test objects before each test method.
     */
    @Before
    public void setUp() {
        // Initializing test objects before each test method
        location = new Location("Shelter A", "1234 Shelter Ave");
        victim = new DisasterVictim("John Doe", "2024-01-01");
        supply = new Supply("Water Bottle", 10);
    }

    /**
     * Helper method to check if a supply is in the list.
     *
     * @param supplies The list of supplies to check.
     * @param supplyToCheck The supply to check for in the list.
     * @return boolean Returns true if the supply is in the list, otherwise false.
     */
    private boolean containsSupply(ArrayList<Supply> supplies, Supply supplyToCheck) {
        return supplies.contains(supplyToCheck);
    }

    /**
     * Test for the constructor of the Location class.
     * It checks if the constructor initializes the location object correctly.
     */
    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter A", location.getName());
        assertEquals("Constructor should set the address correctly", "1234 Shelter Ave", location.getAddress());
    }

    /**
     * Test for the setName method of the Location class.
     * It checks if the setName method updates the name of the location correctly.
     */
    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    /**
     * Test case for the setAddress method of the Location class.
     * It verifies if the setAddress method updates the address of the location correctly.
     */
    @Test
    public void testSetAddress() {
        String newAddress = "4321 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    /**
     * Test case for the addOccupant method of the Location class.
     * It checks if the addOccupant method adds a disaster victim to the occupants list.
     */
    @Test
    public void testAddOccupant() {
        location.addOccupant(victim);
        assertTrue("addOccupant should add a disaster victim to the occupants list", location.getOccupants().contains(victim));
    }

    /**
     * Test case for the removeOccupant method of the Location class.
     * It ensures that the removeOccupant method removes the disaster victim from the occupants list.
     */
    @Test
    public void testRemoveOccupant() {
        location.addOccupant(victim); // Ensure the victim is added first
        location.removeOccupant(victim);
        assertFalse("removeOccupant should remove the disaster victim from the occupants list", location.getOccupants().contains(victim));
    }

    /**
     * Test case for the setAndGetOccupants methods of the Location class.
     * It tests if the setOccupants method replaces the occupants list with the new list correctly.
     */
    @Test
    public void testSetAndGetOccupants() {
        ArrayList<DisasterVictim> newOccupants = new ArrayList<>();
        newOccupants.add(victim);
        location.setOccupants(newOccupants);
        assertTrue("setOccupants should replace the occupants list with the new list", location.getOccupants().containsAll(newOccupants));
    }

    /**
     * Test case for the addSupply method of the Location class.
     * It verifies if the addSupply method adds a supply to the supplies list.
     */
    @Test
    public void testAddSupply() {
        location.addSupply(supply);
        assertTrue("addSupply should add a supply to the supplies list", containsSupply(location.getSupplies(), supply));
    }

    /**
     * Test case for the removeSupply method of the Location class.
     * It ensures that the removeSupply method removes the supply from the supplies list.
     */
    @Test
    public void testRemoveSupply() {
        location.addSupply(supply); // Ensure the supply is added first
        location.removeSupply(supply);
        assertFalse("removeSupply should remove the supply from the supplies list", containsSupply(location.getSupplies(), supply));
    }

    /**
     * Test case for the setAndGetSupplies methods of the Location class.
     * It tests if the setSupplies method replaces the supplies list with the new list correctly.
     */
    @Test
    public void testSetAndGetSupplies() {
        ArrayList<Supply> newSupplies = new ArrayList<>();
        newSupplies.add(supply);
        location.setSupplies(newSupplies);
        assertTrue("setSupplies should replace the supplies list with the new list", containsSupply(location.getSupplies(), supply));
    }

    /**
     * Test case for the suppliesRemovedIfQuantityZero method of the Location class.
     * It verifies if supplies are removed from the supplies list when the quantity becomes zero due to an occupant taking them all.
     */
    @Test
    public void testSuppliesRemovedIfQuantityZero() {
        Supply a = new Supply("dab pen", 1);
        Location testloc = new Location("test location", "1234 ave");
        DisasterVictim testperson = new DisasterVictim("bob", "2024-01-20");
        testloc.addSupply(a);
        int orgSize = testloc.getSupplies().size();
        testloc.addOccupant(testperson);
        testperson.addPersonalBelonging(a, testloc);
        boolean correct = true;
        if (testloc.getSupplies().size() == orgSize) {
            correct = false;
        }
        assertTrue("Supplies size should be less since the quantity is 0", correct);
    }

}

