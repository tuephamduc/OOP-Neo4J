package controller;

import java.util.Random;

import data.Data;

public class RandomPropertiesPerson extends RandomPropetiesNode implements IPerson {

	public RandomPropertiesPerson() {
		// TODO Auto-generated constructor stub
	}
	
	private String Tempid;
	Data data = new Data();
	
	@Override
	public String randomDinhDanh(int id) {
		return Tempid.replace(" ", "_")+id;
	}

	@Override
	public String randomMoTa() {
		return data.descriptionPerson[new Random().nextInt(data.descriptionPerson.length)];
	}
	
	@Override
	public String randomNhan() {
		String id;
		id = data.firstName[new Random().nextInt(data.firstName.length)]+" "+
			data.midName[new Random().nextInt(data.midName.length)]
			+" "+data.lastName[new Random().nextInt(data.lastName.length)];
		Tempid = id;
		return id;
	}
	
	@Override
	public int randomAge() {
		return new Random().nextInt(90);
	}

	@Override
	public String randomJob() {
		return data.job[new Random().nextInt(data.job.length)];
	}

	@Override
	public String randomQuocTich() {
		return data.quoctich[new Random().nextInt(data.quoctich.length)];
	}
}
