package dto;

import java.math.*;
/**
 * This class represents takes in how much the user puts in,
 * and calculates and returns the change to the user.
 * @author Yi Yang
 *
 */
public class Change {
    private BigDecimal change;
    private final BigDecimal input;
    private final BigDecimal cost;
    private final BigDecimal changeBeforeBreakDown;
    private int tempHolder;
    /**
     * Constructs a new Change object given input money and cost
     * @param input Money to be used
     * @param cost Cost of the item
     */
    public Change(BigDecimal input, BigDecimal cost) {
        this.input = input;
        this.cost = cost;
        this.changeBeforeBreakDown = input.subtract(cost);
    }
    /**
     * Calculates the change needed to be returned to the user
     * @param vmd VendingMachineDetails object
     * @return the amount needed to be returned to user
     */
    public String calculateChange(VendingMachineDetails vmd) {
        String tempString = "";
        change  = input.subtract(cost);
        int[] intArray = vmd.getIntArray();
        //using the enum array to represent different denominations
        Denominations[] denomArr = Denominations.values(); 
        
        for (int i = 0; i  < intArray.length ; i++){
            tempString += calculateAmount(denomArr[i],intArray[i]);
            intArray[i] = tempHolder; 
        }
        
        vmd.setIntArray(intArray);
        
        return "Your change in denominations is displayed here \n" + changeBeforeBreakDown + "\n" +  tempString;
    } 
    /**
     * This method calculates how many denominations to be returned to fill the change
     * @param den Denominations object
     * @param amountInmachine amount in the vending machine
     * @return the denomination and its amount to be returned
     */
    public String calculateAmount(Denominations den,int amountInmachine){
        int tempQuant = 0;
        while(change.compareTo(den.description) >=0 && amountInmachine  > 0){
            tempQuant++;
            amountInmachine--;
            change = change.subtract(den.description);
        }
        
        tempHolder = amountInmachine;
        return den + " :  " + tempQuant + "\n";  
    }     
}

