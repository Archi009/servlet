package api;

import java.util.Calendar;
import java.util.Date;

/*
 * String 메서드 indexOf
 * Date, LocalDate, Calender
 * List
 * Set
 * Map
 */
public class StringUtil {
	//문자형 날자에서 년도만 월
	public static String getYear(String data) {
	
		return data.substring(0, 4);
		 
	}
	public static String getMonth(String data)
	{
		return data.substring(4,6);
	}
	
	
	public static String getYear(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return String.valueOf(calendar.get(Calendar.YEAR)); 
	}
	public static void main(String[] args) {
		System.out.println( StringUtil.getYear("20220408"));
		System.out.println( StringUtil.getMonth("20220408"));
		System.out.println( StringUtil.getYear(new Date()));
	
	}
}
