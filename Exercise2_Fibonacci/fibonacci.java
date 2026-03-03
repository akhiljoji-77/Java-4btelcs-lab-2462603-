package practical;
import java.util.Scanner;
public class fibonacci {
		static void printFibonacci(int n) {
			if(n<=0) {
				System.out.println("Nothing to print");
				return;
			}
			long a=0,b=1;
			System.out.println("Fibonacci: ");
			for(int i=0;i<n;i++) {
				System.out.print(a + (i == n-1 ? "\n" : ", "));
				long next = a + b;
				a = b;
				b = next;
			}
		
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("2462603");
			System.out.print("How many fibonacci numbers? ");
			int n = sc.nextInt();
			printFibonacci(n);
			
			System.out.println("Enter an integer to test even/odd: ");
			int x=sc.nextInt();
			System.out.println(x + (x%2==0? " is even" : " is odd"));
			sc.close();
			
		}
}