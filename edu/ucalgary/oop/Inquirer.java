package edu.ucalgary.oop;

public class Inquirer{

    private String firstName;
    private String lastName;
    private String info;
    private String ServicesPhoneNum;

    public Inquirer( String firstName, String lastName, String ServicesPhoneNum, String info){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ServicesPhoneNum = ServicesPhoneNum;
        this.info = info;

    }

    public String getFirstName(){
        return  firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getInfo(){
        return info;
    }

    public String getServicesPhoneNum(){
        return ServicesPhoneNum;
    }
}

