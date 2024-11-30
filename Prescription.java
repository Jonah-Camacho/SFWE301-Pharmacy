
public class Prescription extends DrugBatch {
	
	enum Status {InProgress, ReadyFilled, Sold, Cancelled, None};    // Filled = ready for pick up
	
	int prescriptionID;
	String dosage;
	String directions = "";
	int refillPeriodDays;         // Refill every _ days
	int refillCount;              // On _ refill;
	boolean isSigned;             // Doctor's signature or phone call approval
	Status prescriptionStatus;
	
	// Constructor
	
	public Prescription (int batchID, String drugName, int strength, int quantity, String maxDosagePerDay, String expirationDate, String allergiesAndNotes, int pricePerMg, int prescriptionID, String dosage, String directions, int refillPeriodDays, int refillCount, boolean isSigned, Status prescriptionStatus) {
		super(batchID, drugName, strength, quantity, maxDosagePerDay, expirationDate, allergiesAndNotes, pricePerMg);
		this.prescriptionID = prescriptionID;
		this.dosage = dosage;
		this.directions = directions;
		this.refillPeriodDays = refillPeriodDays;
		this.refillCount = refillCount;
		this.isSigned = isSigned;
		this.prescriptionStatus = prescriptionStatus;
	}
}
