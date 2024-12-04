// Pharmacy Management System - SFWE 301
// Written by Molly Auer
// December 2024

import java.time.LocalDate;

public class DrugBatch {
	
	int batchID;
	String drugName;
	int strength;
	int quantity;
	int maxDosagePerDay;
	LocalDate expirationDate;
	String allergiesAndNotes = "";
	double pricePerCapsule;
	
	// Constructor
	
	public DrugBatch (int batchID, String drugName, int strength, int quantity, int maxDosagePerDay, LocalDate expirationDate, String allergiesAndNotes, double pricePerCapsule) {
		this.batchID = batchID;
		this.drugName = drugName;
		this.strength = strength;
		this.quantity = quantity;
		this.maxDosagePerDay = maxDosagePerDay;
		this.expirationDate = expirationDate;
		this.allergiesAndNotes = allergiesAndNotes;
		this.pricePerCapsule = pricePerCapsule;
	}
	
}
