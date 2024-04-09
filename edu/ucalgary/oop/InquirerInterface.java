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

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InquirerInterface {

    public  String DBURL;
    public  String USERNAME;
    public  String PASSWORD;

    private Connection dbConnect;

    public InquirerInterface(String url, String user, String pw) {
        this.DBURL = url;
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public void initializeConnection() {
        try {
            Connection connection = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
            this.dbConnect = connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** 
     * connects to ensf380project msqyl databasse and allows user to add inquirers and inquiry log into tables, and search disastser victims to link
     * @param args
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ensf380project";
        String username = "oop";
        String password = "ucalgary";

        InquirerInterface JDBC = new InquirerInterface(url, username, password);
        JDBC.initializeConnection();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Welcome to Inquirer interface");
            System.out.println("1.) View all inquirers");
            System.out.println("2.) View all inquiry logs ");
            System.out.println("3.) Add inquirer");
            System.out.println("4.) Add inquiry log");
            System.out.println("5.) Search for disaster victim");
            System.out.println("6.) Exit");

            System.out.print("Type number corresponding to action to select: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    try {
                        Statement stmt = JDBC.dbConnect.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM INQUIRER");
                        System.out.println("-----------------------------------------------------------------------------");
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            System.out.printf("| %-16s ", rs.getMetaData().getColumnName(i));
                        }
                        System.out.println("|");
                        System.out.println("-----------------------------------------------------------------------------");
                        while (rs.next()) {
                            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                System.out.printf("| %-16s ", rs.getString(i));
                            }
                            System.out.println("|");
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();;
                    }
                }
                else if (choice == 2) {
                    try {
                        Statement stmt = JDBC.dbConnect.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM INQUIRY_LOG");
                        System.out.println("-----------------------------------------------------------------------------");

                        System.out.printf("| %-5s | %-5s | %-15s | %-36s |%n", rs.getMetaData().getColumnName(1), rs.getMetaData().getColumnName(2), rs.getMetaData().getColumnName(3), rs.getMetaData().getColumnName(4));
                        System.out.println("-----------------------------------------------------------------------------");
                        while (rs.next()) {
                            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                if (i == 1) {
                                    System.out.printf("| %-5s ", rs.getString(i));
                                }
                                else if (i == 2) {
                                    System.out.printf("| %-8s ", rs.getString(i));
                                }
                                else if (i == 3) {
                                    System.out.printf("| %-15s ", rs.getString(i));
                                }
                                else {
                                    System.out.printf("| %-36s ", rs.getString(i));
                                }
                            }
                            System.out.println("|");
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();;
                    }
                }
                else if (choice == 3) {
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.print("Enter given first name: ");
                    String entered_fname = scanner.nextLine();
                    System.out.print("Enter given last name: ");
                    String entered_lname = scanner.nextLine();
                    System.out.print("Enter given phone number: ");
                    String entered_pnum = scanner.nextLine();
                    Pattern pnum_pat = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
                    Matcher pnum_match = pnum_pat.matcher(entered_pnum);
                    if (!pnum_match.find()) {
                        System.out.println("Invalid format, follow xxx-xxx-xxxx");
                    }
                    else {
                        try {                    
                            Statement stmt = JDBC.dbConnect.createStatement();
                            stmt.executeUpdate("INSERT INTO INQUIRER (firstName, lastName, phoneNumber) VALUES ('" + entered_fname + "', '" + entered_lname + "', '" + entered_pnum + "')");
                            System.out.println("Successfully added inquirer to database!");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (choice == 4) {
                    System.out.println("-----------------------------------------------------------------------------");
                    try {
                        Statement stmt = JDBC.dbConnect.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM INQUIRER");
                        ArrayList<String> inquirerIds = new ArrayList<String>();
                        while(rs.next()) {
                            inquirerIds.add(rs.getString(1));
                        }
                        System.out.print("Enter inquirer id: ");
                        int entered_id = scanner.nextInt();
                        scanner.nextLine();
                        Boolean match = false;
                        for (int i = 0; i < inquirerIds.size(); i++) {
                            if (inquirerIds.get(i).equals(Integer.toString(entered_id))) {
                                match = true;
                            }
                        }
                        if (!match) {
                            System.out.println("Inquirer not found in database");
                        }
                        else {
                            System.out.print("Enter call date: ");
                            String entered_calldate = scanner.nextLine();
                            Pattern date_pat = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
                            Matcher date_match = date_pat.matcher(entered_calldate);
                            if (!date_match.find()) {
                                System.out.println("Invalid format, follow xxxx-xx-xx");
                            }
                            else {
                                System.out.print("Enter log details: ");
                                String entered_details = scanner.nextLine();
                                try {                    
                                    Statement stmt2 = JDBC.dbConnect.createStatement();
                                    stmt2.executeUpdate("INSERT INTO INQUIRY_LOG (inquirer, callDate, details) VALUES ('" + entered_id + "', '" + entered_calldate + "', '" + entered_details + "')");
                                    System.out.println("Successfully added inquiry log to database!");
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if (choice == 5) {
                    System.out.println("-----------------------------------------------------------------------------");
                    try {
                        Statement stmt = JDBC.dbConnect.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM INQUIRY_LOG");
                        ArrayList<String> inquirerDetails = new ArrayList<String>();
                        while(rs.next()) {
                            if (!inquirerDetails.contains(rs.getString(4))) {
                                inquirerDetails.add(rs.getString(4));
                            }
                        }
                        System.out.print("Enter name of victim you would like to search for: ");
                        String entered_search_victim = scanner.nextLine();
                        Boolean found = false;
                        for (int i = 0; i < inquirerDetails.size(); i++) {
                            if (inquirerDetails.get(i).toLowerCase().contains(entered_search_victim.toLowerCase())) {
                                found = true;
                                System.out.print("Possible related entry: ");
                                System.out.println(inquirerDetails.get(i));
                            }
                        }
                        if (!found) {
                            System.out.println("No possible related entries found");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if (choice == 6) {
                    System.out.println("Exiting program.");
                    break;
                }
                else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}