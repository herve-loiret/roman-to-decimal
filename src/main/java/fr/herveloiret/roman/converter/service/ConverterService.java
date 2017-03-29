package fr.herveloiret.roman.converter.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

	private static final String[] ROMAN = { "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	public String convertDecimalToRoman(Long decimal) {

		if (decimal == null || decimal == 0) {
			return "nulla";
		}

		StringBuilder roman = new StringBuilder();

		if (decimal < 0) {
			decimal *= -1;
			roman.append("-");
		}

		while (decimal >= 1000) {
			roman.append("M");
			decimal -= 1000;
		}

		// here decimal < 1000

		if (decimal >= 900) {
			roman.append("CM");
			decimal -= 900;
		}

		if (decimal >= 500) {
			roman.append("D");
			long numberOfC = (decimal - 500) / 100;
			for (int i = 0; i < numberOfC; i++) {
				roman.append("C");
			}
			decimal -= 500 + 100 * numberOfC;
		}

		if (decimal >= 400) {
			roman.append("CD");
			decimal -= 400;
		}

		while (decimal >= 100) {
			roman.append("C");
			decimal -= 100;
		}

		// here decimal < 100

		if (decimal >= 90) {
			roman.append("XC");
			decimal -= 90;
		}

		if (decimal >= 50) {
			roman.append("L");
			long numberOfX = (decimal - 50) / 10;
			for (int i = 0; i < numberOfX; i++) {
				roman.append("X");
			}
			decimal -= 50 + 10 * numberOfX;
		}

		if (decimal >= 40) {
			roman.append("XL");
			decimal -= 40;
		}

		while (decimal >= 10) {
			roman.append("X");
			decimal -= 10;
		}

		// here decimal < 10
		if (decimal > 0) {
			// i used a tab here because i think the low number of possibilities
			// doesn't worth the computing cost
			roman.append(ROMAN[decimal.intValue()]);
		}

		return roman.toString();
	}
}
