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
	
	// Add Pharmacy Personnel to UserDatabase
	public void AddUser (PharmacyPersonnel myPharmacyPersonnel) {
		String newAddress = "\"" + myPharmacyPersonnel.address + "\"";
		String newRecord = "" + myPharmacyPersonnel.IDNumber + "," + myPharmacyPersonnel.fullName + "," + myPharmacyPersonnel.dateOfBirth + "," + myPharmacyPersonnel.userGender + "," + myPharmacyPersonnel.phoneNumber + "," + newAddress + "," + myPharmacyPersonnel.isActive + "," + myPharmacyPersonnel.userRole + ", , , , , , ," + myPharmacyPersonnel.username + "," + myPharmacyPersonnel.password + "," + myPharmacyPersonnel.isLocked;
	
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
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
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
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(myUsername) && values[16].toLowerCase().equals("false")) {
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
	
	// Search if an account is active given the username
	
	public boolean searchAccountIsActive (String myUsername) {
		
		boolean isActive = true;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(myUsername) && values[6].toLowerCase().equals("false")) {
					isActive = false;
				}
			}
			return isActive;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return isActive;
		}
	}
	
	// Search if an account is active given the full name
	
	public boolean checkIfAccountIsActive (String fullName) {
		
		boolean isActive = true;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].equals(fullName) && values[6].toLowerCase().equals("false")) {
					isActive = false;
				}
			}
			return isActive;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return isActive;
		}
	}
	
	// Search is the correct password was entered for an account given a username
	
	public boolean searchPassword (String myUsername, String myPassword) {
		
		boolean isFound = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
	
	// Return the user's role based on fullName
	
	public User.Role returnRole (String fullName) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
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
	
	// Search for the user's name
	
	public String searchCurrentName (String myUsername) {
		
		String name = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(myUsername)) {
					name = values[1];
				}
			}
			return name;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return name;
		}
	}
	
	// Generate new ID number
	
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
	
	// Read last ID number
	
	public int readLastID () {
		
		int lastID = 0;
		String lastIDString = "zero";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				lastIDString = values[0];
			}
			lastID = Integer.parseInt(lastIDString);
			return lastID;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return lastID;
		}
	}
	
	// Archive an account
	
	public void archiveAccount (String fullName) {
		
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[6] = "false";
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
				System.out.println("Name not found. No updates made.");
			}
		}
		
		catch (IOException e) {
			System.out.println("Error writing updated file: " + e.getMessage());
		}
	}
	
	// Reactivate an account
	
	public void reactivateAccount (String fullName) {
		
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[6] = "true";
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
				System.out.println("Name not found. No updates made.");
			}
		}
		
		catch (IOException e) {
			System.out.println("Error writing updated file: " + e.getMessage());
		}
	}
	
	// Return ID based on full name
	
	public int returnID (String fullName) {
		
		int ID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					ID = Integer.parseInt(values[0]);
				}
			}
			return ID;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return ID;
		}
	}
	
}
