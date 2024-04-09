
package edu.ucalgary.oop;

import java.util.ArrayList;
/**
 * an individual looking for disaster victims
 */
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
    
    /** 
     * gets info field
     * @return info as String
     */
    public String getInfo(){
        return info;
    }
    
    /** 
     * gets ServicesPhoneNum field
     * @return ServicesPhoneNum as String
     */
    public String getServicesPhoneNum(){
        return ServicesPhoneNum;
    }
    
    /** 
     * gets logHistory field
     * @return log history as array list
     */
    public ArrayList<ReliefService> getLogHistory() {
        return this.logHistory;
    }
    
    /** 
     * adds element to loghistory field
     * @param log a relief service object
     */
    public void addLog(ReliefService log) {
        this.logHistory.add(log);
    }
}

