/**
 * 
 */
package org.mkko.data;

/**
 * @author mkokott
 *
 */
public class ConverterResponse {

	private final String romanNumber;
	private final String arabicNumber;

	public ConverterResponse(String romanNumber, String arabicNumber) {
		this.romanNumber = romanNumber;
		this.arabicNumber = arabicNumber;
	}

	public String getRomanNumber() {
		return romanNumber;
	}

	public String getArabicNumber() {
		return arabicNumber;
	}
}
