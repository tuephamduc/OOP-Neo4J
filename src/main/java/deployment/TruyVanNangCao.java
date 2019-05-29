package deployment;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import controller.Connection;

public class TruyVanNangCao {

	public void Query1(String Ho) {
    	String q = "MATCH (e:Person) WHERE e.Nhan CONTAINS {Ho} OR e.Age CONTAINS {Ho} OR e.Quoctich CONTAINS {Ho} OR e.Mota CONTAINS {Ho} "
    			+ "RETURN e.Nhan AS Nhan, e.Age AS Age, e.Mota AS Mota, e.Job AS Job, e.Quoctich AS qt";
    	System.out.println("Người có thông tin trên là: "+Ho+":");
    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run(q,parameters("Ho", Ho));
             while (result.hasNext())
             {
                 Record record = result.next();
                 System.out.println("-----");
                 System.out.println("Tên: "+record.get("Nhan").asString());
                 System.out.println("Tuổi: "+record.get("Age").asString());
                 System.out.println("Nghề nghiệp: "+record.get("Job").asString());
                 System.out.println("SĐT: "+record.get("Mota").asString());
                 System.out.println("Quốc tịch: "+record.get("qt").asString());
             }
         }
    }

	public void Query2(String ten) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(country:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE per.Nhan = {ten} "
				+ " WITH DISTINCT country, time RETURN country.Nhan AS locaNhan, time.Nhan AS timeNhan";
		System.out.println("Những địa điểm "+ten+" đã đến thăm là:");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("ten", ten));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println("Địa điểm: "+record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}

	public void Query3(String ten) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE per.Nhan = {ten}"
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT loca, time RETURN loca.Nhan AS locaNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những nơi "+ten+" đến thăm vào tháng 11/2018 là:");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("ten", ten));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}
	
	public void Query4(String location) {
		String q = "MATCH (event:Event)-[:DIEN_RA_TAI]->(loca:Location), (event:Event)-[:DIEN_RA_VAO]->(time:Time) WHERE loca.Nhan = {location}"
				+ " AND time.Nhan CONTAINS 'Oct' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT event, time RETURN event.Nhan AS locaNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những sự kiện diễn ra tại "+location+" vào tháng 10/2018 là:");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("location", location));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("locaNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}
	public void Query5(String link) {
    	System.out.println("Những thực thể đề cập đến bài viết trong "+link+" là:");
    	
    	String q = "MATCH (p) WHERE p.LinkTrichRut = {link} WITH DISTINCT p  RETURN p.Nhan AS Nhan LIMIT 10";

    	 try (Session session = Connection.connection.driver.session()){
             StatementResult result = session.run(q,parameters("link", link));
             while (result.hasNext()){
                 Record record = result.next();
                 if(record.get("Nhan").asString() != "null") System.out.println("Thực thể: "+record.get("Nhan").asString());
             }
         }
    }

	public void Query6(String event) {
		String q = "MATCH (org:Organization)-[:TO_CHUC]->(event:Event), "
				+ "(per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time) WHERE "
				+ " event.Nhan = {event} AND org.TruSo = loca.Nhan "
				+ " WITH DISTINCT per, org, time RETURN per.Nhan AS perNhan, org.TruSo AS truso,"
				+ " org.Nhan AS orgNhan, time.Nhan AS time";
		System.out.println(" ");
		System.out.println("Truy vấn 6: ");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("event", event));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("perNhan").asString()
                +" đến thăm trụ sở của "+record.get("orgNhan").asString()
                +" tại "+record.get("truso").asString()
                +" vào "+record.get("time").asString());
                
            }
        }
	}

	public void Query7(String org) {
		String q = "MATCH (org:Organization)-[:TO_CHUC]->(event:Event)-[:DIEN_RA_VAO]->(time:Time) "
				+ " WHERE org.Nhan = {org} "
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT event, time RETURN event.Nhan AS eventNhan, time.Nhan AS timeNhan ";
		System.out.println(" ");
		System.out.println("Những sự kiện "+org+" tổ chức vào tháng 9/2018 là:");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("org", org));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("eventNhan").asString()+" - Thời gian: "+record.get("timeNhan").asString());
                
            }
        }
	}

	public void Query8(String country) {
		String q = "MATCH (per:Person)-[:DEN_THAM]->(loca:Location)-[:DEN_THAM_VAO]->(time:Time), (loca:Location)-[:THUOC]->(country:Country) "
				+ " WHERE country.Nhan = {cou} AND per.Quoctich <> country.Nhan"
				+ " AND time.Nhan CONTAINS 'Nov' "
				+ " AND time.Nhan ENDS WITH '2018' "
				+ " WITH DISTINCT per, loca, time LIMIT 10 RETURN per.Nhan AS perNhan, time.Nhan AS timeNhan, loca.Nhan AS locaNhan ";
		System.out.println(" ");
		System.out.println("Những người nước ngoài đến "+country+" vào tháng 9/2018 là:");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q,parameters("cou", country));
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("perNhan").asString()+" đến thăm "+record.get("locaNhan").asString()+" thuộc nước "+country+" vào "+record.get("timeNhan").asString());
                
            }
        }
	}
	
	public void Query9() {
		String q = "Match (event:Event)-[:DIEN_RA_VAO]->(time:Time) WHERE time.Nhan CONTAINS 'Dec' " + 
				" AND time.Nhan CONTAINS '23'  AND time.Nhan ENDS WITH '2018' RETURN event.Nhan AS eNhan";
		System.out.println(" ");
		System.out.println("Số sự kiện diễn ra vào 23/12/2018 là:");
   	 try (Session session = Connection.connection.driver.session()){
   		 	int i=0;
            StatementResult result = session.run(q);
            while (result.hasNext()) {
            	Record record = result.next();
            	record.get("eNhan").asString();
            	i++;
            }
            System.out.println(i+" sự kiện!");
        }
	}
	
	public void Query10() {
		String q = "Match (event:Event)-[:DIEN_RA_VAO]->(time:Time) WHERE time.Nhan CONTAINS 'Dec' " + 
				" AND time.Nhan CONTAINS '23'  AND time.Nhan ENDS WITH '2018' RETURN event.Nhan AS event, time.Nhan AS time";
		System.out.println(" ");
		System.out.println("Các sự kiện diễn ra vào 23/12/2018 là:");
   	 try (Session session = Connection.connection.driver.session()){
            StatementResult result = session.run(q);
            while (result.hasNext())
            {
                Record record = result.next();
                System.out.println(record.get("event").asString()+" - "+record.get("time").asString());
                
            }
        }
	}
	
}