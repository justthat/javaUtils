package org.qjin.myapp.commons.utils.lang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * DATE FORMAT yyyyMMddHHmmss
	 */
	public static final SimpleDateFormat KEY_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat KEY_FORMAT_SPLIT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Calendar getCalendar(){
		return Calendar.getInstance();
	}
	
	public static Calendar getCalendar(String day, String format){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDate(day, format));
		return cal;
	}
	
	public static Date getDate(String str, String dateFormat){
		Date date = null;
		try{
			if((str == null) || (str.length() != dateFormat.length())){
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setLenient(false);
			try{
				date = sdf.parse(str);
			}catch(ParseException pe){
				date = new Date();
			}
		}catch(Exception e){
			date = new Date();
		}
		
		return date;
	}
	
	public static Date getDate(){
		return new Date();
	}
	
	public static String getDate2String(Date date, String format){
		if(date != null){
			DateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		}
		return null;
	}
	
	public static String getToday(String format){
		return getDate2String(getDate(), format);
	}
	
	public static long getDateTomillsec(String date){
		if(date.length() < 14)
			return 0;
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
		cal.set(Calendar.MONTH, Integer.parseInt(date.substring(4, 6)) -1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(6, 8)));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(8, 10)));
		cal.set(Calendar.MINUTE, Integer.parseInt(date.substring(10, 12)));
		cal.set(Calendar.SECOND, Integer.parseInt(date.substring(12, 14)));
		
		return cal.getTimeInMillis();
	}
	
	/**
	 * Millsec으로 받은 시간데이터를 String으로 변환한다.
	 * @param millsec time long value
	 * @return KEY_FORMAT
	 */
	public static String getMillsecToDate(long millsec){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millsec);
		return KEY_FORMAT_SPLIT.format(cal.getTime());
	}
	
	public static boolean atBetween(Date date, String beginDateStr, String endDateStr){
		if(beginDateStr == null || endDateStr == null){
			return true;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date endDate;
		
		try{
			beginDate = formatter.parse(beginDateStr);
			endDate = formatter.parse(endDateStr);
		}catch(ParseException pe){
			pe.printStackTrace();
			return true;
		}
		
		if(beginDate != null && date.before(beginDate)){
			return false;
		}
		if(endDate != null){
			endDate = org.apache.commons.lang.time.DateUtils.addDays(endDate, 1);
			if(date.after(endDate) || date.equals(endDate)){
				return false;
			}
		}
		return true;
		
	}
}
