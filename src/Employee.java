import java.time.LocalDate;
import java.time.Period;

public class Employee {
    String employeeId;
    String firstName;
    String lastName;
    String department;
    String position;
    double salary;
    LocalDate hireDate;

    // Constructor chaining
    public Employee() {
        this("Unknown", "No", "Name", "None", "None", 0);
    }

    public Employee(String employeeId, String firstName, String lastName) {
        this(employeeId, firstName, lastName, "Unassigned", "Staff", 0);
    }

    public Employee(String employeeId, String firstName, String lastName, String department, String position, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = LocalDate.now();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void getEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("-----------------------------");
    }

    public int calculateYearsOfService() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }
}

