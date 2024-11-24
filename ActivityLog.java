import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ActivityLog {

	String filePath = "ActivityLog.csv";
	String[] headers = {"Date", "Time", "Activity", "Account ID", "Inventory ID", "Transaction ID", "Price", "Drug", "Quantity", "Tablet/Capsule", "Card Number", "Card Expiration", "Pin"};
	
	enum Activity {AccountUpdate, InventoryUpdate, Transaction};
	
	public void AddActivity () {
		
	}
	
}