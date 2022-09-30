package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Lottery;

public class WriteFileCSV {
	public static void write(String dirSource, ArrayList<Lottery> lotteries) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dirSource)))) {
			bw.write("Company");
			bw.write(",");
			bw.write("Province");
			bw.write(",");
			bw.write("Issue Date");
			bw.write(",");
			bw.write("Prize 0");
			bw.write(",");
			bw.write("Prize 1");
			bw.write(",");
			bw.write("Prize 2");
			bw.write(",");
			bw.write("Prize 3");
			bw.write(",");
			bw.write("Prize 4");
			bw.write(",");
			bw.write("Prize 5");
			bw.write(",");
			bw.write("Prize 6");
			bw.write(",");
			bw.write("Prize 7");
			bw.write(",");
			bw.write("Prize 8");
			bw.newLine();
			for (Lottery lottery : lotteries) {
				bw.write(lottery.getCompany());
				bw.write(",");
				bw.write(lottery.getProvince());
				bw.write(",");
				bw.write(lottery.getRelaseDate());
				bw.write(",");
				bw.write(lottery.getPrize0());
				bw.write(",");
				bw.write(lottery.getPrize1());
				bw.write(",");
				bw.write(lottery.getPrize2());
				bw.write(",");
				bw.write(lottery.getPrize3());
				bw.write(",");
				bw.write(lottery.getPrize4());
				bw.write(",");
				bw.write(lottery.getPrize5());
				bw.write(",");
				bw.write(lottery.getPrize6());
				bw.write(",");
				bw.write(lottery.getPrize7());
				bw.write(",");
				bw.write(lottery.getPrize8());
				bw.newLine();
				;
			}
		}
		System.out.println("[MESSAGE]: Write success");

	}
}
