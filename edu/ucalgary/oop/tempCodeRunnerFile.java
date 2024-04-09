package edu.ucalgary.oop;
import java.sql.*;

public class InquirerInterface {
    private Connection dbConnect;
    public void createConnection() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        InquirerInterface d = new InquirerInterface();
        d.createConnection();
    }
}