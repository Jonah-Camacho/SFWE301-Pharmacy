import java.util.Scanner;

public class GUI {
	
	public static void printMenu (User.Role userRole) {
		System.out.print("Select an option (1-");
		
		if (userRole == User.Role.ITAdministrator) {
			System.out.println("1");
			System.out.println("1. Create Patient Account");
			System.out.println("2. Create Pharmacy Personnel Account");
			System.out.println("3. Create Pharmacy Manager Account");
		}
		if (userRole == User.Role.PharmacyManager) {
			System.out.println("1");
			System.out.println("1. Create Patient Account");
			System.out.println("2. Create Pharmacy Personnel Account");

		}
		if (userRole == User.Role.Pharmacist) {
			System.out.println("1");
			System.out.println("1. Create Patient Account");

		}
		if (userRole == User.Role.PharmacyTech) {
			System.out.println("1");
			System.out.println("1. Create Patient Account");

		}
		if (userRole == User.Role.Cashier) {
			System.out.println("1");

		}
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		UserDatabase myUserDatabase = new UserDatabase();
		String usernameIn;
		String passwordIn;
		boolean usernameFound = false;
		boolean correctPassword = false;
		int remainingAttempts = 4;
		User.Role currentRole;
		
		//long myPhoneNumber = 5204246286L;
		//PharmacyPersonnel MollyAuer = new PharmacyPersonnel("Molly Auer", 7, 11, 2004, User.Gender.Female, myPhoneNumber, "some address", User.Role.ITAdministrator, "mollyauer", "WildcatFurLife!44");
		//myUserDatabase.AddUser(MollyAuer);
		
		
		
		// Log-In System
		
		System.out.println("Welcome to the Pharmacy Management System!");
		System.out.println("Please enter your username:");
		
		// Search if username exists
		
		usernameIn = scnr.next();
		if (myUserDatabase.searchUsername(usernameIn)) {
			usernameFound = true;
		}
		
		while (!usernameFound) {
			System.out.println("Username not found. Please enter a new username:");
			usernameIn = scnr.next();
			if (myUserDatabase.searchUsername(usernameIn)) {
				usernameFound = true;
			}
		}
		
		// Check if account is locked
		
		if (myUserDatabase.searchAccountIsLocked(usernameIn)) {
			System.out.println("Account is locked. Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
			System.exit(0);
		}

		
		// Search if password is correct
		
		System.out.println("Please enter your password:");
		passwordIn = scnr.next();
		if (myUserDatabase.searchPassword(usernameIn, passwordIn)) {
			correctPassword = true;
			System.out.println("Success! You have been logged in.");
		}
		
		while (!correctPassword) {
			System.out.println("Incorrect Password. Please enter a new password:");
			System.out.println("Remaining attempts: " + remainingAttempts);
			passwordIn = scnr.next();
			if (myUserDatabase.searchPassword(usernameIn, passwordIn)) {
				correctPassword = true;
				System.out.println("Success! You have been logged in.");
			}
			--remainingAttempts;
			
			if (remainingAttempts == 0) {
				System.out.println("Incorrect Password. Remaining attempts: " + remainingAttempts);
				System.out.println("All attempts have been used. Account is now locked.");
				System.out.println("Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
				myUserDatabase.lockAccount(usernameIn);
				System.exit(0);
			}
		}
		
		
		// Logged-In
		
		currentRole = myUserDatabase.searchCurrentRole(usernameIn);
		
		printMenu(currentRole);
		
		scnr.close();
	}
}
