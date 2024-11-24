import java.util.Scanner;

public class GUI {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String usernameIn;
		
		UserDatabase myUserDatabase = new UserDatabase();
		long myPhoneNumber = 5204246286L;
		PharmacyPersonnel MollyAuer = new PharmacyPersonnel("Molly Auer", 7, 11, 2004, User.Gender.Female, myPhoneNumber, "some address", User.Role.ITAdministrator, "mollyauer", "WildcatFurLife!44");
		myUserDatabase.AddUser(MollyAuer);
		
		System.out.println("Welcome to the Pharmacy Management System!");
		System.out.println("Please enter your username:");
		
		usernameIn = scnr.next();
		
		if (myUserDatabase.searchUsername(usernameIn)) {
			System.out.println("Username found");
		}
		
		else {
			System.out.println("Username does not exist");
		}
		
		scnr.close();
	}
}
