/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Sami Dunn
 * Section: 11am
 * Date: 10/1/19
 * Time: 7:48 PM
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: Payable
 *
 * Description:  Interface that can be implemented by all payable objects
 *
 * ****************************************
 */

package lab10;

import java.text.ParseException;

/**
 * Creates the abstract methods in order to write a check to an employee of the company
 */

public interface Payable {

    /**
     * Given the number of hours to pay for, this should return
     * a double amount representing the amount of money that should be paid
     * @param nmHrs
     * @return payment
     */
    double calculatePay(double nmHrs);

    /**
     * Returns a string that should be placed in the "Pay To:" field on the check to be printed
     * @return employee
     */
    String getPayTo();

    /**
     * return a string that should be placed in the "Memo:" field on the check
     * @return memo
     */
    String getPayMemo() throws ParseException;
}
