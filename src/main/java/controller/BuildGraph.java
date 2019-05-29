package controller;

import java.io.IOException; 
import java.util.Calendar;

import model.Country;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;
import model.Time;

public class BuildGraph {

	public BuildGraph() {
		// TODO Auto-generated constructor stub
	}
	
	public void createGraph(int numEntity, int numRela ) throws IOException {
		CreateRelationshipQuery.GRAPH = true;
		CreateRelationshipQuery.CSV = false;
		int numEn = numEntity;
		numEntity = numEntity/6;
		numRela = numRela/9;
		
		long begin = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Đang xoá các node cũ...");
		try {
			Connection.connection.removeData();
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		System.out.println("Đang tạo node...");
		
		CreateNodePerson createPer = new CreateNodePerson();
		Person per = new Person();
		createPer.createNode(per, numEntity+numEn%6);
		
		CreateNodeOrganization createOrg = new CreateNodeOrganization();
		Organization Org = new Organization();
		createOrg.createNode(Org, numEntity);
		
		CreateNodeLocation createLocation = new CreateNodeLocation();
		Location loca = new Location();
		createLocation.createNode(loca, numEntity);
		
		CreateNodeEvent createEvent = new CreateNodeEvent();
		Event event = new Event();
		createEvent.createNode(event, numEntity);
		
		CreateNodeCountry createCountry = new CreateNodeCountry();
		Country country = new Country();
		createCountry.createNode(country, numEntity);
		
		CreateNodeTime createTime = new CreateNodeTime();
		Time time = new Time();
		createTime.createNode(time, numEntity);
		
		System.out.println("Đang tạo quan hệ...");
		CreateRelationships Rela = new CreateRelationships();
		Rela.createRelationship(numRela);
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Done: " + (end - begin)+" mili giây!");

	}
}
