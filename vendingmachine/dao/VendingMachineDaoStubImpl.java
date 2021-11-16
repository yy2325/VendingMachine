package dao;

import dao.exceptions.VendingMachinePersistenceException;
import dto.Selection;
import dto.VendingMachineDetails;
import java.util.*;
import java.math.*;
/**
 * This is a stub implementation of VendingMachineDao interface
 * for testing purposes.
 * @author Yi Yang
 *
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    private Selection firstSelection;
    private Selection secondSelection;
    private List<Selection> selectionList = new ArrayList<>();
    /**
     * Constructs a new VendingMachineDaoStubImpl obj
     */
    public VendingMachineDaoStubImpl() {
        firstSelection = new Selection("Cookie");
        firstSelection.setCost(new BigDecimal ("1.00") );
        firstSelection.setInventory(10);
        
        secondSelection = new Selection("Milk");
        secondSelection.setCost(new BigDecimal ("2.00") );
        secondSelection.setInventory(0);
       
        selectionList.add(firstSelection);
        selectionList.add(secondSelection);
    }
    /**
	 * Returns list of all items in the vending machine
	 * @return Selection list containing all available items for selection
	 * @throws VendingMachinePersistenceException
	 */
    @Override
    public List<Selection> getAllSelections() throws VendingMachinePersistenceException {
        return selectionList;
    }
    /**
     * Returns Selection object of the selection 
     * @param selectionName
     * @return Selection object of the selected item
     * @throws VendingMachinePersistenceException
     */
    @Override
    public Selection getSelectionByName(String selectionName) throws VendingMachinePersistenceException {
        return firstSelection;
    }
    /**
     * Writes to the inventory file with updates to the new amount of items available/
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
    	
    }
    /**
     * Return a VendingMachineDetails object of all the vending machine details
     * @return VendingMachineDetails object of all the vending machine details
     * @throws VendingMachinePersistenceException
     */
    @Override
    public VendingMachineDetails getAllVendingMachineDetails() throws VendingMachinePersistenceException {
        VendingMachineDetails empty = new VendingMachineDetails();
        return empty;
    }
    /**
     * Updating the VendingMachineDetails object
     * @param vmd VendingMachineDatails object
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void writeVendingMachineDetails(VendingMachineDetails vmd) throws VendingMachinePersistenceException {
        
    }
    /**
     * Returns a list of Selection objects sorted
     * @param temp
     * @param temp1
     * @return list of Selection objects sorted
     * @throws VendingMachinePersistenceException
     */
    public List<Selection> sortByInput(BigDecimal temp, int alsoTemp) throws VendingMachinePersistenceException {
        return selectionList;
    }
    
}
