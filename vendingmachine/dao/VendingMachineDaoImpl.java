package dao;

import dao.exceptions.VendingMachinePersistenceException;
import dto.Selection;
import dto.VendingMachineDetails;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;
/**
 * This class implements all the methods in VendingMachineDao interface
 * @author Yi Yang
 *
 */
public class VendingMachineDaoImpl implements VendingMachineDao {
    private final Map<String, Selection> inventory = new HashMap<>();
    private VendingMachineDetails inventory2 = new VendingMachineDetails();
    public static final String INVENTORY = "inventory.txt";
    public static final String VMD = "vendingmachinedetails.txt";
    public static final String DELIMITER = "::";
    /**
     * Loads in the inventory of the vending machine from text file
     * @throws VendingMachinePersistenceException
     */
    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
        	// Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY)));   
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load the inventory into memory", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens will hold the different elements of the vending items
        String[] currentTokens;
        while(scanner.hasNextLine()) {
        	// get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // sets the elements
            Selection currentSelection = new Selection(currentTokens[0]);
            currentSelection.setInventory(Integer.parseInt(currentTokens[2]));
            currentSelection.setCost(new BigDecimal(currentTokens[1]));
            inventory.put(currentSelection.getSelectionName(), currentSelection);
        }
        
        scanner.close();
    }
    /**
     * Loads in the details of vending machine inventory from text file
     * @throws VendingMachinePersistenceException
     */
    private void loadVendingMachineDetails() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
        	// Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(VMD)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load the vending into memory", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens will hold the different elements of the vending items
        String[] currentTokens; 
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            VendingMachineDetails currentSelection;
            currentSelection = new VendingMachineDetails(); 
            int[] intArray = currentSelection.getIntArray();
            // This integer array represents the quantities of the denominations
            // in order from largest denomination to smallest
            for(int i = 0; i <currentTokens.length; i++){
                intArray[i] = Integer.parseInt(currentTokens[i]);
            }
            currentSelection.setIntArray(intArray);
            inventory2 =  currentSelection;
        }
        scanner.close();
    }
    /**
     * Writes to the inventory file with updates to the new amount of items available/
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;
        try {
        	// Create PrintWriter for writing the file
            out = new PrintWriter(new FileWriter(INVENTORY));
        } catch(IOException e) {
                throw new VendingMachinePersistenceException("Could not save inventory data.", e);
        }
        // Write out vending info to the inventory file
        List<Selection> inventory =  this.getAllSelections();
        // iterate through the list and get all the elements
        for(Selection selection: inventory) {
            out.println(selection.getSelectionName() + DELIMITER + selection.getCost() + DELIMITER + selection.getInventory());
            out.flush();
        }
        out.close();
    }
    /**
     * Updating the VendingMachineDetails object
     * @param vmd VendingMachineDatails object
     * @throws VendingMachinePersistenceException
     */
    @Override
    public void writeVendingMachineDetails(VendingMachineDetails vmd) throws VendingMachinePersistenceException {        
        PrintWriter out;
        try {
        	// Create PrintWriter for writing the file
            out = new PrintWriter(new FileWriter(VMD));
        } catch(IOException e) {
                throw new VendingMachinePersistenceException("Could not save vending data.", e);
        }
        // iterate through the list and get all the elements
        for (int intMem : vmd.getIntArray()){
            out.print(intMem + DELIMITER);
        } 
        out.flush();
        out.close();
    }
    /**
	 * Returns list of all items in the vending machine
	 * @return Selection list containing all available items for selection
	 * @throws VendingMachinePersistenceException
	 */
    @Override
    public List<Selection> getAllSelections() throws VendingMachinePersistenceException{
        loadInventory();
        return new ArrayList<>(inventory.values());
    }
    /**
     * Return a VendingMachineDetails object of all the vending machine details
     * @return VendingMachineDetails object of all the vending machine details
     * @throws VendingMachinePersistenceException
     */
    @Override
    public VendingMachineDetails getAllVendingMachineDetails() throws VendingMachinePersistenceException{
        loadVendingMachineDetails();
        return inventory2;
    }
    /**
     * Returns Selection object of the selection 
     * @param selectionName
     * @return Selection object of the selected item
     * @throws VendingMachinePersistenceException
     */
    @Override
    public Selection getSelectionByName(String selectionName)  throws VendingMachinePersistenceException{
        loadInventory();
        return inventory.get(selectionName);
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
        loadInventory();
        return inventory.values()
                .stream()
                .filter(s -> s.getCost().doubleValue() <= temp.doubleValue())
                .filter(s -> s.getInventory() > alsoTemp)
                .collect(Collectors.toList()); //using lambda
    }
    
}

