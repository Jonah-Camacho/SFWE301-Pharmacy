import java.util.Scanner;

public class Menu {
	
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
		
		System.out.println(fullName + " has been added to the system");
		
		/*if (myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name already exists.");
			System.out.println("Please try another name or update the existing account.");
			return;
		}
		else {
			
		}*/
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
}
