package model;


public class Event extends Object {
		 private String diadiem;
		 private String daidientochuc;
		 private String time;
		 
		public Event() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Event(String dinhdanh, String nhan, String mota, String link, String thoigian,String diadiem, String daidientochuc,String time) {
			super(dinhdanh, nhan, mota, link, thoigian);
			// TODO Auto-generated constructor stub
			this.diadiem=diadiem;
			this.daidientochuc=daidientochuc;
			this.time=time;
		}
		public String getDiadiem() {
			return diadiem;
		}
		public void setDiadiem(String diadiem) {
			this.diadiem = diadiem;
		}
		public String getDaidientochuc() {
			return daidientochuc;
		}
		public void setDaidientochuc(String daidientochuc) {
			this.daidientochuc = daidientochuc;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
	     
}
