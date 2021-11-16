package dao;

import dao.exceptions.VendingMachinePersistenceException;
import java.io.*;
import java.time.*;
/**
 * This class implements the methods provided in VendingMachineAuditDao interface,
 * it keeps an audit log using java DateTime API to track events of the vending machine.
 * @author Yi Yang
 *
 */
public class VendingMachineAuditDaoImpl implements VendingMachineAuditDao {
    
    public static final String AUDIT_FILE = "audit.txt";
    /**
     * Writes the entry to the audit log that tracks the events of the vending machine.
     * @param entry 
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not persist audit information.", e);
        }
        LocalDateTime timestamp = LocalDateTime.now(); //using java DateTime API
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
        out.close();
    }
    
    
}
