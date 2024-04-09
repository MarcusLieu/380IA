
package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    String expectedType = "Blanket";
	int expectedQuantity = 5;
    private Supply supply = new Supply(expectedType, expectedQuantity);


    /**
     * Test case to ensure that a Supply object is created successfully.
     * It checks if the created supply object is not null.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(supply);
    }

    /**
     * Test case to validate the functionality of the getType method in the Supply class.
     * It checks if getType returns the expected type.
     */
    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", expectedType, supply.getType());
    }

    /**
     * Test case to verify the correctness of the setType method in the Supply class.
     * It ensures that setType updates the type of the supply as expected.
     */
    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("setType should update the type", "Food", supply.getType());
    }

    /**
     * Test case to validate the functionality of the getQuantity method in the Supply class.
     * It checks if getQuantity returns the correct quantity.
     */
    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", expectedQuantity, supply.getQuantity());
    }

    /**
     * Test case to ensure the correctness of the setQuantity method in the Supply class.
     * It verifies that setQuantity updates the quantity of the supply correctly.
     */
    @Test
    public void testSetQuantity() {
        supply.setQuantity(20);
        assertEquals("setQuantity should update the quantity", 20, supply.getQuantity());
    }

    /**
     * Test case to verify that the quantity of the supply decreases by 1 when added as a personal belonging.
     * It adds a supply to a location and then adds the same supply as a personal belonging to a victim,
     * and checks if the quantity decreases by 1.
     */
    @Test
    public void testQuantityFromAddPersonalBelongings(){
        Supply supply = new Supply("band-aid", 10);
        Location location = new Location("ghetto school", "21 jump street");
        DisasterVictim victim =  new DisasterVictim("joe", "2024-01-20");
        location.addSupply(supply);
        location.addOccupant(victim);
        int orgQuantity = supply.getQuantity();
        victim.addPersonalBelonging(supply, location);
        boolean correct = true;

        if (supply.getQuantity() >= orgQuantity) {
            correct = false;
        }
        assertTrue("The supply quantity should be reduced by 1", correct);
    }

}
