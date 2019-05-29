package controller;


import java.io.IOException;
import java.util.Calendar;

public class CreateRelationships {
	
	public CreateRelationshipQuery Rela = new CreateRelationshipQuery();
	
	public CreateRelationships() {
		
	}
	
	public void createRelationship(int num) throws IOException {
		long begin = Calendar.getInstance().getTimeInMillis();

		Rela.doQuery("Person","THAM_GIA","Event",Rela.Query(num, 1));
		Rela.doQuery("Organization","TO_CHUC","Event",Rela.Query(num, 2));
		Rela.doQuery("Person","DAI_DIEN","Event",Rela.Query(num, 3));
		Rela.doQuery("Person","QUOC_TICH","Country",Rela.Query(num, 4));
		Rela.doQuery("Person","DEN_THAM","Location",Rela.Query(num, 5));
		Rela.doQuery("Location","DEN_THAM_VAO","Time",Rela.Query(num, 6));
		Rela.doQuery("Event","DIEN_RA_TAI","Location",Rela.Query(num, 7));
		Rela.doQuery("Event","DIEN_RA_VAO","Time",Rela.Query(num, 8));
		Rela.doQuery("Organization","TRU_SO","Location",Rela.Query(num, 9));
		Rela.doQuery("Location","THUOC","Country",Rela.Query(num, 10));
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Thời gian tạo quan hệ: " + (end - begin)+" mili giây!");
	}
}
