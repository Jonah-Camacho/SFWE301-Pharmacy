import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class PrescriptionDatabase {
	
	String filePath = "PrescriptionDatabase.csv";
	String[] headers = {"Prescription ID", "Patient ID", "Batch ID", "Drug Name", "Strength", "Prescribed Quantity", "Max Dosage per Day", "Expiration Date", "Allergies and Notes", "Price per Capsule", "Dosage", "Directions", "Refill Period (days)", "Refill Count", "Approved by Doctor?", "Status"};
	
	// Add prescription to database
	
	public void addPrescription (Prescription myPrescription) {
		String newAllergiesAndNotes = "" + "\"" + myPrescription.allergiesAndNotes + "\"";
		String newDirections = "" + "\"" + myPrescription.directions + "\"";
		String newRecord = "" + myPrescription.prescriptionID + "," + myPrescription.patientID + "," + myPrescription.batchID + "," + myPrescription.drugName + "," + myPrescription.strength + "," + myPrescription.quantity + "," + myPrescription.maxDosagePerDay + "," + myPrescription.expirationDate.toString() + "," + newAllergiesAndNotes + "," + myPrescription.pricePerCapsule + "," + myPrescription.dosage + "," + newDirections + "," + myPrescription.refillPeriodDays + "," + myPrescription.refillCount + "," + myPrescription.isSigned + "," + myPrescription.prescriptionStatus.toString(); 
		
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
	
	public void updateStatus() {
		
	}
	
	public void cancelPrescription () {
		
	}
	
	// Generate Prescription Database ID
	
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
	
	// Return last prescription ID
	
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
	
	// Return array of prescriptions ready to be filled
	
	public ArrayList<Integer> returnPrescriptionsReadyToBeFilled () {
		
		ArrayList<Integer> prescriptionsReadyToBeFilled = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[14].equals("InProgress")) {
					prescriptionsReadyToBeFilled.add(Integer.parseInt(values[0]));
				}
			}
			return prescriptionsReadyToBeFilled;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return prescriptionsReadyToBeFilled;
		}
	}
	
	// Fill Prescription
	
	public void fillPrescription (int prescriptionID) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (prescriptionID == Integer.parseInt(values[0])) {
					values[14] = Prescription.Status.ReadyFilled.toString();
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
	
	// Return ID of patient associated with prescription
	
	public int returnPatientID (int prescriptionID) {
		
		int patientID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (prescriptionID == Integer.parseInt(values[0])) {
					patientID = Integer.parseInt(values[1]);
				}
			}
			return patientID;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return patientID;
		}
	}
	
	// Return drug name
	
	public String returnDrugName (int prescriptionID) {
		
		String drugName = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (prescriptionID == Integer.parseInt(values[0])) {
					drugName = values[3];
				}
			}
			return drugName;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return drugName;
		}
	}
	
	// Return drug strength
	
	public int returnDrugStrength (int prescriptionID) {
		
		int drugStrength = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (prescriptionID == Integer.parseInt(values[0])) {
					drugStrength = Integer.parseInt(values[4]);
				}
			}
			return drugStrength;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return drugStrength;
		}
	}
	
	// Return drug quantity
	
	public int returnDrugQuantity (int prescriptionID) {
		
		int drugQuantity = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (prescriptionID == Integer.parseInt(values[0])) {
					drugQuantity = Integer.parseInt(values[5]);
				}
			}
			return drugQuantity;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return drugQuantity;
		}
	}
	
	// Return drug quantity
	
	public int returnDrugBatchID (int prescriptionID) {
		
		int batchID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (prescriptionID == Integer.parseInt(values[0])) {
					batchID = Integer.parseInt(values[2]);
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