package extract;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.ConnectDatabase;
import mapper.ConfigMapper;
import model.Config;
import model.Lottery;
import utils.Contanst;
import utils.FormatDate;

public class ExtractContent {
	ConnectDatabase connectDatabase;
	List<Config> configs;

	public ExtractContent() {
		connectDatabase = new ConnectDatabase();
		configs = connectDatabase.query("select * from file_configuration", new ConfigMapper());
	}

	public String getUrl() {
		return configs.get(0).getSouceDate();
	}

	public int getIdUrl() {
		return configs.get(0).getId();
	}

	public ArrayList<Lottery> extract1(LocalDateTime releaseDate) {
		try {
			String url = getUrl();
			ArrayList<Lottery> lotteriesNorth = extractContentHTML2(url + "/xsmb-xo-so-mien-bac-ngay", releaseDate);
			ArrayList<Lottery> lotteriesSouth = extractContentHTML1(url + "/xsmn-xo-so-mien-nam-ngay", releaseDate);
			ArrayList<Lottery> lotteriesCentral = extractContentHTML1(url + "/xsmt-xo-so-mien-trung-ngay", releaseDate);
			ArrayList<Lottery> result = new ArrayList<>();
			result.addAll(lotteriesNorth);
			result.addAll(lotteriesSouth);
			result.addAll(lotteriesCentral);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Lottery> extractContentHTML1(String url, LocalDateTime releaseDate) throws IOException {
		int year = releaseDate.getYear();
		int month = releaseDate.getMonthValue();
		int day = releaseDate.getDayOfMonth();
		if (releaseDate.isBefore(LocalDateTime.of(year, month, day, 17, 10, 00, 00))) {
			System.out.println("[WARRING]: Has not been issued");
			releaseDate.minusDays(1);
		}
		String dateString = FormatDate.convertDateToString(releaseDate);
		System.out.println(dateString);
		String fullUrl = url + "-" + dateString;
		Document document = Jsoup.connect(fullUrl).get();
		Element tableParent = document.getElementsByClass("table-tructiep").first();
		Element header = tableParent.getElementsByClass("result-header").first();

		String company = header.getElementsByTag("a").first().text();
		Element tableResult = tableParent.getElementsByClass("table").first();
		Element thead = tableResult.getElementsByTag("thead").first();
		Element tbody = tableResult.getElementsByTag("tbody").first();

		Elements provinces = thead.getElementsByTag("th");
		int size = provinces.size();
		ArrayList<Lottery> lotteries = new ArrayList<>();
		for (int i = 1; i < size; i++) {
			Lottery lottery = new Lottery();
			lottery.setCompany(company);
			lottery.setProvince(provinces.get(i).text());
			lottery.setRelaseDate(dateString);
			// Get value pize 8
			lottery.setPrize8(getSerial(i, tbody, 0));
			// Get value pize 7
			lottery.setPrize7(getSerial(i, tbody, 1));
			// Get value pize 6
			lottery.setPrize6(getSerial(i, tbody, 2));
			// Get value pize 5
			lottery.setPrize5(getSerial(i, tbody, 3));
			// Get value pize 4
			lottery.setPrize4(getSerial(i, tbody, 4));
			// Get value pize 3
			lottery.setPrize3(getSerial(i, tbody, 5));
			// Get value pize 2
			lottery.setPrize2(getSerial(i, tbody, 6));
			// Get value pize 1
			lottery.setPrize1(getSerial(i, tbody, 7));
			// Get value pize 0
			lottery.setPrize0(getSerial(i, tbody, 8));

			lotteries.add(lottery);
		}
		return lotteries;
	}

	public String getSerial(int index, Element elementParent, int i) {
		Element trowElements = elementParent.getElementsByTag("tr").get(i);
		Elements serialsElementsPrize = trowElements.getElementsByTag("td").get(index).children();
		ArrayList<String> serialListPrize = new ArrayList<>();
		for (Element serialElement : serialsElementsPrize) {
			serialListPrize.add(serialElement.text());
		}
		String serialPrize = String.join("-", serialListPrize);
		return serialPrize;
	}

	public ArrayList<Lottery> extractContentHTML2(String url, LocalDateTime releaseDate) throws IOException {
		int year = releaseDate.getYear();
		int month = releaseDate.getMonthValue();
		int day = releaseDate.getDayOfMonth();
		if (releaseDate.isBefore(LocalDateTime.of(year, month, day, 17, 10, 00, 00))) {
			System.out.println("chua so");
			releaseDate.minusDays(1);
		}
		String dateString = FormatDate.convertDateToString(releaseDate);
		System.out.println(dateString);
		String fullUrl = url + "-" + dateString;
		Document document = Jsoup.connect(fullUrl).get();
		Element tableParent = document.getElementsByClass("result-box").first();
		Element header = tableParent.getElementsByClass("result-header").first();

		String company = header.getElementsByTag("a").first().text();
		Element tableResult = tableParent.getElementsByTag("table").first();
		// Element thead = tableResult.getElementsByTag("thead").first();
		Element tbody = tableResult.getElementsByTag("tbody").first();

		// Elements provinces = thead.getElementsByTag("th");
		ArrayList<Lottery> lotteries = new ArrayList<>();
		Lottery lottery = new Lottery();
		lottery.setCompany(company);
		lottery.setProvince("Miền Bắc");
		lottery.setRelaseDate(dateString);
		// Get value pize 8
		lottery.setPrize8("");
		// Get value pize 7
		lottery.setPrize7(getSerial2(tbody, 8));
		// Get value pize 6
		lottery.setPrize6(getSerial2(tbody, 7));
		// Get value pize 5
		lottery.setPrize5(getSerial2(tbody, 6));
		// Get value pize 4
		lottery.setPrize4(getSerial2(tbody, 5));
		// Get value pize 3
		lottery.setPrize3(getSerial2(tbody, 4));
		// Get value pize 2
		lottery.setPrize2(getSerial2(tbody, 3));
		// Get value pize 1
		lottery.setPrize1(getSerial2(tbody, 2));
		// Get value pize 0
		lottery.setPrize0(getSerial2(tbody, 1));

		lotteries.add(lottery);

		return lotteries;

	}

	public String getSerial2(Element elementParent, int i) {
		Element trowElements = elementParent.getElementsByTag("tr").get(i);
		Elements serialsElementsPrize = trowElements.getElementsByTag("span");
		ArrayList<String> serialListPrize = new ArrayList<>();
		for (Element serialElement : serialsElementsPrize) {
			serialListPrize.add(serialElement.text());
		}
		String serialPrize = String.join("-", serialListPrize);
		return serialPrize;
	}
}
