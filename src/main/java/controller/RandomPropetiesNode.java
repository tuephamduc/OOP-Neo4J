package controller;

import java.util.Calendar;
import java.util.Random;

import data.Data;

public abstract class RandomPropetiesNode {

	Data data = new Data();
	
	public RandomPropetiesNode() {
		// TODO Auto-generated constructor stub
	}

	public abstract String randomDinhDanh(int id);
	
	public abstract String randomNhan();
	
	public abstract String randomMoTa();
	
	public String randomLink() {
		String link ;
		link = data.link[new Random().nextInt(data.link.length)];
		return link;
	}
	
	public String randomThoiGian(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500; //Thời gian trích rút trong vòng 18 năm (6500 ngày) trở lại so với thời gian hiện tại 
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,10)+" "+a.substring(24,28);
	}
}
