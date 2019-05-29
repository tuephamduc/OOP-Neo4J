package controller;

import java.io.BufferedWriter;  
import java.io.FileWriter;
import java.util.Calendar; 

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Person;

public class CreateNodePerson implements ICreate<Person>{
	
	RandomPropertiesPerson randomPerson = new RandomPropertiesPerson();
	
	@Override
	public void createNode(Person per, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {
			System.out.println("Đang thêm node Person...");
			for(int i=0; i<num; i++) {	
				per.setNhan(randomPerson.randomNhan());
				per.setDinhdanh(randomPerson.randomDinhDanh(i));
				per.setMota(randomPerson.randomMoTa());
				per.setLink(randomPerson.randomLink());
				per.setDate(randomPerson.randomThoiGian(i));
				per.setAge(randomPerson.randomAge());
				per.setJob(randomPerson.randomJob());
				per.setQuoctich(randomPerson.randomQuocTich());
	            
		Connection.connection.execute("CREATE ("+per.getDinhdanh()+":Person { "
					+ "DinhDanh: '"+per.getDinhdanh()+"', "
					+ "Nhan: '"+per.getNhan()+"', "
					+ "Mota: '"+per.getMota()+"', "
					+ "LinkTrichRut: '"+per.getLink()+"', "			
					+ "ThoiGianTrichRut: '"+per.getDate()+"', "
					+ "Age: '"+per.getAge()+"', "
					+ "Job: '"+per.getJob()+"', "
					+ "Quoctich: '"+per.getQuoctich()+"'})");
		}	

			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thêm Person: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	@Override
	public void createCSV(Person per, int num) {
		long begin = Calendar.getInstance().getTimeInMillis();
		try {
			
			String csvFile = "Database/Person.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
		            CSVPrinter csvPrinter = new CSVPrinter(writer, 
		            CSVFormat.DEFAULT.withHeader("DinhDanh:ID(Person)", "Nhan", "Mota", "LinkTrichRut", "ThoiGianTrichRut", "Age", "Job", "Quoctich"));) 
		        {
			System.out.println("Đang thêm node Person...");
			for(int i=0; i<num; i++) {	
				per.setNhan(randomPerson.randomNhan());
				per.setDinhdanh(randomPerson.randomDinhDanh(i));
				per.setMota(randomPerson.randomMoTa());
				per.setLink(randomPerson.randomLink());
				per.setDate(randomPerson.randomThoiGian(i));
				per.setAge(randomPerson.randomAge());
				per.setJob(randomPerson.randomJob());
				per.setQuoctich(randomPerson.randomQuocTich());
				
				csvPrinter.printRecord(per.getDinhdanh(), per.getNhan(), per.getMota(),
	            		per.getLink(), per.getDate(),per.getAge(),per.getJob(),per.getQuoctich());
	            csvPrinter.flush();
			}	
		        }
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Ghi CSV Person: " + (end - begin)+" mili giây!");
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}

