package org.mkko.rest;

import org.mkko.data.ConverterResponse;
import org.mkko.logic.RomanNumbersConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mkokott
 *
 */
@Controller
@RequestMapping("/convert")
public class RomanNumberConverterController {

	@RequestMapping(method = RequestMethod.GET, value = "/{romanNumber}")
	public @ResponseBody ConverterResponse convertRomanNumber(@PathVariable String romanNumber) {

		String arabicNumber = "";

		try {
			arabicNumber += RomanNumbersConverter.convertToArabicNumber(romanNumber);
		} catch (IllegalArgumentException e) {
			arabicNumber += e.getMessage();
		}
		return new ConverterResponse(romanNumber, arabicNumber);
	}
}
