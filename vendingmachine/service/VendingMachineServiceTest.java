package service;

import dao.*;
import dto.Selection;
import java.math.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This is a junit test class to test the functions of the service layer
 * @author Yi Yang
 *
 */
public class VendingMachineServiceTest {
    private VendingMachineService service;
    /**
     * Constructs a new VendingMachineServiceTest object
     */
    public VendingMachineServiceTest() {
    	//using the stub implmentations to test
        VendingMachineDao dao = new VendingMachineDaoStubImpl(); 
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
   
    service = new VendingMachineServiceImpl(dao, auditDao);   
    }
    /**
     * Tests if inventory is updated
     * @throws Exception
     */
    @Test
    public void testIfPurchaseSelectionIsUpdatingTheInventory() throws Exception {
        int a = service.getSelectionByName("Cookie").getInventory();
        service.purchaseSelection(service.getSelectionByName("Cookie"),service.getSelectionByName("Cookie").getCost());
        assertEquals( (a - 1) ,service.getSelectionByName("Cookie").getInventory());
    }
    /**
     * Tests if a purchase for an item is valid, if insufficient fund is given
     * and no exception is thrown, it'd be a fail.
     * @throws Exception
     */
    @Test
    public void testValidatePurchaseForAnItemInInventory() throws Exception {
        try {
        service.validatePurchase(service.getSelectionByName("Cookie"), new BigDecimal ("0.50"));
        fail("Expected VendingMachineInsufficientFundsException was not thrown.");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }  
    }
    /**
     * Tests if exception is thrown for an item with no inventory left
     * @throws Exception
     */
    @Test
    public void testValidatePurchaseForAnItemNotInInventory() throws Exception {
        Selection temp = service.getSelectionByName("Milk");
        temp.setInventory(0);
        try {
        service.validatePurchase(temp, new BigDecimal ("2.50"));
        fail("Expected VendingMachineNoItemInventoryException was not thrown.");
        } catch (VendingMachineNoItemInventoryException e) {
            return;
        }
        
    }

    

   
    
}
