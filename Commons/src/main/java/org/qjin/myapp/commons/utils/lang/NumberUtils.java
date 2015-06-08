package org.qjin.myapp.commons.utils.lang;

public class NumberUtils extends org.apache.commons.lang.math.NumberUtils {
	public static boolean equals(Integer source, Integer target){
		return source == null ? target == null : source.equals(target);
	}
}
