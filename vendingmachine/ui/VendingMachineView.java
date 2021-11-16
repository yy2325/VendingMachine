package ui;

import dto.Selection;
import java.math.*;
import java.util.*;
/**
 * This class will show all the messages to be printed to the user
 * when running the application
 * @author Yi Yang
 *
 */
public class VendingMachineView {
    UserIO io;
    /**
     * Constructs a new DVDLibraryView object
     * @param io
     */
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    /**
     * Prints out the menu options to display
     * @return the option that is selected between 1 and 2
     */
    public int getMenuSelection() {
        
        io.print("What would you like to do?");
        return io.readInt("1. Purchase an item \n2. Exit", 1, 2);
    }
    /**
     * Prints out currently items in stock, their costs and the amount left
     * @param selectionList
     */
    public void displaySelectionList(List<Selection> selectionList) {
        for (Selection currentSelection : selectionList) {
            io.print(currentSelection.getSelectionName() + " -  " +
                    currentSelection.getCost() + " : "  +
                    currentSelection.getInventory());
        }
        io.readString("Hit Enter to continue.");
    }
    /**
     * Asks for user how much money they want to put in
     * @return BigDecimal value of input.
     */
    public BigDecimal getMonetaryInput(){ 
        @SuppressWarnings("resource")
		Scanner myScanner =  new Scanner(System.in);
        io.print("How much money would you like to use? ");
        BigDecimal cash = new BigDecimal(myScanner.nextLine());
        return cash;
        
    }
    /**
     * Asks for name of item to purchase
     * @return String
     */
    public String getSelection(){
        return io.readString("What would you like to purchase? Please enter exact name, case sensitive");
    }
   
    /**
     * The banner to be displayed to begin the application
     */
    public void sayHello() {
        io.print("Welcome to my vending machine!");
    }
    /**
     * Prints out string
     * @param string
     */
    public void displayString(String string) {
        io.print(string);
    }
    /**
     * The banner to be displayed at the end of the applicaiton
     */
    public void sayGoodBye() {
        io.print("Thank you!");
    }
    /**
     * The message to be displayed after a successful item purchase
     */
    public void displaySuccesfulPurchase() {
        io.print("Please wait a moment for your item");  
    }
    /**
     * The message to be displayed after an unsuccessful item purchase
     */
    public void displayUnsuccesfulPurchase1() {
        io.print("You cannot purchase this item!");
    }
    /**
     * The message to be displayed if an item to be purchased is out of stock
     */
    public void displayUnsuccesfulPurchase2() {
        io.print("The item you selected is out of stock."); 
    }
    /**
     * The message to be displayed when showing balance
     * @param balance
     */
    public void displayBalance(BigDecimal balance) {
        io.print("Your balance is $" + balance);
    }
    /**
     * Error banner
     * @param errorMsg
     */
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
}
