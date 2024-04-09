/*
javac edu/ucalgary/oop/InquirerInterface.java 
java -cp ".:mysql-connector-j-8.3.0.jar" edu.ucalgary.oop.InquirerInterface
 */

package edu.ucalgary.oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InquirerInterface {

    public  String DBURL;
    public  String USERNAME;
    public  String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    public InquirerInterface(String url, String user, String pw) {
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public void initializeConnection() {
        try {
            Connection connection = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ensf380project";
        String username = "oop";
        String password = "ucalgary";

        InquirerInterface JDBC = new InquirerInterface(url, username, password);
        JDBC.initializeConnection();

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome to Inquirer interface");
            System.out.println("1.) View all inquirers");
        }
    }
}