package fileService;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import sales.Sales;

public class FileService {

	/* 
	 * reading file via BufferedReader(oReader)
	 * splitting string from csv file by ,
	 * parsing sales from string to integer (iSales)
	 * Manipulating String for date and parse it into LocalDate wrapper via formatter defined in oFormatter
	 * (sModDate -> oDate)
	 * giving localdate(oDate) and sales(iSales) data into oSales object
	 * add oSales to list
	 * close oReader
	*/
	
	public List<Sales> fileReader(String sFilename, List<Sales> listName) throws IOException {
		BufferedReader oReader = null;
		DateTimeFormatter oFormatter = null;
		try {
			oReader = new BufferedReader(new FileReader(sFilename));
			oFormatter = DateTimeFormatter.ofPattern("dd LLL yyyy", Locale.ENGLISH);
			String sData;
			String sHeader;
			sHeader = oReader.readLine();
			while ((sData = oReader.readLine()) != null) {
				String[] aSplit = sData.split(",");
				Integer iSales = Integer.parseInt(aSplit[1]);
				String sModDate = aSplit[0];
				sModDate= sModDate.replace("-", " 20");
				sModDate = "01 " + sModDate;
				LocalDate oDate = LocalDate.parse(sModDate, oFormatter);
				Sales oSales = new Sales(oDate, iSales);
				listName.add(oSales);
			}
			return listName;
		} finally {
			if (oReader != null) {
				oReader.close();
			}
		}
	}
}
