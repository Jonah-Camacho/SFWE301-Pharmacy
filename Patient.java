// Pharmacy Management System - SFWE 301
// Written by Molly Auer
// December 2024

import java.util.ArrayList;

public class Patient extends User {
	
	String doctorsName;
	long doctorsPhoneNumber;
	boolean isInsured = false;
	String insuranceProvider = "";
	long insurancePolicyNumber = 0L;
	boolean hasAllergies = false;
	String allergies = "";
	boolean hasNotes = false;
	String notes = "";
	ArrayList<Integer> prescriptionIDs = new ArrayList<>();
	
	
	//Basic Patient Constructor
	public Patient (String fullName, String dateOfBirth, int ID, Gender userGender, long phoneNumber, String address, String doctorsName, long doctorsPhoneNumber) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.IDNumber = ID;
		this.userGender = userGender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userRole = Role.Patient;
		this.doctorsName = doctorsName;
		this.doctorsPhoneNumber = doctorsPhoneNumber;
	}
	
	//Insured Patient Constructor
	public Patient (String fullName, String dateOfBirth, int ID, Gender userGender, long phoneNumber, String address, String doctorsName, long doctorsPhoneNumber, String insuranceProvider, long insurancePolicyNumber) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.IDNumber = ID;
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
	
	public void addAllergies(String allergies) {
		this.allergies = allergies;
		this.hasAllergies = true;
	}
	
	public void addNotes(String notes) {
		this.notes = notes;
		this.hasNotes = true;
	}
	
	public void addPrescription (int prescriptionID) {
		this.prescriptionIDs.add(prescriptionID);
	}
	

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
