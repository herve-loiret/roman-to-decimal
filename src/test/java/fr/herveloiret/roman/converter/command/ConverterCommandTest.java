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
	public void should_convert_positive_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1003));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MIII");
	}

	@Test
	public void should_convert_1_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("I");
	}

	@Test
	public void should_convert_4_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(4));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("IV");
	}

	@Test
	public void should_convert_1954_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1954));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MCMLIV");
	}

	@Test
	public void should_convert_1980_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1980));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MCMLXXX");
	}

	@Test
	public void should_convert_3000_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(3000));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MMM");
	}

	@Test
	public void should_convert_1900_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1900));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MCM");
	}

	@Test
	public void should_convert_1800_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1800));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MDCCC");
	}

	@Test
	public void should_convert_1990_values() {
		CommandResult comandResult = shell.executeCommand(generateCommand(1990));

		assertThat(comandResult.isSuccess()).isTrue();
		assertThat(comandResult.getResult()).isEqualTo("MCMXC");
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
