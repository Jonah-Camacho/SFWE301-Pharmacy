import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
	
	String filePath = "UserDatabase.csv";
	String[] headers = {"ID Number", "Full Name", "Date of Birth", "Gender", "Phone Number", "Address", "Active?", "Role", "Doctor's Name", "Doctor's Phone Number", "Insurance Provider", "Insurance Policy Number", "Allergies", "Notes", "Username", "Password", "Locked?"};
	
	// Add Patient to UserDatabase
	
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
	
	// Add Pharmacy Personnel to UserDatabase
	
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
	
	// Search and Locate a username in the database
	
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
			System.out.println("Error reading file: " + e.getMessage());
			return false;
		}
	}
	
	// Search if an account already exists based on the full name
	
	public boolean checkIfAccountExists (String fullName) {
		
		boolean isFound = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[1].equals(fullName)) {
					isFound = true;
				}
			}
			return isFound;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return false;
		}
	}
	
	// Search if an account is locked given the username
	
	public boolean searchAccountIsLocked (String myUsername) {
		
		boolean isLocked = true;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[14].equals(myUsername) && values[16].equals("false")) {
					isLocked = false;
				}
			}
			return isLocked;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return true;
		}
	}
	
	// Search is the correct password was entered for an account given a username
	
	public boolean searchPassword (String myUsername, String myPassword) {
		
		boolean isFound = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[14].equals(myUsername) && values[15].equals(myPassword)) {
					isFound = true;
				}
			}
			return isFound;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return false;
		}
	}
	
	// Lock an account
	
	public void lockAccount (String myUsername) {
		
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[14].equals(myUsername)) {
					values[16] = "true";
					updated = true;
				}
				lines.add(String.join(",", values));
			}
		}
		
		catch (IOException e) {
			System.out.println("Error reading file for update: " + e.getMessage());
		}
		
		try (FileWriter writer = new FileWriter(filePath)) {
			for (String line : lines) {
				writer.write(line + "\n");
			}
			if (!updated) {
				System.out.println("Username not found. No updates made.");
			}
		}
		
		catch (IOException e) {
			System.out.println("Error writing updated file: " + e.getMessage());
		}
	}
	
	// Unlock an account
	
	public void unlockAccount (String myUsername) {
		
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[14].equals(myUsername)) {
					values[16] = "false";
					updated = true;
				}
				lines.add(String.join(",", values));
			}
		}
		
		catch (IOException e) {
			System.out.println("Error reading file for update: " + e.getMessage());
		}
		
		try (FileWriter writer = new FileWriter(filePath)) {
			for (String line : lines) {
				writer.write(line + "\n");
			}
			if (!updated) {
				System.out.println("Username not found. No updates made.");
			}
		}
		
		catch (IOException e) {
			System.out.println("Error writing updated file: " + e.getMessage());
		}
	}
	
	// Search for the user's current role
	
	public User.Role searchCurrentRole (String myUsername) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values[14].equals(myUsername)) {
					if (values[7].equals("ITAdministrator")) {
						return User.Role.ITAdministrator;
					}
					if (values[7].equals("PharmacyManager")) {
						return User.Role.PharmacyManager;
					}
					if (values[7].equals("Pharmacist")) {
						return User.Role.Pharmacist;
					}
					if (values[7].equals("PharmacyTech")) {
						return User.Role.PharmacyTech;
					}
					if (values[7].equals("Cashier")) {
						return User.Role.Cashier;
					}
					if (values[7].equals("Patient")) {
						return User.Role.Patient;
					}
				}
			}
			return User.Role.Patient;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return User.Role.Patient;
		}
	}

	
}
