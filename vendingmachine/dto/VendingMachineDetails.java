package dto;

/**
 * This class contains getter and setter for 
 * int array, to be used to calculate the change in Change class
 * @author Yi Yang
 *
 */
public class VendingMachineDetails {
    int[] intArray = new int[10];
    /**
     * Constructs a new VendingMachineDetails object
     */
    public VendingMachineDetails() {
        
    }
    /**
     * Sets the int array
     * @param intArray
     */
    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }
    /**
     * Returns the int array
     * @return the int array
     */
    public int[] getIntArray() {
        return this.intArray;
    }
     
}

