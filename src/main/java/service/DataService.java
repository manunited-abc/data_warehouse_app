package service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDatabase;
import extract.ExtractContent;
import extract.ExtractContent2;
import io.WriteFileCSV;
import model.Lottery;
import utils.FormatDate;

public class DataService {
	ConnectDatabase connectDatabase;
	ExtractContent2 extractContent;
	public DataService() throws IOException {
		connectDatabase = new ConnectDatabase();
		extractContent = new ExtractContent2();
	}
	
	public void saveFile() throws IOException {
		LocalDateTime date = LocalDateTime.now();
		String dateFormat = FormatDate.convertDateToString(date);
		String dirSource = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\data_lotteries."+dateFormat+"_datawarehouse-localhost.csv";
		String fileName  = "data_lotteries."+dateFormat+"_datawarehouse-localhost.csv";
		int idUrl = extractContent.getIdUrl();
		List<Lottery> lotteries = extractContent.extract();
		if(lotteries!=null) {
			try {									
				WriteFileCSV.write(dirSource, lotteries);
				connectDatabase.insert("insert into `datawarehouse_db`.`file_log` (`id_config`, `date_crawl`, `file_name`, `status`) values(?,?,?,?)",idUrl,date.toString(),fileName,"ER");			
			} catch (IOException e) {
				connectDatabase.insert("insert into `datawarehouse_db`.`file_log` (`id_config`, `date_crawl`, `file_name`, `status`) values(?,?,?,?)",idUrl,date.toString(),fileName,"ERROR");						
				e.fillInStackTrace();
				
			}
		}
		

	}
}
