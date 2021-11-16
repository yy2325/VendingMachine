package ui;

import java.util.*;

/**
 * This class implements all the methods in UserIO interface
 * @author Yi Yang
 *
 */
public class UserIOImpl implements UserIO {

    Scanner myScanner = new Scanner(System.in);
    
    /**
     *
     * A very simple method that takes in a message to display on the console 
     * and then waits for a integer answer from the user to return.
     *
     * @param msg - String of information to display to the user.
     *
     */
    @Override
    public void print(String msg){
        System.out.println(msg);   
    }
    
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and then waits for an answer from the user to return.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as string
     */
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        
        String a = myScanner.nextLine();
        return a;
    }
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as integer
     */
    @Override
    public int readInt(String prompt){
    	boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                // print the message prompt
                String stringValue = this.readString(prompt);
                // Get the input line, and try and parse
                num = Integer.parseInt(stringValue); 
                invalidInput = false; 
            } catch (NumberFormatException e) {
                // If invalid, it'll go here and do this.
                this.print("Invalid input, try again!");
            }
        }
        return num;  
    }
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
    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as double
     */
    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Invalid input, try again!");
            }
        }
    }
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
    @Override
    public double readDouble(String prompt, double min, double max) {
    	double result;
    	do {
    		result = readDouble(prompt);
    		} while (result < min || result > max);
    	return result;
    	}
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a float
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as float
     */
    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Invalid input, try again!");
            }
        }
    }
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
    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a long
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as long
     */
    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Invalid input, try again!");
            }
        }
    }
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
    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }
    
}
