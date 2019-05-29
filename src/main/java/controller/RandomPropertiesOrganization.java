package controller;
import java.util.Random;

import data.Data;

public class RandomPropertiesOrganization extends RandomPropetiesNode implements IOrganization{

	public RandomPropertiesOrganization() {
		// TODO Auto-generated constructor stub
	}
	
	private String Tempid;
	Data data = new Data();

	@Override
	public String randomNhan() {
		Tempid = data.nameOrganization[new Random().nextInt(data.nameOrganization.length)];
		return Tempid;
	}

	@Override
	public String randomMoTa() {
		return data.descriptionOrganization[new Random().nextInt(data.descriptionOrganization.length)];
	}

	@Override
	public String randomTruSo() {
		return data.location[new Random().nextInt(data.location.length)];
	}
	
	@Override
	public String randomDinhDanh(int i) {
		String tem = Tempid.replace(" ", "_");
		return tem+i;
	}
}
