// Pharmacy Management System - SFWE 301
// Written by Molly Auer
// December 2024

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DrugInformation {

	String filePath = "DrugInformation.csv";
	String[] headers = {"DrugName", "Strength (mg/capsule)", "MaxDosagePerDay (# of capsules)", "AllergiesAndNotes", "PricePerCapsule ($/capsule)"};
	
	
	// Check if drug exists
	
	public boolean checkIfDrugExists (String drugName) {
		
		boolean isFound = false;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				if (values[0].toLowerCase().equals(drugName.toLowerCase())) {
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
				if (values[0].toLowerCase().equals(drugName.toLowerCase())) {
					strength = Integer.parseInt(values[1]);
					boolean alreadyExists = false;
					for (int i = 0; i < drugStrengthOptions.size(); ++i) {
						if (strength == drugStrengthOptions.get(i)) {
							alreadyExists = true;
						}
					}
					if (!alreadyExists) {
						drugStrengthOptions.add(strength);
					}
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
				if ((values[0].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[1])) == strength) {
					maxDosagePerDay = Integer.parseInt(values[2]);
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
				if (values[0].toLowerCase().equals(drugName.toLowerCase())) {
					allergiesAndNotes = values[3];
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
				if ((values[0].toLowerCase().equals(drugName.toLowerCase())) && (Integer.parseInt(values[1])) == strength) {
					pricePerCapsule = Double.parseDouble(values[4]);
				}
			}
			return pricePerCapsule;
		}
		
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return pricePerCapsule;
		}
	}
	
	
}
