package dao;

import dao.exceptions.VendingMachinePersistenceException;
/**
 * This interface provides all the methods to be implemented in VendingMachineAuditDaoImpl
 * @author Yi Yang
 *
 */
public interface VendingMachineAuditDao {
    /**
     * Writes the entry to the audit log that tracks the events of the vending machine.
     * @param entry 
     * @throws VendingMachinePersistenceException
     */
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
}
