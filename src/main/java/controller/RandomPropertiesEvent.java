package controller;

import java.util.Calendar;
import java.util.Random;

import data.Data;

public class RandomPropertiesEvent extends RandomPropetiesNode implements IEvent {

	public RandomPropertiesEvent() {
		// TODO Auto-generated constructor stub
	}
	
	private String Tempid;

	Data data = new Data();

	@Override
	public String randomNhan() {
		Tempid = data.event[new Random().nextInt(data.event.length)];
		return Tempid;
	}

	@Override
	public String randomMoTa() {
		return data.event[new Random().nextInt(data.event.length)];
	}
	
	@Override
	public String randomDinhDanh(int i) { 
		return (Tempid).replace(" ", "_")+i;
	}
	
	@Override
	public String randomDiaDiem() {
		return data.location[new Random().nextInt(data.location.length)];
	}
	
	@Override
	public String randomDaiDien() {
		String nhan = null ;
		nhan = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
				data.midName[new Random().nextInt(data.midName.length)]+" "+
				data.lastName[new Random().nextInt(data.lastName.length)];
		return nhan;
	}

	@Override
	public String randomTime(int i) {
		Calendar calendar = Calendar.getInstance();
		i = i%6500+new Random().nextInt(15);
		calendar.add(Calendar.DATE, -i);
		String a =  calendar.getTime().toString();
		return a.substring(0,10)+" "+a.substring(24,28);
	}
}
