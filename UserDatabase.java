import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
	
	String filePath = "UserDatabase.csv";
	String[] headers = {"ID Number", "Full Name", "Date of Birth", "Gender", "Phone Number", "Address", "Active?", "Role", "Doctor's Name", "Doctor's Phone Number", "Insurance Provider", "Insurance Policy Number", "Allergies", "Notes", "Username", "Password", "Locked?", "Prescription IDs"};
	
	// Add Patient to UserDatabase
	
	public void AddUser (Patient myPatient) {
		String newRecord = "" + myPatient.IDNumber + "," + myPatient.fullName + "," + myPatient.dateOfBirth + "," + myPatient.userGender + "," + myPatient.phoneNumber + ",\"" + myPatient.address + "\"," + myPatient.isActive + "," + myPatient.userRole + "," + myPatient.doctorsName + "," + myPatient.doctorsPhoneNumber + "," + myPatient.insuranceProvider + "," + myPatient.insurancePolicyNumber + ",\"" + myPatient.allergies + "\",\"" + myPatient.notes + "\", , , ," + "";
	
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
		String newRecord = "" + myPharmacyPersonnel.IDNumber + "," + myPharmacyPersonnel.fullName + "," + myPharmacyPersonnel.dateOfBirth + "," + myPharmacyPersonnel.userGender + "," + myPharmacyPersonnel.phoneNumber + "," + newAddress + "," + myPharmacyPersonnel.isActive + "," + myPharmacyPersonnel.userRole + ", , , , , , ," + myPharmacyPersonnel.username + "," + myPharmacyPersonnel.password + "," + myPharmacyPersonnel.isLocked + "";
	
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
	
	// Search for the user's current role based on the username
	
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
	
	// Return ID based on username
	
	public int searchCurrentID (String username) {
		
		int ID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
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
	
	// Update Name given fullName
	
	public void updateNameFN (String fullName, String newName) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[1] = newName;
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
	
	// Update DoB given fullName

	public void updateDateOfBirthFN (String fullName, String dob) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[2] = dob;
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
	
	// Return dob given fullName
	
	public String returnDoBFN (String fullName) {
		
		String dob = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					dob = values[2];
				}
			}
			return dob;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return dob;
		}
	}
	
	// Update Gender given fullName

	public void updateGenderFN (String fullName, User.Gender newGender) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[3] = newGender.toString();
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
	
	// Return gender given fullName

	public User.Gender returnGenderFN (String fullName) {
		
		User.Gender gender = User.Gender.Other;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					if (values[3].equals("Male")) {
						gender = User.Gender.Male;
					}
					if (values[3].equals("Female")) {
						gender = User.Gender.Female;
					}
					if (values[3].equals("Other")) {
						gender = User.Gender.Other;
					}
				}
			}
			return gender;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return gender;
		}
	}
	
	// Update Phone Number given fullName

	public void updatePhoneNumberFN (String fullName, long newPhoneNumber) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[4] = Long.toString(newPhoneNumber);
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
	
	// Return phone number given fullName

	public long returnPhoneNumberFN (String fullName) {
		
		long phoneNumber = 0L;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					phoneNumber = Long.parseLong(values[4]);
				}
			}
			return phoneNumber;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return phoneNumber;
		}
	}
	
	// Update Address given fullName

	public void updateAddressFN (String fullName, String newAddress) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[5] = "\"" + newAddress + "\"";
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
	
	// Return address given fullName

	public String returnAddressFN (String fullName) {
		
		String address = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					address = values[5];
				}
			}
			return address;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return address;
		}
	}
	
	// Update Name given username
	
	public void updateNameU (String username, String newName) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[1] = newName;
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
	
	// Update DoB given username

	public void updateDateOfBirthU (String username, String dob) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[2] = dob;
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
	
	// Return dob given username

	public String returnDoBU (String username) {
		
		String dob = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					dob = values[2];
				}
			}
			return dob;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return dob;
		}
	}
	
	// Update Gender given username

	public void updateGenderU (String username, User.Gender newGender) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[3] = newGender.toString();
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
	
	// Return gender given username
	
	public User.Gender returnGenderU (String username) {
		
		User.Gender gender = User.Gender.Other;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					if (values[3].equals("Male")) {
						gender = User.Gender.Male;
					}
					if (values[3].equals("Female")) {
						gender = User.Gender.Female;
					}
					if (values[3].equals("Other")) {
						gender = User.Gender.Other;
					}
				}
			}
			return gender;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return gender;
		}
	}
	
	// Update Phone Number given username

	public void updatePhoneNumberU (String username, long newPhoneNumber) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[4] = Long.toString(newPhoneNumber);
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
	
	// Return Phone number given username

	public long returnPhoneNumberU (String username) {
		
		long phoneNumber = 0L;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					phoneNumber = Long.parseLong(values[4]);
				}
			}
			return phoneNumber;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return phoneNumber;
		}
	}
	
	// Update Address given username

	public void updateAddressU (String username, String newAddress) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[5] = "\"" + newAddress + "\"";
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
	
	// Return address given username
	
	public String returnAddressU (String username) {
		
		String address = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					address = values[5];
				}
			}
			return address;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return address;
		}
	}
	
	// Update Doctor's name

	public void updateDoctorsName (String fullName, String newDoctorsName) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[8] = newDoctorsName;
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
	
	// Return doctor's name

	public String returnDoctorsName (String fullName) {
		
		String doctorsName = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					doctorsName = values[8];
				}
			}
			return doctorsName;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return doctorsName;
		}
	}
	
	// Update Doctor's phone number

	public void updateDoctorsPhoneNumber (String fullName, long newDocsPhoneNumber) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[9] = Long.toString(newDocsPhoneNumber);
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
	
	// Return doctor's phone number

	public long returnDoctorsPhoneNumber (String fullName) {
		
		long doctorsPhoneNumber = 0L;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					doctorsPhoneNumber = Long.parseLong(values[9]);
				}
			}
			return doctorsPhoneNumber;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return doctorsPhoneNumber;
		}
	}
	
	// Update Insurance Provider

	public void updateInsurnaceProvider (String fullName, String newInsuranceProvider) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[10] = newInsuranceProvider;
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
	
	// Return insurance provider

	public String returnInsurnaceProvider (String fullName) {
		
		String insuranceProvider = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					insuranceProvider = values[10];
				}
			}
			return insuranceProvider;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return insuranceProvider;
		}
	}
	
	// Update Insurance Policy Number

	public void updateInsurnacePolicyNumber (String fullName, long newPolicyNumber) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[11] = Long.toString(newPolicyNumber);
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
	
	// Return insurance policy number

	public long returnInsurnacePolicyNumber (String fullName) {
		
		long insurancePolicyNumber = 0L;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					insurancePolicyNumber = Long.parseLong(values[11]);
				}
			}
			return insurancePolicyNumber;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return insurancePolicyNumber;
		}
	}
	
	// Update Allergies

	public void updateAllergies (String fullName, String newAllergies) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[12] = "\"" + newAllergies + "\"";
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
	
	// Return allergies

	public String returnAllergies (String fullName) {
		
		String allergies = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					allergies = values[12];
				}
			}
			return allergies;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return allergies;
		}
	}
	
	// Update Notes

	public void updateNotes (String fullName, String newNotes) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					values[13] = "\"" + newNotes + "\"";
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
	
	// Return notes

	public String returnNotes (String fullName) {
		
		String notes = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					notes = values[13];
				}
			}
			return notes;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return notes;
		}
	}
	
	// Update Role

	public void updateRole (String username, User.Role newRole) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[7] = newRole.toString();
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
	
	// Update username

	public void updateUsername (String username, String newUsername) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[14] = newUsername;
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
	
	// Update password

	public void updatePassword (String username, String newPassword) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					values[15] = newPassword;
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
	
	// Return password
	
	public String returnPassword (String username) {
		
		String password = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
					password = values[15];
				}
			}
			return password;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return password;
		}
	}
	
	// Return name from username

	public String returnName (String username) {
		
		String name = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals(username)) {
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
	
	// Add prescription to patient's prescription ID array

	public void addPrescriptionToPatient (int patientID, int prescriptionID) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(patientID))) {
					values[17] = values[17].substring(0, values[1].length() - 1);
					values[17] = values[17] + prescriptionID + ",\"";
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
	
	// Return Patient's prescription array
	
	public ArrayList<Integer> returnPatientPrescriptionIDArray (String fullName) {
		
		ArrayList<Integer> patientPrescriptionIDs = new ArrayList<>();
		String prescriptionIDs = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(fullName.toLowerCase())) {
					prescriptionIDs = values[17];
				}
			}
			prescriptionIDs = prescriptionIDs.substring(1, prescriptionIDs.length() - 2);
			String[] IDs = prescriptionIDs.split(",");
			for (int i = 0; i < IDs.length; ++i) {
				patientPrescriptionIDs.add(Integer.parseInt(IDs[i]));
			}
			return patientPrescriptionIDs;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return patientPrescriptionIDs;
		}
	}	
	
}
