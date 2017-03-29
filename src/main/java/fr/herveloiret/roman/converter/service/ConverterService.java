package fr.herveloiret.roman.converter.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

	public String convertDecimalToRoman(Long decimal) {

		if (decimal == null || decimal == 0) {
			return "nulla";
		}

		String roman = "";

		return roman;
	}
}
