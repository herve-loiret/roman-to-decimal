package fr.herveloiret.roman.converter.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;

public class ConverterCommandTest {

	private final JLineShellComponent shell;

	public ConverterCommandTest() {
		Bootstrap bootstrap = new Bootstrap();
		shell = bootstrap.getJLineShellComponent();
	}

	@Test
	public void should_convert_negative_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(-3));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("-III");
	}

	@Test
	public void should_return_error_message_when_decimal_more_than_5000() {
		CommandResult comandResult = shell.executeCommand(generateCommand(5_001));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult())
				.isEqualTo("this converter doesn't handle number higher or equals than 5000");
	}

	@Test
	public void should_return_error_message_when_decimal_is_not_numeric() {
		CommandResult comandResult = shell.executeCommand("convert --decimal dsfdsf");

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult())
				.isEqualTo("the value dsfdsf you specified is not a numeric");
	}

	@Test
	public void should_convert_1_value() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("I");
	}

	@Test
	public void should_convert_1991_value() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1991));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MCMXCI");
	}

	@Test
	public void should_convert_2548_value() {
		CommandResult comandResult = shell.executeCommand(generateCommand(2548));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MMDXLVIII");
	}
	
	@Test
	public void should_convert_3773_value() {
		CommandResult comandResult = shell.executeCommand(generateCommand(3773));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MMMDCCLXXIII");
	}
	

	@Test
	public void should_convert_4429_value() {
		CommandResult comandResult = shell.executeCommand(generateCommand(4429));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MMMMCDXXIX");
	}
	

	@Test
	public void should_convert_329_value() {
		CommandResult comandResult = shell.executeCommand(generateCommand(329));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("CCCXXIX");
	}

	@Test
	public void should_convert_null_values() {
		CommandResult commandResult = shell.executeCommand(generateCommand(0));

		assertThat(commandResult.isSuccess()).isTrue();
		assertThat(commandResult.getResult()).isEqualTo("nulla");
	}

	private String generateCommand(int decimal) {
		return "convert --decimal " + decimal;
	}

}
