import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class PharmacyInfo {
	
	String name = "CVS Pharmacy";
	String address = "2385 N Silverbell Rd, Tucson, AZ 85745";
	long phoneNumber = 5206879468L;
	ArrayList<String> daysOfTheWeek = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
	ArrayList<LocalTime> openingTimes = new ArrayList<>(Arrays.asList(LocalTime.of(8, 0), LocalTime.of(8, 0), LocalTime.of(8, 0), LocalTime.of(8, 0), LocalTime.of(8, 0), LocalTime.of(8, 0), LocalTime.of(8, 0)));
	ArrayList<LocalTime> closingTimes = new ArrayList<>(Arrays.asList(LocalTime.of(22, 0), LocalTime.of(22, 0), LocalTime.of(22, 0), LocalTime.of(22, 0), LocalTime.of(16, 0), LocalTime.of(16, 0), LocalTime.of(16, 0)));
	
	// Setters
	
	public void updatePharmacyName(String newName) {
		this.name = newName;
	}
		
	public void updatePharmacyAddress(String newAddress) {
		this.address = newAddress;
	}
	
	public void updatePharmacyPhoneNumber(long newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}
	
	public void updateOpeningHours(String day, LocalTime newOpenTime) {
		if (day.equals("Monday")) {
			openingTimes.set(0, newOpenTime);
		}
		if (day.equals("Tuesday")) {
			openingTimes.set(1, newOpenTime);
		}
		if (day.equals("Wednesday")) {
			openingTimes.set(2, newOpenTime);
		}
		if (day.equals("Thursday")) {
			openingTimes.set(3, newOpenTime);
		}
		if (day.equals("Friday")) {
			openingTimes.set(4, newOpenTime);
		}
		if (day.equals("Saturday")) {
			openingTimes.set(5, newOpenTime);
		}
		if (day.equals("Sunday")) {
			openingTimes.set(6, newOpenTime);
		}
	}
	
	public void updateClosingHours(String day, LocalTime newClosingTime) {
		if (day.equals("Monday")) {
			openingTimes.set(0, newClosingTime);
		}
		if (day.equals("Tuesday")) {
			openingTimes.set(1, newClosingTime);
		}
		if (day.equals("Wednesday")) {
			openingTimes.set(2, newClosingTime);
		}
		if (day.equals("Thursday")) {
			openingTimes.set(3, newClosingTime);
		}
		if (day.equals("Friday")) {
			openingTimes.set(4, newClosingTime);
		}
		if (day.equals("Saturday")) {
			openingTimes.set(5, newClosingTime);
		}
		if (day.equals("Sunday")) {
			openingTimes.set(6, newClosingTime);
		}
	}
	
	
	// Getters
	
	public String returnName() {
		return name;
	}
	
	public String returnAddress() {
		return address;
	}
	
	public long returnPhoneNumber() {
		return phoneNumber;
	}
	
	public LocalTime returnOpeningHours(String day) {
		if (day.equals("Monday")) {
			return openingTimes.get(0);
		}
		if (day.equals("Tuesday")) {
			return openingTimes.get(1);
		}
		if (day.equals("Wednesday")) {
			return openingTimes.get(2);
		}
		if (day.equals("Thursday")) {
			return openingTimes.get(3);
		}
		if (day.equals("Friday")) {
			return openingTimes.get(4);
		}
		if (day.equals("Saturday")) {
			return openingTimes.get(5);
		}
		if (day.equals("Sunday")) {
			return openingTimes.get(6);
		}
		return LocalTime.of(0, 0);
	}
	
	public LocalTime returnClosingHours(String day) {
		if (day.equals("Monday")) {
			return closingTimes.get(0);
		}
		if (day.equals("Tuesday")) {
			return closingTimes.get(1);
		}
		if (day.equals("Wednesday")) {
			return closingTimes.get(2);
		}
		if (day.equals("Thursday")) {
			return closingTimes.get(3);
		}
		if (day.equals("Friday")) {
			return closingTimes.get(4);
		}
		if (day.equals("Saturday")) {
			return closingTimes.get(5);
		}
		if (day.equals("Sunday")) {
			return closingTimes.get(6);
		}
		return LocalTime.of(0, 0);
	}

}
