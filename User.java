
public abstract class User {
	
	enum Gender {Male, Female, Other};
	enum Role {ITAdministrator, PharmacyManager, Pharmacist, PharmacyTech, Cashier, Patient};
	
	int IDNumber;
	String fullName;
	String dateOfBirth;
	int dobMonth;
	int dobDay;
	int dobYear;
	Gender userGender;
	int phoneNumber;
	String address;
	String streetLine1;
	String streetLine2 = "";
	String city;
	String state;
	int zipCode;
	boolean isActive = true;
	Role userRole;
	int currIDNum = 0;
	
	
	public int GenerateIDNumber() {
		++currIDNum;
		return currIDNum;
	}
	
}
