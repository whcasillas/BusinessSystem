package com.hisun.bean.contact;
/**
 * 银行信息bean
 * @author Administrator
 *
 */
public class BankInfo {
	private String bank_id;
	private String bank_name;

	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	

	public BankInfo(String bank_id, String bank_name) {
		super();
		this.bank_id = bank_id;
		this.bank_name = bank_name;

	}
	
	public BankInfo() {
	
	}
	@Override
	public String toString() {
		return "BankInfo [bank_id=" + bank_id + ", bank_name=" + bank_name
				+ "]";
	}
	
	

}
