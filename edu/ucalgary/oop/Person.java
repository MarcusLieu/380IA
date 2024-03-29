package edu.ucalgary.oop;

public abstract class Person {
    public String firstName;
    public String lastName;
    public int age;
    public String dateOfBirth;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
