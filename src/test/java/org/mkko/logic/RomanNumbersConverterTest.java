package org.mkko.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mkokott
 *
 */
public class RomanNumbersConverterTest {

	@Test
	public void convertsExamplesFromAssignmentCorrectly() {

		String _1999 = "MCMXCIX";
		String _15 = "XV";
		Assert.assertEquals(1999, RomanNumbersConverter.convertToArabicNumber(_1999));
		Assert.assertEquals(15, RomanNumbersConverter.convertToArabicNumber(_15));
	}

	@Test
	public void convertsAllSingleRomanDigitsCorrectly() {

		Assert.assertEquals(1, RomanNumbersConverter.convertToArabicNumber("I"));
		Assert.assertEquals(4, RomanNumbersConverter.convertToArabicNumber("IV"));
		Assert.assertEquals(5, RomanNumbersConverter.convertToArabicNumber("V"));
		Assert.assertEquals(9, RomanNumbersConverter.convertToArabicNumber("IX"));
		Assert.assertEquals(10, RomanNumbersConverter.convertToArabicNumber("X"));
		Assert.assertEquals(40, RomanNumbersConverter.convertToArabicNumber("XL"));
		Assert.assertEquals(50, RomanNumbersConverter.convertToArabicNumber("L"));
		Assert.assertEquals(90, RomanNumbersConverter.convertToArabicNumber("XC"));
		Assert.assertEquals(100, RomanNumbersConverter.convertToArabicNumber("C"));
		Assert.assertEquals(400, RomanNumbersConverter.convertToArabicNumber("CD"));
		Assert.assertEquals(500, RomanNumbersConverter.convertToArabicNumber("D"));
		Assert.assertEquals(900, RomanNumbersConverter.convertToArabicNumber("CM"));
		Assert.assertEquals(1000, RomanNumbersConverter.convertToArabicNumber("M"));
	}

	@Test
	public void convertsSimpleCaseWithoutSubstractionRuleCorrectly() {

		String _3 = "III";
		Assert.assertEquals(3, RomanNumbersConverter.convertToArabicNumber(_3));
	}

	@Test
	public void convertsSimpleCaseWithSubstractionRuleCorrectly() {

		String _14 = "XIV";
		Assert.assertEquals(14, RomanNumbersConverter.convertToArabicNumber(_14));
	}

	@Test
	public void converterIsCaseInsensitive() {

		Assert.assertEquals(1, RomanNumbersConverter.convertToArabicNumber("i"));
		Assert.assertEquals(1, RomanNumbersConverter.convertToArabicNumber("I"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void simpleRuleSyntaxIsNotAllowed() {

		String invalidRomanNumber = "MIIX";
		Assert.assertTrue(RomanNumbersConverter.convertToArabicNumber(invalidRomanNumber) > 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyStringThrowsIllegalArgumentException() {

		Assert.assertTrue(RomanNumbersConverter.convertToArabicNumber("") > 0);
	}
}
