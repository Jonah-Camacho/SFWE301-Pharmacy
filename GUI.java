import java.util.Scanner;

public class GUI {
	
	// Print Menu Function
	
	public static void printMenu (User.Role userRole) {
		System.out.print("Select an option (1-");
		
		if (userRole == User.Role.ITAdministrator) {
			System.out.println("23):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  Archive Patient Account");
			System.out.println("4.  Reactivate Patient Account");
			System.out.println("5.  Create Pharmacy Personnel Account");
			System.out.println("6.  Update Pharmacy Personnel Account");
			System.out.println("7.  Create Pharmacy Manager Account");
			System.out.println("8.  Update Pharmacy Manager Account");
			System.out.println("9.  Unlock Pharmacy Personnel Account");
			System.out.println("10. View Prescription History");
			System.out.println("11. Request Prescription");
			System.out.println("12. Fill Prescription");
			System.out.println("13. Update Prescription Status");
			System.out.println("14. Make Transaction");
			System.out.println("15. View Inventory");
			System.out.println("16. Remove Expired Inventory");
			System.out.println("17. Purchase Drug Shipment");
			System.out.println("18. View User Database");
			System.out.println("19. View Activity Log");
			System.out.println("20. Request Financial Reports");
			System.out.println("21. Request Inventory Reports");
			System.out.println("22. Update Pharmacy Information");
			System.out.println("23. Log Out");
			System.out.println();
		}
		if (userRole == User.Role.PharmacyManager) {
			System.out.println("19):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  Archive Patient Account");
			System.out.println("4.  Create Pharmacy Personnel Account");
			System.out.println("5.  Update Pharmacy Personnel Account");
			System.out.println("6.  Unlock Pharmacy Personnel Account");
			System.out.println("7.  View Prescription History");
			System.out.println("8.  Request Prescription");
			System.out.println("9.  Update Prescription Status");
			System.out.println("10. Make Transaction");
			System.out.println("11. View Inventory");
			System.out.println("12. Remove Expired Inventory");
			System.out.println("13. Purchase Drug Shipment");
			System.out.println("14. View User Database");
			System.out.println("15. View Activity Log");
			System.out.println("16. Request Financial Reports");
			System.out.println("17. Request Inventory Reports");
			System.out.println("18. Update Pharmacy Information");
			System.out.println("19. Log Out");
			System.out.println();
		}
		if (userRole == User.Role.Pharmacist) {
			System.out.println("8):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  View Prescription History");
			System.out.println("4.  Request Prescription");
			System.out.println("5.  Fill Prescription");
			System.out.println("6.  Update Prescription Status");
			System.out.println("7.  Make Transaction");
			System.out.println("8.  Log Out");
			System.out.println();
		}
		if (userRole == User.Role.PharmacyTech) {
			System.out.println("7):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  View Prescription History");
			System.out.println("4.  Request Prescription");
			System.out.println("5.  Update Prescription Status");
			System.out.println("6.  Make Transaction");
			System.out.println("7.  Log Out");
			System.out.println();
		}
		if (userRole == User.Role.Cashier) {
			System.out.println("3):");
			System.out.println("1.  Request Prescription");
			System.out.println("2.  Make Transaction");
			System.out.println("3.  Log Out");
			System.out.println();
		}
	}
	
	// Menu Selection
	
	public static void menuFunction(User.Role userRole, int selection, Scanner scnr, String username, UserDatabase myUserDatabase) {
		if (userRole == User.Role.ITAdministrator) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, username, myUserDatabase);
					break;
				case 2:
					updatePatientAccount();
					break;
				case 3:
					archivePatientAccount();
					break;
				case 4:
					reactivatePatientAccount();
					break;
				case 5:
					createPharmacyPersonnelAccount();
					break;
				case 6:
					updatePharmacyPersonnelAccount();
					break;
				case 7:
					createPharmacyManagerAccount();
					break;
				case 8:
					updatePharmacyManagerAccount();
					break;
				case 9:
					unlockPharmacyPersonnelAccount();
					break;
				case 10:
					viewPrescriptionHistory();
					break;
				case 11:
					requestPrescription();
					break;
				case 12:
					fillPrescription();
					break;
				case 13:
					updatePrescriptionStatus();
					break;
				case 14:
					makeTransaction();
					break;
				case 15:
					viewInventory();
					break;
				case 16:
					removeExpiredInventory();
					break;
				case 17:
					purchaseDrugShipment();
					break;
				case 18:
					viewUserDatabase();
					break;
				case 19:
					viewActivityLog();
					break;
				case 20:
					requestFinancialReport();
					break;
				case 21:
					requestInventoryReport();
					break;
				case 22:
					updatePharmacyInformation();
					break;
				case 23:
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
		if (userRole == User.Role.PharmacyManager) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, username, myUserDatabase);
					break;
				case 2:
					updatePatientAccount();
					break;
				case 3:
					archivePatientAccount();
					break;
				case 4:
					createPharmacyPersonnelAccount();
					break;
				case 5:
					updatePharmacyPersonnelAccount();
					break;
				case 6:
					unlockPharmacyPersonnelAccount();
					break;
				case 7:
					viewPrescriptionHistory();
					break;
				case 8:
					requestPrescription();
					break;
				case 9:
					updatePrescriptionStatus();
					break;
				case 10:
					makeTransaction();
					break;
				case 11:
					viewInventory();
					break;
				case 12:
					removeExpiredInventory();
					break;
				case 13:
					purchaseDrugShipment();
					break;
				case 14:
					viewUserDatabase();
					break;
				case 15:
					viewActivityLog();
					break;
				case 16:
					requestFinancialReport();
					break;
				case 17:
					requestInventoryReport();
					break;
				case 18:
					updatePharmacyInformation();
					break;
				case 19:
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
		if (userRole == User.Role.Pharmacist) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, username, myUserDatabase);
					break;
				case 2:
					updatePatientAccount();
					break;
				case 3:
					viewPrescriptionHistory();
					break;
				case 4:
					requestPrescription();
					break;
				case 5:
					fillPrescription();
					break;
				case 6:
					updatePrescriptionStatus();
					break;
				case 7:
					makeTransaction();
					break;
				case 8:
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
		if (userRole == User.Role.PharmacyTech) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, username, myUserDatabase);
					break;
				case 2:
					updatePatientAccount();
					break;
				case 3:
					viewPrescriptionHistory();
					break;
				case 4:
					requestPrescription();
					break;
				case 5:
					updatePrescriptionStatus();
					break;
				case 6:
					makeTransaction();
					break;
				case 7:
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
		if (userRole == User.Role.Cashier) {
			switch(selection) {
				case 1:
					requestPrescription();
					break;
				case 2:
					makeTransaction();
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
	}
	
	// Menu Functions
		
	public static void createPatientAccount(Scanner scnr, String username, UserDatabase myUserDatabase) {
		System.out.println("Please enter the full name of the patient:");
		String fullName = scnr.next();
		
		if (myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name already exists.");
			System.out.println("Please try another name or update the existing account.");
			return;
		}
		else {
			
		}
	}
	
	public static void updatePatientAccount() {
		
	}
	
	public static void archivePatientAccount() {
		
	}
	
	public static void reactivatePatientAccount() {
		
	}
	
	public static void createPharmacyPersonnelAccount() {
		
	}
	
	public static void updatePharmacyPersonnelAccount() {
		
	}
	
	public static void createPharmacyManagerAccount() {
		
	}
	
	public static void updatePharmacyManagerAccount() {
		
	}
	
	public static void unlockPharmacyPersonnelAccount() {
		
	}
	
	public static void viewPrescriptionHistory() {
		
	}
	
	public static void requestPrescription() {
		
	}
	
	public static void fillPrescription() {
		
	}
	
	public static void updatePrescriptionStatus() {
		
	}
	
	public static void makeTransaction() {
		
	}
	
	public static void viewInventory() {
		
	}
	
	public static void removeExpiredInventory() {
		
	}
	
	public static void purchaseDrugShipment() {
		
	}
	
	public static void viewUserDatabase() {
		
	}
	
	public static void viewActivityLog() {
		
	}
	
	public static void requestFinancialReport() {
		System.out.println("This function is not currently available.");
	}
	
	public static void requestInventoryReport() {
		System.out.println("This function is not currently available.");
	}
	
	public static void updatePharmacyInformation() {
		
	}
	
	// Main

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		UserDatabase myUserDatabase = new UserDatabase();
		PharmacyInfo myPharmacy = new PharmacyInfo();
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
			printMenu(currentRole);
			menuSelection = scnr.nextInt();
			menuFunction(currentRole, menuSelection, scnr, usernameIn, myUserDatabase);
		}
		
		System.out.println("You have been successfully logged out. Goodbye!");
		
		scnr.close();
	}
}
