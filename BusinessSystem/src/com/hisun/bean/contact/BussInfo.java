package com.hisun.bean.contact;

public class BussInfo {
	private String buss_id;
	private String buss_name;
	public String getBuss_id() {
		return buss_id;
	}
	public void setBuss_id(String buss_id) {
		this.buss_id = buss_id;
	}
	public String getBuss_name() {
		return buss_name;
	}
	public void setBuss_name(String buss_name) {
		this.buss_name = buss_name;
	}
	@Override
	public String toString() {
		return "BussInfo [buss_id=" + buss_id + ", buss_name=" + buss_name
				+ "]";
	}
	public BussInfo(String buss_id, String buss_name) {
		super();
		this.buss_id = buss_id;
		this.buss_name = buss_name;
	}
	public BussInfo() {
	}
	
	
}
