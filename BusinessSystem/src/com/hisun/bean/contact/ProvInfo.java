package com.hisun.bean.contact;

public class ProvInfo {
	private String prov_id;
	private String prov_name;
	
	public String getProv_id() {
		return prov_id;
	}
	public void setProv_id(String prov_id) {
		this.prov_id = prov_id;
	}
	public String getProv_name() {
		return prov_name;
	}
	public void setProv_name(String prov_name) {
		this.prov_name = prov_name;
	}
	@Override
	public String toString() {
		return "ProInfo [prov_id=" + prov_id + ", prov_name=" + prov_name + "]";
	}
	public ProvInfo() {
	
	}
	public ProvInfo(String prov_id, String prov_name) {
		super();
		this.prov_id = prov_id;
		this.prov_name = prov_name;
	}
	
	
}
