// Pharmacy Management System - SFWE 301
// Written by Molly Auer
// December 2024

import java.time.LocalDate;

public class Prescription extends DrugBatch {
	
	enum Status {InProgress, ReadyFilled, Sold, Cancelled, None};    // Filled = ready for pick up
	
	int prescriptionID;
	int patientID;
	String dosage;
	String directions = "";
	int refillPeriodDays;         // Refill every _ days
	int refillCount;              // On _ refill;
	boolean isSigned;             // Doctor's signature or phone call approval
	Status prescriptionStatus;
	
	// Constructor
	
	public Prescription (int batchID, String drugName, int strength, int quantity, int maxDosagePerDay, LocalDate expirationDate, String allergiesAndNotes, double pricePerCapsule, int prescriptionID, int patientID, String dosage, String directions, int refillPeriodDays, int refillCount, boolean isSigned, Status prescriptionStatus) {
		super(batchID, drugName, strength, quantity, maxDosagePerDay, expirationDate, allergiesAndNotes, pricePerCapsule);
		this.prescriptionID = prescriptionID;
		this.patientID = patientID;
		this.dosage = dosage;
		this.directions = directions;
		this.refillPeriodDays = refillPeriodDays;
		this.refillCount = refillCount;
		this.isSigned = isSigned;
		this.prescriptionStatus = prescriptionStatus;
	}
}
