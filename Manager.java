/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller and Sami Dunn
 * Section: 11 am
 * Date: 9/24/19
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: Manager
 *
 * Description:  Manager subclass for the Employee class
 *
 * ****************************************
 */

package lab10;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Checked exception checking any issues that might arise from the Manager class
 */
class ManagerException extends Exception {
    public ManagerException(String message)  {super(message);}
    }

/**
 * Manager class as a type of employee
 */
public class Manager extends Employee {
    private List<Employee> empList;
    private DepartmentName deptName;

    /**
     * Explicit constructor to create new employee
     *
     * @param empID     Employee id
     * @param firstName First name
     * @param lastName  Last name
     * @param ssNum     Social Security Number
     * @param hireDate  Hire date (as {@link Date} object
     * @param salary    Current employee salary
     * @param deptName  The {@link DepartmentName} that the manager is in charge of
     */
    public Manager(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary, DepartmentName deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;

    }

    /**
     * String constructor for new Managers
     * @param empID     Employee id
     * @param firstName First name
     * @param lastName  Last name
     * @param ssNum     Social Security Number
     * @param hireDate  Hire date (as {@link Date} object
     * @param salary    Current employee salary
     * @param deptName  The {@link String} that the manager is in charge of
     */
    public Manager(int empID, String firstName, String lastName, int ssNum, Date hireDate, double salary, String deptName) throws ManagerException {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.empList = new ArrayList<Employee>();
        try {
            this.deptName = DepartmentName.valueOf(deptName);
        }
        catch (IllegalArgumentException e) {
            throw new ManagerException("Invalid Department Name: " + deptName);
        }

    }


    /**
     * Getter method for department name
     *
     * @return this.deptName
     */
    public DepartmentName getDeptName() {
        return this.deptName;
    }

    /**
     * Setter method for department name
     */
    public void setDeptName() {
        this.deptName = deptName;

    }

    /**
     * Adds employee to a certain manager
     * @param emp
     * @throws ManagerException
     */
    public void addEmployee(Employee emp) throws ManagerException {
        if(empList.contains(emp)) {
            throw new ManagerException("Employee " + emp.getFirstName() + " " + emp.getLastName() + " already exists.");
        }
        else empList.add(emp);
    }

    /**
     * Returns the list of employees a manager is currently in charge of
     * @return
     */
    public List<Employee> getEmpList() {
        return this.empList;
    }

    /**
     * Takes employees off of a manager's list
     * @param emp
     * @throws ManagerException
     */
    public void removeEmployee(Employee emp) throws ManagerException {
            if (empList.contains(emp) == false) {
                throw new ManagerException("Employee " + emp.getFirstName() + " " + emp.getLastName() + " does not exist.");
            }
            else empList.remove(emp);
    }

    /**
     * prints every employee that's working under a manager
     * @param man
     */
    public static void displayManager(Manager man) {
        System.out.println("Manager:\t" + man.getFirstName() + " " + man.getLastName());
        System.out.println("Department:\t" + man.getDeptName());
        System.out.println("# Employees:\t" + man.getEmpList().size());
        HRDBSystem.displayEmployees(man.getEmpList());

    }


        /**
         * toString method to print the manager and details, includes department name
         *
         * @return super.toString() + ",MANAGER," + getDeptName()
         */
    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + getDeptName();
    }

    public enum DepartmentName {
        ENGINEERING("ENGINEERING"),
        HUMAN("HUMAN RESOURCES"),
        ADMINISTRATION("ADMINISTRATION"),
        STAFF("STAFF"),
        OTHER("OTHER");


        private String deptName;
        /**
         * Constructs a new department name
         *
         * @param deptName
         */
        DepartmentName(String deptName) {
            this.deptName = deptName;
        }


    }

}