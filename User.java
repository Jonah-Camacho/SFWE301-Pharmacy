
public abstract class User {
	
	enum Gender {Male, Female, Other};
	enum Role {ITAdministrator, PharmacyManager, Pharmacist, PharmacyTech, Cashier, Patient, None};
	
	int IDNumber;
	String fullName;
	String dateOfBirth;
	Gender userGender;
	long phoneNumber;
	String address;
	boolean isActive = true;
	Role userRole;

}
