/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller and Sami Dunn
 * Section: 11 am
 * Date: 9/26/19
 * Time:
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: HRDBSystem
 *
 * Description:  Human Resources database main class
 *
 * ****************************************
 */

package lab10;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for Human Resources database
 */
public class HRDBSystem {
    /**
     * Main method for the Human Resources class
     * @param args
     */
    public static void main(String[] args) throws ParseException, ManagerException {
        //create lists for each employee category
        List<Employee> empList= new ArrayList<Employee>();
        List<Manager> manList = new ArrayList<Manager>();

        //initiate all employees/managers
        Manager manager = new Manager(0, "Michael", "Scott", 87654321, HRDateUtils.strToDate("2000-03-13") , 100000000, "ENGINEERING");
        Employee employee1 = new Employee(1, "Dwight", "Schrute", 12345678, HRDateUtils.strToDate("2000-07-01"), 100000000);
        Employee employee2 = new Employee(10, "Jim", "Halpert", 66666666, HRDateUtils.strToDate("1999-03-30"), 75000);
        Employee employee3 = new Employee(2, "Pam", "Beasley", 13131313, HRDateUtils.strToDate("2000-02-22"), 65000);
        Manager manager2 = new Manager(21, "Jerry", "Birmingham", 10458209, HRDateUtils.strToDate("1995-05-10") , 100000000, "ADMINISTRATION");
        Employee employee4 = new Employee(11, "Jason", "Shaw", 56910582, HRDateUtils.strToDate("1998-06-03"), 100000000);
        Employee employee5 = new Employee(12, "Emily", "Smith", 10564819, HRDateUtils.strToDate("1999-09-30"), 75000);
        Employee employee6 = new Employee(13, "John", "Parker", 67391057, HRDateUtils.strToDate("2000-02-26"), 65000);

        //add all employees/managers to designated lists
        empList.add(manager);
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
        empList.add(employee5);
        empList.add(employee6);
        manList.add(manager);
        manList.add(manager2);

        //display employees
        System.out.println(manager);
        displayEmployee(employee1);
        displayEmployees(empList);

        //Assign employees to manager
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);

        //Assign employees to manager2
        manager2.addEmployee(employee4);
        manager2.addEmployee(employee5);
        manager2.addEmployee(employee6);

        //display managers and their employees
        manager.displayManager(manager);
        manager2.displayManager(manager2);

    }

    /**
     * Prints out a singular employee with his/her employee ID
     * @param emp
     */
    public static void displayEmployee(Employee emp) {
        if (emp instanceof Manager) {
            System.out.println(emp.getEmpID() + " : " + emp.getFirstName() + " " + emp.getLastName() + " [MANAGER]");
        }
        else {
            System.out.println(emp.getEmpID() + " : " + emp.getFirstName() + " " + emp.getLastName());
        }

    }

    /**
     * prints every employee or manager in a list
     * @param ListOfEmps
     */
    public static void displayEmployees(List<Employee> ListOfEmps) {
        for (int i = 0; i < ListOfEmps.size(); i++) {
            displayEmployee(ListOfEmps.get(i));
        }

    }
}