
package edu.ucalgary.oop;
/**
 * things that can be allocated to disaster victims that are stored in specific locations
 */
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
     * gets type field
     * @return type as String
     */
    public String getType(){
        return this.type; 
    }

    
    /** 
     * sets type field
     * @param type as String
     */
    public void setType(String type){
        this.type = new String(type);
    }

    
    /** 
     * gets quantity field
     * @return quantity as int
     */
    public int getQuantity(){
        return this.quantity; 
    }

    
    /** 
     * sets quantity field
     * @param quantity as int
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
