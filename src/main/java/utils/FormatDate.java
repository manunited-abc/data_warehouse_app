package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {
	public static void main(String[] args) {
		System.out.println(convertDateToString(LocalDateTime.now()));
	}
	public static String convertDateToString(LocalDateTime date) {
		DateTimeFormatter fmDateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return date.format(fmDateTimeFormatter);
	}
}
