/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 *
 * Name: Michael Heller and Sami Dunn
 * Date: 9/25/19
 *
 * Project: csci205
 * Package: lab09
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab10;



import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * A basic representation for an Employee to be stored in an HR database system
 *
 * @author Michael Heller
 * @version 0.2
 */
public class Employee implements Payable{

    /** Employee id */
    private int empID;

    /** First name */
    private String firstName;

    /** Last name */
    private String lastName;

    /** Social Security number */
    private int ssNum;

    /** Date employee was hired */
    private Date hireDate;

    /** Current salary of the employee */
    private double salary;

    /**
     * Explicit constructor to create new employee - uses generateID() to create a new employee ID based on
     * if the ID is already being used or not
     *
     * @param empID     Employee id
     * @param firstName First name
     * @param lastName  Last name
     * @param ssNum     Social Security Number
     * @param hireDate  Hire date (as {@link Date} object
     * @param salary    Current employee salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary) {

        this.empID = IDFactory.safeToUse(empID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    /**
     * @return the employee id
     */
    public int getEmpID() { return empID; }

    /**
     * @return employee first name
     */
    public String getFirstName() { return firstName; }

    /**
     * @return Last name
     */
    public String getLastName() { return lastName; }

    /**
     * @return Social Security number
     */
    public int getSsNum() {
        return ssNum;
    }

    /**
     * @return {@link Date} employee was hired
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @return current employee salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }


    /**
     * Generated equal function for the Employee class
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ssNum == employee.ssNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, firstName, lastName, ssNum, hireDate, salary);
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + HRDateUtils.dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;

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
        //52 weeks in a year and 40 hours per week
        double hrRate = getSalary() / (40*52);
        //calculate their weekly pay
        double paycheck = 40 * hrRate;
        //determine if they worked overtime and calculate it
        if (nmHrs > 40) {
            double OT = nmHrs - 40;
            double OTMoney = OT * (hrRate*1.5);
            return OTMoney + paycheck;
        }
        //else return their normal weekly paycheck
        else {
            return paycheck;
        }

    }

    /**
     * Returns a string that should be placed in the "Pay To:" field on the check to be printed
     *
     * @return first and last name of employee
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
        return "Employee ID: " + getEmpID() + ", Pay Date: " + HRDateUtils.strToDate("2019-10-01");
    }

    /**
     * A factory to generate unique IDs in a safe way
     */
    private static class IDFactory {
        /**
         * Collection of unique Employee IDs generated / assigned
         */
        static HashSet<Integer> setOfAssignedIDs = new HashSet<>();

        /**
         * Generates next available unused employee ID
         * @return
         */
        static Integer generateID() {
            int count = 0;
            for (int i = 1; i-1 <= setOfAssignedIDs.size(); i++) {
                count++;
                if (setOfAssignedIDs.size() == 0) {
                    return 1;
                }

                else if (setOfAssignedIDs.contains(i)) {
                    continue;
                }

                else {
                    return count;
                }

            }
            return count;
        }

        /**
         * Checks to see which IDs have not been used yet and if a new one would work
         * @param empID
         * @return new or confirmed empID
         */
        public static Integer safeToUse(Integer empID) {

            if (IDFactory.setOfAssignedIDs.contains(empID) || empID <= 0){
                empID = IDFactory.generateID();
                IDFactory.setOfAssignedIDs.add(empID);
                return empID;
            }

            else {
                IDFactory.setOfAssignedIDs.add(empID);
                return empID;
            }
        }
    }
}
