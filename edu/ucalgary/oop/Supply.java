package edu.ucalgary.oop;

public class Supply {
    private String type; 
    private int quantity; 

    public Supply(String type, int quantity){
        if(quantity < 0){
            this.quantity = 1; 
        }else{this.quantity = quantity;}
        this.type = new String(type); 
    }
    
    
    /** 
     * @return String
     */
    public String getType(){
        return this.type; 
    }

    
    /** 
     * @param type
     */
    public void setType(String type){
        this.type = new String(type);
    }

    
    /** 
     * @return int
     */
    public int getQuantity(){
        return this.quantity; 
    }

    
    /** 
     * @param quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
