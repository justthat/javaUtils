package org.qjin.myapp.commons.utils.lang;

import java.util.Arrays;
import java.util.List;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	public static String defaultIfEmpty(Integer wIntValue, String defaultValue){
		return isEmpty(wIntValue) == true ? defaultValue : String.valueOf(wIntValue);
	}
	
	public static int getLengthIfNull(String value){
		return value == null ? 0 : value.length();
	}
	
	public static boolean isEmpty(Integer wIntValue){
		return wIntValue == null ? true : false;
	}
	
	public static boolean isNotEmpty(Integer wIntValue){
		return isEmpty(wIntValue) == false ? true: false;
	}
	
	public static boolean isNotEmptyAndNotEquals(String source, String target){
		return isNotEmpty(source) && notEquals(source, target);
	}
	
	public static boolean notEquals(String source, String target){
		return !equals(source, target);
	}
	
	/*public static boolean  isEmail(String value){
		return EmailValidator.getInstance().isValid(value);
	}*/
	
	/*public static boolean isDomain(String value){
		return DomainValidator.getInstance().isValid(value);
	}*/
	
	/*public static boolean isIpAddress(String value){
		return InetAddressValidator.getInstance().isValid(value);
	}*/
	
	public static List<String> splitAsList(String str, String separatorChars){
		return Arrays.asList(StringUtils.split(str, separatorChars));
	}
	
	public static String[] splitAndLowerCase(String str, String separatorChars){
		return StringUtils.split(StringUtils.lowerCase(str), separatorChars);
	}
	
	/*public boolean isInRange(Integer value, Integer min, Integer max){
		return IntegerValidator.getInstance().isInRange(value, min, max);
	}*/
}
