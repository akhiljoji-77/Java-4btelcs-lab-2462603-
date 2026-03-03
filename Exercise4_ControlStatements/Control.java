package practical;
import java.util.Scanner;
public class Control {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2462603");
		System.out.print("Enter an integer: ");
		int n = sc.nextInt();
		if(n < 0) {
			System.out.println("Negative");
		} else if (n == 0) {
			System.out.println("Zero");
		} else {
			System.out.println("Positive");
		}
		if(n%2==0) {
			System.out.println("It is even");
		} else {
			System.out.println("It is odd");
		}
		int day = n % 7 + 1;
		switch (day) {
		case 1 -> System.out.println("Monday");
		case 2 -> System.out.println("Tuesday");
		case 3 -> System.out.println("Wednesday");
		case 4 -> System.out.println("Thursday");
		case 5 -> System.out.println("Friday");
		case 6 -> System.out.println("Saturday");
		default -> System.out.println("Sunday");
			
		}
	}
}
