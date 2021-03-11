/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller and Sami Dunn
 * Section: 11 am
 * Date: 9/30/19
 * Time:
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: Account
 *
 * Description:  File that contains classes for an Insufficient Funds exception and
 * creates an Account object that is implemented from the Payable interface.
 *
 * ****************************************
 */

package lab10;

import java.io.PrintStream;
import java.text.ParseException;

/**
 * Exception class for when there is insufficient funds in an account
 * @authors Michael Heller and Sami Dunn
 * @version 0.1
 */
class InsufficientFundsException extends Throwable {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


/**
 * Implementation of an Account object that stems from the Payable interface
 * @authors Michael Heller and Sami Dunn
 * @version 0.1
 */
public class Account  {

    private double balance;

    /**
     * Account constructor that takes in an initial account balance
     * @param initBalance
     */
    public Account (double initBalance) {
        this.balance = initBalance;
    }

    /**
     * Setter method for the account balance
     */
    public void setBalance() {
        this.balance = balance;
    }

    /**
     * Getter method for the account balance
     * @return current account balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Credits money to an account
     * @param amount
     * @return the account balance after adding credit
     */
    public double credit(double amount) {
        balance += amount;
        return balance;
    }

    /**
     * Takes debit amount value from an account
     * @param amount
     * @return the account balance after taking debit
     */
    public double debit(double amount) throws InsufficientFundsException {

        if (amount >= balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        else {
            balance -= amount;
            return balance;
        }
    }

    /**
     * Prints out check information for a payable entity
     * @param p
     * @param hoursBilled
     * @param out
     */
    public void processCheck(Payable p, double hoursBilled, PrintStream out) throws ParseException, InsufficientFundsException {

            double checkAmount = p.calculatePay(hoursBilled);
            String roundedAmount = String.format("%.02f",checkAmount);
            out.println("Pay to: " + p.getPayTo());
            out.println("Memo: " + p.getPayMemo());
            debit(checkAmount);
            out.println("Amount paid: $" + roundedAmount);
        }


    /**
     * toString method that prints the account and its balance
     * @return String description
     */
    @Override
    public String toString() {
        return "Account{" +
                "balance = $" + String.format("%.02f", balance) +
                '}';
    }



}