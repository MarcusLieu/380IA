

package edu.ucalgary.oop;

import java.util.ArrayList;
/**
 * represents a place where disaster victims are placed, and where supplies is located
 */
public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants;
    private ArrayList<Supply> supplies;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new ArrayList<>();
        this.supplies = new ArrayList<>();
    }

    
    /** 
     * gets name field
     * @return name as String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * set name field
     * @param name as String
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * gets address field
     * @return address as String
     */
    public String getAddress() {
        return this.address;
    }

    
    /** 
     * set address field
     * @param address as string
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /** 
     * gets occupants field
     * @return occupants as array list
     */
    public ArrayList<DisasterVictim> getOccupants() {
        return this.occupants;
    }

    
    /** 
     * sets occupants field
     * @param occupants as array list of disaster victims
     */
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = occupants;
    }

    
    /** 
     * gets supplies field
     * @return supplies as array list
     */
    public ArrayList<Supply> getSupplies() {
        return this.supplies;
    }

    
    /** 
     * sets supplies field
     * @param supplies as array list of supplies
     */
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }

    
    /** 
     * adds element to occupants field
     * @param occupant as disaster victim object
     */
    public void addOccupant(DisasterVictim occupant) {
        if (!this.occupants.contains(occupant)) {
            this.occupants.add(occupant);
        }
    }

    
    /** 
     * removes element from occupants field
     * @param occupant as disaster victim
     */
    public void removeOccupant(DisasterVictim occupant) {
        this.occupants.remove(occupant);
    }

    
    /** 
     * adds element to supply field if it is not already in it
     * @param supply as supply object
     */
    public void addSupply(Supply supply) {
        if (!this.supplies.contains(supply)) {
            this.supplies.add(supply);
        }
    }

    
    /** 
     * removes element from supply field
     * @param supply as supply
     */
    public void removeSupply(Supply supply) {
        this.supplies.remove(supply);
    }
}

