
public class PharmacyPersonnel extends User {
	
	String username;
	String password;
	boolean isLocked = false;
	
	//Constructor
	public PharmacyPersonnel (String fullName, String dateOfBirth, int ID, Gender userGender, long phoneNumber, String address, Role userRole, String username, String password) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.IDNumber = ID;
		this.userGender = userGender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userRole = userRole;
		this.username = username;
		this.password = password;
	}

		
	//Setters
	
	
	
	//Getters
	
	
	
	//Methods
	
	public void PrintPharmacyPersonnelInfo() {
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
		
		System.out.println("Username: " + username);
		
		if (isLocked == true) {
			System.out.print("Locked or Unlocked: Locked");
		}
		else {
			System.out.print("Locked or Unlocked: Unlocked");
		}
	}
}
