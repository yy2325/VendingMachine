package controller;

import dao.exceptions.VendingMachinePersistenceException;
import dto.*;
import service.*;
import ui.*;
import java.util.*;
import java.math.*;
/**
 * This class is the controller, it controls the menu, as well as
 * implementing different methods for different options.
 * This program allows 5 different features for users to interact with the vending machine
 * @author Yi Yang
 *
 */
public class VendingMachineController {
    private VendingMachineService service;
    private VendingMachineView view;
    private BigDecimal balance = new BigDecimal("0");
    private VendingMachineDetails vmd;
    /**
     * Constructs a new VendingMachineController object
     * @param service VendingMachineService object
     * @param view VendingMachineView object
     */
    public VendingMachineController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    /**
     * Creates a loop that will execute different features
     * when a menu option is selected
     */
    public void run() throws VendingMachinePersistenceException  {
        view.sayHello(); //prints opening banner
        boolean keepGoing = true;
        try{
            do {
                List<Selection> selectionList = service.getAllSelections();
                view.displaySelectionList(selectionList);//displays the list of items
                int userChoice =  view.getMenuSelection();
                switch(userChoice) {
                    case 1:
                        purchaseItem();
                        break;
                    case 2:
                        keepGoing = false;
                        view.sayGoodBye(); //Prints exiting banner
                        break;
                    default:
                        System.out.println("An error has occured!");
                }
            } while(keepGoing);
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    /**
     * Simulates purchase of item from a vending machine.
     * The vending machine will give what the user selected
     * and return the change to the user.
     * @throws VendingMachinePersistenceException
     */
    public void purchaseItem() throws VendingMachinePersistenceException {
       vmd = service.getAllVendingMachineDetails(); //gets all the items details in the vending machine
       BigDecimal cashInput = view.getMonetaryInput(); //gets how much money user input
       balance = balance.add(cashInput);
       String temp = view.getSelection();
       Selection currentSelection = service.getSelectionByName(temp); 
       Change tempChange = new Change(balance,currentSelection.getCost());
       try{
           service.purchaseSelection(currentSelection, balance);
           balance = balance.subtract(currentSelection.getCost());//updates the balance
           view.displaySuccesfulPurchase();//prints successful purchase banner
           view.displayString(tempChange.calculateChange(vmd)); //calculates the change needed to return
           service.writeVendingMachineDetails(vmd);
       }catch (VendingMachineInsufficientFundsException | VendingMachineNoItemInventoryException e) {
           view.displayErrorMessage(e.getMessage());
       }
       
        
   }

   
}