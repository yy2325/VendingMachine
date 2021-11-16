package dto;

import java.math.*;
/**
 * This enum converts the dollar amount into different denominations
 * @author Yi Yang
 *
 */
public enum Denominations {
    HUNDREDS ( new BigDecimal("100.00")), //$100 bills
    FIFTIES ( new BigDecimal("50.00")), //$50 bills
    TWENTIES ( new BigDecimal("20.00")), //$20 bills
    TENS ( new BigDecimal("10.00")), //$10 bills
    FIVES ( new BigDecimal("5.00")), //$5 bills
    TWOS ( new BigDecimal("2.00")), //$2 bills
    ONES ( new BigDecimal("1.00")), //$1 bills
    QUARTERS ( new BigDecimal("0.25")), //$0.25 coins
    DIMES ( new BigDecimal("0.10")), //$0.10 coins
    NICKELS ( new BigDecimal("0.05")), //$0.05 coins
    PENNIES ( new BigDecimal("0.01")); //$0.01 coins
  
    public final BigDecimal description;
    
    Denominations(BigDecimal denomination){
        description = denomination;     
    }
     
}