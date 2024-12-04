// Pharmacy Management System - SFWE 301
// Written by Molly Auer
// December 2024

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ActivityLog {

	String filePath = "ActivityLog.csv";
	String[] headers = {"Activity ID", "Date", "Time", "Activity", "Pharmacy Personnel Name", "Pharmacy Personnel Role", "Created/Updated Account ID", "Created/Updated Account Role", "Account Updated Field", "Before Change", "After Change", "Patient ID", "Prescription ID", "Drug Name", "Drug Strength", "Drug Quantity", "Batch ID", "Updated Prescription Status", "Total Price", "Card Number", "Card Expiration", "Card Security Code", "Pharmacy Info Update Field"};
	
	enum Activity {AccountCreation, AccountUpdate, RequestPrescription, FillPrescription, CancelPrescription, MakeTransaction, ViewInventory, RemoveExpiredInventory, PurchaseDrugShipment, ViewPrescriptionDatabase, ViewUserDatabase, ViewActivityLog, RequestFinancialReport, RequestInventoryReport, UpdatePharmacyInfo};
	enum AccountUpdateField {Name, DateOfBirth, Gender, PhoneNumber, Address, DoctorsName, DoctorsPhoneNumber, InsuranceProvider, InsurancePolicyNumber, Allergies, Notes, Role, Username, Password, LockedStatus, ActiveStatus, Prescription, None};
	enum PharmacyInfoUpdateField {Name, Address, Hours, PhoneNumber, None};	
	
	public void AddActivity (Activity myActivity, String pharmacyPersonnelName, User.Role pharmacyPersonnelRole, int createdOrUpdatedAccountID, User.Role createdOrUpdatedAccountRole, AccountUpdateField myAccountUpdateField, String beforeChange, String afterChange, int patientId, int prescriptionID, String drugName, int drugStrength, int drugQuantity, int batchID, Prescription.Status updatedPrescriptionStatus, double totalPrice, long cardNumber, String cardExpiration, int cardSecurityCode, PharmacyInfoUpdateField myPharmacyInfoUpdateField) {
				
		int activityID = generateID();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
	
		String newRecord = "" + activityID + "," + date + "," + time + "," + myActivity.toString() + "," + pharmacyPersonnelName + "," + pharmacyPersonnelRole.toString() + "," + createdOrUpdatedAccountID + "," + createdOrUpdatedAccountRole.toString() + "," + myAccountUpdateField.toString() + ",\"" + beforeChange + "\",\"" + afterChange + "\"," + patientId + "," + prescriptionID + "," + drugName + "," + drugStrength + "," + drugQuantity + "," + batchID + "," + updatedPrescriptionStatus.toString() + "," + totalPrice + "," + cardNumber + "," + cardExpiration + "," + cardSecurityCode + "," + myPharmacyInfoUpdateField.toString();
	
		try {
			File file = new File(filePath);
			boolean fileExists = file.exists();
		
		try (FileWriter writer = new FileWriter(filePath, true)) {
			
			if (!fileExists) {
				writer.write(String.join(",", headers) + "\n");
				
			}
			
			writer.write(newRecord + "\n");
		}
		
		System.out.println("Data written successfully.");
		
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	// Generate Activity Log ID
	
	public int generateID () {
		
		int lastID = 0;
		String lastIDString = "zero";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				lastIDString = values[0];
			}
			lastID = Integer.parseInt(lastIDString);
			return lastID + 1;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return lastID;
		}
	}
}
	
