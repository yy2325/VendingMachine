package service;

import dao.VendingMachineAuditDao;
import dao.VendingMachineDao;
import dao.exceptions.VendingMachinePersistenceException;
import dto.Selection;
import dto.VendingMachineDetails;
import java.math.*;
import java.util.*;
/**
 * This class implements all the methods in VendingMachineService interface
 * @author Yi Yang
 *
 */
public class VendingMachineServiceImpl implements VendingMachineService {
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    /**
     * Constructs a new VendingMachineServiceImpl object
     * @param dao VendingMachineDao object
     * @param auditDao VendingMachineAuditDao object
     */
    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;  
        this.auditDao = auditDao;
    }
    /**
	 * Returns list of all items in the vending machine
	 * @return Selection list containing all available items for selection
	 * @throws VendingMachinePersistenceException
	 */
    @Override
    public List<Selection> getAllSelections() throws VendingMachinePersistenceException {
        return dao.getAllSelections();
    }
    /**
     * Return a VendingMachineDetails object of all the vending machine details
     * @return VendingMachineDetails object of all the vending machine details
     * @throws VendingMachinePersistenceException
     */
    @Override
    public VendingMachineDetails getAllVendingMachineDetails() throws VendingMachinePersistenceException {
        return dao.getAllVendingMachineDetails();
    }
    /**
     * **
     * Updating the VendingMachineDetails object
     * @param vmd VendingMachineDatails object
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void writeVendingMachineDetails(VendingMachineDetails vmd) throws VendingMachinePersistenceException {
        dao.writeVendingMachineDetails(vmd);
    }
    /**
     * Returns Selection object of the selection 
     * @param selectionName
     * @return Selection object of the selected item
     * @throws VendingMachinePersistenceException
     */
    @Override
    public Selection getSelectionByName(String selectionName) throws VendingMachinePersistenceException {
        return dao.getSelectionByName(selectionName);
    }
    /**
     * Updates the number of items left in the inventory
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void updateInventory() throws VendingMachinePersistenceException {
        dao.writeInventory();
    }
    /**
     * Keeps audit log of transactions
     * @param transaction
     * @throws VendingMachinePersistenceException
     */
   
    public void logTransaction(String transaction) throws VendingMachinePersistenceException{
         auditDao.writeAuditEntry(transaction);   
    }
    /**
     * Purchases the item selected and updates the inventory accordingly
     * @param selection Selection object
     * @param balance BigDecimal object, amount of money
     * @throws VendingMachineInsufficientFundsException
     * @throws VendingMachineNoItemInventoryException
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void purchaseSelection(Selection selection, BigDecimal balance) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException  { 
        validatePurchase(selection, balance);
        selection.setInventory(selection.getInventory() - 1);
        try{
           updateInventory(); 
        } catch (VendingMachinePersistenceException e){
            throw new VendingMachinePersistenceException ("Unable to update inventory", e);
        }   
    }
    /**
     * Validates the purchase made
     * @param selection Selection object
     * @param balance BigDecimal object
     * @throws VendingMachineInsufficientFundsException
     * @throws VendingMachineNoItemInventoryException
     */
    public void validatePurchase(Selection selection, BigDecimal balance) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException {
        if (selection.getCost().doubleValue() > balance.doubleValue() ){  
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Insufficient Funds.");
        } 
        if (selection.getInventory() == 0 ){
          
            throw new VendingMachineNoItemInventoryException(
                    "ERROR: Item not available");
        }
    }
    /**
     * Returns a list of Selection objects sorted
     * @param temp
     * @param temp1
     * @return list of Selection objects sorted
     * @throws VendingMachinePersistenceException
     */
    @Override
    public List<Selection> sortByInput(BigDecimal temp, int alsoTemp) throws VendingMachinePersistenceException {
        return dao.sortByInput(temp, alsoTemp);
    }
    
}
