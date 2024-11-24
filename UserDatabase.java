import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
	
	String filePath = "UserDatabase.csv";
	String[] headers = {"ID Number", "Full Name", "Date of Birth", "Gender", "Phone Number", "Address", "Active or Archived", "Role", "Doctor's Name", "Doctor's Phone Number", "Insurance Provider", "Insurance Policy Number", "Allergies", "Notes", "Username", "Password", "Locked or Unlocked"};
	
	
	public void AddUser (Patient myPatient) {
		String newRecord = "" + myPatient.IDNumber + "," + myPatient.fullName + "," + myPatient.dateOfBirth + "," + myPatient.userGender + "," + myPatient.phoneNumber + "," + myPatient.address + "," + myPatient.isActive + "," + myPatient.userRole + "," + myPatient.doctorsName + "," + myPatient.doctorsPhoneNumber + "," + myPatient.insuranceProvider + "," + myPatient.insurancePolicyNumber + "," + myPatient.allergies + "," + myPatient.notes + ", , , ";
	
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
	
	
	public void AddUser (PharmacyPersonnel myPharmacyPersonnel) {
		String newRecord = "" + myPharmacyPersonnel.IDNumber + "," + myPharmacyPersonnel.fullName + "," + myPharmacyPersonnel.dateOfBirth + "," + myPharmacyPersonnel.userGender + "," + myPharmacyPersonnel.phoneNumber + "," + myPharmacyPersonnel.address + ", ," + myPharmacyPersonnel.userRole + ", , , , , , ," + myPharmacyPersonnel.username + "," + myPharmacyPersonnel.password + "," + myPharmacyPersonnel.isLocked;
	
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
	
	
	public boolean searchUsername (String myUsername) {
		
		boolean isFound = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[14].equals(myUsername)) {
					isFound = true;
				}
			}
			return isFound;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file for update: " + e.getMessage());
			return false;
		}
	}

	
}
