import java.util.Scanner;

public class AlphanumericCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to validate: ");
        String input = sc.nextLine();

        if (isAlphanumeric(input)) {
            System.out.println("✅ The string contains only alphanumeric characters.");
        } else {
            System.out.println("❌ The string contains special characters or spaces.");
        }

        sc.close();
    }

 
    public static boolean isAlphanumeric(String str) {
   
        return str.matches("^[a-zA-Z0-9]+$");
    }
}
