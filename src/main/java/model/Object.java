package model;


public class Object {
	 private String dinhdanh;
	 private String nhan;
	 private String mota;
	 private String link;
	 private String thoigian;
	 
	 public Object() {
	 } 
	 
	 public Object(String dinhdanh, String nhan, String mota, String link, String thoigian ) {
		super();
		this.dinhdanh = dinhdanh;
		this.nhan = nhan;
		this.mota = mota;
		this.link = link;
		this.thoigian=thoigian;
	}

	public String getDinhdanh() {
		return dinhdanh;
	}
	public void setDinhdanh(String dinhdanh) {
		this.dinhdanh = dinhdanh;
	}
	public String getNhan() {
		return nhan;
	}
	public void setNhan(String nhan) {
		this.nhan = nhan;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setDate(String date) {
		this.thoigian = date;
	}
	public String getDate() {
		return thoigian;
	}
}
