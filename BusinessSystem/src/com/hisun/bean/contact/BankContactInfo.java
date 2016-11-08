package com.hisun.bean.contact;

public class BankContactInfo {
	private String bank_name; 				//银行名称
	private String bank_type;					//银行业务类型	
	private String contact_name;			//联系人姓名
	private String bank_contact_typ;		//银行联系人服务类型
	private String contact_mbl;				//联系人电话
	private String contact_email;			//联系人邮箱
	private String contact_qq;				//联系人qq
	private String bank_address;			//银行地址
	private String contact_remarks;		//备注
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getBank_contact_typ() {
		return bank_contact_typ;
	}
	public void setBank_contact_typ(String bank_contact_typ) {
		this.bank_contact_typ = bank_contact_typ;
	}
	public String getContact_mbl() {
		return contact_mbl;
	}
	public void setContact_mbl(String contact_mbl) {
		this.contact_mbl = contact_mbl;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getContact_qq() {
		return contact_qq;
	}
	public void setContact_qq(String contact_qq) {
		this.contact_qq = contact_qq;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public String getContact_remarks() {
		return contact_remarks;
	}
	public void setContact_remarks(String contact_remarks) {
		this.contact_remarks = contact_remarks;
	}
	@Override
	public String toString() {
		return "BankContactInfo [bank_name=" + bank_name + ", bank_type="
				+ bank_type + ", contact_name=" + contact_name
				+ ", bank_contact_typ=" + bank_contact_typ + ", contact_mbl="
				+ contact_mbl + ", contact_email=" + contact_email
				+ ", contact_qq=" + contact_qq + ", bank_address="
				+ bank_address + ", contact_remarks=" + contact_remarks + "]";
	}
	public BankContactInfo() {
	}
	public BankContactInfo(String bank_name, String bank_type,
			String contact_name, String bank_contact_typ, String contact_mbl,
			String contact_email, String contact_qq, String bank_address,
			String contact_remarks) {
		super();
		this.bank_name = bank_name;
		this.bank_type = bank_type;
		this.contact_name = contact_name;
		this.bank_contact_typ = bank_contact_typ;
		this.contact_mbl = contact_mbl;
		this.contact_email = contact_email;
		this.contact_qq = contact_qq;
		this.bank_address = bank_address;
		this.contact_remarks = contact_remarks;
	}
	
	
	
	
	
}
