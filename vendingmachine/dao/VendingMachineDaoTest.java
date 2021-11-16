package dao;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This is a junit testing class for VendingMachineDaoImpl
 * @author Yi Yang
 *
 */
public class VendingMachineDaoTest {
	
    VendingMachineDao dao = new VendingMachineDaoImpl();
    /**
     * Constructs a VendingMachineDaoTest object
     */
    public VendingMachineDaoTest() {
    }


    /**
     * Test of getAllSelections method, of class VendingMachineDao.
     */
    @org.junit.Test
    public void testGetAllSelections() throws Exception {
        dao.getAllSelections();
        assertEquals(5, dao.getAllSelections().size());
    }

    /**
     * Test of getSelectionByName method, of class VendingMachineDao.
     */
    @org.junit.Test
    public void testGetSelectionByName() throws Exception {
    	System.out.println("Test ran.");
    }

    /**
     * Test of writeInventory method, of class VendingMachineDao.
     */
    @org.junit.Test
    public void testWriteInventory() throws Exception {
    	System.out.println("Test ran.");
    }

    /**
     * Test of getAllVendingMachineDetails method, of class VendingMachineDao.
     */
    @org.junit.Test
    public void testGetAllVendingMachineDetails() throws Exception {
    	System.out.println("Test ran.");    	
    }
    
}
