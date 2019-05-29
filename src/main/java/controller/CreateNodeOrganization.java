package controller;

import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.util.Calendar;  

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Organization;

public class CreateNodeOrganization implements ICreate<Organization>{

	RandomPropertiesOrganization randomOrg = new RandomPropertiesOrganization();
	
	@Override
	public void createNode(Organization Org, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();

		try {
			System.out.println("Đang thêm node Organization...");
			for(int i=0; i<num; i++) {	
				Org.setNhan(randomOrg.randomNhan());
				Org.setDinhdanh(randomOrg.randomDinhDanh(i));
				Org.setMota(randomOrg.randomMoTa());
				Org.setLink(randomOrg.randomLink());
				Org.setDate(randomOrg.randomThoiGian(i));
				Org.setTruSo(randomOrg.randomTruSo());
				
				Connection.connection.execute("CREATE ("+Org.getDinhdanh()+":Organization { "
					+ "DinhDanh: '"+Org.getDinhdanh()+"', "
					+ "Nhan: '"+Org.getNhan()+"', "
					+ "Mota: '"+Org.getMota()+"', "
					+ "LinkTrichRut: '"+Org.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+Org.getDate()+"', "
					+ "TruSo: '"+Org.getTruSo()+"'})");
		}	
		        
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Organization: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	@Override
	public void createCSV(Organization Org, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();

		try {
			String csvFile = "Database/Organization.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		            CSVPrinter csvPrinter = new CSVPrinter(writer, 
		            CSVFormat.DEFAULT.withHeader("DinhDanh:ID(Organization)", "Nhan", "Mota", "LinkTrichRut", "ThoiGianTrichRut", "TruSo"));) 
		        {
			System.out.println("Đang thêm node Organization...");
			for(int i=0; i<num; i++) {	
				Org.setNhan(randomOrg.randomNhan());
				Org.setDinhdanh(randomOrg.randomDinhDanh(i));
				Org.setMota(randomOrg.randomMoTa());
				Org.setLink(randomOrg.randomLink());
				Org.setDate(randomOrg.randomThoiGian(i));
				Org.setTruSo(randomOrg.randomTruSo());
				
				csvPrinter.printRecord(Org.getDinhdanh(), Org.getNhan(), Org.getMota(),
	            		Org.getLink(), Org.getDate(),Org.getTruSo());
	            csvPrinter.flush();
		}	
		        }
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Ghi CSV Organization: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
