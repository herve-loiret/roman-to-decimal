package fr.herveloiret.roman.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

@Component
public class ConverterCommand implements CommandMarker {

	private ConverterService converterService;

	@Autowired
	public ConverterCommand(ConverterService converterService) {
		this.converterService = converterService;
	}

	@CliAvailabilityIndicator({ "translate" })
	public boolean isSimpleAvailable() {
		return true;
	}

	@CliCommand(value = "translate", help = "translate from number roman to decimal")
	public String translateRomanToDecimal() {
		String result = "";

		return result;
	}

}
