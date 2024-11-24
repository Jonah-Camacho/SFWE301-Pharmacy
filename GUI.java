import java.util.Scanner;

public class GUI {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String usernameIn;
		
		System.out.println("Welcome to the Pharmacy Management System!");
		System.out.println("Please enter your username:");
		
		usernameIn = scnr.next();
		
		
		scnr.close();
	}
}
