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
	String[] headers = {"Prescription ID", "Batch ID", "Drug Name", "Strength", "Prescribed Quantity", "Max Dosage per Day", "Expiration Date", "Allergies and Notes", "Price per Mg", "Dosage", "Directions", "Refill Period (days)", "Refill Count", "Approved by Doctor?", "Status"};
	
	public void addPrescription () {
		
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
	
}