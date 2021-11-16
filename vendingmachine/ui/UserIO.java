package ui;
/**
 * /**
 * The interface provides list of methods to be implemented for UserIOImpl
 * @author Yi Yang
 *
 */

public interface UserIO {
	/**
    *
    * A very simple method that takes in a message to display on the console 
    * and then waits for a integer answer from the user to return.
    *
    * @param msg - String of information to display to the user.
    *
    */
    void print(String msg);
    /**
    *
    * A simple method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter a double
    * to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @return the answer to the message as double
    */
    double readDouble(String prompt) throws NumberFormatException;
    /**
    *
    * A slightly more complex method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter a double
    * within the specified min/max range to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @param min - minimum acceptable value for return
    * @param max - maximum acceptable value for return
    * @return an double value as an answer to the message prompt within the min/max range
    */
    double readDouble(String prompt, double min, double max) throws NumberFormatException;
    /**
    *
    * A simple method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter a float
    * to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @return the answer to the message as float
    */
    float readFloat(String prompt) throws NumberFormatException;
    /**
    *
    * A slightly more complex method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter a float
    * within the specified min/max range to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @param min - minimum acceptable value for return
    * @param max - maximum acceptable value for return
    * @return an float value as an answer to the message prompt within the min/max range
    */
    float readFloat(String prompt, float min, float max) throws NumberFormatException;
    /**
    *
    * A simple method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter an integer
    * to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @return the answer to the message as integer
    */
    int readInt(String prompt) throws NumberFormatException;
    /**
    *
    * A slightly more complex method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter an integer
    * within the specified min/max range to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @param min - minimum acceptable value for return
    * @param max - maximum acceptable value for return
    * @return an integer value as an answer to the message prompt within the min/max range
    */
    int readInt(String prompt, int min, int max) throws NumberFormatException;
    /**
    *
    * A simple method that takes in a message to display on the console, 
    * and continually reprompts the user with that message until they enter a long
    * to be returned as the answer to that message.
    *
    * @param prompt - String explaining what information you want from the user.
    * @return the answer to the message as long
    */
    long readLong(String prompt) throws NumberFormatException;
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a long
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an long value as an answer to the message prompt within the min/max range
     */
    long readLong(String prompt, long min, long max) throws NumberFormatException;
    /**
    *
    * A simple method that takes in a message to display on the console, 
    * and then waits for an answer from the user to return.
    *
    * @param prompt - String explaining what information you want from the user.
    * @return the answer to the message as string
    */
    String readString(String prompt);
    
}