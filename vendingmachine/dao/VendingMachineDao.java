package dao;

import dao.exceptions.VendingMachinePersistenceException;
import dto.Selection;
import dto.VendingMachineDetails;
import java.util.*;
import java.math.*;
/**
 * This interface provides all methods needed to be implemented in VendingMachineDaoImpl
 * @author Yi Yang
 *
 */
public interface VendingMachineDao {
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
    public Selection getSelectionByName(String selectionName) throws VendingMachinePersistenceException;
    /**
     * Writes to the inventory file with updates to the new amount of items available/
     * @throws VendingMachinePersistenceException
     */
    public void writeInventory()throws VendingMachinePersistenceException;
    /**
     * Return a VendingMachineDetails object of all the vending machine details
     * @return VendingMachineDetails object of all the vending machine details
     * @throws VendingMachinePersistenceException
     */
    public VendingMachineDetails getAllVendingMachineDetails() throws VendingMachinePersistenceException;
    /**
     * Updating the VendingMachineDetails object
     * @param vmd VendingMachineDatails object
     * @throws VendingMachinePersistenceException
     */
    public void writeVendingMachineDetails(VendingMachineDetails vmd) throws VendingMachinePersistenceException;
    /**
     * Returns a list of Selection objects sorted
     * @param temp
     * @param temp1
     * @return list of Selection objects sorted
     * @throws VendingMachinePersistenceException
     */
    public List<Selection> sortByInput(BigDecimal temp, int temp1) throws VendingMachinePersistenceException;
    
}