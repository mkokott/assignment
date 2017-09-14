/**
 * 
 */
package org.mkko.data;

import java.util.Map;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

/**
 * @author mkokott
 *
 */
public class RomanDigits {

	private static final Map<String, Integer> romanDigits;
	static {
		romanDigits = new CaseInsensitiveMap<>();
		romanDigits.put("I", 1);
		romanDigits.put("IV", 4);
		romanDigits.put("V", 5);
		romanDigits.put("IX", 9);
		romanDigits.put("X", 10);
		romanDigits.put("XL", 40);
		romanDigits.put("L", 50);
		romanDigits.put("XC", 90);
		romanDigits.put("C", 100);
		romanDigits.put("CD", 400);
		romanDigits.put("D", 500);
		romanDigits.put("CM", 900);
		romanDigits.put("M", 1000);
	}

	public static Integer getValue(String romanDigit) throws IllegalArgumentException {

		if (!romanDigits.containsKey(romanDigit))
			throw new IllegalArgumentException(romanDigit + " is not a valid roman digit.");

		return romanDigits.get(romanDigit);
	}
}