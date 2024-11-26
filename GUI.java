import java.util.Scanner;

public class GUI {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		UserDatabase myUserDatabase = new UserDatabase();
		PharmacyInfo myPharmacy = new PharmacyInfo();
		Menu myMenu = new Menu();
		String usernameIn;
		String passwordIn;
		boolean usernameFound = false;
		boolean correctPassword = false;
		int remainingAttempts = 4;
		User.Role currentRole;
		int menuSelection = 0;
		
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
			System.out.println();
		}
		
		while (!correctPassword) {
			System.out.println("Incorrect Password. Please enter a new password:");
			System.out.println("Remaining attempts: " + remainingAttempts);
			passwordIn = scnr.next();
			if (myUserDatabase.searchPassword(usernameIn, passwordIn)) {
				correctPassword = true;
				System.out.println("Success! You have been logged in.");
				System.out.println();
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
	
		while ((currentRole == User.Role.ITAdministrator && menuSelection != 23) || (currentRole == User.Role.PharmacyManager && menuSelection != 19) || (currentRole == User.Role.Pharmacist && menuSelection != 8) || (currentRole == User.Role.PharmacyTech && menuSelection != 7) || (currentRole == User.Role.Cashier && menuSelection != 3)) {
			myMenu.printMenu(currentRole);
			menuSelection = scnr.nextInt();
			myMenu.menuFunction(currentRole, menuSelection, scnr, usernameIn, myUserDatabase, myPharmacy);
		}
		
		System.out.println("You have been successfully logged out. Goodbye!");
		
		scnr.close();
	}
}
