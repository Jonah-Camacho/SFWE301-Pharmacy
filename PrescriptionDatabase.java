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
	
}