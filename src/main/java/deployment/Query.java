package deployment;

import java.util.ArrayList;
import java.util.Calendar;

public class Query {

	public Query() {
		// TODO Auto-generated constructor stub
	}
	public void Run() {
		
// -------------- 10 truy vấn cơ bản ---------------
		TruyVanCoBan query1 = new TruyVanCoBan();
		ArrayList<Long> time = new ArrayList<Long>();
		long a;
		// 1. In ra ten cua tat ca nhung nguoi co tuoi 76
		long begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query1(76);
		long end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 1: "+ a+" mili giây!");	
		time.add(a);
		
		//2. In ra Thông tin cua tat ca nhung nguoi có quốc tịch Lao
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query2("Lao");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 2: "+ a+" mili giây!");	
		time.add(a);
		
		//3. In ra thông tin của tat ca nhung nguoi ten chua tu "Hung"
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query3("Hùng");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 3: "+ a+" mili giây!");	
		time.add(a);
			
		//4. In ra tên của tất cả Person
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query4();
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 4: "+ a+" mili giây!");	
		time.add(a);	
			
		//5. In ra nhãn của 1 thực thể tùy chọn 
		//Nhập Person, Organization, Event, Location, Country, Time hoặc 1,2,3,4,5,6 để xác định đối 
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query5("Person");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 5: "+ a+" mili giây!");	
		time.add(a);
				
		//6. In ra những link bài viết có viết về Organization nhập vào:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query6("Apple");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 6: "+ a+" mili giây!");	
		time.add(a);
		
		//7. In ra nhãn của những thực thể Person có đề cập trong Link nhập vào:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query7("https://search.maven.org/artifact/org.neo4j/neo4j-kernel/3.5.0/jar");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 7: "+ a+" mili giây!");	
		time.add(a);
		
		//8. In địa điểm và thời gian tổ chức event:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query8("Ca múa nhạc tạp kỹ");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 8: "+ a+" mili giây!");	
		time.add(a);
		
		//9. In các location có trong 1 country:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query9("Viet Nam");
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 9: "+ a+" mili giây!");	
		time.add(a);
		
		//10. In ra 20 Person, location, time có trong quan hệ Person đến thăm Lociton vào Time:
		begin_query1 = Calendar.getInstance().getTimeInMillis();
		query1.Query10();
		end_query1 = Calendar.getInstance().getTimeInMillis();
		a=(end_query1-begin_query1);
		System.out.println("----Truy vấn cơ bản 10: "+ a+" mili giây!");							
		time.add(a);
				
// ========================================================================
				
// --------------- 10 truy vấn nâng cao ---------------
		TruyVanNangCao query2 = new TruyVanNangCao();
		
		//1. Nhập vào một String bất kì in ra tất cả thông tin của 1 người có liên quan đến String đấy 
		long begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query1("Hùng");
		long end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 1: "+ a+" mili giây!");	
		time.add(a);
		
		// 2. Nhập vào 1 người xác định in ra thời gian và nước mà người ấy đến thăm
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query2("Nguyễn Thị Hương");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 2: "+ a+" mili giây!");	
		time.add(a);
		
		// 3. Nhập vào 1 người xác định in ra những địa điểm và thời gian người đó đến thăm vào Tháng 11/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query3("Nguyễn Thị Hương");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 3: "+ a+" mili giây!");	
		time.add(a);
			
		// 4. Nhập vào 1 địa điểm in ra tên của những sự kiện và thời gian diễn ra tại đó vào tháng 10/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query4("Trụ sở Apple Califonia");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("----Truy vấn nâng cao 4: "+ a+" mili giây!");	
		a=(end_query2-begin_query2);
		time.add(a);
		
		//5. In ra nhãn của 10 thực thể có đề cập trong Link nhập vào:
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query5("https://xuanhung937556578.wordpress.com/");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 5: "+ a+" mili giây!");	
		time.add(a);
				 
		//6. In ra danh sách 10 người và thời gian đến thăm trụ sở của các Organization đã tổ chức 1 sự kiện cụ thể
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query6("Lễ hội mùa xuân");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 6: "+ a+" mili giây!");	
		time.add(a);
				
		//7. In Organization đã tổ chức những sự kiện nào vào tháng 9/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query7("Grab");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 7: "+ a+" mili giây!");	
		time.add(a);
				
		//8. In ra những người "nước ngoài" nào đã đến thăm các location thuộc country nhập vào trong tháng 9/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query8("Phap");
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 8: "+ a+" mili giây!");	
		time.add(a);
		
		//9. Tính số sự kiện diễn ra vào ngày 23/12/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query9();
		end_query2 = Calendar.getInstance().getTimeInMillis();
		a=(end_query2-begin_query2);
		System.out.println("----Truy vấn nâng cao 9: "+ a+" mili giây!");	
		time.add(a);
		
		//10. In ra tên các sự kiện diễn ra vào ngày 23/12/2018
		begin_query2 = Calendar.getInstance().getTimeInMillis();
		query2.Query10();
		end_query2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("----Truy vấn nâng cao 10: "+ a+" mili giây!");	
		time.add(a);
		
		int i=0;
		for (long x : time) {
			i++;
            System.out.println("Truy vấn số "+i+": "+x+"ms");
        }

		
	}
}
