import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GUI {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		UserDatabase myUserDatabase = new UserDatabase();
		PharmacyInfo myPharmacy = new PharmacyInfo();
		Inventory myInventory = new Inventory();
		PrescriptionDatabase myPrescriptionDatabase = new PrescriptionDatabase();
		ActivityLog myActivityLog = new ActivityLog();
		DrugInformation myDrugInformation = new DrugInformation();
		String usernameIn;
		String passwordIn;
		boolean usernameFound = false;
		boolean correctPassword = false;
		int remainingAttempts = 4;
		String currentName;
		User.Role currentRole;
		int menuSelection = 0;
	
		
		/*String filePath = "Workspace.csv";
		
		// Write record - works for expiration and list!
		
		LocalDate expirationDate = LocalDate.now().plusYears(1);
		String list = "1,2,3";
		String newRecord = "" + expirationDate + ",\"" + list + "\"";
	
		try {
			File file = new File(filePath);
			boolean fileExists = file.exists();
		
		try (FileWriter writer = new FileWriter(filePath, true)) {
			writer.write(newRecord + "\n");
		}
		
		System.out.println("Data written successfully.");
		
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		// Return expiration - works!
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				LocalDate newExpirationDate = LocalDate.parse(values[0]);
			}
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		// Return list - works!
		
		ArrayList<Integer> myValues = new ArrayList<>();
		String stringValues = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				stringValues = values[1];
			}
			stringValues = stringValues.substring(1, stringValues.length() - 1);
			String [] newValues = stringValues.split(",");
			for (int i = 0; i < newValues.length; ++i) {
				myValues.add(Integer.parseInt(newValues[i]));
			}
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		// Update List - works!
		
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].length() > 0) {
					values[1] = values[1].substring(0, values[1].length() - 1);
					values[1] = values[1] + "," + "5" + "\"";
					updated = true;
					lines.add(String.join(",", values));
				}
			}
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
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
		}*/
		
		
		
		
		
		
		
		
		
		
		
		// Log-In System
		
		System.out.println("Welcome to the Pharmacy Management System!");
		System.out.println("Please enter your username:");
		
		// Search if username exists
		
		usernameIn = scnr.next();
		String newline = scnr.nextLine();
		if (myUserDatabase.searchUsername(usernameIn)) {
			usernameFound = true;
		}
		
		while (!usernameFound) {
			System.out.println("Username not found. Please enter a new username:");
			usernameIn = scnr.next();
			newline = scnr.nextLine();
			if (myUserDatabase.searchUsername(usernameIn)) {
				usernameFound = true;
			}
		}
		
		// Check if account is locked
		
		if (myUserDatabase.searchAccountIsLocked(usernameIn)) {
			System.out.println("Account is locked. Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
			System.exit(0);
		}
		
		// Check if account is active
		
		if (!myUserDatabase.searchAccountIsActive(usernameIn)) {
			System.out.println("Account is archived. Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
			System.exit(0);
		}

		
		// Search if password is correct
		
		System.out.println("Please enter your password:");
		passwordIn = scnr.next();
		newline = scnr.nextLine();
		if (myUserDatabase.searchPassword(usernameIn, passwordIn)) {
			correctPassword = true;
			System.out.println("Success! You have been logged in.");
			System.out.println();
		}
		
		while (!correctPassword) {
			System.out.println("Incorrect Password. Please enter a new password:");
			System.out.println("Remaining attempts: " + remainingAttempts);
			passwordIn = scnr.next();
			newline = scnr.nextLine();
			if (myUserDatabase.searchPassword(usernameIn, passwordIn)) {
				correctPassword = true;
				System.out.println("Success! You have been logged in.");
				System.out.println();
			}
			--remainingAttempts;
			
			if (remainingAttempts == 0) {
				System.out.println("Incorrect Password. Remaining attempts: " + remainingAttempts);
				System.out.println("All attempts have been used. Account is now locked.");
				System.out.println("Please contact a Pharmacy Manager or IT Administrator to unlock your account.");
				myUserDatabase.lockAccount(usernameIn);
				System.exit(0);
			}
		}
		
		
		// Logged-In
		
		currentName = myUserDatabase.searchCurrentName(usernameIn);
		currentRole = myUserDatabase.searchCurrentRole(usernameIn);
	
		while ((currentRole == User.Role.ITAdministrator && menuSelection != 23) || (currentRole == User.Role.PharmacyManager && menuSelection != 20) || (currentRole == User.Role.Pharmacist && menuSelection != 8) || (currentRole == User.Role.PharmacyTech && menuSelection != 6) || (currentRole == User.Role.Cashier && menuSelection != 3)) {
			Menu.printMenu(currentRole);
			menuSelection = scnr.nextInt();
			newline = scnr.nextLine();      // To absorb newline and avoid issues when working with menu functions
			Menu.menuFunction(currentRole, menuSelection, scnr, myUserDatabase, myPharmacy, myActivityLog, myPrescriptionDatabase, myInventory, currentName, myDrugInformation);
		}
		
		System.out.println("You have been successfully logged out. Goodbye!");
		
		scnr.close();
	}
}
