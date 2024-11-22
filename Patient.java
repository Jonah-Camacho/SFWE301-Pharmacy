
public class Patient extends User {
	
	String doctorsName;
	int doctorsPhoneNumber;
	boolean isInsured = false;
	String insuranceProvider = "";
	int insurancePolicyNumber = -1;
	boolean hasAllergies = false;
	String allergies = "";
	boolean hasNotes = false;
	String notes = "";
	
	
	//Basic Patient Constructor
	public Patient (String fullName, int dobMonth, int dobDay, int dobYear, Gender userGender, int phoneNumber, String address, String doctorsName, int doctorsPhoneNumber) {
		this.fullName = fullName;
		this.dateOfBirth = Integer.toString(dobMonth) + "/" +  Integer.toString(dobDay) + "/" + Integer.toString(dobYear);
		this.IDNumber = GenerateIDNumber();
		this.userGender = userGender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userRole = Role.Patient;
		this.doctorsName = doctorsName;
		this.doctorsPhoneNumber = doctorsPhoneNumber;
	}
	
	//Insured Patient Constructor
	public Patient (String fullName, int dobMonth, int dobDay, int dobYear, Gender userGender, int phoneNumber, String address, String doctorsName, int doctorsPhoneNumber, String insuranceProvider, int insurancePolicyNumber) {
		this.fullName = fullName;
		this.dateOfBirth = Integer.toString(dobMonth) + "/" +  Integer.toString(dobDay) + "/" + Integer.toString(dobYear);
		this.IDNumber = GenerateIDNumber();
		this.userGender = userGender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userRole = Role.Patient;
		this.doctorsName = doctorsName;
		this.doctorsPhoneNumber = doctorsPhoneNumber;
		this.isInsured = true;
		this.insuranceProvider = insuranceProvider;
		this.insurancePolicyNumber = insurancePolicyNumber;
	}
	
	
	
	//Setters
	
	public void AddAllergies(String allergies) {
		this.allergies = allergies;
		this.hasAllergies = true;
	}
	
	public void AddNotes(String notes) {
		this.notes = notes;
		this.hasNotes = true;
	}
	
	//Getters
	
	
	
	//Methods
	
	public void PrintPatientInfo() {
		System.out.println("ID: " + IDNumber);
		System.out.println("Name: " + fullName);
		System.out.println("Role: " + userRole);
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("Gender: " + userGender);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Address: " + address);
		
		if (isActive == true) {
			System.out.print("Active or Archived: Active");
		}
		else {
			System.out.print("Active or Archived: Archived");
		}
		
		System.out.println("Doctor: " + doctorsName);
		System.out.println("Doctor's Phone Number: " + doctorsPhoneNumber);
		
		if (isInsured) {
			System.out.println("Insurance Provider: " + insuranceProvider);
			System.out.println("Insurance Policy Number: " + insurancePolicyNumber);
		}
		
		if (hasAllergies) {
			System.out.println("Allergies: " + allergies);
		}
		else {
			System.out.println("Allergies: N/A");
		}
		
		if (hasNotes) {
			System.out.println("Notes: " + notes);
		}
		else {
			System.out.println("Notes: N/A");
		}
	}
	
	
}
