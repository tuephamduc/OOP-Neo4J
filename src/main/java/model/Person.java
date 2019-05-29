package model;


public class Person extends Object {
	
	 private int age;
	 private String job;
	 private String quoctich;
	 public Person() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Person(String dinhdanh, String nhan, String mota, String link,String thoigian, int age,String job,String quoctich) {
		super(dinhdanh, nhan, mota, link, thoigian);
		// TODO Auto-generated constructor stub
		this.age =age;
		this.job =job;
		this.quoctich=quoctich;
	}
	public String getQuoctich() {
		 return this.quoctich;
	 }
	 public void setQuoctich(String qt) {
		 this.quoctich=qt;
	 }
	 public String getJob() {
		 return this.job;
	 }
	 public void setJob(String job) {
		 this.job=job;
	 }
	 public int getAge() {
		 return this.age;
	 }
	 public void setAge(int age) {
		 this.age=age;
	 }
}
