package deployment;

import static org.neo4j.driver.v1.Values.parameters; 

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import controller.Connection;

public class TruyVanCoBan {

	public TruyVanCoBan() {
		// TODO Auto-generated constructor stub
	}
	
	public void Query1(int Age) {
	    	String q = "MATCH (e:Person) WHERE e.Age = {Age} RETURN e.Nhan AS Nhan";
	    	String a = String.valueOf(Age);
	    	System.out.println("Những người có tuổi "+Age+":");
	    	 try (Session session = Connection.connection.driver.session()){
	             StatementResult result = session.run(q,parameters("Age", a));
	             
	             while (result.hasNext())
	             {
	                 Record record = result.next();
	                 System.out.println(record.get("Nhan").asString());
	             }
	         }
	    }
	
	public void Query2(String Quoctich) {
    	String q = "MATCH (e:Person) WHERE e.Quoctich = {Quoctich} RETURN e.Nhan AS Nhan, "
    			+ "e.Age AS Age, e.Mota AS Mota, e.Job AS Job, e.ThoiGianTrichRut AS Time";
    	
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run(q,parameters("Quoctich", Quoctich));
             System.out.println("Những người có quốc tịch "+Quoctich+":");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
                 System.out.println("Thời gian trích rút: "+record.get("Time").asString());
             }
         }
    }
	
	public void Query3(String Ten) {
    	String q = "MATCH (e:Person) WHERE e.Nhan ENDS WITH {Ten} RETURN e.Nhan AS Nhan, "
    			+ "e.Age AS Age, e.Mota AS Mota, e.Job AS Job, e.ThoiGianTrichRut AS Time";
    	System.out.println("Những người có tên "+Ten+":");
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run(q,parameters("Ten", Ten));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
                 System.out.println("Thời gian trích rút: "+record.get("Time").asString());
                 }
         }
    }
	
	public void Query4() {
    	System.out.println("Tất cả Person: ");
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run("MATCH (e:Person) RETURN e.DinhDanh AS DD, e.Nhan AS Nhan, e.ThoiGianTrichRut AS Time");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Định Danh: "+record.get("DD").asString()+" - Tên: "+record.get("Nhan").asString()+" - Thoi gian trich rut: "+record.get("Time").asString());
                 
             }
         }
    }
	
	public void Query5(String s) {
		if(s=="1") s = "Person";
		else if(s=="2") s = "Organization";
		else if(s=="3") s = "Event";
		else if(s=="4") s = "Location";
		else if(s=="5") s = "Country";
		else if(s=="6") s = "Time";
    	System.out.println("Tất cả "+s+":");
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run("MATCH (e:"+s+") RETURN e.Nhan AS Nhan");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println(record.get("Nhan").asString());
             }
         }
    }
	
	public void Query6(String Org) {
    	String q = "MATCH (Or:Organization) WHERE Or.Nhan = {Org} RETURN Or.LinkTrichRut AS Link, Or.ThoiGianTrichRut AS Time";
    	
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run(q,parameters("Org", Org));
             System.out.println("Những bài viết viết về "+Org+" là:");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Link: "+record.get("Link").asString()+" - Thoi gian trich rut: "+record.get("Time").asString());
             }
         }
    }
	
	public void Query7(String link) {
    	String q = "MATCH (per:Person) WHERE per.LinkTrichRut = {link} RETURN per.Nhan AS perNhan";
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run(q,parameters("link", link));
             System.out.println("Những thực thể Person đề cập đến bài viết trong "+link+" là:");
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("Person: "+record.get("perNhan").asString());
              
             }
         }
    }

	public void Query8(String event) {
		String q = "MATCH (event:Event) WHERE event.Nhan = {event} RETURN event.DiaDiem AS DD, event.ThoiGianToChuc AS time";
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("event", event));
            System.out.println("Địa điểm tổ chức "+event+" là:");
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println("Địa điểm: "+record.get("DD").asString()+" - Thời gian: "+record.get("time").asString());
             
            }
        }
	}

	public void Query9(String country) {
		String q = "MATCH (loca:Location) WHERE loca.QuocGia = {country} "
				+ "WITH DISTINCT loca RETURN loca.DinhDanh AS locaDD, loca.Nhan AS locaNhan";
	   	 try (Session session = Connection.connection.driver.session()){
	            StatementResult result = session.run(q,parameters("country", country));
	            System.out.println("Loation có trong "+country+" là:");
	            while (result.hasNext())
	            {
	                Record record = result.next();
	                System.out.println("Định danh: "+record.get("locaDD").asString()+" - Nhãn: "+record.get("locaNhan").asString());
	             
	            }
	        }
	}

	public void Query10() {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time)"
				+ " WITH DISTINCT per, loca, time RETURN per.Nhan AS perNhan, "
				+ "loca.Nhan AS locaNhan, time.Nhan AS timeNhan LIMIT 20";
		System.out.println(" ");
		System.out.println("20 quan hệ (Person)-[:DEN_THAM]->(Location)-[:DEN_THAM_VAO]->(Time):");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q);
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("perNhan").asString()+" ĐẾN THĂM: "+record.get("locaNhan").asString()+
                		" VÀO: "+record.get("timeNhan").asString());
                
            }
        }
	}
	
}
