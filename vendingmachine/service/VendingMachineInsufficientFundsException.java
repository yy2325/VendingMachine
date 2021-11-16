package service;
/**
 * This class defines the VendingMachineInsufficientFundsException
 * and the error message
 * @author Yi Yang
 *
 */
public class VendingMachineInsufficientFundsException extends Exception {
    
	private static final long serialVersionUID = 1L;
	/**
	 * Constructs a new VendingMachineInsufficientFundsException given message
	 * @param message
	 */
	public VendingMachineInsufficientFundsException(String message) {
        super(message);
    }
	/**
	 * Constructs a new VendingMachineInsufficientFundsException given message and cause
	 * @param message
	 * @param cause
	 */
    public VendingMachineInsufficientFundsException(String message,
            Throwable cause) {
        super(message, cause);
    }
    
}
