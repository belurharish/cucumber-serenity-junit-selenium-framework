package commonUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Util {
	public static LocalDate dateNow=LocalDate.now(ZoneOffset.UTC);
	
	public static DateTimeFormatter datetimeFormatter =DateTimeFormatter.ofPattern("MMM dd yyyy");
	
	/**
	 * Get the ordinal of the date like 'th, st, rd' etc
	 * @author Harisha.P
	 * @param number
	 * @return ordinal string
	 */
	public static String getDateOrdinal(int number) {
	    switch( (number<20) ? number : number%10 ) {
	        case 1 : return "st";
	        case 2 : return "nd";
	        case 3 : return "rd";
	        default : return "th";
	    }
	}
	
	/**
	 * Get date in 'Apr 5th 19' format by passing the date
	 * @author Harisha.P
	 * @param date
	 * @return formatted date
	 */
	public static String getDate(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("MMM d'"+getDateOrdinal(date.getDayOfMonth())+"' yy"));
	}
	
	/**
	 * Get the previous working day of the week
	 * @author Harisha.P
	 * @param date
	 * @return LocalDate
	 */
	public static LocalDate getPreviousWorkingDay(LocalDate date) {
		DayOfWeek dayOfWeek = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
		switch (dayOfWeek) {
		case MONDAY:
			return date.minus(3, ChronoUnit.DAYS);
		case SUNDAY:
			return date.minus(2, ChronoUnit.DAYS);
		default:
			return date.minus(1, ChronoUnit.DAYS);
		}
	}
}
