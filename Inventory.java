import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

	String filePath = "Inventory.csv";
	String[] headers = {"Batch ID", "Drug Name", "Strength (mg/capsule)", "Total Quantity", "Max Dosage per Day", "Expiration Date", "Allergies and Notes", "Price per Mg"};
	
	public void addDrug() {
		
	}
	
	public void sellDrug() {
		
	}
	
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
	
}
