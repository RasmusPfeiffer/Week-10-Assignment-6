package sales;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Sales {

	// defining Sales Object
	private LocalDate tTime;
	private Integer iSales;

	
	public Sales (LocalDate tTime, Integer iSales) {
		this.tTime = tTime;
		this.iSales = iSales;
	}
	public Integer getiSales() {
		return iSales;
	}
	public void setiSales(Integer iSales) {
		this.iSales = iSales;
	}
	// Modified getTime method to return a String with the Date without the day
	public String gettTime() {
		DateTimeFormatter oFormatter = DateTimeFormatter.ofPattern("yyyy-LL", Locale.ENGLISH);
		String sDate = tTime.format(oFormatter);
		return sDate;
	}
	// Modified getYear getter Method to return the year as an Integer
	public Integer getYear() {
		DateTimeFormatter oFormatter = DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH);
		String sDate = tTime.format(oFormatter);
		Integer iYear = Integer.parseInt(sDate);
		return iYear;
	}
	public void settTime(LocalDate tTime) {
		this.tTime = tTime;
	}
	
}
