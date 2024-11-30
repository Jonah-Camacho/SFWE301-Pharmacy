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
	String[] headers = {"Activity ID", "Date", "Time", "Activity", "Pharmacy Personnel Name", "Pharmacy Personnel Role", "Created Account ID", "Created Account Role", "Updated Account ID", "Updated Account Role", "Updated Account Field"};
	
	enum Activity {AccountCreation, AccountUpdate, RequestPrescription, UpdatePrescriptionStatus, MakeTransaction, ViewInventory, RemoveInventory, PurchaseDrugShipment, ViewUserDatabase, ViewActivityLog, RequestFinancialReport, RequestInventoryReport, UpdatePharmacyInfo};
	enum AccountUpdateField {Username, Password, Name, DateOfBirth, Gender, PhoneNumber, Address, DoctorsName, DoctorsPhoneNumber, InsuranceProivder, InsurancePolicyNumber, Allergies, Notes, Role, LockedStatus, ActiveStatus};
	
	public void AddActivity () {
		
	}
	
	
	public void AddUser (Patient myPatient) {
		String newAddress = "\"" + myPatient.address + "\"";
		String newAllergies = "\"" + myPatient.allergies + "\"";
		String newNotes = "\"" + myPatient.notes + "\"";
		String newRecord = "" + myPatient.IDNumber + "," + myPatient.fullName + "," + myPatient.dateOfBirth + "," + myPatient.userGender + "," + myPatient.phoneNumber + "," + newAddress + "," + myPatient.isActive + "," + myPatient.userRole + "," + myPatient.doctorsName + "," + myPatient.doctorsPhoneNumber + "," + myPatient.insuranceProvider + "," + myPatient.insurancePolicyNumber + "," + newAllergies + "," + newNotes + ", , , ";
	
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
