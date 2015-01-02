package com.lftechnology.dec31;

/**
 * Create a class called Employee that includes three pieces of information as
 * instance variables a first name (type String), a last name (type String) and
 * a monthly salary (double). Your class should have a constructor that
 * initializes the three instance variables. Provide a set and a get method for
 * each instance variable. Write a test application named EmployeeTest that
 * demonstrates class Employee's capabilities. Create two Employee objects and
 * display each object's yearly salary. Then give each Employee a 10% raise and
 * display each Employee's yearly salary again.
 * 
 * @author satish
 *
 */
public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Krishna", "Banjade", 100000);
		Employee employee2 = new Employee("Gopal", "Shah", 80000);
		double salaryRaise = 0;
		employee1.display();
		System.out.println("Yearly Salary: "
				+ employee1.calculateYearlySalary());
		employee2.display();
		System.out.println("Yearly Salary: "
				+ employee2.calculateYearlySalary());

		System.out.println("\nAfter giving the 10 % raise in slary");
		salaryRaise = 10;
		employee1.raiseSalary(salaryRaise);
		employee1.display();
		System.out.println("Yearly Salary: "
				+ employee1.calculateYearlySalary());
		employee2.raiseSalary(10);
		employee2.display();
		System.out.println("Yearly Salary: "
				+ employee2.calculateYearlySalary());

	}

}

/**
 * This class stores the data of an employee such as first name, last name and
 * monthly salary and also provides methods to manipulate it sucha as change
 * salary
 * 
 * @author satish
 *
 */
class Employee {
	String firstName = "";
	String lastName = "";
	// monthly salary
	double salary = 0;

	Employee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return last name of the employee
	 */
	public String setLastName() {
		return lastName;
	}

	/**
	 * @return salary of the employee
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param percentage
	 *            raise in salary
	 */
	public void raiseSalary(double percentage) {
		salary *= 1 + percentage / 100;
	}

	/**
	 * @return yearly salary
	 */
	public double calculateYearlySalary() {
		return salary * 12;
	}

	public void display() {
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Salary: " + salary);
	}

}
