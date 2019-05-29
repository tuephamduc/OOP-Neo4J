package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;  

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Country;

public class CreateNodeCountry implements ICreate<Country>{
	
	RandomPropertiesCountry randomCountry = new RandomPropertiesCountry();
	
	@Override
	public void createNode(Country country, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {	
			System.out.println("Đang thêm node Country...");
			for(int i=0; i<num; i++) {	
				country.setNhan(randomCountry.randomNhan());
				country.setDinhdanh(randomCountry.randomDinhDanh(i));
				country.setMota(randomCountry.randomMoTa());
				country.setLink(randomCountry.randomLink());
				country.setDate(randomCountry.randomThoiGian(i));
				Connection.connection.execute("CREATE ("+country.getDinhdanh()+":Country { "
					+ "DinhDanh: '"+country.getDinhdanh()+"', "
					+ "Nhan: '"+country.getNhan()+"', "
					+ "Mota: '"+country.getMota()+"', "
					+ "LinkTrichRut: '"+country.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+country.getDate()+"'})");
			}
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Thêm Country: " + (end - begin)+" mili giây!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	@Override
	public void createCSV(Country country, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {	
			String csvFile = "Database/Country.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		            CSVPrinter csvPrinter = new CSVPrinter(writer, 
		            CSVFormat.DEFAULT.withHeader("DinhDanh:ID(Country)", "Nhan", "Mota", "LinkTrichRut", "ThoiGianTrichRut"));) 
		        {
			System.out.println("Đang thêm node Country...");
			for(int i=0; i<num; i++) {	
				country.setNhan(randomCountry.randomNhan());
				country.setDinhdanh(randomCountry.randomDinhDanh(i));
				country.setMota(randomCountry.randomMoTa());
				country.setLink(randomCountry.randomLink());
				country.setDate(randomCountry.randomThoiGian(i));
				
				csvPrinter.printRecord(country.getDinhdanh(), country.getNhan(), country.getMota(),
	            		country.getLink(), country.getDate());
	            csvPrinter.flush();
		}	
		        }
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Country: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
