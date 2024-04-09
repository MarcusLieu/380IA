/*
 java edu/ucalgary/oop/DisasterVictimInterface
 */

package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class DisasterVictimInterface {
    
    /** 
     * disaster victim interface to add them to designated locations
     * @param args command line arguments
     */
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
            System.out.println("1.) View available locations");
            System.out.println("2.) View occupants at location");
            System.out.println("3.) Add a disaster victim to system");
            System.out.println("4.) Exit");
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
                else if (choice == 2) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("1.) siteA");
                    System.out.println("2.) siteB");
                    System.out.println("3.) siteC");
                    System.out.println("4.) siteD");
                    System.out.print("Select the location you would like to see occupants from:  ");
                    int choice2 = scanner.nextInt();

                    for (int i = 0; i < sites.get(choice2 - 1).getOccupants().size(); i++) {
                        System.out.println("--------------------------------------------------");
                        System.out.print("First name: ");
                        System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getFirstName());
                        System.out.print("Entry date: ");
                        System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getEntryDate());
                        if (sites.get(choice2 - 1).getOccupants().get(i).getMedicalRecords() == null) {
                            System.out.println("No medical records recorded");
                        }
                        else {
                            System.out.print("Treatment details: ");
                            System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getMedicalRecords().get(0).getTreatmentDetails());
                            System.out.print("Treatment date: ");
                            System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getMedicalRecords().get(0).getDateOfTreatment());
                        }
                        if (sites.get(choice2 - 1).getOccupants().get(i).getFamilyConnections() == null) {
                            System.out.println("No relations recorded");
                        }
                        else {
                            System.out.print("Related victim first name: ");
                            if (sites.get(choice2 - 1).getOccupants().get(i) == sites.get(choice2 - 1).getOccupants().get(i).getFamilyConnections().get(0).getPersonOne()) {
                                System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getFamilyConnections().get(0).getPersonTwo().getFirstName());
                            }
                            else {
                                System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getFamilyConnections().get(0).getPersonOne().getFirstName());
                            }
                            System.out.print("Relation description: ");
                            System.out.println(sites.get(choice2 - 1).getOccupants().get(i).getFamilyConnections().get(0).getRelationshipTo());
                        }
                    }
                }
                else if (choice == 3) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("1.) siteA");
                    System.out.println("2.) siteB");
                    System.out.println("3.) siteC");
                    System.out.println("4.) siteD");
                    System.out.print("Enter location to place disaster victim in: ");
                    int entered_location = scanner.nextInt();
                    scanner.nextLine();
                    if (entered_location >= 1 && entered_location <= 4) {
                        try {
                            System.out.print("Enter given firstname for disaster victim: ");
                            String entered_name = scanner.nextLine();
                            System.out.print("Enter given entry date for disaster victim: ");
                            String entered_date = scanner.nextLine();
                            DisasterVictim newVictim = new DisasterVictim(entered_name, entered_date);
                            System.out.print("Enter medical records (Type 1 for yes and 2 for no)? ");
                            int choice3a = scanner.nextInt();
                            scanner.nextLine();
                            if (choice3a == 1) {
                                System.out.print("Enter treatment details: ");
                                String entered_treatment_details = scanner.nextLine();
                                System.out.print("Enter date of treatment: ");
                                String entered_treatment_date = scanner.nextLine();
                                MedicalRecord newMedicalRecord = new MedicalRecord(sites.get(entered_location-1), entered_treatment_details, entered_treatment_date);
                                newVictim.addMedicalRecord(newMedicalRecord);
                                System.out.println("Medical records created");
                            }
                            else if (choice3a == 2) {    
                            }
                            else {
                                throw new Exception();
                            }
                            System.out.print("Enter relations? (Type 1 for yes and 2 for no)? ");
                            int choice3b = scanner.nextInt();
                            scanner.nextLine();
                            if (choice3b == 1) {
                                System.out.print("Enter first name of related disaster victim: ");
                                Boolean match = false;
                                String entered_related_victim = scanner.nextLine().trim();
                                System.out.print("Enter relationship to victim: ");
                                String entered_relation_description = scanner.nextLine();
                                for (int i = 0; i < sites.size(); i++) {
                                    for (int j = 0; j < sites.get(i).getOccupants().size(); i++) {
                                        if (sites.get(i).getOccupants().get(j).getFirstName().toLowerCase().equals(entered_related_victim.toLowerCase())) {
                                            match = true;
                                            try {
                                                FamilyRelation newFamilyRelation = new FamilyRelation(newVictim, entered_relation_description, sites.get(i).getOccupants().get(j));
                                                newVictim.addFamilyConnection(newFamilyRelation);
                                                System.out.println("Relationship created");

                                            }
                                            catch(IllegalArgumentException e) {
                                                System.out.println("Relationship already exists");
                                            }
                                        }
                                    }
                                }
                                if (!match) {
                                    System.out.println("Related victim not found in any location");
                                }
                            }
                            else if (choice3b == 2) {
                            }
                            else {
                                throw new Exception();
                            }

                            sites.get(entered_location-1).addOccupant(newVictim);
                            System.out.println("Victim successfully added to system!");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println("Invalid date format, follow YYYY-MM-DD");
                        }
                    }
                    else {
                        System.out.println("Invalid choice");
                    }
                }
                else if (choice == 4) {
                    System.out.println("Exiting program.");
                    break;
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
