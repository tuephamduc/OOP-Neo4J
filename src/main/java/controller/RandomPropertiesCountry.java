package controller;
import java.util.Random;

import data.Data;

public class RandomPropertiesCountry extends RandomPropetiesNode{

	public RandomPropertiesCountry() {
		// TODO Auto-generated constructor stub
	}
	
	private String Tempid;
	
	Data data = new Data();

	@Override
	public String randomNhan() {
		String nhan = null ;
		nhan = data.quoctich[new Random().nextInt(data.quoctich.length)];
		Tempid = nhan;
		return nhan;
	}

	@Override
	public String randomMoTa() {
		String des = null;
		des = data.desquoctich[new Random().nextInt(data.desquoctich.length)];
		return des;
	}
	
	@Override
	public String randomDinhDanh(int i) {
		String tem = (Tempid).replace(" ", "_");
		return tem+i;
	}
}
