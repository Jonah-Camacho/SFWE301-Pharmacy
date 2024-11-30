import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ActivityLog {

	String filePath = "ActivityLog.csv";
	String[] headers = {"Activity ID", "Date", "Time", "Activity", "Pharmacy Personnel Name", "Pharmacy Personnel Role", "Created/Updated Account ID", "Created/Updated Account Role", "Account Updated Field", "Before Change", "After Change", "Patient ID", "Prescription ID", "Drug Name", "Drug Strength", "Drug Quantity", "Batch ID", "Updated Prescription Status", "Total Price", "Card Number", "Card Expiration", "Card Pin", "Pharmacy Info Update Field"};
	
	enum Activity {AccountCreation, AccountUpdate, RequestPrescription, UpdatePrescriptionStatus, MakeTransaction, ViewInventory, RemoveExpiredInventory, PurchaseDrugShipment, ViewPrescriptionDatabase, ViewUserDatabase, ViewActivityLog, RequestFinancialReport, RequestInventoryReport, UpdatePharmacyInfo};
	enum AccountUpdateField {Name, DateOfBirth, Gender, PhoneNumber, Address, DoctorsName, DoctorsPhoneNumber, InsuranceProivder, InsurancePolicyNumber, Allergies, Notes, Role, Username, Password, LockedStatus, ActiveStatus, None};
	enum PharmacyInfoUpdateField {Address, Hours, PhoneNumber, None};
	
	
	
	public void AddActivity (Activity myActivity, String pharmacyPersonnelName, User.Role pharmacyPersonnelRole, int createdOrUpdatedAccountID, User.Role createdOrUpdatedAccountRole, AccountUpdateField myAccountUpdateField, String beforeChange, String afterChange, int patientId, int prescriptionID, String drugName, int drugStrength, int drugQuantity, int batchID, Prescription.Status updatedPrescriptionStatus, double totalPrice, long cardNumber, String cardExpiration, int cardPin, PharmacyInfoUpdateField myPharmacyInfoUpdateField) {
		
		// Generate activity ID, date, and time
		
		int activityID = 0;
		String date = "";
		String time = "";

		String newBeforeChange = "\"" + beforeChange + "\"";
		String newAfterChange = "\"" + afterChange + "\"";
		String newRecord = "" + activityID + "," + date + "," + time + "," + myActivity.toString() + "," + pharmacyPersonnelName + "," + pharmacyPersonnelRole.toString() + "," + createdOrUpdatedAccountID + "," + createdOrUpdatedAccountRole.toString() + "," + myAccountUpdateField.toString() + "," + newBeforeChange + "," + newAfterChange + "," + patientId + "," + prescriptionID + "," + drugName + "," + drugStrength + "," + drugQuantity + "," + batchID + "," + updatedPrescriptionStatus.toString() + "," + totalPrice + "," + cardNumber + "," + cardExpiration + "," + cardPin + "," + myPharmacyInfoUpdateField.toString();
	
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
}
	
