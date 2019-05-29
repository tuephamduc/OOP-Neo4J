package model;


public class Location extends Object {
	 private String quocgia;
	 
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(String dinhdanh, String nhan, String mota, String link, String thoigian,String quocgia) {
		super(dinhdanh, nhan, mota, link, thoigian);
		// TODO Auto-generated constructor stub
		this.quocgia=quocgia;
	}
	public String getQuocGia() {
		 return this.quocgia;
	 }
	 public void setQuocGia(String qg) {
		 this.quocgia=qg;
	 }
}
