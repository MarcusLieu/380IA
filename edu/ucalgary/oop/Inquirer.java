package edu.ucalgary.oop;

public class Inquirer extends Person{

    private String info;
    private String ServicesPhoneNum;

    public Inquirer(String firstName, String lastName, String ServicesPhoneNum, String info){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ServicesPhoneNum = ServicesPhoneNum;
        this.info = info;
    }

    public String getInfo(){
        return info;
    }

    public String getServicesPhoneNum(){
        return ServicesPhoneNum;
    }
}

