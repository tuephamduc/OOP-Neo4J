package controller;

import java.util.Random;

import data.Data;

public class RandomPropertiesLocation extends RandomPropetiesNode implements ILocation {

	public RandomPropertiesLocation() {
		// TODO Auto-generated constructor stub
	}
	private String Tempid;
	Data data = new Data();

	@Override
	public String randomNhan() {
		Tempid = data.location[new Random().nextInt(data.location.length)];
		return Tempid;
	}

	@Override
	public String randomMoTa() {
		return data.desquoctich[new Random().nextInt(data.desquoctich.length)];
	}
	
	@Override
	public String randomDinhDanh(int i) {
		String tem = (Tempid).replace(" ", "_");
		return tem+i;
	}
	
	@Override
	public String randomQuocGia() {
		return data.quoctich[new Random().nextInt(data.quoctich.length)];
	}
	
}
