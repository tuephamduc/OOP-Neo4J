package controller;

import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.util.Calendar;  

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Event;

public class CreateNodeEvent implements ICreate<Event>{
	
	RandomPropertiesEvent randomEvent = new RandomPropertiesEvent();
	
	@Override
	public void createNode(Event event, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {	
			System.out.println("Đang thêm node Event...");
			for(int i=0; i<num; i++) {	
				event.setNhan(randomEvent.randomNhan());
				event.setDinhdanh(randomEvent.randomDinhDanh(i));
				event.setMota(randomEvent.randomMoTa());
				event.setLink(randomEvent.randomLink());
				event.setDate(randomEvent.randomThoiGian(i));
				event.setDaidientochuc(randomEvent.randomDaiDien());
				event.setDiadiem(randomEvent.randomDiaDiem());
				event.setTime(randomEvent.randomTime(i));

				Connection.connection.execute("CREATE ("+event.getDinhdanh()+":Event { "
					+ "Nhan: '"+event.getNhan()+"', "
					+ "DinhDanh: '"+event.getDinhdanh()+"', "
					+ "Mota: '"+event.getMota()+"', "
					+ "LinkTrichRut: '"+event.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+event.getDate()+"', "
					+ "DiaDiem: '"+event.getDiadiem()+"', "
					+ "ThoiGianToChuc: '"+event.getTime()+"', "
					+ "DaiDien: '"+event.getDaidientochuc()+"'})");
		}	

			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Event: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	@Override
	public void createCSV(Event event, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {	
			String csvFile = "Database/Event.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		            CSVPrinter csvPrinter = new CSVPrinter(writer, 
		            CSVFormat.DEFAULT.withHeader("DinhDanh:ID(Event)", "Nhan", "Mota", "LinkTrichRut", "ThoiGianTrichRut", "DiaDiem", "ThoiGianToChuc","DaiDien"));) 
		        {
			System.out.println("Đang thêm node Event...");
			for(int i=0; i<num; i++) {	
				event.setNhan(randomEvent.randomNhan());
				event.setDinhdanh(randomEvent.randomDinhDanh(i));
				event.setMota(randomEvent.randomMoTa());
				event.setLink(randomEvent.randomLink());
				event.setDate(randomEvent.randomThoiGian(i));
				event.setDaidientochuc(randomEvent.randomDaiDien());
				event.setDiadiem(randomEvent.randomDiaDiem());
				event.setTime(randomEvent.randomTime(i));
				
				csvPrinter.printRecord(event.getDinhdanh(), event.getNhan(), event.getMota(),
	            		event.getLink(), event.getDate(),event.getDiadiem(),event.getTime(),event.getDaidientochuc());
	            csvPrinter.flush();
		}	
		        }
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Ghi CSV Event: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
