package com.hisun.bean.contact;
/**
 * 银行类型bean
 * @author Administrator
 *
 */
public class BankType {
	private String bank_typ_id;
	private String bank_typ_name;
	public String getBank_typ_id() {
		return bank_typ_id;
	}
	public void setBank_typ_id(String bank_typ_id) {
		this.bank_typ_id = bank_typ_id;
	}
	public String getBank_typ_name() {
		return bank_typ_name;
	}
	public void setBank_typ_name(String bank_typ_name) {
		this.bank_typ_name = bank_typ_name;
	}
	
	public BankType(String bank_typ_id, String bank_typ_name) {
		super();
		this.bank_typ_id = bank_typ_id;
		this.bank_typ_name = bank_typ_name;
	
	}
	
	public BankType() {
	}
	@Override
	public String toString() {
		return "BankTyp [bank_typ_id=" + bank_typ_id + ", bank_typ_name="
				+ bank_typ_name + "]";
	}
	
	
}
