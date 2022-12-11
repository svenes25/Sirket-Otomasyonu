package odev1;

public class Proje {

	private static int syc=0;
	private int depNo;
	private int projeID;
	private String projeAd;
	private int projeSure;
	private int projeMaliyet;
	
	public Proje(int depNo, String projeAd, int projeSure, int projeMaliyet) {
		this.depNo = depNo;
		this.projeID = ++syc;
		this.projeAd = projeAd;
		this.projeSure = projeSure;
		this.projeMaliyet = projeMaliyet;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public int getProjeID() {
		return projeID;
	}

	public void setProjeID(int projeID) {
		this.projeID = projeID;
	}

	public String getProjeAd() {
		return projeAd;
	}

	public void setProjeAd(String projeAd) {
		this.projeAd = projeAd;
	}

	public int getProjeSure() {
		return projeSure;
	}

	public void setProjeSure(int projeSure) {
		this.projeSure = projeSure;
	}

	public int getProjeMaliyet() {
		return projeMaliyet;
	}

	public void setProjeMaliyet(int projeMaliyet) {
		this.projeMaliyet = projeMaliyet;
	}
	
}
