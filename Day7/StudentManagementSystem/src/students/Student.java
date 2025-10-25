package students;

import java.io.Serializable;

public class Student implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rollno;
    private String sname;
    private String course;
    private double attendancePercentage;
    private double score;
    private char grade;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int rollno, String sname, String course, double attendancePercentage, double score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendancePercentage = attendancePercentage;
        this.score = score;
    }

    // Calculate grade
    public void calculateGrade() throws AttendanceException {
        if(attendancePercentage < 60) {
            throw new AttendanceException("Attendance below 60% for student: " + sname);
        }
        if(score >= 90) grade = 'A';
        else if(score >= 75) grade = 'B';
        else if(score >= 60) grade = 'C';
        else grade = 'D';
    }

    // Getters
    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    @Override
    public String toString() {
        return rollno + " " + sname + " " + course + " " + attendancePercentage + "% " + score + " " + grade;
    }
}
