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
			System.out.println("3.  Archive Account");
			System.out.println("4.  Reactivate Account");
			System.out.println("5.  Create Pharmacy Personnel Account");
			System.out.println("6.  Update Pharmacy Personnel Account");
			System.out.println("7.  Create Pharmacy Manager Account");
			System.out.println("8.  Create IT Administrator Account");
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
			System.out.println("3.  Archive Account");
			System.out.println("4.  Reactivate Account");
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
	
	public static void menuFunction(User.Role currentRole, int selection, Scanner scnr, UserDatabase myUserDatabase, PharmacyInfo myPharmacy, ActivityLog myActivityLog, PrescriptionDatabase myPrescriptionDatabase, Inventory myInventory, String currentName) {
		if (currentRole == User.Role.ITAdministrator) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 2:
					updatePatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 3:
					archiveAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 4:
					reactivateAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 5:
					createPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 6:
					updatePharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 7:
					createPharmacyManagerAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 8:
					createITAdministratorAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 9:
					unlockPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
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
		if (currentRole == User.Role.PharmacyManager) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 2:
					updatePatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 3:
					archiveAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 4:
					reactivateAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 5:
					createPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 6:
					updatePharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 7:
					unlockPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
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
		if (currentRole == User.Role.Pharmacist) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 2:
					updatePatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
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
		if (currentRole == User.Role.PharmacyTech) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 2:
					updatePatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
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
		if (currentRole == User.Role.Cashier) {
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
		
	public static void createPatientAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
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
			myActivityLog.AddActivity(ActivityLog.Activity.AccountCreation, currentName, currentRole, myUserDatabase.readLastID(), User.Role.Patient, ActivityLog.AccountUpdateField.None, "", "", myUserDatabase.readLastID(), 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
			
			System.out.println(fullName + " has successfully been added to the system!");
		}
	}
	
	public static void updatePatientAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name associated with the account you would like to update:");
		String fullName = scnr.nextLine();
		
		if (!myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name does not exist.");
			return;
		}
		else {
			if (myUserDatabase.returnRole(fullName) != User.Role.Patient) {
				System.out.println("The account associated with this name is a " + myUserDatabase.returnRole(fullName) + " Account, not a Patient Account");
				System.out.println("Please use an alternate function to update this account.");
				return;
			}
			else {
				System.out.println("Please indicate which field you would like to update (1-11):");
				System.out.println("1.  Name");
				System.out.println("2.  Date of Birth");
				System.out.println("3.  Gender");
				System.out.println("4.  Phone Number");
				System.out.println("5.  Address");
				System.out.println("6.  Doctor's Name");
				System.out.println("7.  Doctor's Phone Number");
				System.out.println("8.  Insurance Provider");
				System.out.println("9.  Insurance Policy Number");
				System.out.println("10. Allergies");
				System.out.println("11. Notes");
				
				int answer = scnr.nextInt();
				
				while (answer < 1 || answer > 11) {
					System.out.println("Please enter an integer between 1 and 11:");
					answer = scnr.nextInt();
				}
				
				if (answer == 1) {
					System.out.println("Please enter the updated name of the patient:");
					String name = scnr.nextLine();
					myUserDatabase.updateNameFN(fullName, name);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.Name, fullName, name, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 2) {
					System.out.println("Please enter the updated date of birth of the patient:");
					String dob = scnr.nextLine();
					String ogDob = myUserDatabase.returnDoBFN(fullName);
					myUserDatabase.updateDateOfBirthFN(fullName, dob);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.DateOfBirth, ogDob, dob, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");

				}
				if (answer == 3) {
					System.out.println("Please enter the updated gender of the patient (Male/Female/Other):");
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
					User.Gender ogGender = myUserDatabase.returnGenderFN(fullName);
					myUserDatabase.updateGenderFN(fullName, patientGender);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.Gender, ogGender.toString(), patientGender.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 4) {
					System.out.println("Please enter the updated 10 digit phone number of the patient in the form ##########:");
					long phoneNumber = scnr.nextLong();
					String newline = scnr.nextLine();
					while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
						System.out.println("Invalid entry. Please enter a 10 digit phone number:");
						phoneNumber = scnr.nextLong();
						newline = scnr.nextLine();
					}
					long ogPhoneNumber = myUserDatabase.returnPhoneNumberFN(fullName);
					myUserDatabase.updatePhoneNumberFN(fullName, phoneNumber);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.PhoneNumber, Long.toString(ogPhoneNumber), Long.toString(phoneNumber), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 5) {
					System.out.println("Please enter the updated address of the patient:");
					String address = scnr.nextLine();
					String ogAddress = myUserDatabase.returnAddressFN(fullName);
					myUserDatabase.updateAddressFN(fullName, address);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.Address, ogAddress, address, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 6) {
					System.out.println("Please enter the updated full name of the patient's doctor:");
					String doctorsName = scnr.nextLine();
					String ogDoctorsName = myUserDatabase.returnDoctorsName(fullName);
					myUserDatabase.updateDoctorsName(fullName, doctorsName);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.DoctorsName, ogDoctorsName, doctorsName, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 7) {
					System.out.println("Please enter the updated 10 digit phone number of the patient's doctor in the form ##########:");
					long docsPhoneNumber = scnr.nextLong();
					long ogDoctorsPhoneNumber = myUserDatabase.returnDoctorsPhoneNumber(fullName);
					String newline = scnr.nextLine();
					while (docsPhoneNumber < 1000000000 || docsPhoneNumber > 9999999999L) {
						System.out.println("Invalid entry. Please enter a 10 digit phone number:");
						docsPhoneNumber = scnr.nextLong();
						newline = scnr.nextLine();
					}
					myUserDatabase.updateDoctorsPhoneNumber(fullName, docsPhoneNumber);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.DoctorsPhoneNumber, Long.toString(ogDoctorsPhoneNumber), Long.toString(docsPhoneNumber), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 8) {
					System.out.println("Please enter the updated name of the patient's insurance provider:");
					String insuranceProvider = scnr.nextLine();
					String ogInsuranceProvider = myUserDatabase.returnInsurnaceProvider(fullName);
					myUserDatabase.updateInsurnaceProvider(fullName, insuranceProvider);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.InsuranceProvider, ogInsuranceProvider, insuranceProvider, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 9) {
					System.out.println("Please enter the patient's updated insurance policy number in the form of a 8-13 digit number:");
					long insurancePolicyNumber = scnr.nextLong();
					long ogPolicyNumber = myUserDatabase.returnInsurnacePolicyNumber(fullName);
					String newline = scnr.nextLine();
					while (insurancePolicyNumber < 10000000 || insurancePolicyNumber > 9999999999999L) {
						System.out.println("Invalid entry. Please enter a 8-13 digit number:");
						insurancePolicyNumber = scnr.nextLong();
						newline = scnr.nextLine();
					}
					myUserDatabase.updateInsurnacePolicyNumber(fullName, insurancePolicyNumber);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.InsurancePolicyNumber, Long.toString(ogPolicyNumber), Long.toString(insurancePolicyNumber), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 10) {
					System.out.println("Please list the patient's updated allergies in one line:");
					String allergies = scnr.nextLine();
					String ogAllergies = myUserDatabase.returnAllergies(fullName);
					myUserDatabase.updateAllergies(fullName, allergies);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.Allergies, ogAllergies, allergies, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
				if (answer == 11) {
					System.out.println("Please list the patient's updated notes in one line:");
					String notes = scnr.nextLine();
					String ogNotes = myUserDatabase.returnNotes(fullName);
					myUserDatabase.updateNotes(fullName, notes);
					myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.Notes, ogNotes, notes, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("The account has been updated.");
				}
			}
		}
	}
	
	public static void archiveAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name associated with the account you would like to archive:");
		String fullName = scnr.nextLine();
		
		if (!myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("There is no account associated with this name.");
			return;
		}
		else {
			System.out.println(fullName + "'s account has been found.");
			if (!myUserDatabase.checkIfAccountIsActive(fullName)) {
				System.out.println("This account is already archived.");
				return;
			}
			else {
				System.out.println("Are you sure you would like to archive this account? (yes or no)");
				String answer = scnr.next();
				String newline = scnr.nextLine();
				while (!(answer.equals("yes") || answer.equals("no"))) {
					System.out.println("Invalid entry. Please enter yes or no.");
					answer = scnr.next();
					newline = scnr.nextLine();
				}
				if (answer.equals("yes")) {
					myUserDatabase.archiveAccount(fullName);
					myActivityLog.AddActivity(ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.ActiveStatus, "Active", "Archived", 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println(fullName + "'s account has been archived.");
				}
				if (answer.equals("no")) {
					System.out.println(fullName + "'s account has not been archived.");
				}
			}
		}
	}
	
	public static void reactivateAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name associated with the account you would like to reactivate:");
		String fullName = scnr.nextLine();
		
		if (!myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("There is no account associated with this name.");
			return;
		}
		else {
			System.out.println(fullName + "'s account has been found.");
			if (myUserDatabase.checkIfAccountIsActive(fullName)) {
				System.out.println("This account is already active.");
				return;
			}
			else {
				System.out.println("Are you sure you would like to reactivate this account? (yes or no)");
				String answer = scnr.next();
				String newline = scnr.nextLine();
				while (!(answer.equals("yes") || answer.equals("no"))) {
					System.out.println("Invalid entry. Please enter yes or no.");
					answer = scnr.next();
					newline = scnr.nextLine();
				}
				if (answer.equals("yes")) {
					myUserDatabase.reactivateAccount(fullName);
					myActivityLog.AddActivity(ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.returnID(fullName), myUserDatabase.returnRole(fullName), ActivityLog.AccountUpdateField.ActiveStatus, "Archived", "Active", 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println(fullName + "'s account has been reactivated.");
				}
				if (answer.equals("no")) {
					System.out.println(fullName + "'s account has not been reactivated.");
				}
			}
		}
	}
	
	public static void createPharmacyPersonnelAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name of the pharmacy employee:");
		String fullName = scnr.nextLine();
				
		if (myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name already exists.");
			System.out.println("Please try another name or update the existing account.");
			return;
		}
		else {
			System.out.println("Please enter the date of birth of the employee in the form MM/DD/YYYY:");
			String dob = scnr.nextLine();
			
			System.out.println("Please enter the address of the employee:");
			String address = scnr.nextLine();
			
			System.out.println("Please indicate the gender of the employee (Male/Female/Other):");
			String gender = scnr.next();
			String newline = scnr.nextLine();
			while (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
				System.out.println("Invalid entry. Please enter Male, Female, or Other.");
				gender = scnr.next();
				newline = scnr.nextLine();
			}
			User.Gender employeeGender = User.Gender.Other;
			if (gender.equals("Male")) {
				employeeGender = User.Gender.Male;
			}
			if (gender.equals("Female")) {
				employeeGender = User.Gender.Female;
			}
			if (gender.equals("Other")) {
				employeeGender = User.Gender.Other;
			}
			
			System.out.println("Please enter the 10 digit phone number of the employee in the form ##########:");
			long phoneNumber = scnr.nextLong();
			newline = scnr.nextLine();
			while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
				System.out.println("Invalid entry. Please enter a 10 digit phone number:");
				phoneNumber = scnr.nextLong();
				newline = scnr.nextLine();
			}
			
			System.out.println("Please enter the role of the employee (Pharmacist, PharmacyTech, or Cashier):");
			String role = scnr.next();
			newline = scnr.nextLine();
			while (!(role.equals("Pharmacist") || role.equals("PharmacyTech") || role.equals("Cashier"))) {
				System.out.println("Invalid entry. Please enter Pharmacist, PharmacyTech, or Cashier.");
				role = scnr.next();
				newline = scnr.nextLine();
			}
			User.Role employeeRole = User.Role.Cashier;
			if (role.equals("Pharmacist")) {
				employeeRole = User.Role.Pharmacist;
			}
			if (role.equals("PharmacyTech")) {
				employeeRole = User.Role.PharmacyTech;
			}
			if (role.equals("Cashier")) {
				employeeRole = User.Role.Cashier;
			}
			
			System.out.println("Please enter the username for the employee's account:");
			String username = scnr.next();
			newline = scnr.nextLine();
			
			while (myUserDatabase.searchUsername(username)) {
				System.out.println("An account associated with that username already exists.");
				System.out.println("Please enter a new username:");
				username = scnr.next();
				newline = scnr.nextLine();
			}
			
			String password = "a";
			String validatedPassword = "b";
			int run = 0;
			while (!validatedPassword.equals(password)) {
				if (run != 0) {
					System.out.println("Error: Initial password does not match.");
				}
				System.out.println("Please enter the password for the employee's account:");
				password = scnr.next();
				newline = scnr.nextLine();
				System.out.println("Please re-eneter the password:");
				validatedPassword = scnr.next();
				newline = scnr.nextLine();
				++run;
			}
			
			PharmacyPersonnel newPharmacyEmployee = new PharmacyPersonnel(fullName, dob, myUserDatabase.generateID(), employeeGender, phoneNumber, address, employeeRole, username, password);
			myUserDatabase.AddUser(newPharmacyEmployee);
			myActivityLog.AddActivity (ActivityLog.Activity.AccountCreation, currentName, currentRole, myUserDatabase.readLastID(), employeeRole, ActivityLog.AccountUpdateField.None, "", "", 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
			
			System.out.println(fullName + " has successfully been added to the system under the username " + username + "!");
		}
	}
	
	public static void updatePharmacyPersonnelAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the username associated with the account you would like to update:");
		String username = scnr.nextLine();
		
		if (!myUserDatabase.searchUsername(username)) {
			System.out.println("An account associated with this username does not exist.");
			return;
		}
		else {
			if (currentRole == User.Role.PharmacyManager) {
				if (myUserDatabase.searchCurrentRole(username) != User.Role.Pharmacist || myUserDatabase.searchCurrentRole(username) != User.Role.PharmacyTech || myUserDatabase.searchCurrentRole(username) != User.Role.Cashier) {
					System.out.println("The account associated with this name is a " + myUserDatabase.searchCurrentRole(username) + " Account, not a Pharmacist, PharmacyTech, or Cashier Account");
					System.out.println("Please use an alternate function to update this account.");
					return;
				}
				else {
					System.out.println("Please indicate which field you would like to update (1-8):");
					System.out.println("1. Name");
					System.out.println("2. Date of Birth");
					System.out.println("3. Gender");
					System.out.println("4. Phone Number");
					System.out.println("5. Address");
					System.out.println("6. Role");
					System.out.println("7. Username");
					System.out.println("8. Password");
					
					int answer = scnr.nextInt();
					
					while (answer < 1 || answer > 8) {
						System.out.println("Please enter an integer between 1 and 8:");
						answer = scnr.nextInt();
					}
					
					if (answer == 1) {
						System.out.println("Please enter the updated name of the employee:");
						String name = scnr.nextLine();
						String ogName = myUserDatabase.returnName(username);
						myUserDatabase.updateNameU(username, name);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Name, ogName, name, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 2) {
						System.out.println("Please enter the updated date of birth of the employee:");
						String dob = scnr.nextLine();
						String ogDob = myUserDatabase.returnDoBU(username);
						myUserDatabase.updateDateOfBirthU(username, dob);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.DateOfBirth, ogDob, dob, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 3) {
						System.out.println("Please enter the updated gender of the employee (Male/Female/Other):");
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
						User.Gender ogGender = myUserDatabase.returnGenderU(username);
						myUserDatabase.updateGenderU(username, patientGender);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Gender, ogGender.toString(), patientGender.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 4) {
						System.out.println("Please enter the updated 10 digit phone number of the employee in the form ##########:");
						long phoneNumber = scnr.nextLong();
						String newline = scnr.nextLine();
						while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
							System.out.println("Invalid entry. Please enter a 10 digit phone number:");
							phoneNumber = scnr.nextLong();
							newline = scnr.nextLine();
						}
						long ogPhoneNumber = myUserDatabase.returnPhoneNumberU(username);
						myUserDatabase.updatePhoneNumberU(username, phoneNumber);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.PhoneNumber, Long.toString(ogPhoneNumber), Long.toString(phoneNumber), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 5) {
						System.out.println("Please enter the updated address of the employee:");
						String address = scnr.nextLine();
						String ogAddress = myUserDatabase.returnAddressU(username);
						myUserDatabase.updateAddressU(username, address);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Address, ogAddress, address, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 6) {
						System.out.println("Please enter the updated role of the employee (Pharmacist, PharmacyTech, or Cashier):");
						String role = scnr.next();
						String newline = scnr.nextLine();
						while (!(role.equals("Pharmacist") || role.equals("PharmacyTech") || role.equals("Cashier"))) {
							System.out.println("Invalid entry. Please enter Pharmacist, PharmacyTech, or Cashier:");
							role = scnr.next();
							newline = scnr.nextLine();
						}
						User.Role employeeRole = User.Role.Cashier;
						if (role.equals("Pharmacist")) {
							employeeRole = User.Role.Pharmacist;
						}
						if (role.equals("PharmacyTech")) {
							employeeRole = User.Role.PharmacyTech;
						}
						if (role.equals("Cashier")) {
							employeeRole = User.Role.Cashier;
						}
						User.Role ogRole = myUserDatabase.searchCurrentRole(username);
						myUserDatabase.updateRole(username, employeeRole);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Role, ogRole.toString(), employeeRole.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 7) {
						System.out.println("Please enter the updated username for the employee:");
						String newUsername = scnr.next();
						String newline = scnr.nextLine();
						while (myUserDatabase.searchUsername(newUsername)) {
							System.out.println("This username is already taken. Please enter a new updated username:");
							newUsername = scnr.next();
							newline = scnr.nextLine();
						}
						myUserDatabase.updateUsername(username, newUsername);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Username, username, newUsername, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 8) {
						String password = "a";
						String validatedPassword = "b";
						int run = 0;
						while (!validatedPassword.equals(password)) {
							if (run != 0) {
								System.out.println("Error: Initial password does not match.");
							}
							System.out.println("Please enter the updated password for the employee's account:");
							password = scnr.next();
							String newline = scnr.nextLine();
							System.out.println("Please re-eneter the password:");
							validatedPassword = scnr.next();
							newline = scnr.nextLine();
							++run;
						}
						String ogPassword = myUserDatabase.returnPassword(username);
						myUserDatabase.updatePassword(username, validatedPassword);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Password, ogPassword, validatedPassword, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
				}
			}
			if (currentRole == User.Role.ITAdministrator) {
				if (myUserDatabase.searchCurrentRole(username) == User.Role.Patient) {
					System.out.println("The account associated with this name is a " + myUserDatabase.searchCurrentRole(username) + " Account, not a Pharmacy Personnel Account");
					System.out.println("Please use an alternate function to update this account.");
					return;
				}
				else {
					System.out.println("Please indicate which field you would like to update (1-8):");
					System.out.println("1. Name");
					System.out.println("2. Date of Birth");
					System.out.println("3. Gender");
					System.out.println("4. Phone Number");
					System.out.println("5. Address");
					System.out.println("6. Role");
					System.out.println("7. Username");
					System.out.println("8. Password");
					
					int answer = scnr.nextInt();
					
					while (answer < 1 || answer > 8) {
						System.out.println("Please enter an integer between 1 and 8:");
						answer = scnr.nextInt();
					}
					
					if (answer == 1) {
						System.out.println("Please enter the updated name of the employee:");
						String name = scnr.nextLine();
						String ogName = myUserDatabase.returnName(username);
						myUserDatabase.updateNameU(username, name);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Name, ogName, name, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 2) {
						System.out.println("Please enter the updated date of birth of the employee:");
						String dob = scnr.nextLine();
						String ogDob = myUserDatabase.returnDoBU(username);
						myUserDatabase.updateDateOfBirthU(username, dob);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.DateOfBirth, ogDob, dob, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 3) {
						System.out.println("Please enter the updated gender of the employee (Male/Female/Other):");
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
						User.Gender ogGender = myUserDatabase.returnGenderU(username);
						myUserDatabase.updateGenderU(username, patientGender);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Gender, ogGender.toString(), patientGender.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 4) {
						System.out.println("Please enter the updated 10 digit phone number of the employee in the form ##########:");
						long phoneNumber = scnr.nextLong();
						String newline = scnr.nextLine();
						while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
							System.out.println("Invalid entry. Please enter a 10 digit phone number:");
							phoneNumber = scnr.nextLong();
							newline = scnr.nextLine();
						}
						long ogPhoneNumber = myUserDatabase.returnPhoneNumberU(username);
						myUserDatabase.updatePhoneNumberU(username, phoneNumber);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.PhoneNumber, Long.toString(ogPhoneNumber), Long.toString(phoneNumber), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 5) {
						System.out.println("Please enter the updated address of the employee:");
						String address = scnr.nextLine();
						String ogAddress = myUserDatabase.returnAddressU(username);
						myUserDatabase.updateAddressU(username, address);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Address, ogAddress, address, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 6) {
						System.out.println("Please enter the updated role of the employee (ITAdministrator, PharmacyManager, Pharmacist, PharmacyTech, or Cashier):");
						String role = scnr.next();
						String newline = scnr.nextLine();
						while (!(role.equals("ITAdministrator") || role.equals("PharmacyManager") || role.equals("Pharmacist") || role.equals("PharmacyTech") || role.equals("Cashier"))) {
							System.out.println("Invalid entry. Please enter ITAdministrator, PharmacyManager, Pharmacist, PharmacyTech, or Cashier.");
							role = scnr.next();
							newline = scnr.nextLine();
						}
						User.Role employeeRole = User.Role.Cashier;
						if (role.equals("ITAdministrator")) {
							employeeRole = User.Role.ITAdministrator;
						}
						if (role.equals("PharmacyManager")) {
							employeeRole = User.Role.PharmacyManager;
						}
						if (role.equals("Pharmacist")) {
							employeeRole = User.Role.Pharmacist;
						}
						if (role.equals("PharmacyTech")) {
							employeeRole = User.Role.PharmacyTech;
						}
						if (role.equals("Cashier")) {
							employeeRole = User.Role.Cashier;
						}
						User.Role ogRole = myUserDatabase.searchCurrentRole(username);
						myUserDatabase.updateRole(username, employeeRole);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Role, ogRole.toString(), employeeRole.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 7) {
						System.out.println("Please enter the updated username for the employee:");
						String newUsername = scnr.next();
						String newline = scnr.nextLine();
						while (myUserDatabase.searchUsername(newUsername)) {
							System.out.println("This username is already taken. Please enter a new updated username:");
							newUsername = scnr.next();
							newline = scnr.nextLine();
						}
						myUserDatabase.updateUsername(username, newUsername);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Username, username, newUsername, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
					if (answer == 8) {
						String password = "a";
						String validatedPassword = "b";
						int run = 0;
						while (!validatedPassword.equals(password)) {
							if (run != 0) {
								System.out.println("Error: Initial password does not match.");
							}
							System.out.println("Please enter the updated password for the employee's account:");
							password = scnr.next();
							String newline = scnr.nextLine();
							System.out.println("Please re-eneter the password:");
							validatedPassword = scnr.next();
							newline = scnr.nextLine();
							++run;
						}
						String ogPassword = myUserDatabase.returnPassword(username);
						myUserDatabase.updatePassword(username, validatedPassword);
						myActivityLog.AddActivity (ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.Password, ogPassword, validatedPassword, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
						System.out.println("The account has been updated.");
					}
				}
			}
		}
	}
	
	public static void createPharmacyManagerAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name of the pharmacy manager:");
		String fullName = scnr.nextLine();
				
		if (myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name already exists.");
			System.out.println("Please try another name or update the existing account.");
			return;
		}
		else {
			System.out.println("Please enter the date of birth of the pharmacy manager in the form MM/DD/YYYY:");
			String dob = scnr.nextLine();
			
			System.out.println("Please enter the address of the pharmacy manager:");
			String address = scnr.nextLine();
			
			System.out.println("Please indicate the gender of the pharmacy manager (Male/Female/Other):");
			String gender = scnr.next();
			String newline = scnr.nextLine();
			while (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
				System.out.println("Invalid entry. Please enter Male, Female, or Other.");
				gender = scnr.next();
				newline = scnr.nextLine();
			}
			User.Gender employeeGender = User.Gender.Other;
			if (gender.equals("Male")) {
				employeeGender = User.Gender.Male;
			}
			if (gender.equals("Female")) {
				employeeGender = User.Gender.Female;
			}
			if (gender.equals("Other")) {
				employeeGender = User.Gender.Other;
			}
			
			System.out.println("Please enter the 10 digit phone number of the pharmacy manager in the form ##########:");
			long phoneNumber = scnr.nextLong();
			newline = scnr.nextLine();
			while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
				System.out.println("Invalid entry. Please enter a 10 digit phone number:");
				phoneNumber = scnr.nextLong();
				newline = scnr.nextLine();
			}
			
			System.out.println("Please enter the username for the pharmacy manager's account:");
			String username = scnr.next();
			newline = scnr.nextLine();
			
			while (myUserDatabase.searchUsername(username)) {
				System.out.println("An account associated with that username already exists.");
				System.out.println("Please enter a new username:");
				username = scnr.next();
				newline = scnr.nextLine();
			}
			
			String password = "a";
			String validatedPassword = "b";
			int run = 0;
			while (!validatedPassword.equals(password)) {
				if (run != 0) {
					System.out.println("Error: Initial password does not match.");
				}
				System.out.println("Please enter the password for the pharmacy manager's account:");
				password = scnr.next();
				newline = scnr.nextLine();
				System.out.println("Please re-eneter the password:");
				validatedPassword = scnr.next();
				newline = scnr.nextLine();
				++run;
			}
			
			PharmacyPersonnel newPharmacyEmployee = new PharmacyPersonnel(fullName, dob, myUserDatabase.generateID(), employeeGender, phoneNumber, address, User.Role.PharmacyManager, username, password);
			myUserDatabase.AddUser(newPharmacyEmployee);
			myActivityLog.AddActivity (ActivityLog.Activity.AccountCreation, currentName, currentRole, myUserDatabase.readLastID(), User.Role.PharmacyManager, ActivityLog.AccountUpdateField.None, "", "", 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
			
			System.out.println(fullName + " has successfully been added to the system under the username " + username + "!");
		}
	}
	
	public static void createITAdministratorAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name of the IT Administrator:");
		String fullName = scnr.nextLine();
				
		if (myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name already exists.");
			System.out.println("Please try another name or update the existing account.");
			return;
		}
		else {
			System.out.println("Please enter the date of birth of the IT Administrator in the form MM/DD/YYYY:");
			String dob = scnr.nextLine();
			
			System.out.println("Please enter the address of the IT Administrator:");
			String address = scnr.nextLine();
			
			System.out.println("Please indicate the gender of the IT Administrator (Male/Female/Other):");
			String gender = scnr.next();
			String newline = scnr.nextLine();
			while (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
				System.out.println("Invalid entry. Please enter Male, Female, or Other.");
				gender = scnr.next();
				newline = scnr.nextLine();
			}
			User.Gender employeeGender = User.Gender.Other;
			if (gender.equals("Male")) {
				employeeGender = User.Gender.Male;
			}
			if (gender.equals("Female")) {
				employeeGender = User.Gender.Female;
			}
			if (gender.equals("Other")) {
				employeeGender = User.Gender.Other;
			}
			
			System.out.println("Please enter the 10 digit phone number of the IT Administrator in the form ##########:");
			long phoneNumber = scnr.nextLong();
			newline = scnr.nextLine();
			while (phoneNumber < 1000000000 || phoneNumber > 9999999999L) {
				System.out.println("Invalid entry. Please enter a 10 digit phone number:");
				phoneNumber = scnr.nextLong();
				newline = scnr.nextLine();
			}
			
			System.out.println("Please enter the username for the IT Administrator's account:");
			String username = scnr.next();
			newline = scnr.nextLine();
			
			while (myUserDatabase.searchUsername(username)) {
				System.out.println("An account associated with that username already exists.");
				System.out.println("Please enter a new username:");
				username = scnr.next();
				newline = scnr.nextLine();
			}
			
			String password = "a";
			String validatedPassword = "b";
			int run = 0;
			while (!validatedPassword.equals(password)) {
				if (run != 0) {
					System.out.println("Error: Initial password does not match.");
				}
				System.out.println("Please enter the password for the IT Administrator's account:");
				password = scnr.next();
				newline = scnr.nextLine();
				System.out.println("Please re-eneter the password:");
				validatedPassword = scnr.next();
				newline = scnr.nextLine();
				++run;
			}
			
			PharmacyPersonnel newPharmacyEmployee = new PharmacyPersonnel(fullName, dob, myUserDatabase.generateID(), employeeGender, phoneNumber, address, User.Role.ITAdministrator, username, password);
			myUserDatabase.AddUser(newPharmacyEmployee);
			myActivityLog.AddActivity (ActivityLog.Activity.AccountCreation, currentName, currentRole, myUserDatabase.readLastID(), User.Role.ITAdministrator, ActivityLog.AccountUpdateField.None, "", "", 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
			
			System.out.println(fullName + " has successfully been added to the system under the username " + username + "!");
		}
	}
	
	
	public static void unlockPharmacyPersonnelAccount(Scanner scnr, UserDatabase myUserDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the username associated with the account you would like to unlock:");
		String username = scnr.nextLine();
		
		if (!myUserDatabase.searchUsername(username)) {
			System.out.println("There is no account associated with this username.");
			return;
		}
		else {
			System.out.println(username + "'s account has been found.");
			if (!myUserDatabase.searchAccountIsLocked(username)) {
				System.out.println("This account is not locked.");
				return;
			}
			else {
				System.out.println("Are you sure you would like to unlock this account? (yes or no)");
				String answer = scnr.next();
				String newline = scnr.nextLine();
				while (!(answer.equals("yes") || answer.equals("no"))) {
					System.out.println("Invalid entry. Please enter yes or no.");
					answer = scnr.next();
					newline = scnr.nextLine();
				}
				if (answer.equals("yes")) {
					myUserDatabase.unlockAccount(username);
					myActivityLog.AddActivity(ActivityLog.Activity.AccountUpdate, currentName, currentRole, myUserDatabase.searchCurrentID(username), myUserDatabase.searchCurrentRole(username), ActivityLog.AccountUpdateField.LockedStatus, "Locked", "Unlocked", 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println(username + "'s account has been unlocked.");
				}
				if (answer.equals("no")) {
					System.out.println(username + "'s account has not been unlocked.");
				}
			}
		}
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
