import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.awt.Desktop;

public class Menu {
	
	// Print Menu Function

	public static void printMenu (User.Role userRole) {
		System.out.println();
		System.out.print("Select an option (1-");
		
		if (userRole == User.Role.ITAdministrator) {
			System.out.println("23):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Create Pharmacist, PharmacyTech, or Cashier Account");
			System.out.println("3.  Create Pharmacy Manager Account");
			System.out.println("4.  Create IT Administrator Account");
			System.out.println("5.  Update Patient Account");
			System.out.println("6.  Update Pharmacy Personnel Account");
			System.out.println("7.  Archive Account");
			System.out.println("8.  Reactivate Account");
			System.out.println("9.  Unlock Pharmacy Personnel Account");
			System.out.println("10. View Prescription History");
			System.out.println("11. Request Prescription");
			System.out.println("12. Fill Prescription");
			System.out.println("13. Make Transaction");
			System.out.println("14. View Inventory");
			System.out.println("15. Remove Expired Inventory");
			System.out.println("16. Purchase Drug Shipment");
			System.out.println("17. View Prescription Database");
			System.out.println("18. View User Database");
			System.out.println("19. View Activity Log");
			System.out.println("20. Request Financial Reports");
			System.out.println("21. Request Inventory Reports");
			System.out.println("22. Update Pharmacy Information");
			System.out.println("23. Log Out");
			System.out.println();
		}
		if (userRole == User.Role.PharmacyManager) {
			System.out.println("20):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Create Pharmacist, PharmacyTech, or Cashier Account");
			System.out.println("3.  Update Patient Account");
			System.out.println("4.  Update Pharmacy Personnel Account");
			System.out.println("5.  Archive Account");
			System.out.println("6.  Reactivate Account");
			System.out.println("7.  Unlock Pharmacy Personnel Account");
			System.out.println("8.  View Prescription History");
			System.out.println("9.  Request Prescription");
			System.out.println("10. Make Transaction");
			System.out.println("11. View Inventory");
			System.out.println("12. Remove Expired Inventory");
			System.out.println("13. Purchase Drug Shipment");
			System.out.println("14. View Prescription Database");
			System.out.println("15. View User Database");
			System.out.println("16. View Activity Log");
			System.out.println("17. Request Financial Reports");
			System.out.println("18. Request Inventory Reports");
			System.out.println("19. Update Pharmacy Information");
			System.out.println("20. Log Out");
			System.out.println();
		}
		if (userRole == User.Role.Pharmacist) {
			System.out.println("8):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  View Prescription History");
			System.out.println("4.  Request Prescription");
			System.out.println("5.  Fill Prescription");
			System.out.println("6.  Make Transaction");
			System.out.println("7.  View Prescription Database");
			System.out.println("8.  Log Out");
			System.out.println();
		}
		if (userRole == User.Role.PharmacyTech) {
			System.out.println("6):");
			System.out.println("1.  Create Patient Account");
			System.out.println("2.  Update Patient Account");
			System.out.println("3.  View Prescription History");
			System.out.println("4.  Request Prescription");
			System.out.println("5.  Make Transaction");
			System.out.println("6.  Log Out");
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
	
	public static void menuFunction(User.Role currentRole, int selection, Scanner scnr, UserDatabase myUserDatabase, PharmacyInfo myPharmacy, ActivityLog myActivityLog, PrescriptionDatabase myPrescriptionDatabase, Inventory myInventory, String currentName, DrugInformation myDrugInformation) {
		if (currentRole == User.Role.ITAdministrator) {
			switch(selection) {
				case 1:
					createPatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 2:
					createPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 3:
					createPharmacyManagerAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 4:
					createITAdministratorAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 5:
					updatePatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 6:
					updatePharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 7:
					archiveAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 8:
					reactivateAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 9:
					unlockPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 10:
					viewPrescriptionHistory(scnr, myUserDatabase, myPrescriptionDatabase, myActivityLog, currentName, currentRole);
					break;
				case 11:
					requestPrescription(scnr, myUserDatabase, myInventory, myActivityLog, currentName, currentRole, myDrugInformation, myPrescriptionDatabase);
					break;
				case 12:
					fillPrescription(scnr, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
					break;
				case 13:
					makeTransaction(scnr, myUserDatabase, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
					break;
				case 14:
					viewInventory();
					break;
				case 15:
					removeExpiredInventory(scnr, myInventory, myPrescriptionDatabase, myActivityLog, currentName, currentRole);
					break;
				case 16:
					purchaseDrugShipment(scnr, myInventory, myActivityLog, currentName, currentRole, myDrugInformation);
					break;
				case 17:
					viewPrescriptionDatabase();
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
					updatePharmacyInformation(scnr, myPharmacy, myActivityLog, currentName, currentRole);
					break;
				case 23:
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
					createPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 3:
					updatePatientAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 4:
					updatePharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 5:
					archiveAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 6:
					reactivateAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 7:
					unlockPharmacyPersonnelAccount(scnr, myUserDatabase, myActivityLog, currentName, currentRole);
					break;
				case 8:
					viewPrescriptionHistory(scnr, myUserDatabase, myPrescriptionDatabase, myActivityLog, currentName, currentRole);
					break;
				case 9:
					requestPrescription(scnr, myUserDatabase, myInventory, myActivityLog, currentName, currentRole, myDrugInformation, myPrescriptionDatabase);
					break;
				case 10:
					makeTransaction(scnr, myUserDatabase, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
					break;
				case 11:
					viewInventory();
					break;
				case 12:
					removeExpiredInventory(scnr, myInventory, myPrescriptionDatabase, myActivityLog, currentName, currentRole);
					break;
				case 13:
					purchaseDrugShipment(scnr, myInventory, myActivityLog, currentName, currentRole, myDrugInformation);
					break;
				case 14:
					viewPrescriptionDatabase();
					break;
				case 15:
					viewUserDatabase();
					break;
				case 16:
					viewActivityLog();
					break;
				case 17:
					requestFinancialReport();
					break;
				case 18:
					requestInventoryReport();
					break;
				case 19:
					updatePharmacyInformation(scnr, myPharmacy, myActivityLog, currentName, currentRole);
					break;
				case 20:
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
					viewPrescriptionHistory(scnr, myUserDatabase, myPrescriptionDatabase, myActivityLog, currentName, currentRole);
					break;
				case 4:
					requestPrescription(scnr, myUserDatabase, myInventory, myActivityLog, currentName, currentRole, myDrugInformation, myPrescriptionDatabase);
					break;
				case 5:
					fillPrescription(scnr, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
					break;
				case 6:
					makeTransaction(scnr, myUserDatabase, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
					break;
				case 7:
					viewPrescriptionDatabase();
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
					viewPrescriptionHistory(scnr, myUserDatabase, myPrescriptionDatabase, myActivityLog, currentName, currentRole);
					break;
				case 4:
					requestPrescription(scnr, myUserDatabase, myInventory, myActivityLog, currentName, currentRole, myDrugInformation, myPrescriptionDatabase);
					break;
				case 5:
					makeTransaction(scnr, myUserDatabase, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
			}
		}
		if (currentRole == User.Role.Cashier) {
			switch(selection) {
				case 1:
					requestPrescription(scnr, myUserDatabase, myInventory, myActivityLog, currentName, currentRole, myDrugInformation, myPrescriptionDatabase);
					break;
				case 2:
					makeTransaction(scnr, myUserDatabase, myPrescriptionDatabase, myInventory, myActivityLog, currentName, currentRole);
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
				String newline = scnr.nextLine();
				
				while (answer < 1 || answer > 11) {
					System.out.println("Please enter an integer between 1 and 11:");
					answer = scnr.nextInt();
					newline = scnr.nextLine();
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
					newline = scnr.nextLine();
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
					newline = scnr.nextLine();
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
					newline = scnr.nextLine();
					while (docsPhoneNumber < 1000000000 || docsPhoneNumber > 9999999999L) {
						System.out.println("Invalid entry. Please enter a 10 digit phone number:");
						docsPhoneNumber = scnr.nextLong();
						newline = scnr.nextLine();
					}
					long ogDoctorsPhoneNumber = myUserDatabase.returnDoctorsPhoneNumber(fullName);
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
					newline = scnr.nextLine();
					while (insurancePolicyNumber < 10000000 || insurancePolicyNumber > 9999999999999L) {
						System.out.println("Invalid entry. Please enter a 8-13 digit number:");
						insurancePolicyNumber = scnr.nextLong();
						newline = scnr.nextLine();
					}
					long ogPolicyNumber = myUserDatabase.returnInsurnacePolicyNumber(fullName);
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
					String newline = scnr.nextLine();
					
					while (answer < 1 || answer > 8) {
						System.out.println("Please enter an integer between 1 and 8:");
						answer = scnr.nextInt();
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
							newline = scnr.nextLine();
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
					String newline = scnr.nextLine();
					
					while (answer < 1 || answer > 8) {
						System.out.println("Please enter an integer between 1 and 8:");
						answer = scnr.nextInt();
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
						newline = scnr.nextLine();
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
							newline = scnr.nextLine();
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
	
	public static void viewPrescriptionHistory(Scanner scnr, UserDatabase myUserDatabase, PrescriptionDatabase myPrescriptionDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name of the patient:");
		String fullName = scnr.nextLine();
		
		if (!myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name does not exist.");
			System.out.println("Please try another name or create a new patient account.");
			return;
		}
		else {
			if (myUserDatabase.returnRole(fullName) != User.Role.Patient) {
				System.out.println("This account is not a patient account and therefore has no prescription history.");
				return;
			}
			else {
				if (!myUserDatabase.checkIfAccountIsActive(fullName)) {
					System.out.println("This account is inactive.");
					System.out.println("Please try another name or reactivate this account.");
					return;
				}
				else {
					ArrayList<Integer> prescriptionIDs = myUserDatabase.returnPatientPrescriptionIDArray(fullName);
					if (prescriptionIDs.size() > 0) {
						System.out.println("PrescriptionID: DrugName, DrugStrength (mg/capsule), DrugQuantity, BatchID, ExpirationDate, Dosage, MaxDosagePerDay, Directions, RefillPeriod (days), RefillCount, Status, TotalCost");
						System.out.println(fullName + "'s Prescription History:");
						for (int i = 0; i < prescriptionIDs.size(); ++i) {
							int id = prescriptionIDs.get(i);
							System.out.println(id + ":\t" + myPrescriptionDatabase.returnDrugName(id) + ",\t" + myPrescriptionDatabase.returnDrugStrength(id) + " mg/capsule,\t" + myPrescriptionDatabase.returnDrugQuantity(id) + " capsules,\tbatch" + myPrescriptionDatabase.returnDrugBatchID(id) + ",\tExpires " + myPrescriptionDatabase.returnExpirationDate(id) + ",\t" + myPrescriptionDatabase.returnDosage(id) + ",\t" + myPrescriptionDatabase.returnMaxDosagePerDay(id) + ",\t" + myPrescriptionDatabase.returnDirections(id) + ",\tCan refill every " + myPrescriptionDatabase.returnRefillPeriod(id) + " days,\tOn refill number " + myPrescriptionDatabase.returnRefillCount(id) + ",\t" + myPrescriptionDatabase.returnPrescriptionStatus(id) + ",\t$" + (myPrescriptionDatabase.returnDrugQuantity(id) * myPrescriptionDatabase.returnPricePerCapsule(id)));
						}
					}
					else {
						System.out.println("There are no prescriptions associated with this account.");
						return;
					}
				}
			}
		}
	}
	
	public static void requestPrescription(Scanner scnr, UserDatabase myUserDatabase, Inventory myInventory, ActivityLog myActivityLog, String currentName, User.Role currentRole, DrugInformation myDrugInformation, PrescriptionDatabase myPrescriptionDatabase) {
		System.out.println("Please enter the full name of the patient that you would like to request a prescription for:");
		String fullName = scnr.nextLine();
		if (!myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("There is no account associated with this name.");
			System.out.println("Please try another name or create an account.");
			return;
		}
		else {
			if (myUserDatabase.returnRole(fullName) != User.Role.Patient) {
				System.out.println("This user is not a patient.");
				System.out.println("Prescriptions can only be requested for patients");
				System.out.println("Please try again with a patient account.");
				return;
			}
			else {
				if (!myUserDatabase.checkIfAccountIsActive(fullName)) {
					System.out.println("This patient's account is archived.");
					System.out.println("Please reactivate the account or create a new account.");
					return;
				}
				else {
					System.out.println("Please enter the name of the drug you would like prescribed:");
					String drugName = scnr.nextLine();
					while (!myInventory.checkIfDrugExists(drugName)) {
						System.out.println("This drug is not available for purchase.");
						System.out.println("Please enter another drug name:");
						drugName = scnr.nextLine();
					}
					
					ArrayList<Integer> strengthOptions = myInventory.returnDrugStrengthOptions(drugName);
					int strengthChoice;
					if (strengthOptions.size() > 1) {
						System.out.println("You can be prescribed " + drugName + " with one of the following strength (mg/capsule) options:");
						for (int strength:strengthOptions) {
							System.out.println(strength);
						}
						
						System.out.println("Please enter the strength (mg/capsule) of " + drugName + " that you would like:");
						strengthChoice = scnr.nextInt();
						String newline = scnr.nextLine();
						boolean isValid = false;
						for (int strength:strengthOptions) {
							if (strengthChoice == strength) {
								isValid = true;
							}
						}
						
						while (!isValid) {
							System.out.println("That option is unavailable.");
							System.out.println("Please try again and enter the strength (mg/capsule) of " + drugName + " that you would like:");
							strengthChoice = scnr.nextInt();
							newline = scnr.nextLine();
							isValid = false;
							for (int strength:strengthOptions) {
								if (strengthChoice == strength) {
									isValid = true;
								}
							}
						}
					}
					else {
						strengthChoice = strengthOptions.get(0);
					}
					
					
					System.out.println(drugName + " costs " + myInventory.returnPricePerCapsule(drugName, strengthChoice) + " per capsule.");
					System.out.println("Please enter the quantity of " + drugName + " that you would like prescribed:");
					int quantity = scnr.nextInt();
					String newline = scnr.nextLine();
					
					while (myInventory.returnTotalQuantity(drugName, strengthChoice) < quantity) {
						System.out.println("Sorry, there is not enough of this drug in stock.");
						System.out.println("Please enter a new quantity below or equal to " + myInventory.returnTotalQuantity(drugName, strengthChoice));
						quantity = scnr.nextInt();
						newline = scnr.nextLine();
					}
					
					System.out.println("Please indicate the desired dosage given by the doctor:");
					String dosage = scnr.nextLine();
					
					System.out.println("Please indicate any directions given by the doctor in one line:");
					String directions = scnr.nextLine();
					
					System.out.println("Please indicate the refill period in days given by the doctor:");
					int refillPeriod = scnr.nextInt();
					newline = scnr.nextLine();
					
					System.out.println("Please indicate the total amount of refills recommended by the doctor:");
					int refillCount = scnr.nextInt();
					newline = scnr.nextLine();
					
					System.out.println("Has the doctor signed off on the prescription or approved it over phone call? (yes or no):");
					String answer = scnr.next();
					newline = scnr.nextLine();
					while (!(answer.equals("yes") || answer.equals("no"))) {
						System.out.println("Invalid entry. Please enter yes or no.");
						answer = scnr.next();
						newline = scnr.nextLine();
					}
					if (answer.equals("yes")) {
						boolean isSigned = true;
						double totalPrice = quantity * myInventory.returnPricePerCapsule(drugName, strengthChoice);
						System.out.println("The total cost will be: $" + totalPrice);
						System.out.println("Would you like to request this prescription? (yes or no):");
						answer = scnr.next();
						newline = scnr.nextLine();
						while (!(answer.equals("yes") || answer.equals("no"))) {
							System.out.println("Invalid entry. Please enter yes or no:");
							answer = scnr.next();
							newline = scnr.nextLine();
						}
						if (answer.equals("yes")) {
							int batchID = myInventory.returnOldestStockedBatchID(drugName, strengthChoice, quantity);
							Prescription newPrescription = new Prescription(batchID, drugName, strengthChoice, quantity, myInventory.returnMaxDosagePerDay(drugName, strengthChoice), myInventory.returnExpirationDate(batchID), myInventory.returnAllergiesAndNotes(drugName), myInventory.returnPricePerCapsule(drugName, strengthChoice), myPrescriptionDatabase.generateID(), myUserDatabase.returnID(fullName), dosage, directions, refillPeriod, refillCount, true, Prescription.Status.InProgress);
							myPrescriptionDatabase.addPrescription(newPrescription);
							myUserDatabase.addPrescriptionToPatient(myUserDatabase.returnID(fullName), myPrescriptionDatabase.returnLastID());
							myActivityLog.AddActivity(ActivityLog.Activity.RequestPrescription, currentName, currentRole, myUserDatabase.returnID(fullName), User.Role.Patient, ActivityLog.AccountUpdateField.Prescription, "", "", myUserDatabase.returnID(fullName), myPrescriptionDatabase.returnLastID(), drugName, strengthChoice, quantity, batchID, Prescription.Status.InProgress, totalPrice, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
							System.out.println("Your prescription request has been processed!");
							System.out.println("Your prescription ID is " + myPrescriptionDatabase.returnLastID());
							return;
						}
						else {
							System.out.println("Prescription request has been cancelled.");
							return;
						}
					}
					if (answer.equals("no")) {
						boolean isSigned = false;
						System.out.println("Sorry, this prescription cannot be processed without doctor's approval.");
						System.out.println("Please try again after getting it approved.");
						return;
					}
				}
			}
		}
	}
	
	public static void fillPrescription(Scanner scnr, PrescriptionDatabase myPrescriptionDatabase, Inventory myInventory, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		ArrayList<Integer> prescriptionsReadyToBeFilled = myPrescriptionDatabase.returnPrescriptionsReadyToBeFilled();
		if (prescriptionsReadyToBeFilled.size() > 0) {
			System.out.println("The following prescription IDs are ready to be filled:");
			for (int prescriptionID:prescriptionsReadyToBeFilled) {
				System.out.println(prescriptionID);
			}
			System.out.println("Would you like to fill all of the prescriptions? (yes or no)");
			String answer = scnr.next();
			String newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no:");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			if (answer.equals("yes")) {
				for (int prescriptionID:prescriptionsReadyToBeFilled) {
					myPrescriptionDatabase.fillPrescription(prescriptionID);
					myInventory.fillPrescription(myPrescriptionDatabase.returnDrugBatchID(prescriptionID), myPrescriptionDatabase.returnDrugQuantity(prescriptionID));
					myActivityLog.AddActivity(ActivityLog.Activity.FillPrescription, currentName, currentRole, myPrescriptionDatabase.returnPatientID(prescriptionID), User.Role.Patient, ActivityLog.AccountUpdateField.Prescription, "Prescription In Progress", "Prescription Filled", myPrescriptionDatabase.returnPatientID(prescriptionID), prescriptionID, myPrescriptionDatabase.returnDrugName(prescriptionID), myPrescriptionDatabase.returnDrugStrength(prescriptionID), myPrescriptionDatabase.returnDrugQuantity(prescriptionID), myPrescriptionDatabase.returnDrugBatchID(prescriptionID), Prescription.Status.ReadyFilled, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("Prescription " + prescriptionID + " has been successfully filled!");
				}
				System.out.println("All prescriptions have been successfully filled!");
				return;
			}
			if (answer.equals("no")) {
				answer = "yes";
				while (prescriptionsReadyToBeFilled.size() > 0 && answer.equals("yes")) {
					System.out.println("Please enter the ID of the prescription you would like to fill:");
					int id = scnr.nextInt();
					newline = scnr.nextLine();
					boolean isValid = false;
					for (int prescriptionID:prescriptionsReadyToBeFilled) {
						if (id == prescriptionID) {
							isValid = true;
						}
					}
					while (!isValid) {
						System.out.println("That option is unavailable.");
						System.out.println("Please try again and enter the ID of the prescription you would like to fill:");
						id = scnr.nextInt();
						newline = scnr.nextLine();
						isValid = false;
						for (int prescriptionID:prescriptionsReadyToBeFilled) {
							if (id == prescriptionID) {
								isValid = true;
							}
						}
					}
					myPrescriptionDatabase.fillPrescription(id);
					myInventory.fillPrescription(myPrescriptionDatabase.returnDrugBatchID(id), myPrescriptionDatabase.returnDrugQuantity(id));
					myActivityLog.AddActivity(ActivityLog.Activity.FillPrescription, currentName, currentRole, myPrescriptionDatabase.returnPatientID(id), User.Role.Patient, ActivityLog.AccountUpdateField.Prescription, "Prescription In Progress", "Prescription Filled", myPrescriptionDatabase.returnPatientID(id), id, myPrescriptionDatabase.returnDrugName(id), myPrescriptionDatabase.returnDrugStrength(id), myPrescriptionDatabase.returnDrugQuantity(id), myPrescriptionDatabase.returnDrugBatchID(id), Prescription.Status.ReadyFilled, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
					System.out.println("Prescription " + id + " has been successfully filled!");
					
					
					System.out.println("Would you like to fill another prescription? (yes or no):");
					answer = scnr.next();
					newline = scnr.nextLine();
					while (!(answer.equals("yes") || answer.equals("no"))) {
						System.out.println("Invalid entry. Please enter yes or no:");
						answer = scnr.next();
						newline = scnr.nextLine();
					}
				}
			}
		}
		else {
			System.out.println("There are no prescriptions ready to be filled.");
			return;
		}	
	}
	
	public static void makeTransaction(Scanner scnr, UserDatabase myUserDatabase, PrescriptionDatabase myPrescriptionDatabase, Inventory myInventory, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Please enter the full name of the patient purchasing a prescription:");
		String fullName = scnr.nextLine();
		
		if (!myUserDatabase.checkIfAccountExists(fullName)) {
			System.out.println("An account associated with this name does not exist.");
			System.out.println("Please try another name or create a new patient account.");
			return;
		}
		else {
			if (myUserDatabase.returnRole(fullName) != User.Role.Patient) {
				System.out.println("This account is not a patient account and therefore has no prescriptions to purchase.");
				return;
			}
			else {
				if (!myUserDatabase.checkIfAccountIsActive(fullName)) {
					System.out.println("This account is inactive.");
					System.out.println("Please try another name or reactivate this account.");
					return;
				}
				else {
					ArrayList<Integer> prescriptionIDs = myUserDatabase.returnPatientPrescriptionIDArray(fullName);
					if (prescriptionIDs.size() > 0) {
						boolean readyForSale = false;
						for (int i = 0; i < prescriptionIDs.size(); ++i) {
							if (myPrescriptionDatabase.returnPrescriptionStatus(prescriptionIDs.get(i)) == Prescription.Status.ReadyFilled) {
								readyForSale = true;
							}
						}
						
						if (!readyForSale) {
							System.out.println("There are no prescriptions ready for sale associated with this account.");
							System.out.println("Please request a prescription or wait for it to be filled by the pharmacist.");
							return;
						}
						else {
							System.out.println("The following prescriptions are filled and ready for purchase:");
							System.out.println("PrescriptionID: DrugName, DrugStrength (mg/capsule), DrugQuantity, BatchID, ExpirationDate, Dosage, MaxDosagePerDay, Directions, RefillPeriod (days), RefillCount, Status, TotalCost");
							for (int i = 0; i < prescriptionIDs.size(); ++i) {
								if (myPrescriptionDatabase.returnPrescriptionStatus(prescriptionIDs.get(i)) == Prescription.Status.ReadyFilled) {
									int id = prescriptionIDs.get(i);
									System.out.println(id + ":\t" + myPrescriptionDatabase.returnDrugName(id) + ",\t" + myPrescriptionDatabase.returnDrugStrength(id) + " mg/capsule,\t" + myPrescriptionDatabase.returnDrugQuantity(id) + " capsules,\tbatch" + myPrescriptionDatabase.returnDrugBatchID(id) + ",\tExpires " + myPrescriptionDatabase.returnExpirationDate(id) + ",\t" + myPrescriptionDatabase.returnDosage(id) + ",\t" + myPrescriptionDatabase.returnMaxDosagePerDay(id) + ",\t" + myPrescriptionDatabase.returnDirections(id) + ",\tCan refill every " + myPrescriptionDatabase.returnRefillPeriod(id) + " days,\tOn refill number " + myPrescriptionDatabase.returnRefillCount(id) + ",\t" + myPrescriptionDatabase.returnPrescriptionStatus(id) + ",\t$" + (myPrescriptionDatabase.returnDrugQuantity(id) * myPrescriptionDatabase.returnPricePerCapsule(id)));
								}
							}
							System.out.println();
							System.out.println("Please enter the prescription ID of the prescription you would like to purchase:");
							int prescriptionID = scnr.nextInt();
							String newline = scnr.nextLine();
							boolean isValid = false;
							for (int ID:prescriptionIDs) {
								if (prescriptionID == ID) {
									isValid = true;
								}
							}
							while (!isValid) {
								System.out.println("That option is unavailable.");
								System.out.println("Please try again and enter the prescription ID of the prescription you would like to purchase:");
								prescriptionID = scnr.nextInt();
								newline = scnr.nextLine();
								isValid = false;
								for (int ID:prescriptionIDs) {
									if (prescriptionID == ID) {
										isValid = true;
									}
								}
							}
							
							double totalPrice = myPrescriptionDatabase.returnDrugQuantity(prescriptionID) * myPrescriptionDatabase.returnPricePerCapsule(prescriptionID);
							System.out.println("The total price for this prescription is $" + totalPrice);
							
							System.out.println("Would you like to purchase this prescription? (yes or no):");
							String answer = scnr.next();
							newline = scnr.nextLine();
							while (!(answer.equals("yes") || answer.equals("no"))) {
								System.out.println("Invalid entry. Please enter yes or no:");
								answer = scnr.next();
								newline = scnr.nextLine();
							}
							if (answer.equals("yes")) {
								System.out.println("Would you like to pay with cash or credit? (cash or credit):");
								answer = scnr.next();
								newline = scnr.nextLine();
								while (!(answer.equals("cash") || answer.equals("credit"))) {
									System.out.println("Invalid entry. Please enter cash or credit:");
									answer = scnr.next();
									newline = scnr.nextLine();
								}
								if (answer.equals("cash")) {
									System.out.println("Please enter the amount of cash paid by the patient:");
									double cash = scnr.nextDouble();
									newline = scnr.nextLine();
									while (cash < totalPrice) {
										System.out.println("Invalid amount. Please pay at least $" + totalPrice + " in cash:");
										cash = scnr.nextDouble();
										newline = scnr.nextLine();
									}
									if (cash != totalPrice) {
										System.out.println("Please return $" + (cash - totalPrice) + " to the patient.");
									}
									System.out.println("The transaction is completed!");
									myPrescriptionDatabase.soldPrescription(prescriptionID);
									myActivityLog.AddActivity(ActivityLog.Activity.MakeTransaction, currentName, currentRole, myPrescriptionDatabase.returnPatientID(prescriptionID), User.Role.Patient, ActivityLog.AccountUpdateField.Prescription, "Prescription Is Ready", "Prescription Sold", myPrescriptionDatabase.returnPatientID(prescriptionID), prescriptionID, myPrescriptionDatabase.returnDrugName(prescriptionID), myPrescriptionDatabase.returnDrugStrength(prescriptionID), myPrescriptionDatabase.returnDrugQuantity(prescriptionID), myPrescriptionDatabase.returnDrugBatchID(prescriptionID), Prescription.Status.Sold, totalPrice, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
								}
								if (answer.equals("credit")) {
									System.out.println("Please enter the 16 digit card number:");
									long cardNumber = scnr.nextLong();
									newline = scnr.nextLine();
									while (cardNumber < 1000000000000000L || cardNumber > 9999999999999999L) {
										System.out.println("Invalid entry. Please enter a 16 digit card number:");
										cardNumber = scnr.nextLong();
										newline = scnr.nextLine();
									}
									
									System.out.println("Please enter the expiration date in the form MM/YYYY:");
									String cardExpiration = scnr.next();
									newline = scnr.nextLine();
									
									System.out.println("Please enter the 3 digit security code:");
									int code = scnr.nextInt();
									newline = scnr.nextLine();
									while (code < 100 || code > 999) {
										System.out.println("Invalid entry. Please enter a 3 digit security code:");
										code = scnr.nextInt();
										newline = scnr.nextLine();
									}
									System.out.println("The transaction is completed!");
									myPrescriptionDatabase.soldPrescription(prescriptionID);
									myActivityLog.AddActivity(ActivityLog.Activity.MakeTransaction, currentName, currentRole, myPrescriptionDatabase.returnPatientID(prescriptionID), User.Role.Patient, ActivityLog.AccountUpdateField.Prescription, "Prescription Is Ready", "Prescription Sold", myPrescriptionDatabase.returnPatientID(prescriptionID), prescriptionID, myPrescriptionDatabase.returnDrugName(prescriptionID), myPrescriptionDatabase.returnDrugStrength(prescriptionID), myPrescriptionDatabase.returnDrugQuantity(prescriptionID), myPrescriptionDatabase.returnDrugBatchID(prescriptionID), Prescription.Status.Sold, totalPrice, cardNumber, cardExpiration, code, ActivityLog.PharmacyInfoUpdateField.None);
								}
								return;
							}
							if (answer.equals("no")) {
								System.out.println("Would you like to cancel this prescription? (yes or no):");
								answer = scnr.next();
								newline = scnr.nextLine();
								while (!(answer.equals("yes") || answer.equals("no"))) {
									System.out.println("Invalid entry. Please enter yes or no:");
									answer = scnr.next();
									newline = scnr.nextLine();
								}
								if (answer.equals("yes")) {
									myPrescriptionDatabase.cancelPrescription(prescriptionID);
									myInventory.cancelPrescription(myPrescriptionDatabase.returnDrugBatchID(prescriptionID), myPrescriptionDatabase.returnDrugQuantity(prescriptionID));
									myActivityLog.AddActivity(ActivityLog.Activity.CancelPrescription, currentName, currentRole, myPrescriptionDatabase.returnPatientID(prescriptionID), User.Role.Patient, ActivityLog.AccountUpdateField.Prescription, "Prescription Is Ready", "Prescription Cancelled", myPrescriptionDatabase.returnPatientID(prescriptionID), prescriptionID, myPrescriptionDatabase.returnDrugName(prescriptionID), myPrescriptionDatabase.returnDrugStrength(prescriptionID), myPrescriptionDatabase.returnDrugQuantity(prescriptionID), myPrescriptionDatabase.returnDrugBatchID(prescriptionID), Prescription.Status.Cancelled, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
								}
								if (answer.equals("no")) {
									return;
								}
							}
						}
					}
					else {
						System.out.println("There are no prescriptions associated with this account.");
						System.out.println("Please request a prescription before making a transaction.");
						return;
					}
				}
			}
		}	
	}
	
	public static void viewInventory() {
		String filePath = "Inventory.csv";

        File file = new File(filePath);

        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.println(filePath + " is opening.");
            } catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
	}
	
	public static void removeExpiredInventory(Scanner scnr, Inventory myInventory, PrescriptionDatabase myPrescriptionDatabase, ActivityLog myActivityLog, String currentName, User.Role currentRole) {

	}
	
	public static void purchaseDrugShipment(Scanner scnr, Inventory myInventory, ActivityLog myActivityLog, String currentName, User.Role currentRole, DrugInformation myDrugInformation) {
		
		System.out.println("Please enter the name of the drug you would like to purchase:");
		String drugName = scnr.nextLine();
		while (!myDrugInformation.checkIfDrugExists(drugName)) {
			System.out.println("This drug is not available for purchase.");
			System.out.println("Please enter another drug name:");
			drugName = scnr.nextLine();
		}
		
		ArrayList<Integer> strengthOptions = myDrugInformation.returnDrugStrengthOptions(drugName);
		int strengthChoice;
		if (strengthOptions.size() > 1) {
			System.out.println("You can purchase " + drugName + " with one of the following strength (mg/capsule) options:");
			for (int strength:strengthOptions) {
				System.out.println(strength);
			}
			
			System.out.println("Please enter the strength (mg/capsule) of " + drugName + " that you would like:");
			strengthChoice = scnr.nextInt();
			String newline = scnr.nextLine();
			boolean isValid = false;
			for (int strength:strengthOptions) {
				if (strengthChoice == strength) {
					isValid = true;
				}
			}
			
			while (!isValid) {
				System.out.println("That option is unavailable.");
				System.out.println("Please try again and enter the strength (mg/capsule) of " + drugName + " that you would like:");
				strengthChoice = scnr.nextInt();
				newline = scnr.nextLine();
				isValid = false;
				for (int strength:strengthOptions) {
					if (strengthChoice == strength) {
						isValid = true;
					}
				}
			}
		}
		else {
			strengthChoice = strengthOptions.get(0);
		}
		
		System.out.println(drugName + " costs " + myDrugInformation.returnPricePerCapsule(drugName, strengthChoice) + " per capsule.");
		System.out.println("Please enter the quantity of " + drugName + " that you would like:");
		int quantity = scnr.nextInt();
		String newline = scnr.nextLine();
		
		double totalPrice = quantity * myDrugInformation.returnPricePerCapsule(drugName, strengthChoice);
		System.out.println("The total cost will be: $" + totalPrice);
		System.out.println("Would you like to make this purchase? (yes or no):");
		String answer = scnr.next();
		newline = scnr.nextLine();
		while (!(answer.equals("yes") || answer.equals("no"))) {
			System.out.println("Invalid entry. Please enter yes or no:");
			answer = scnr.next();
			newline = scnr.nextLine();
		}
		if (answer.equals("yes")) {
			DrugBatch newDrugShipment = new DrugBatch(myInventory.generateID(), drugName, strengthChoice, quantity, myDrugInformation.returnMaxDosagePerDay(drugName, strengthChoice), myInventory.generateExpirationDate(), myDrugInformation.returnAllergiesAndNotes(drugName), myDrugInformation.returnPricePerCapsule(drugName, strengthChoice));
			myInventory.addDrugBatch(newDrugShipment);
			myActivityLog.AddActivity(ActivityLog.Activity.PurchaseDrugShipment, currentName, currentRole, 0, User.Role.None, ActivityLog.AccountUpdateField.None, "", "", 0, 0, drugName, strengthChoice, quantity, myInventory.returnLastID(), Prescription.Status.None, totalPrice, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.None);
			System.out.println(drugName + " has been purchased!");
		}
		else {
			System.out.println("Purchase has been cancelled.");
		}
		
	}
	
	public static void viewPrescriptionDatabase() {
		String filePath = "PrescriptionDatabase.csv";

        File file = new File(filePath);

        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.println(filePath + " is opening.");
            } catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
	}
	
	public static void viewUserDatabase() {
		String filePath = "UserDatabase.csv";

        File file = new File(filePath);

        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.println(filePath + " is opening.");
            } catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
	}
	
	public static void viewActivityLog() {
		String filePath = "ActivityLog.csv";

        File file = new File(filePath);

        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.println(filePath + " is opening.");
            } catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
	}
	
	public static void requestFinancialReport() {
		System.out.println("This function is not currently available.");
	}
	
	public static void requestInventoryReport() {
		System.out.println("This function is not currently available.");
	}
	
	public static void updatePharmacyInformation(Scanner scnr, PharmacyInfo myPharmacy, ActivityLog myActivityLog, String currentName, User.Role currentRole) {
		System.out.println("Would you like to update the pharmacy name, address, phone number, or hours? (name, address, phone number, or hours):");
		String answer = scnr.nextLine();
		while (!(answer.equals("name") || answer.equals("address") || answer.equals("phone number") || answer.equals("hours"))) {
			System.out.println("Invalid entry. Please enter name, address, phone number, or hours:");
			answer = scnr.nextLine();
		}
		if (answer.equals("name")) {
			System.out.println("Please enter the updated pharmacy name:");
			String name = scnr.nextLine();
			System.out.println("Are you sure you would like to change the pharmacy name from " + myPharmacy.returnName() +  " to " + name +  "? (yes or no):");
			answer = scnr.next();
			String newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no:");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			if (answer.equals("yes")) {
				String ogName = myPharmacy.returnName();
				myPharmacy.updatePharmacyName(name);
				myActivityLog.AddActivity(ActivityLog.Activity.UpdatePharmacyInfo, currentName, currentRole, 0, User.Role.None, ActivityLog.AccountUpdateField.None, ogName, name, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.Name);
				System.out.println("The pharmacy name has been successfully updated to " + name);
				return;
			}
			if (answer.equals("no")) {
				System.out.println("The pharmacy name has not been updated.");
				return;
			}
		}
		if (answer.equals("address")) {
			System.out.println("Please enter the updated pharmacy address:");
			String address = scnr.nextLine();
			System.out.println("Are you sure you would like to change the pharmacy address from " + myPharmacy.returnAddress() +  " to " + address +  "? (yes or no):");
			answer = scnr.next();
			String newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no:");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			if (answer.equals("yes")) {
				String ogAddress = myPharmacy.returnAddress();
				myPharmacy.updatePharmacyAddress(address);
				myActivityLog.AddActivity(ActivityLog.Activity.UpdatePharmacyInfo, currentName, currentRole, 0, User.Role.None, ActivityLog.AccountUpdateField.None, ogAddress, address, 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.Address);
				System.out.println("The pharmacy address has been successfully updated to " + address);
				return;
			}
			if (answer.equals("no")) {
				System.out.println("The pharmacy address has not been updated.");
				return;
			}
		}
		if (answer.equals("phone number")) {
			System.out.println("Please enter the updated pharmacy phone number:");
			long phoneNumber = scnr.nextLong();
			String newline = scnr.nextLine();
			System.out.println("Are you sure you would like to change the pharmacy phone number from " + myPharmacy.returnPhoneNumber() +  " to " + phoneNumber +  "? (yes or no):");
			answer = scnr.next();
			newline = scnr.nextLine();
			while (!(answer.equals("yes") || answer.equals("no"))) {
				System.out.println("Invalid entry. Please enter yes or no:");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			if (answer.equals("yes")) {
				long ogPhoneNumber = myPharmacy.returnPhoneNumber();
				myPharmacy.updatePharmacyPhoneNumber(phoneNumber);
				myActivityLog.AddActivity(ActivityLog.Activity.UpdatePharmacyInfo, currentName, currentRole, 0, User.Role.None, ActivityLog.AccountUpdateField.None, Long.toString(ogPhoneNumber), Long.toString(phoneNumber), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.PhoneNumber);
				System.out.println("The pharmacy phone number has been successfully updated to " + phoneNumber);
				return;
			}
			if (answer.equals("no")) {
				System.out.println("The pharmacy phone number has not been updated.");
				return;
			}
		}
		if (answer.equals("hours")) {
			System.out.println("What day would you like to update the hours for? (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday):");
			String day = scnr.next();
			String newline = scnr.nextLine();
			while (!(day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday") || day.equals("Saturday") || day.equals("Sunday"))) {
				System.out.println("Invalid entry. Please enter Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday:");
				day = scnr.next();
				newline = scnr.nextLine();
			}
			
			System.out.println("Would you like to update opening or closing hours on " + day + "? (opening or closing):");
			answer = scnr.next();
			newline = scnr.nextLine();
			while (!(answer.equals("opening") || answer.equals("closing"))) {
				System.out.println("Invalid entry. Please enter opening or closing:");
				answer = scnr.next();
				newline = scnr.nextLine();
			}
			if (answer.equals("opening")) {
				System.out.println("Currently, the pharmacy opens at " + myPharmacy.returnOpeningHours(day) + " on " + day);
				System.out.println("Please enter the hour value for the new time you would like the pharmacy to open in the form of an integer:");
				int hour = scnr.nextInt();
				newline = scnr.nextLine();
				System.out.println("Please enter the minute value for the new time you would like the pharmacy to open in the form of an integer:");
				int minute = scnr.nextInt();
				newline = scnr.nextLine();
				LocalTime newOpeningHours = LocalTime.of(hour, minute);
				
				System.out.println("Are you sure you would like to change the pharmacy opening hours on " + day + " from " + myPharmacy.returnOpeningHours(day) +  " to " + newOpeningHours +  "? (yes or no):");
				answer = scnr.next();
				newline = scnr.nextLine();
				while (!(answer.equals("yes") || answer.equals("no"))) {
					System.out.println("Invalid entry. Please enter yes or no:");
					answer = scnr.next();
					newline = scnr.nextLine();
				}
				if (answer.equals("yes")) {
					LocalTime ogOpeningHours = myPharmacy.returnOpeningHours(day);
					myPharmacy.updateOpeningHours(day, newOpeningHours);
					myActivityLog.AddActivity(ActivityLog.Activity.UpdatePharmacyInfo, currentName, currentRole, 0, User.Role.None, ActivityLog.AccountUpdateField.None, ogOpeningHours.toString(), newOpeningHours.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.Hours);
					System.out.println("The pharmacy opening hours on " + day + " has been successfully updated to " + newOpeningHours);
					return;
				}
				if (answer.equals("no")) {
					System.out.println("The pharmacy hours have not been updated.");
					return;
				}			
			}
			if (answer.equals("closing")) {
				System.out.println("Currently, the pharmacy closes at " + myPharmacy.returnClosingHours(day) + " on " + day);
				System.out.println("Please enter the hour value for the new time you would like the pharmacy to close in the form of an integer:");
				int hour = scnr.nextInt();
				newline = scnr.nextLine();
				System.out.println("Please enter the minute value for the new time you would like the pharmacy to close in the form of an integer:");
				int minute = scnr.nextInt();
				newline = scnr.nextLine();
				LocalTime newClosingHours = LocalTime.of(hour, minute);
				
				System.out.println("Are you sure you would like to change the pharmacy closing hours on " + day + " from " + myPharmacy.returnClosingHours(day) +  " to " + newClosingHours +  "? (yes or no):");
				answer = scnr.next();
				newline = scnr.nextLine();
				while (!(answer.equals("yes") || answer.equals("no"))) {
					System.out.println("Invalid entry. Please enter yes or no:");
					answer = scnr.next();
					newline = scnr.nextLine();
				}
				if (answer.equals("yes")) {
					LocalTime ogClosingHours = myPharmacy.returnClosingHours(day);
					myPharmacy.updateClosingHours(day, newClosingHours);
					myActivityLog.AddActivity(ActivityLog.Activity.UpdatePharmacyInfo, currentName, currentRole, 0, User.Role.None, ActivityLog.AccountUpdateField.None, ogClosingHours.toString(), newClosingHours.toString(), 0, 0, "", 0, 0, 0, Prescription.Status.None, 0, 0, "", 0, ActivityLog.PharmacyInfoUpdateField.Hours);
					System.out.println("The pharmacy closing hours on " + day + " has been successfully updated to " + newClosingHours);
					return;
				}
				if (answer.equals("no")) {
					System.out.println("The pharmacy hours have not been updated.");
					return;
				}	
			}
		}
	}
}
