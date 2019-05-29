package controller;

import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.util.Calendar;  

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Location;

public class CreateNodeLocation implements ICreate<Location>{
	
	RandomPropertiesLocation randomLocation = new RandomPropertiesLocation();
	
	@Override
	public void createNode(Location loca, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		RandomPropertiesLocation randomLocation = new RandomPropertiesLocation();
		try {
			System.out.println("Đang thêm node Location...");
			for(int i=0; i<num; i++) {	
				loca.setNhan(randomLocation.randomNhan());
				loca.setDinhdanh(randomLocation.randomDinhDanh(i));
				loca.setMota(randomLocation.randomMoTa());
				loca.setLink(randomLocation.randomLink());
				loca.setDate(randomLocation.randomThoiGian(i));
				loca.setQuocGia(randomLocation.randomQuocGia());

				Connection.connection.execute("CREATE ("+loca.getDinhdanh()+":Location { "
					+ "DinhDanh: '"+loca.getDinhdanh()+"', "
					+ "Nhan: '"+loca.getNhan()+"', "
					+ "Mota: '"+loca.getMota()+"', "
					+ "LinkTrichRut: '"+loca.getLink()+"', "			
					+ "ThoiGianTrichRut:'"+loca.getDate()+"', "
					+ "QuocGia: '"+loca.getQuocGia()+"'})");
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Location: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	@Override
	public void createCSV(Location loca, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		RandomPropertiesLocation randomLocation = new RandomPropertiesLocation();
		try {
			String csvFile = "Database/Location.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		            CSVPrinter csvPrinter = new CSVPrinter(writer, 
		            CSVFormat.DEFAULT.withHeader("DinhDanh:ID(Location)", "Nhan", "Mota", "LinkTrichRut", "ThoiGianTrichRut", "QuocGia"));) 
		        {
			System.out.println("Đang thêm node Location...");
			for(int i=0; i<num; i++) {	
				loca.setNhan(randomLocation.randomNhan());
				loca.setDinhdanh(randomLocation.randomDinhDanh(i));
				loca.setMota(randomLocation.randomMoTa());
				loca.setLink(randomLocation.randomLink());
				loca.setDate(randomLocation.randomThoiGian(i));
				loca.setQuocGia(randomLocation.randomQuocGia());
				
				csvPrinter.printRecord(loca.getDinhdanh(), loca.getNhan(), loca.getMota(),
	            		loca.getLink(), loca.getDate(),loca.getQuocGia());
	            csvPrinter.flush();
		}	
				}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Ghi CSV Location: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

}
