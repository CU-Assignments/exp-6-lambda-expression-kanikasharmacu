import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;
    
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMarks() {
        return marks;
    }
    
    @Override
    public String toString() {
        return "Student [name=" + name + ", marks=" + marks + "]";
    }
}

public class StudentFilterDemo {
    public static void main(String[] args) {
        // Create list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 72.5));
        students.add(new Student("Alice", 88.0));
        students.add(new Student("Bob", 65.8));
        students.add(new Student("Emma", 92.3));
        students.add(new Student("Michael", 78.9));
        students.add(new Student("Sarah", 81.2));
        students.add(new Student("David", 69.7));
        students.add(new Student("Olivia", 95.6));
        
        System.out.println("All Students:");
        students.forEach(student -> System.out.println(student));
        
        // Using streams and lambda expressions to:
        // 1. Filter students scoring above 75%
        // 2. Sort them by marks in descending order
        // 3. Collect their names
        List<String> highScorers = students.stream()
                .filter(student -> student.getMarks() > 75.0)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        
        System.out.println("\nStudents scoring above 75% (sorted by marks, highest first):");
        highScorers.forEach(name -> System.out.println(name));
        
        // Alternative approach with more detailed output
        System.out.println("\nDetailed list of high scorers:");
        students.stream()
                .filter(student -> student.getMarks() > 75.0)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .forEach(student -> System.out.println(student.getName() + ": " + student.getMarks() + "%"));
    }
}
