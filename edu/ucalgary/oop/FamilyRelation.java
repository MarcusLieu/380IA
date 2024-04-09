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
     * gets personeOne as disaster victim
     * @return personOne as DisasterVictim
     */
    public DisasterVictim getPersonOne() {
        return this.personOne;
    }
    
    /** 
     * gets relationship between both victims
     * @return relationshipTo as String
     */
    public String getRelationshipTo() {
        return this.relationshipTo;
    }
    
    /** 
     * gets personTwo as disaster victim
     * @return personTwo as DisasterVictim
     */
    public DisasterVictim getPersonTwo() {
        return this.personTwo;
    }
    
    /** 
     * sets personOne field
     * @param personOne a disaster victim
     */
    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }
    
    /** 
     * sets relationshipTo field
     * @param relationshipTo a string
     */
    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }
    
    /** 
     * sets personTwo field
     * @param personTwo a disaster victim
     */
    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
}
