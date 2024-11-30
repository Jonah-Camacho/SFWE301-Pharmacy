import java.util.Scanner;

public class GUI {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		UserDatabase myUserDatabase = new UserDatabase();
		PharmacyInfo myPharmacy = new PharmacyInfo();
		Inventory myInventory = new Inventory();
		PrescriptionDatabase myPrescriptionDatabase = new PrescriptionDatabase();
		ActivityLog myActivityLog = new ActivityLog();
		String usernameIn;
		String passwordIn;
		boolean usernameFound = false;
		boolean correctPassword = false;
		int remainingAttempts = 4;
		String currentName;
		User.Role currentRole;
		int menuSelection = 0;
				
		// Log-In System
		
		System.out.println("Welcome to the Pharmacy Management System!");
		System.out.println("Please enter your username:");
		
		// Search if username exists
		
		usernameIn = scnr.next();
		String newline = scnr.nextLine();
		if (myUserDatabase.searchUsername(usernameIn)) {
			usernameFound = true;
		}
		
		while (!usernameFound) {
			System.out.println("Username not found. Please enter a new username:");
			usernameIn = scnr.next();
			newline = scnr.nextLine();
			if (myUserDatabase.searchUsername(usernameIn)) {
				usernameFound = true;
			}
		}
		
		// Check if account is locked
		
		if (myUserDatabase.searchAccountIsLocked(usernameIn)) {
			System.out.println("Account is locked. Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
			System.exit(0);
		}
		
		// Check if account is active
		
		if (!myUserDatabase.searchAccountIsActive(usernameIn)) {
			System.out.println("Account is archived. Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
			System.exit(0);
		}

		
		// Search if password is correct
		
		System.out.println("Please enter your password:");
		passwordIn = scnr.next();
		newline = scnr.nextLine();
		if (myUserDatabase.searchPassword(usernameIn, passwordIn)) {
			correctPassword = true;
			System.out.println("Success! You have been logged in.");
			System.out.println();
		}
		
		while (!correctPassword) {
			System.out.println("Incorrect Password. Please enter a new password:");
			System.out.println("Remaining attempts: " + remainingAttempts);
			passwordIn = scnr.next();
			newline = scnr.nextLine();
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
		
		currentName = myUserDatabase.searchCurrentName(usernameIn);
		currentRole = myUserDatabase.searchCurrentRole(usernameIn);
	
		while ((currentRole == User.Role.ITAdministrator && menuSelection != 24) || (currentRole == User.Role.PharmacyManager && menuSelection != 21) || (currentRole == User.Role.Pharmacist && menuSelection != 8) || (currentRole == User.Role.PharmacyTech && menuSelection != 7) || (currentRole == User.Role.Cashier && menuSelection != 3)) {
			Menu.printMenu(currentRole);
			menuSelection = scnr.nextInt();
			newline = scnr.nextLine();      // To absorb newline and avoid issues when working with menu functions
			Menu.menuFunction(currentRole, menuSelection, scnr, myUserDatabase, myPharmacy, myActivityLog, myPrescriptionDatabase, myInventory, currentName);
		}
		
		System.out.println("You have been successfully logged out. Goodbye!");
		
		scnr.close();
	}
}
