package edu.ucalgary.oop;

import java.util.ArrayList;

public class Inquirer extends Person{

    private String info;
    private String ServicesPhoneNum;
    private ArrayList<ReliefService> logHistory;

    public Inquirer(String firstName, String lastName, String ServicesPhoneNum, String info){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ServicesPhoneNum = ServicesPhoneNum;
        this.info = info;
        this.logHistory = new ArrayList<ReliefService>();
    }
    public String getInfo(){
        return info;
    }
    public String getServicesPhoneNum(){
        return ServicesPhoneNum;
    }
    public ArrayList<ReliefService> getLogHistory() {
        return this.logHistory;
    }
    public void addLog(ReliefService log) {
        this.logHistory.add(log);
    }
}

