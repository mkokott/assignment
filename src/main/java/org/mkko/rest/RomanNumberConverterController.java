package org.mkko.rest;

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
	public @ResponseBody String convertRomanNumber(@PathVariable String romanNumber) {

		try {
			return "" + RomanNumbersConverter.convertToArabicNumber(romanNumber);
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
	}
}
