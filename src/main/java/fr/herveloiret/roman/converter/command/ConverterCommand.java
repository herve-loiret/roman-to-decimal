package fr.herveloiret.roman.converter.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import fr.herveloiret.roman.converter.service.ConverterService;

@Component
public class ConverterCommand implements CommandMarker {

	private ConverterService converterService;

	@Autowired
	public ConverterCommand(ConverterService converterService) {
		this.converterService = converterService;
	}

	@CliAvailabilityIndicator({ "convert" })
	public boolean isSimpleAvailable() {
		return true;
	}

	@CliCommand(value = "convert", help = "convert from decimal to roman decimal")
	public String translateDecimalToRoman(
			@CliOption(key = {
					"decimal" }, mandatory = true, help = "The decimal value to convert") final String decimal) {

		Long decimalLong = null;
		try {
			decimalLong = Long.valueOf(decimal);
		} catch (NumberFormatException e) {
			throw new RuntimeException("the value " + decimal + " you specified is not a numeric");
		}

		if (decimalLong >= 5000 || decimalLong <= -5000) {
			throw new RuntimeException("this converter doesn't handle number higher or equals than 5000");
		}

		return converterService.convertDecimalToRoman(decimalLong);
	}

}
