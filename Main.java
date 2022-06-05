import java.util.*;
import java.time.*;

public class Main {

	static Object[][] months = {{"January", 31}, {"Febuary", 28}, {"March", 31}, {"April", 30}, 
							{"May", 31}, {"June", 30}, {"July", 31}, {"August", 31}, 
							{"September", 30}, {"October", 31}, {"November", 30}, 
							{"December", 31}};

	public static void main(String args[]) {
		KafkaCalc cal = new KafkaCalc(months);

		cal.getAll();
	}
}