
public class Prescription extends DrugBatch {
	
	enum Status {InProgress, Ready, Filled};    // Filled = handed out / sold
	
	int prescriptionID;
	String dosage;
	String directions = "";
	int refillPeriodDays;         // Refill every _ days
	int refillCount;              // On _ refill;
	boolean isSigned;             // Doctor's signature or phone call approval
	Status prescriptionStatus;
	
	// Constructor
	
	public Prescription (String drugName, int strength, int quantity, String maxDosagePerDay, String expirationDate, String allergiesAndNotes, int pricePerMg, String dosage, String directions, int refillPeriodDays, int refillCount, boolean isSigned, Status prescriptionStatus) {
		super(drugName, strength, quantity, maxDosagePerDay, expirationDate, allergiesAndNotes, pricePerMg);
		this.prescriptionID = 0;
		this.dosage = dosage;
		this.directions = directions;
		this.refillPeriodDays = refillPeriodDays;
		this.refillCount = refillCount;
		this.isSigned = isSigned;
		this.prescriptionStatus = prescriptionStatus;
	}
}
