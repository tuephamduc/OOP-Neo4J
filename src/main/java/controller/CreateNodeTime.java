package controller;

import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.util.Calendar;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Time;

public class CreateNodeTime implements ICreate<Time>{
	
	RandomPropertiesTime randomTime = new RandomPropertiesTime();
	
	@Override
	public void createNode(Time time, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {
			System.out.println("Đang thêm node Time...");
				for(int i=0; i<num; i++) {	
				time.setDinhdanh(randomTime.randomDinhDanh(i));
				time.setNhan(randomTime.randomNhan());
				time.setMota(randomTime.randomMoTa());
				time.setLink(randomTime.randomLink());
				time.setDate(randomTime.randomThoiGian(i));
				Connection.connection.execute("CREATE ("+time.getDinhdanh()+":Time { "
					+ "DinhDanh: '"+time.getDinhdanh()+"', "
					+ "Nhan: '"+time.getNhan()+"', "
					+ "Mota: '"+time.getMota()+"', "
					+ "LinkTrichRut: '"+time.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+time.getDate()+"'})");
				}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian thực hiện: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	@Override
	public void createCSV(Time time, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {
			String csvFile = "Database/Time.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		            CSVPrinter csvPrinter = new CSVPrinter(writer, 
		            CSVFormat.DEFAULT.withHeader("DinhDanh:ID(Time)", "Nhan", "Mota", "LinkTrichRut", "ThoiGianTrichRut"));) 
		        {
			System.out.println("Đang thêm node Time...");
				for(int i=0; i<num; i++) {	
				time.setDinhdanh(randomTime.randomDinhDanh(i));
				time.setNhan(randomTime.randomNhan());
				time.setMota(randomTime.randomMoTa());
				time.setLink(randomTime.randomLink());
				time.setDate(randomTime.randomThoiGian(i));

				csvPrinter.printRecord(time.getDinhdanh(), time.getNhan(), time.getMota(),
	            		time.getLink(), time.getDate());
	            csvPrinter.flush();
		}	
		        }
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian thực hiện: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
