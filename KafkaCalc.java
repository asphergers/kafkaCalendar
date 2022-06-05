import java.util.*;
import java.time.*;
public class KafkaCalc {
	private Object[][] months;
	private LocalDate today = LocalDate.now();

	public KafkaCalc(Object[][] months) {
		this.months = months;
	}

	public int getCurrentMonth() {
		return today.getMonthValue();
	}

	public int getCurrentDay() {
		return today.getDayOfMonth();
	}

	public int getBetween(int current, int past, int currentDate) {
		int difference = 0;
		for (int i = past; i<current-1; i++) {
			difference += (int)months[i][1];
		}

		return difference + currentDate;
	}

	public int getTill(int current, int future, int currentDate) {
		int difference = 0;
		for (int i = current-1; i<future; i++) {
			difference += (int)months[i][1];
		}

		return (difference - currentDate + 1) * -1;
	}

	public String getDate(int month) {
		int currentMonth = getCurrentMonth();
		int past = getBetween(getCurrentMonth(), month-1, getCurrentDay()) * ((month<=getCurrentMonth()?1:0));
		int future = getTill(getCurrentMonth(), month-1, getCurrentDay()) * ((month>getCurrentMonth())?1:0);
		return months[month-1][0] + " " + (past + future);
	}

	public void getAll() {
		for (int i = 1; i<months.length+1; i++) {
			System.out.println(getDate(i));
		}
	}


}