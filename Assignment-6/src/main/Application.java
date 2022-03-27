package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dataService.DataService;
import fileService.FileService;
import sales.Sales;

public class Application {

	public static void main(String[] args) throws IOException {
		
		List<Sales> lModel3 = new ArrayList<Sales>();
		List<Sales> lModelS = new ArrayList<Sales>();
		List<Sales> lModelX = new ArrayList<Sales>();
		FileService oFile = new FileService();
		DataService oData = new DataService();

		oFile.fileReader("model3.csv", lModel3);
		oData.groupByYear(lModel3, "Model 3 ");
		oFile.fileReader("modelS.csv", lModelS);
		oData.groupByYear(lModelS, "Model S");
		oFile.fileReader("modelX.csv", lModelX);
		oData.groupByYear(lModelX, "Model X");
	}
}
