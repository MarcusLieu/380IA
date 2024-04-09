
package edu.ucalgary.oop;


import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;
/**
 * Junit tests for FamilyRelation class
 */
public class FamilyRelationTest {

    private DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
    private DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    /**
     * Test case for verifying the creation of a FamilyRelation object.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }

    /**
     * Test case for setting and getting the first person in a family relationship.
     */
    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", "2024-03-21");
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    /**
     * Test case for setting and getting the second person in a family relationship.
     */
    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another Person", "2024-04-22");
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    /**
     * Test case for setting and getting the relationship type between two persons.
     */
    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }

    /**
     * Test case for adding duplicate family relationship information, which should throw an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFamilyRelationDuplicateInfo() {
        DisasterVictim person1 = new DisasterVictim("todd", "2024-01-20");
        DisasterVictim person2 = new DisasterVictim("howard", "2024-02-20");
        FamilyRelation p1p2 = new FamilyRelation(person1, "siblings", person2);
        FamilyRelation p2p1 = new FamilyRelation(person2, "siblings", person1);
        person1.addFamilyConnection(p1p2);
        person1.addFamilyConnection(p2p1);
    }

    /**
     * Test case for verifying that if a relationship is made between two people, it should be added to both.
     */
    @Test
    public void testTwoWayRelation() {
        DisasterVictim person3 = new DisasterVictim("bob", "2024-01-20");
        DisasterVictim person4 = new DisasterVictim("joe", "2024-02-20");
        FamilyRelation p4p3 = new FamilyRelation(person4, "siblings", person3);
        person3.addFamilyConnection(p4p3);
        assertEquals("If a relationship is made between two people, it should be added to both", person3.getFamilyConnections(), person4.getFamilyConnections());
    }

    /**
     * Test case for verifying that if a relationship is deleted between two people, it should be deleted from both.
     */
    @Test
    public void testTwoWayDeletion() {
        DisasterVictim person3 = new DisasterVictim("bob", "2024-01-20");
        DisasterVictim person4 = new DisasterVictim("joe", "2024-02-20");
        FamilyRelation p4p3 = new FamilyRelation(person4, "siblings", person3);
        person3.addFamilyConnection(p4p3);
        person4.removeFamilyConnection(p4p3);
        assertEquals("If a relationship is deleted between two people, it should be deleted from both", person3.getFamilyConnections(), person4.getFamilyConnections());
    }
}
