import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;
    
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

public class EmployeeSortDemo {
    public static void main(String[] args) {
        // Create list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Smith", 35, 75000.0));
        employees.add(new Employee("Alice Johnson", 28, 82000.0));
        employees.add(new Employee("Bob Williams", 42, 95000.0));
        employees.add(new Employee("Emma Davis", 31, 68000.0));
        employees.add(new Employee("Michael Brown", 38, 88000.0));
        
        System.out.println("Original Employee List:");
        employees.forEach(employee -> System.out.println(employee));
        
        // Sort by name using lambda expression
        System.out.println("\nSorted by Name:");
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(employee -> System.out.println(employee));
        
        // Sort by age using lambda expression
        System.out.println("\nSorted by Age:");
        Collections.sort(employees, (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(employee -> System.out.println(employee));
        
        // Sort by salary using lambda expression
        System.out.println("\nSorted by Salary:");
        Collections.sort(employees, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employees.forEach(employee -> System.out.println(employee));
        
        // Sort by salary in descending order (highest first)
        System.out.println("\nSorted by Salary (Highest First):");
        Collections.sort(employees, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        employees.forEach(employee -> System.out.println(employee));
    }
}
