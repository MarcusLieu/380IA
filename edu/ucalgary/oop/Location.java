package edu.ucalgary.oop;

import java.util.ArrayList;

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
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    
    /** 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /** 
     * @return ArrayList<DisasterVictim>
     */
    public ArrayList<DisasterVictim> getOccupants() {
        return this.occupants;
    }

    
    /** 
     * @param occupants
     */
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = occupants;
    }

    
    /** 
     * @return ArrayList<Supply>
     */
    public ArrayList<Supply> getSupplies() {
        return this.supplies;
    }

    
    /** 
     * @param supplies
     */
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }

    
    /** 
     * @param occupant
     */
    public void addOccupant(DisasterVictim occupant) {
        if (!this.occupants.contains(occupant)) {
            this.occupants.add(occupant);
        }
    }

    
    /** 
     * @param occupant
     */
    public void removeOccupant(DisasterVictim occupant) {
        this.occupants.remove(occupant);
    }

    
    /** 
     * @param supply
     */
    public void addSupply(Supply supply) {
        if (!this.supplies.contains(supply)) {
            this.supplies.add(supply);
        }
    }

    
    /** 
     * @param supply
     */
    public void removeSupply(Supply supply) {
        this.supplies.remove(supply);
    }
}

