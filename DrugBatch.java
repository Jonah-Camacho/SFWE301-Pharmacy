
public class DrugBatch {
	
	int batchID;
	String drugName;
	int strength;
	int quantity;
	String maxDosagePerDay;
	String expirationDate;
	String allergiesAndNotes = "";
	int pricePerMg;
	
	// Constructor
	
	public DrugBatch (String drugName, int strength, int quantity, String maxDosagePerDay, String expirationDate, String allergiesAndNotes, int pricePerMg) {
		this.batchID = 0;
		this.drugName = drugName;
		this.strength = strength;
		this.quantity = quantity;
		this.maxDosagePerDay = maxDosagePerDay;
		this.expirationDate = expirationDate;
		this.allergiesAndNotes = allergiesAndNotes;
		this.pricePerMg = pricePerMg;
	}
	
}
