package br.edu.utfpr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.AbstractBeanField;

public class LocalDateConverter extends AbstractBeanField<String, LocalDate> {

	@Override
	protected LocalDate convert(String value) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(value, dateTimeFormatter);
	}
}
