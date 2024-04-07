package edu.ucalgary.oop;
import java.util.ArrayList;

public class InquirerLogs {
    private Inquirer inquirer;
    private ArrayList<ReliefService> logHistory;

    public InquirerLogs(Inquirer inquirer) {
        this.inquirer = inquirer;
        this.logHistory = new ArrayList<ReliefService>();
    }
    public Inquirer getInquirer() {
        return this.inquirer;
    }
    public ArrayList<ReliefService> getLogHistory() {
        return this.logHistory;
    }
    public void AddLog(ReliefService log) {
        this.logHistory.add(log);
    }

}
