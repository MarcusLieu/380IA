
package edu.ucalgary.oop;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class FamilyRelationTest {

    private DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
    private DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
	
    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", "2024-03-21");
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another Person", "2024-04-22");
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFamilyRelationDuplicateInfo() {
        DisasterVictim person1 = new DisasterVictim("todd", "2024-01-20");
        DisasterVictim person2 = new DisasterVictim("howard", "2024-02-20");
        FamilyRelation p1p2 = new FamilyRelation(person1, "2024-03-20", person2);
        FamilyRelation p2p1 = new FamilyRelation(person2, "2024-03-20", person1);
        person1.addFamilyConnection(p1p2);
        person1.addFamilyConnection(p2p1);
    }

   
}
