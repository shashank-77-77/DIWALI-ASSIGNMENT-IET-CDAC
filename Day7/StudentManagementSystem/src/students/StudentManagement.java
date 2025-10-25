package students;

import java.io.*;
import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "shashank", "Java", 85, 92));
        students.add(new Student(2, "soham", "Python", 78, 88));
        students.add(new Student(3, "pratik", "JavaScript", 55, 70)); // Should throw exception
        students.add(new Student(4, "ritik", "Java", 90, 65));
        students.add(new Student(5, "harsh", "Python", 82, 72));
        students.add(new Student(6, "pranay", "C++", 95, 80));
        students.add(new Student(7, "dev", "Java", 88, 85));
        students.add(new Student(8, "ram", "Python", 60, 60));
        students.add(new Student(9, "shyam", "C++", 70, 55));
        students.add(new Student(10, "jonny", "JavaScript", 92, 98));

        // Calculate grades and handle low attendance
        for(Student s : students) {
            try {
                s.calculateGrade();
            } catch (AttendanceException e) {
                System.out.println(e.getMessage());
            }
        }

        // Serialize students to file
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            System.out.println("Students have been serialized to students.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Store students in decreasing order of attendance
        TreeSet<Student> sortedStudents = new TreeSet<>(Comparator.comparingDouble(Student::getAttendancePercentage).reversed());
        sortedStudents.addAll(students);

        System.out.println("\nStudents sorted by attendance (high to low):");
        for(Student s : sortedStudents) {
            System.out.println(s);
        }
    }
}
