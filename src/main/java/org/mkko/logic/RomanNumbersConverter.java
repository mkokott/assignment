/**
 * 
 */
package org.mkko.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.mkko.data.RomanDigits;

/**
 * @author mkokott
 *
 */
public class RomanNumbersConverter {

	/**
	 * array contains all six special cases for subtraction rule (i.e. IV
	 * instead of IIII)
	 */
	private static final String[] substractionRuleDigits = new String[] { "IV", "IX", "XL", "XC", "CD", "CM" };

	/**
	 * regular expression to validate a Roman number with subtraction rule (i.e.
	 * MIIII is invalid and must be written MIV). see
	 * https://www.safaribooksonline.com/library/view/regular-expressions-cookbook/9780596802837/ch06s09.html
	 * for details.
	 */
	private static final String validationRegex = "^(?=[MDCLXVI])M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";

	/**
	 * converts a Roman number to its value as Arabic number.
	 * 
	 * @param romanNumber
	 * @return the Roman number's value as Arabic number.
	 * @throws {@link
	 *             IllegalArgumentException} if the given Roman number is not
	 *             valid.
	 */
	public static long convertToArabicNumber(String romanNumber) throws IllegalArgumentException {

		romanNumber = romanNumber.toUpperCase(Locale.UK);

		if (!isValidRomanNumber(romanNumber))
			throw new IllegalArgumentException(romanNumber + " is not a valid roman number.");

		long arabicNumber = 0;
		for (String digit : splitDigits(romanNumber))
			arabicNumber += resolveSingleRomanDigit(digit);

		return arabicNumber;
	}

	private static boolean isValidRomanNumber(String romanNumber) {

		return romanNumber.matches(validationRegex);
	}

	/**
	 * return the single Roman digits (i.e. IV, X, C, etc.) from a given Roman
	 * number as list.
	 * 
	 * @param romanNumber
	 * @return
	 */
	private static List<String> splitDigits(String romanNumber) {

		List<String> romanDigits = new ArrayList<String>();

		for (String digit : substractionRuleDigits) {

			if (romanNumber.contains(digit)) {
				romanDigits.add(digit);
				romanNumber = romanNumber.replace(digit, "");
			}
		}
		for (Character character : romanNumber.toCharArray())
			romanDigits.add(character.toString());

		return romanDigits;
	}

	/**
	 * returns the integer value of a given single Roman digit (i.e. actual
	 * single letter ones such as I or X but also valid subtraction rule digits
	 * such as IX or XL).
	 * 
	 * @param singleDigit
	 * @return
	 */
	private static int resolveSingleRomanDigit(String singleDigit) {

		return RomanDigits.getValue(singleDigit);
	}
}
