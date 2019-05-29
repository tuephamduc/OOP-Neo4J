package controller;
import java.util.Calendar; 

import data.Data;

public class RandomPropertiesTime extends RandomPropetiesNode{

	public RandomPropertiesTime() {
		// TODO Auto-generated constructor stub
	}
	
	private String Tempid;
	
	Data data = new Data();

	@Override
	public String randomNhan() {
		return Tempid;
	}

	@Override
	public String randomMoTa() {
		return "Time";
	}
	
	@Override
	public String randomDinhDanh(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, -i);
		String a =  calendar.getTime().toString();
		Tempid = a.substring(0,10)+" "+a.substring(24,28);
		return Tempid.replace(" ","_")+"_"+i;
	}
	
}
