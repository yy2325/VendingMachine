package service;

import dao.exceptions.VendingMachinePersistenceException;
import dto.Selection;
import dto.VendingMachineDetails;
import java.util.*;
import java.math.*;
/**
 * This interface contains all the methods to be implemented in
 * VendingMachineServiceImpl class.
 * @author Yi Yang
 *
 */
public interface VendingMachineService {
	/**
	 * Returns list of all items in the vending machine
	 * @return Selection list containing all available items for selection
	 * @throws VendingMachinePersistenceException
	 */
    public List<Selection> getAllSelections() throws VendingMachinePersistenceException;
    /**
     * Returns Selection object of the selection 
     * @param selectionName
     * @return Selection object of the selected item
     * @throws VendingMachinePersistenceException
     */
    public Selection getSelectionByName(String itemName) throws VendingMachinePersistenceException;
    /**
     * Updates the number of items left in the inventory
     * @throws VendingMachinePersistenceException
     */
    public void updateInventory() throws VendingMachinePersistenceException;
    /**
     * Purchases the item selected and updates the inventory accordingly
     * @param selection Selection object
     * @param balance BigDecimal object, amount of money
     * @throws VendingMachineInsufficientFundsException
     * @throws VendingMachineNoItemInventoryException
     * @throws VendingMachinePersistenceException
     */
    public void purchaseSelection(Selection selection, BigDecimal balance) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException ;
    /**
     * Return a VendingMachineDetails object of all the vending machine details
     * @return VendingMachineDetails object of all the vending machine details
     * @throws VendingMachinePersistenceException
     */
    public VendingMachineDetails getAllVendingMachineDetails() throws VendingMachinePersistenceException;
    /**
     * **
     * Updating the VendingMachineDetails object
     * @param vmd VendingMachineDatails object
     * @throws VendingMachinePersistenceException
     */
    public void writeVendingMachineDetails(VendingMachineDetails vmd) throws VendingMachinePersistenceException;
    /**
     * Validates the purchase made
     * @param selection Selection object
     * @param balance BigDecimal object
     * @throws VendingMachineInsufficientFundsException
     * @throws VendingMachineNoItemInventoryException
     */
    public void validatePurchase(Selection selection, BigDecimal balance) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException;
    /**
     * Returns a list of Selection objects sorted
     * @param temp
     * @param temp1
     * @return list of Selection objects sorted
     * @throws VendingMachinePersistenceException
     */
    public List<Selection> sortByInput(BigDecimal temp, int alsoTemp) throws VendingMachinePersistenceException;

}
