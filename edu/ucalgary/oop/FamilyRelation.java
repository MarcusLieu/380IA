package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }
    
    /** 
     * @return DisasterVictim
     */
    public DisasterVictim getPersonOne() {
        return this.personOne;
    }
    
    /** 
     * @return String
     */
    public String getRelationshipTo() {
        return this.relationshipTo;
    }
    
    /** 
     * @return DisasterVictim
     */
    public DisasterVictim getPersonTwo() {
        return this.personTwo;
    }
    
    /** 
     * @param personOne
     */
    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }
    
    /** 
     * @param relationshipTo
     */
    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }
    
    /** 
     * @param personTwo
     */
    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
}
