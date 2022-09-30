package service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;



import dao.ConnectDatabase;
import extract.ExtractContent;
import io.WriteFileCSV;
import model.Lottery;
import utils.FormatDate;

public class DataService {
	ConnectDatabase connectDatabase;
	ExtractContent extractContent;
	public DataService() {
		connectDatabase = new ConnectDatabase();
		extractContent = new ExtractContent();
	}
	
	public void saveFile() {
		LocalDateTime date = LocalDateTime.now();
		String dateFormat = FormatDate.convertDateToString(date);
		String dirSource = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\data_lotteries."+dateFormat+"_datawarehouse-localhost.csv";
		String fileName  = "data_lotteries."+dateFormat+"_datawarehouse-localhost.csv";
		int idUrl = extractContent.getIdUrl();
		ArrayList<Lottery> lotteries = extractContent.extract1(date);
		if(lotteries!=null) {
			try {									
				WriteFileCSV.write(dirSource, lotteries);
				connectDatabase.insert("insert into `datawarehouse_db`.`file_log` (`id_config`, `date_crawl`, `file_name`, `status`) values(?,?,?,?)",idUrl,date.toString(),fileName,"SV");			
			} catch (IOException e) {
				connectDatabase.insert("insert into `datawarehouse_db`.`file_log` (`id_config`, `date_crawl`, `file_name`, `status`) values(?,?,?,?)",idUrl,date.toString(),fileName,"ERROR");						
				e.fillInStackTrace();
				
			}
		}
		

	}
}
