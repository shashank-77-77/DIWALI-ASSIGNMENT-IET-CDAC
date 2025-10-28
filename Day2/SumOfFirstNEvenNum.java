//Sum of first n even numbers 
//Input: Integer n 
//Output: Sum of first n even numbers 

import java.util.Scanner;

public class Question1_Sum_Of_N_Even_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int sum=0;
		for(int i=2;i<=n;i++) {
			if(i%2==0) {
			sum=sum+i;
			
			}
		}
		sc.close();
		System.out.println("Sum of All even numbers till "+n+" is:"+sum);
	}

}