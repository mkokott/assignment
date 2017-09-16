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
	private final boolean valid;

	public ConverterResponse(String romanNumber, String arabicNumber, boolean valid) {
		this.romanNumber = romanNumber;
		this.arabicNumber = arabicNumber;
		this.valid = valid;
	}

	public String getRomanNumber() {
		return romanNumber;
	}

	public String getArabicNumber() {
		return arabicNumber;
	}

	public boolean isValid() {
		return this.valid;
	}
}
