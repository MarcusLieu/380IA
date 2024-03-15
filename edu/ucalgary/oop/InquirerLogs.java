package edu.ucalgary.oop;
import java.util.ArrayList;

public class InquirerLogs {
    private Inquirer inquirer;
    private ArrayList<String> logHistory;

    public InquirerLogs(Inquirer inquirer) {
        this.inquirer = inquirer;
        this.logHistory = new ArrayList<String>();
    }
    public Inquirer getInquirer() {
        return this.inquirer;
    }
    public ArrayList<String> getLogHistory() {
        return this.logHistory;
    }
    public void AddLog(String log) {
        this.logHistory.add(log);
    }

}
