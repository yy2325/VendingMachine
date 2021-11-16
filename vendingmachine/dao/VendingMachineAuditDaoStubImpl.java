package dao;

import dao.exceptions.VendingMachinePersistenceException;

/**
 * This is a stub implementation for VendingMachineAuditDao
 * for testing purposes.
 * @author Yi Yang
 *
 */
public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao {
	/**
     * Writes the entry to the audit log that tracks the events of the vending machine.
     * @param entry 
     * @throws VendingMachinePersistenceException
     */
	@Override
	public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
		//stub
   }
    
}
