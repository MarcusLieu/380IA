package edu.ucalgary.oop;

public abstract class Person {
    public String firstName;
    public String lastName;
    public int age;
    public String dateOfBirth;

    
    /** 
     * gets firstName field
     * @return first name as String
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * gets lastName field
     * @return last name as String
     */
    public String getLastName() {
        return this.lastName;
    }


    
    /** 
     * sets firstName field
     * @param firstName as String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * sets lastName field
     * @param lastName as String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
