/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Sami Dunn and Michael Heller
 * Section: 11am
 * Date: 10/1/19
 * Time: 11:11 PM
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: Contractor
 *
 * Description:  Creates a Contractor class
 *
 * ****************************************
 */

package lab10;

import java.text.ParseException;
import java.util.Date;

public class Contractor implements Payable{
    /** ID Number */
    private int IDNum;
    /** First name of the contractor */
    private String firstName;
    /** Last name of the contractor */
    private String lastName;
    /** Social security number */
    private int SSN;
    /** The fixed hourly rate */
    private double hourlyRate;

    /** Construct a new contractor object */
    public Contractor(int IDNum, String firstName, String lastName, int SSN, double hourlyRate) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.hourlyRate = hourlyRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public int getIDNum() {
        return IDNum;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    /** Clean way of displaying the contractors */
    @Override
    public String toString() {
        return "Contractor{" +
                "IDNum=" + IDNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN=" + SSN +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

    /**
     * Given the number of hours to pay for, this should return
     * a double amount representing the amount of money that should be paid
     *
     * @param nmHrs
     * @return payment
     */
    @Override
    public double calculatePay(double nmHrs) {
        return hourlyRate * nmHrs;
    }

    /**
     * Returns a string that should be placed in the "Pay To:" field on the check to be printed
     *
     * @return employee
     */
    @Override
    public String getPayTo() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * return a string that should be placed in the "Memo:" field on the check
     *
     * @return memo
     */
    @Override
    public String getPayMemo() throws ParseException {
        return "Contractor ID: " + getIDNum() + ", Pay Date: " + HRDateUtils.strToDate("2019-10-02");
    }
}
