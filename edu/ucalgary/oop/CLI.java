package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        Location siteA = new Location("siteA", "123 street NE");
        Location siteB = new Location("siteB", "123 street NE");
        Location siteC = new Location("siteC", "123 street NE");
        Location siteD = new Location("siteD", "123 street NE");

        ArrayList<Location> sites = new ArrayList<Location>();
        sites.add(siteA);
        sites.add(siteB);
        sites.add(siteC);
        sites.add(siteD);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome to DisasterVictim CLI");
            System.out.println("1.) view available locations");
            System.out.println("2.) view occupants at location");
            System.out.println("3.) add a disaster victim to system");
            System.out.println("4.) exit");
            System.out.print("Type number corresponding to action to select: ");
            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Available locations: ");
                    for (int i = 0; i < sites.size(); i++) {
                        System.out.println(sites.get(i).getName());
                    }
                }
                if (choice == 4) {
                    System.out.println("exiting program.");
                    break;
                }
            }
            catch(Exception e) {
                System.out.println("Invalid choice");
            }
        }
        scanner.close();

    }
}
