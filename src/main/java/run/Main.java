package run;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

import service.DataService;
import utils.FormatDate;

public class Main {
	public static void main(String[] args) throws IOException {
		new DataService().saveFile();
	}
}