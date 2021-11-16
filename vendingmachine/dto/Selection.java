package dto;

import java.math.*;
/**
 * This class is the selection class that 
 * contains getters and setters for each element
 * of the vending item.
 * @author Yi Yang
 *
 */
public class Selection {
    private final  String selectionName;
    private BigDecimal cost;
    private int numOfItem; // number in stock
    /**
     * Constructs a new Selection object given its name
     * @param name
     */
    public Selection(String name) {
        this.selectionName = name;
    }
    /**
     * Returns the name of the item
     * @return name of item
     */
    public String getSelectionName() {
        return selectionName;
    }
    /**
     * Returns cost of item
     * @return cost of item
     */
    public BigDecimal getCost() {
        return cost;
    } 
    /**
     * Sets the cost of the item
     * @param cost
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    /**
     * Returns how many in stock
     * @return
     */
    public int getInventory() {
        return numOfItem;
    }
    /**
     * Sets how many items in stock
     * @param inventory
     */
    public void setInventory(int inventory) {
        this.numOfItem = inventory;
        }
    
    
}