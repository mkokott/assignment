package org.mkko.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mkko.data.ConverterResponse;
import org.mkko.logic.RomanNumbersConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller that serves rest endpoints of the backend component.
 * 
 * @author mkokott
 *
 */
@Controller
@RequestMapping("/convert")
public class RomanNumberConverterController {

	private static final Logger logger = LogManager.getLogger(RomanNumberConverterController.class);

	/**
	 * GET on /convert/{romanNumber} returns the Arabic representation of a
	 * given {romanNumber}.
	 * 
	 * @param romanNumber
	 *            in subtraction syntax (i.e. IX instead of VIIII).
	 * @return JSON array of {@link ConverterResponse} with Arabic
	 *         representation of a Roman number an error message if the input
	 *         value is not a valid Roman number.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{romanNumber}")
	public @ResponseBody ConverterResponse convertRomanNumber(@PathVariable String romanNumber) {

		logger.info("converter called with argument " + romanNumber);
		String arabicNumber = "";
		boolean valid = true;

		try {
			arabicNumber += RomanNumbersConverter.convertToArabicNumber(romanNumber);
		} catch (IllegalArgumentException e) {
			valid = false;
			arabicNumber += e.getMessage();
		}
		return new ConverterResponse(romanNumber, arabicNumber, valid);
	}
}
