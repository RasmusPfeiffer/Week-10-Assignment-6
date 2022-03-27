package dataService;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sales.Sales;

public class DataService {

	public void groupByYear(List<Sales> listName, String sModel) {
		
		/* 
		 * calling header method to print header
		 * Grouping List<Sales> into map with Integer(year,key) and IntSummaryStatistics(Sales,value)
		 * printing getSum for every key(Year) with forEach method
		 * fetching best and worst month from highestSales and lowestSales methods
		*/
		
		System.out.println(header(sModel));
		Map<Integer, IntSummaryStatistics> mSalesPerYear = 
		listName.stream()
				.collect(Collectors.groupingBy(Sales::getYear, Collectors.summarizingInt(Sales::getiSales)));
		mSalesPerYear.forEach((k, v) -> System.out.println(k + " -> " + v.getSum()));
		this.highestSales(listName, sModel);
		this.lowestSales(listName, sModel);
	}

	public void highestSales(List<Sales> listName, String sModel) {
		// finding highest Sale
		Optional<Sales> bestMonthOpt = listName.stream().max(Comparator.comparing(Sales::getiSales));
		bestMonthOpt
				.ifPresent(oSales -> System.out.println("The best Month for " + sModel + "was " + oSales.gettTime()));
	}

	public void lowestSales(List<Sales> listName, String sModel) {
		// finding lowest Sale
		Optional<Sales> worstMonthOpt = listName.stream().min(Comparator.comparing(Sales::getiSales));
		worstMonthOpt
				.ifPresent(oSales -> System.out.println("The worst Month for " + sModel + "was " + oSales.gettTime()));
	}

	public String header(String sModel) {
		// defining header output
		String sHeader = "\n" + sModel + " Yearly Sales Report\n---------------------------";
		return sHeader;
	}
}
