import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class Inventory {

	String filePath = "Inventory.csv";
	String[] headers = {"Batch ID", "Drug Name", "Strength (mg/capsule)", "Total Quantity", "Max Dosage per Day", "Expiration Date", "Allergies and Notes", "Price per Capsule"};
	
	// Add new drug shipment to inventory
	
	public void addDrugBatch(DrugBatch newDrugBatch) {
		double newPrice = newDrugBatch.pricePerCapsule + 0.01;  // To make a profit
		String newAllergiesAndNotes = "" + "\"" + newDrugBatch.allergiesAndNotes + "\"";
		String newRecord = "" + newDrugBatch.batchID + "," + newDrugBatch.drugName + "," + newDrugBatch.strength + "," + newDrugBatch.quantity + "," + newDrugBatch.maxDosagePerDay + "," + newDrugBatch.expirationDate.toString() + "," + newAllergiesAndNotes + "," + newPrice;
	
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
	
	// Remove inventory for filled prescription
	
	public void fillPrescription (int batchID, int quantity) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (batchID == Integer.parseInt(values[0])) {
					int newQuantity = Integer.parseInt(values[3]) - quantity;
					values[3] = Integer.toString(newQuantity);
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
	
	// Remove expired inventory
	
	public void removeExpiredInventory () {
		
	}
	
	// Generate Drug Batch ID
	
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
	
	// Return last ID
	
	public int returnLastID () {
		
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
	
	// Generate Expiration Date
	
	public LocalDate generateExpirationDate () {
		return LocalDate.now().plusYears(1);
	}
	
	// Check if drug exists
	
	public boolean checkIfDrugExists (String drugName) {
		
		boolean isFound = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(drugName.toLowerCase())) {
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
	
	// Return drug strength options
	
	public ArrayList<Integer> returnDrugStrengthOptions (String drugName) {
		
		ArrayList<Integer> drugStrengthOptions = new ArrayList<>();
		int strength;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(drugName.toLowerCase())) {
					strength = Integer.parseInt(values[2]);
					drugStrengthOptions.add(strength);
				}
			}
			return drugStrengthOptions;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return drugStrengthOptions;
		}
	}
	
	// Return max dosage per day
	
	public int returnMaxDosagePerDay (String drugName, int strength) {
		
		int maxDosagePerDay = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[2])) == strength) {
					maxDosagePerDay = Integer.parseInt(values[4]);
				}
			}
			return maxDosagePerDay;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return maxDosagePerDay;
		}
	}
	
	// Return allergies and notes

	public String returnAllergiesAndNotes (String drugName) {
		
		String allergiesAndNotes = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[1].toLowerCase().equals(drugName.toLowerCase())) {
					allergiesAndNotes = values[6];
				}
			}
			return allergiesAndNotes;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return allergiesAndNotes;
		}
	}
	
	// Return price per capsule
	
	public double returnPricePerCapsule (String drugName, int strength) {
		
		double pricePerCapsule = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[2])) == strength) {
					pricePerCapsule = Double.parseDouble(values[7]);
				}
			}
			return pricePerCapsule;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return pricePerCapsule;
		}
	}
	
	// Return batch ID
	
	public int returnBatchID (String drugName, int strength) {
		
		int batchID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[2])) == strength) {
					batchID = Integer.parseInt(values[0]);
				}
			}
			return batchID;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return batchID;
		}
	}
	
	// Return expiration date
	
	public LocalDate returnExpirationDate (int batchID) {
		
		LocalDate expirationDate = LocalDate.now();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (batchID == Integer.parseInt(values[0])) {
					expirationDate = LocalDate.parse(values[5]);
				}
			}
			return expirationDate;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return expirationDate;
		}
	}
	
	// Check total quantity of certain drug and strength
	
	public int returnTotalQuantity (String drugName, int strength) {
		
		int totalQuantity = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[2])) == strength) {
					totalQuantity += Integer.parseInt(values[3]);
				}
			}
			return totalQuantity;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return totalQuantity;
		}
	}
	
	// Return oldest, stocked batch ID

	public int returnOldestStockedBatchID (String drugName, int strength, int quantity) {
		
		int batchID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[2])) == strength && Integer.parseInt(values[3]) >= quantity) {
					batchID = Integer.parseInt(values[0]);
					return batchID;
				}
			}
			return batchID;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return batchID;
		}
	}
	
	
}
