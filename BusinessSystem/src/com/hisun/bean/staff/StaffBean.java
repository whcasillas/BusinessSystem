package com.hisun.bean.staff;

public class StaffBean {
	private String staff_id;
	private String staff_name;
	private String depart_id;
	private String state;
	private String role_id;
	private String tm_smp;
	private String update_staff;
	private String update_time;
	private String phone_number;
	private String e_mail;
	
	public StaffBean() {}
	
	
	public StaffBean(String staff_id, String staff_name, String depart_id,
			String state, String role_id, String tm_smp, String update_staff,
			String update_time, String phone_number, String e_mail) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.depart_id = depart_id;
		this.state = state;
		this.role_id = role_id;
		this.tm_smp = tm_smp;
		this.update_staff = update_staff;
		this.update_time = update_time;
		this.phone_number = phone_number;
		this.e_mail = e_mail;
	}


	public String getUpdate_staff() {
		return update_staff;
	}

	public void setUpdate_staff(String update_staff) {
		this.update_staff = update_staff;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(String depart_id) {
		this.depart_id = depart_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getTm_smp() {
		return tm_smp;
	}
	public void setTm_smp(String tm_smp) {
		this.tm_smp = tm_smp;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	
}
