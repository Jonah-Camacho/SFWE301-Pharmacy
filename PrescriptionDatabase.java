import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PrescriptionDatabase {
	
	String filePath = "PrescriptionDatabase.csv";
	String[] headers = {"Prescription ID", "Patient ID", "Batch ID", "Drug Name", "Strength", "Prescribed Quantity", "Max Dosage per Day", "Expiration Date", "Allergies and Notes", "Price per Capsule", "Dosage", "Directions", "Refill Period (days)", "Refill Count", "Approved by Doctor?", "Status"};
	
	// Add prescription to database
	
	public void addPrescription (Prescription myPrescription) {
		String newRecord = "" + myPrescription.prescriptionID + "," + myPrescription.patientID + "," + myPrescription.batchID + "," + myPrescription.drugName + "," + myPrescription.strength + "," + myPrescription.quantity + "," + myPrescription.maxDosagePerDay + "," + myPrescription.expirationDate + ",\"" + myPrescription.allergiesAndNotes + "\"," + myPrescription.pricePerCapsule + "," + myPrescription.dosage + ",\"" + myPrescription.directions + "\"," + myPrescription.refillPeriodDays + "," + myPrescription.refillCount + "," + myPrescription.isSigned + "," + myPrescription.prescriptionStatus.toString(); 
		
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
				if (values[15].equals("InProgress")) {
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
				if (values[0].equals(Integer.toString(prescriptionID))) {
					values[15] = Prescription.Status.ReadyFilled.toString();
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
	
	// Cancel Prescription
	
	public void cancelPrescription (int prescriptionID) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					values[15] = Prescription.Status.Cancelled.toString();
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
	
	// Sold Prescription
	
	public void soldPrescription (int prescriptionID) {
		List<String> lines = new ArrayList<>();
		boolean updated = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					values[15] = Prescription.Status.Sold.toString();
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
				if (values[0].equals(Integer.toString(prescriptionID))) {
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
				if (values[0].equals(Integer.toString(prescriptionID))) {
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
				if (values[0].equals(Integer.toString(prescriptionID))) {
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
				if (values[0].equals(Integer.toString(prescriptionID))) {
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
	
	// Return drug batch ID
	
	public int returnDrugBatchID (int prescriptionID) {
		
		int batchID = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
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
	
	// Return max dosage per day
	
	public int returnMaxDosagePerDay (int prescriptionID) {
		
		int maxDosagePerDay = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					maxDosagePerDay = Integer.parseInt(values[6]);
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

	public String returnAllergiesAndNotes (int prescriptionID) {
		
		String allergiesAndNotes = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					allergiesAndNotes = values[8];
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
	
	public double returnPricePerCapsule (int prescriptionID) {
		
		double pricePerCapsule = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					pricePerCapsule = Double.parseDouble(values[9]);
				}
			}
			return pricePerCapsule;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return pricePerCapsule;
		}
	}
	
	// Return expiration date
	
	public LocalDate returnExpirationDate (int prescriptionID) {
		
		LocalDate expirationDate = LocalDate.now();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					expirationDate = LocalDate.parse(values[7]);
				}
			}
			return expirationDate;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return expirationDate;
		}
	}
	
	// Return dosage

	public String returnDosage (int prescriptionID) {
		
		String dosage = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					dosage = values[10];
				}
			}
			return dosage;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return dosage;
		}
	}
	
	// Return directions

	public String returnDirections (int prescriptionID) {
		
		String directions = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					directions = values[11];
				}
			}
			return directions;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return directions;
		}
	}
	
	// Return refill period

	public int returnRefillPeriod (int prescriptionID) {
		
		int refillPeriod = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					refillPeriod = Integer.parseInt(values[12]);
				}
			}
			return refillPeriod;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return refillPeriod;
		}
	}
	
	// Return refill count

	public int returnRefillCount (int prescriptionID) {
		
		int refillCount = 0;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					refillCount = Integer.parseInt(values[13]);
				}
			}
			return refillCount;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return refillCount;
		}
	}
	
	// Return status

	public Prescription.Status returnPrescriptionStatus (int prescriptionID) {
		
		Prescription.Status status = Prescription.Status.None;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].equals(Integer.toString(prescriptionID))) {
					if (values[15].equals("InProgress")) {
						status = Prescription.Status.InProgress;
					}
					if (values[15].equals("ReadyFilled")) {
						status = Prescription.Status.ReadyFilled;
					}
					if (values[15].equals("Sold")) {
						status = Prescription.Status.Sold;
					}
					if (values[15].equals("Cancelled")) {
						status = Prescription.Status.Cancelled;
					}
				}
			}
			return status;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return status;
		}
	}
	
	
}