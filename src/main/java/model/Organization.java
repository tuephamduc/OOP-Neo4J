package model;


public class Organization extends Object {
	
	 private String truso;
	 public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organization(String dinhdanh, String nhan, String mota, String link, String thoigian,String truso) {
		super(dinhdanh, nhan, mota, link, thoigian);
		// TODO Auto-generated constructor stub
		this.truso=truso;
	}
	public String getTruSo() {
		 return this.truso;
	 }
	 public void setTruSo(String ts) {
		 this.truso=ts;
	 }
	 
}
