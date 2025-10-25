import java.io.*;
import java.util.*;
import java.util.regex.*;

// ========================== Custom Exceptions ==========================
class AttendanceLowException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7527728925664807719L;

	public AttendanceLowException(String msg) { super(msg); }
}

class WrongOperatorException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5964662139238646495L;

	public WrongOperatorException(String msg) { super(msg); }
}

// ========================== Math Utility Layer ==========================
class MathUtils {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (isPrime(i)) primes.add(i);
        return primes;
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    public static List<Integer> fibonacci(int n) {
        List<Integer> fib = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fib.add(a);
            int c = a + b;
            a = b;
            b = c;
        }
        return fib;
    }

    public static String evenOrOdd(int n) {
        return (n % 2 == 0) ? "Even" : "Odd";
    }

    public static int sumEven(int n) {
        return n * (n + 1);
    }

    public static int sumOdd(int n) {
        return n * n;
    }

    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    public static boolean isArmstrong(int n) {
        int temp = n, sum = 0, digits = String.valueOf(n).length();
        while (temp > 0) {
            int r = temp % 10;
            sum += Math.pow(r, digits);
            temp /= 10;
        }
        return sum == n;
    }

    public static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void printTable(int n) {
        for (int i = 1; i <= 10; i++)
            System.out.println(n + " x " + i + " = " + (n * i));
    }

    public static void printPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }
}

// ========================== Calculator ==========================
class Calculator {
    public static int calculate(int num1, int num2, String op) throws WrongOperatorException {
        switch (op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            case "%": return num1 % num2;
            default: throw new WrongOperatorException("Invalid operator: " + op);
        }
    }
}

// ========================== Employee Management ==========================
class Employee implements Serializable, Comparable<Employee> {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6733454473088742535L;
	String empName;
    int empID;
    String empRole;

    Employee() {}
    Employee(int id, String name) { this.empID = id; this.empName = name; this.empRole = "Developer"; }
    Employee(int id, String name, String role) { this.empID = id; this.empName = name; this.empRole = role; }

    public String toString() { return empID + " - " + empName + " (" + empRole + ")"; }
    public int compareTo(Employee e) { return this.empID - e.empID; }
}

// ========================== Student Management ==========================
class Student implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6122525287880383667L;
	int rollno;
    String sname;
    String course;
    double attendance_percentage;
    double score;

    Student() {}
    Student(int rollno, String sname, String course, double attendance, double score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance;
        this.score = score;
    }

    public String calculateGrade() throws AttendanceLowException {
        if (attendance_percentage < 60)
            throw new AttendanceLowException("Attendance below threshold for " + sname);
        if (score >= 85) return "A";
        else if (score >= 70) return "B";
        else if (score >= 50) return "C";
        else return "F";
    }

    public String toString() {
        return rollno + " - " + sname + " (" + course + ") | Attendance: " + attendance_percentage + "% | Score: " + score;
    }
}

// ========================== Coding Challenge Utilities ==========================
class ChallengeUtils {

    public static int longestStringLength(String[] arr) {
        int max = 0;
        for (String s : arr) if (s.length() > max) max = s.length();
        return max;
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int num : nums) actual += num;
        return expected - actual;
    }

    public static void rotateArray(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            result[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    public static boolean isAlphanumeric(String s) {
        return Pattern.matches("[A-Za-z0-9]+", s);
    }
}

// ========================== Main Interactive Console ==========================
public class DiwaliAssignmentMerge {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> empList = new ArrayList<>();
    static ArrayList<Student> stuList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n================= ALL-IN-ONE JAVA INTERACTIVE CONSOLE =================");
            System.out.println("1. Math Operations");
            System.out.println("2. Calculator");
            System.out.println("3. Employee Management");
            System.out.println("4. Student Management");
            System.out.println("5. Coding Challenges");
            System.out.println("6. Exit");
            System.out.print("Select your option: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> mathMenu();
                case 2 -> calculatorMenu();
                case 3 -> employeeMenu();
                case 4 -> studentMenu();
                case 5 -> challengeMenu();
                case 6 -> {
                    System.out.println("System shutting down gracefully... All modules terminated.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please realign and retry.");
            }
        }
    }

    // ========================== Menus ==========================
    static void mathMenu() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Prime: " + MathUtils.isPrime(n));
        System.out.println("Primes up to " + n + ": " + MathUtils.generatePrimes(n));
        System.out.println("Factorial: " + MathUtils.factorial(n));
        System.out.println("Fibonacci: " + MathUtils.fibonacci(n));
        System.out.println("Even/Odd: " + MathUtils.evenOrOdd(n));
        System.out.println("Sum of first " + n + " even numbers: " + MathUtils.sumEven(n));
        System.out.println("Sum of first " + n + " odd numbers: " + MathUtils.sumOdd(n));
        System.out.println("Palindrome: " + MathUtils.isPalindrome(n));
        System.out.println("Armstrong: " + MathUtils.isArmstrong(n));
        System.out.println("Reverse: " + MathUtils.reverseNumber(n));
        System.out.println("Enter two numbers for GCD/LCM:");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("GCD: " + MathUtils.gcd(a, b));
        System.out.println("LCM: " + MathUtils.lcm(a, b));
        System.out.print("Enter number for multiplication table: ");
        MathUtils.printTable(sc.nextInt());
        System.out.print("Enter rows for pattern: ");
        MathUtils.printPattern(sc.nextInt());
    }

    static void calculatorMenu() {
        try {
            System.out.print("Enter number1: "); int a = sc.nextInt();
            System.out.print("Enter number2: "); int b = sc.nextInt();
            System.out.print("Enter operator (+, -, *, /, %): "); String op = sc.next();
            System.out.println("Result: " + Calculator.calculate(a, b, op));
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    static void employeeMenu() {
        System.out.println("1. Add Employee\n2. Remove Employee\n3. Show All\n4. Show Sorted\n5. Find by Name\n6. Save to File\n7. Back");
        int ch = sc.nextInt(); sc.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Enter ID, Name, Role: ");
                empList.add(new Employee(sc.nextInt(), sc.next(), sc.next()));
            }
            case 2 -> {
                System.out.print("Enter ID to remove: ");
                int id = sc.nextInt();
                empList.removeIf(e -> e.empID == id);
            }
            case 3 -> empList.forEach(System.out::println);
            case 4 -> { Collections.sort(empList); empList.forEach(System.out::println); }
            case 5 -> {
                System.out.print("Enter name: ");
                String name = sc.next();
                empList.stream().filter(e -> e.empName.equalsIgnoreCase(name)).forEach(System.out::println);
            }
            case 6 -> {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
                    oos.writeObject(empList);
                    System.out.println("Employees saved successfully.");
                } catch (IOException e) { System.out.println("Error saving employees."); }
            }
            case 7 -> {}
        }
    }

    static void studentMenu() {
        System.out.println("1. Add Student\n2. Show All\n3. Show Sorted by Attendance\n4. Save to File\n5. Back");
        int ch = sc.nextInt(); sc.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Enter rollno, name, course, attendance, score: ");
                stuList.add(new Student(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble()));
            }
            case 2 -> stuList.forEach(System.out::println);
            case 3 -> {
                stuList.sort((s1, s2) -> Double.compare(s2.attendance_percentage, s1.attendance_percentage));
                stuList.forEach(System.out::println);
            }
            case 4 -> {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
                    oos.writeObject(stuList);
                    System.out.println("Students saved successfully.");
                } catch (IOException e) { System.out.println("Error saving students."); }
            }
            case 5 -> {}
        }
    }

    static void challengeMenu() {
        String[] arr = {"CDAC", "Java", "Enterprise", "Solutions"};
        System.out.println("Longest string length: " + ChallengeUtils.longestStringLength(arr));
        int[] nums = {0, 1, 3, 4};
        System.out.println("Missing number: " + ChallengeUtils.findMissingNumber(nums));
        int[] nums1 = {1, 2, 3}, nums2 = {4, 5, 6};
        System.out.println("Merged sorted array: " + Arrays.toString(ChallengeUtils.mergeSortedArrays(nums1, nums2)));
        int[] rotate = {1, 2, 3, 4, 5};
        ChallengeUtils.rotateArray(rotate, 2);
        System.out.println("Array after rotation: " + Arrays.toString(rotate));
        System.out.println("Alphanumeric check for 'A1B2C3': " + ChallengeUtils.isAlphanumeric("A1B2C3"));
    }
}
