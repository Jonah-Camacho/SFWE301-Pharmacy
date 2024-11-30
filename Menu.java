import java.util.Scanner;

public class Menu {
	
	// Print Menu Function

	public static void printMenu (User.Role userRole) {
		System.out.println();
		System.out.print("Select an option (1-");
		
		if (userRole == User.Role.ITAdministrator) {
			System.out.println("24):");
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
			System.out.println("18. View Prescription Database");
			System.out.println("19. View User Database");
			System.out.println("20. View Activity Log");
			System.out.println("21. Request Financial Reports");
			System.out.println("22. Request Inventory Reports");
			System.out.println("23. Update Pharmacy Information");
			System.out.println("24. Log Out");
			System.out.println();
		}
		if (userRole == User.Role.PharmacyManager) {
			System.out.println("21):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  Archive Patient Account");
			System.out.println("4.  Reactivate Patient Account");
			System.out.println("5.  Create Pharmacy Personnel Account");
			System.out.println("6.  Update Pharmacy Personnel Account");
			System.out.println("7.  Unlock Pharmacy Personnel Account");
			System.out.println("8.  View Prescription History");
			System.out.println("9.  Request Prescription");
			System.out.println("10. Update Prescription Status");
			System.out.println("11. Make Transaction");
			System.out.println("12. View Inventory");
			System.out.println("13. Remove Expired Inventory");
			System.out.println("14. Purchase Drug Shipment");
			System.out.println("15. View Prescription Database");
			System.out.println("16. View User Database");
			System.out.println("17. View Activity Log");
			System.out.println("18. Request Financial Reports");
			System.out.println("19. Request Inventory Reports");
			System.out.println("20. Update Pharmacy Information");
			System.out.println("21. Log Out");
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
	
	public static void menuFunction(User.Role userRole, int selection, Scanner scnr, String username, UserDatabase myUserDatabase, PharmacyInfo myPharmacy) {
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
					viewPrescriptionDatabase();
					break;
				case 19:
					viewUserDatabase();
					break;
				case 20:
					viewActivityLog();
					break;
				case 21:
					requestFinancialReport();
					break;
				case 22:
					requestInventoryReport();
					break;
				case 23:
					updatePharmacyInformation();
					break;
				case 24:
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
					reactivatePatientAccount();
					break;
				case 5:
					createPharmacyPersonnelAccount();
					break;
				case 6:
					updatePharmacyPersonnelAccount();
					break;
				case 7:
					unlockPharmacyPersonnelAccount();
					break;
				case 8:
					viewPrescriptionHistory();
					break;
				case 9:
					requestPrescription();
					break;
				case 10:
					updatePrescriptionStatus();
					break;
				case 11:
					makeTransaction();
					break;
				case 12:
					viewInventory();
					break;
				case 13:
					removeExpiredInventory();
					break;
				case 14:
					purchaseDrugShipment();
					break;
				case 15:
					viewPrescriptionDatabase();
					break;
				case 16:
					viewUserDatabase();
					break;
				case 17:
					viewActivityLog();
					break;
				case 18:
					requestFinancialReport();
					break;
				case 19:
					requestInventoryReport();
					break;
				case 20:
					updatePharmacyInformation();
					break;
				case 21:
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
		String fullName = scnr.nextLine();
				
		if (myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name already exists.");
			System.out.println("Please try another name or update the existing account.");
			return;
		}
		else {
			Patient newPatient = new Patient("", "", 0, User.Gender.Other, 0, "", "", 0);
			System.out.println("Please enter the date of birth of the patient in the form MM/DD/YYYY:");
			String dob = scnr.nextLine();
			
			System.out.println("Please enter the address of the patient:");
			String address = scnr.nextLine();
			
			System.out.println("Please indicate the gender of the patient (Male/Female/Other):");
			String gender = scnr.next();
			String newline = scnr.nextLine();
			while (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
				System.out.println("Invalid entry. Please enter Male, Female, or Other.");
				gender = scnr.next();
				newline = scnr.nextLine();
			}
			User.Gender patientGender = User.Gender.Other;
			if (gender.equals("Male")) {
				patientGender = User.Gender.Male;
			}
			if (gender.equals("Female")) {
				patientGender = User.Gender.Female;
			}
			if (gender.equals("Other")) {
				patientGender = User.Gender.Other;
			}
			
			System.out.println("Please enter the 10 digit phone number of the patient in the form ##########:");
			long phoneNumber = scnr.nextLong();
			newline = scnr.nextLine();
			while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
				System.out.println("Invalid entry. Please enter a 10 digit phone number:");
				phoneNumber = scnr.nextLong();
				newline = scnr.nextLine();
			}
			
			System.out.println("Please enter the full name of the patient's doctor:");
			String doctorsName = scnr.nextLine();
			
			System.out.println("Please enter the 10 digit phone number of the patients doctor in the form ##########:");
			long docPhoneNumber = scnr.nextLong();
			newline = scnr.nextLine();
			while (docPhoneNumber < 1000000000 || docPhoneNumber > 9999999999L) {
				System.out.println("Invalid entry. Please enter a 10 digit phone number:");
				docPhoneNumber = scnr.nextLong();
				newline = scnr.nextLine();
			}
			
			System.out.println("Is the patient insured? (yes or no)");
			String answer = scnr.next();
			newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no.");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			String insuranceProvider;
			long insurancePolicyNumber;
			if (answer.equals("yes")) {
				System.out.println("Please enter the name of the patient's insurance provider:");
				insuranceProvider = scnr.nextLine();
				
				System.out.println("Please enter the patient's insurance policy number in the form of a 8-13 digit number:");
				insurancePolicyNumber = scnr.nextLong();
				newline = scnr.nextLine();
				while (insurancePolicyNumber < 10000000 || insurancePolicyNumber > 9999999999999L) {
					System.out.println("Invalid entry. Please enter a 8-13 digit number:");
					insurancePolicyNumber = scnr.nextLong();
					newline = scnr.nextLine();
				}
				
				Patient patient = new Patient(fullName, dob, myUserDatabase.generateID(), patientGender, phoneNumber, address, doctorsName, docPhoneNumber, insuranceProvider, insurancePolicyNumber);
				newPatient = patient;
			}
			if (answer.equals("no")) {
				Patient patient = new Patient(fullName, dob, myUserDatabase.generateID(), patientGender, phoneNumber, address, doctorsName, docPhoneNumber);
				newPatient = patient;
			}
			
			System.out.println("Does the patient have any allergies? (yes or no)");
			answer = scnr.next();
			newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no.");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			String allergies;
			if (answer.equals("yes")) {
				System.out.println("Please list the patient's allergies in one line:");
				allergies = scnr.nextLine();
				newPatient.addAllergies(allergies);
			}
			
			System.out.println("Do you have any notes to write for the patient? (yes or no)");
			answer = scnr.next();
			newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no.");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			String notes;
			if (answer.equals("yes")) {
				System.out.println("Please list the patient's notes in one line:");
				notes = scnr.nextLine();
				newPatient.addNotes(notes);
			}
			
			myUserDatabase.AddUser(newPatient);
			System.out.println(fullName + " has successfully been added to the system!");
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
	
	public static void viewPrescriptionDatabase() {
		
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
}
