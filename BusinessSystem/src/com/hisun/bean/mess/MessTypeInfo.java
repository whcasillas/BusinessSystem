package com.hisun.bean.mess;

public class MessTypeInfo {
	private String mess_type_id;
	private String mess_type_name;
	public String getMess_type_id() {
		return mess_type_id;
	}
	public void setMess_type_id(String mess_type_id) {
		this.mess_type_id = mess_type_id;
	}
	public String getMess_type_name() {
		return mess_type_name;
	}
	public void setMess_type_name(String mess_type_name) {
		this.mess_type_name = mess_type_name;
	}
	@Override
	public String toString() {
		return "MessTypeInfo [mess_type_id=" + mess_type_id
				+ ", mess_type_name=" + mess_type_name + "]";
	}
	public MessTypeInfo(String mess_type_id, String mess_type_name) {
		super();
		this.mess_type_id = mess_type_id;
		this.mess_type_name = mess_type_name;
	}
	public MessTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
