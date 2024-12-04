// Pharmacy Management System - SFWE 301
// Written by Molly Auer
// December 2024

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

public class Inventory {

	String filePath = "Inventory.csv";
	String[] headers = {"Batch ID", "Drug Name", "Strength (mg/capsule)", "Total Quantity", "Max Dosage per Day", "Expiration Date", "Allergies and Notes", "Price per Capsule"};
	
	// Add new drug shipment to inventory
	
	public void addDrugBatch(DrugBatch newDrugBatch) {
		double newPrice = newDrugBatch.pricePerCapsule + 0.01;  // To make a profit
		String newRecord = "" + newDrugBatch.batchID + "," + newDrugBatch.drugName + "," + newDrugBatch.strength + "," + newDrugBatch.quantity + "," + newDrugBatch.maxDosagePerDay + "," + newDrugBatch.expirationDate + "," + newDrugBatch.allergiesAndNotes + "," + newPrice;
	
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
				if (values[0].equals(Integer.toString(batchID))) {
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
	
	// Replace inventory for cancelled prescription
	
	public void cancelPrescription (int batchID, int quantity) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(batchID))) {
					int newQuantity = Integer.parseInt(values[3]) + quantity;
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
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (values[2].equals(Integer.toString(strength)))) {
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
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (values[2].equals(Integer.toString(strength)))) {
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
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (values[2].equals(Integer.toString(strength)))) {
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
			int run = 0;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (run != 0) {
					if (values[0].equals(Integer.toString(batchID))) {
						expirationDate = LocalDate.parse(values[5]);
					}
				}
				++run;
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
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (values[2].equals(Integer.toString(strength)))) {
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
				if ((values[1].toLowerCase().equals(drugName.toLowerCase())) && (values[2].equals(Integer.toString(strength))) && (quantity <= Integer.parseInt(values[3]))) {
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
	
	// Return expired batch IDs
	
	public ArrayList<Integer> returnExpiredBatchIDs () {
		
		ArrayList<Integer> expiredBatchIDs = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			int run = 0;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (run != 0) {
					if (LocalDate.parse(values[5]).isBefore(LocalDate.now()) && Integer.parseInt(values[3]) > 0) {
						expiredBatchIDs.add(Integer.parseInt(values[0]));
					}
				}
				++run;
			}
			return expiredBatchIDs;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return expiredBatchIDs;
		}
	}
	
	// Remove expired inventory
	
	public void removeExpiredInventory (ArrayList<Integer> expiredBatchIDs) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for (int i = 0; i < expiredBatchIDs.size(); ++i) {
					if (values[0].equals(expiredBatchIDs.get(i).toString())) {
						values[3] = Integer.toString(0);
						updated = true;
					}
					lines.add(String.join(",", values));
				}
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
	
	// Return low stock batch IDs for low stock notification
	
	public ArrayList<Integer> returnLowStockBatchIDs () {
		
		ArrayList<Integer> lowStockBatchIDs = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			int run = 0;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (run != 0) {
					if (Integer.parseInt(values[3]) < 120 && Integer.parseInt(values[3]) > 0) {
						lowStockBatchIDs.add(Integer.parseInt(values[0]));
					}
				}
				++run;
			}
			return lowStockBatchIDs;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return lowStockBatchIDs;
		}
	}
	
	// Return batch IDs for batches expiring in 60 days
	
	public ArrayList<Integer> returnExpiringBatchIDs () {
		
		ArrayList<Integer> expiringBatchIDs = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			int run = 0;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (run != 0) {
					if (Period.between(LocalDate.now(), LocalDate.parse(values[5])).getYears() == 0 && Period.between(LocalDate.now(), LocalDate.parse(values[5])).getMonths() <= 0 && Period.between(LocalDate.now(), LocalDate.parse(values[5])).getDays() <= 60 && Integer.parseInt(values[3]) > 0) {
						expiringBatchIDs.add(Integer.parseInt(values[0]));
					}
				}
				++run;
			}
			return expiringBatchIDs;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return expiringBatchIDs;
		}
	}
	
	// Return batch IDs for batches expiring in 30 days
	
	public ArrayList<Integer> returnUrgentExpiringBatchIDs () {
		
		ArrayList<Integer> urgentExpiringBatchIDs = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			int run = 0;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (run != 0) {
					if (Period.between(LocalDate.now(), LocalDate.parse(values[5])).getYears() == 0 && Period.between(LocalDate.now(), LocalDate.parse(values[5])).getMonths() == 0 && Period.between(LocalDate.now(), LocalDate.parse(values[5])).getDays() <= 30 && Integer.parseInt(values[3]) > 0) {
						urgentExpiringBatchIDs.add(Integer.parseInt(values[0]));
					}
				}
				++run;
			}
			return urgentExpiringBatchIDs;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return urgentExpiringBatchIDs;
		}
	}
		
}
