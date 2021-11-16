package vendingmachine;

import dao.*;
import controller.VendingMachineController;
import dao.exceptions.VendingMachinePersistenceException;
import ui.*;
import service.*;
/**
 * This class contains the main method that runs the application
 * @author Yi Yang
 *
 */
public class App {
	/**
	 * Main method of the program
	 * @param args
	 */
    public static void main(String[] args) throws VendingMachinePersistenceException {
        UserIO iO = new UserIOImpl();
        VendingMachineView myView = new VendingMachineView(iO);
        VendingMachineDao myDao = new VendingMachineDaoImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoImpl();
        VendingMachineService myService = new VendingMachineServiceImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myService,  myView);
        controller.run();
        
    }
    
}
