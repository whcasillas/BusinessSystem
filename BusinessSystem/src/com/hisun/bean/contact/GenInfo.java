package com.hisun.bean.contact;

public class GenInfo {
	private String gen_id;
	private String contact_id;
	private String buss_id;
	private String bank_id;
	private String bank_typ_id;
	private String pro_id;
	private String bank_contact_typ_id;
	private String tm_smp;
	private String gen_sts;	//状态标签0为正常 1为删除
	private String standby1;
	private String standby2;
	private String standby3;
	private String standby4;
	private String standby5;
	private String standby6;
	private String standby7;
	private String standby8;
	private String standby9;
	private String standby10;
	public String getGen_id() {
		return gen_id;
	}
	public void setGen_id(String gen_id) {
		this.gen_id = gen_id;
	}
	public String getContact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	public String getBuss_id() {
		return buss_id;
	}
	public void setBuss_id(String buss_id) {
		this.buss_id = buss_id;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_typ_id() {
		return bank_typ_id;
	}
	public void setBank_typ_id(String bank_typ_id) {
		this.bank_typ_id = bank_typ_id;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getBank_contact_typ_id() {
		return bank_contact_typ_id;
	}
	public void setBank_contact_typ_id(String bank_contact_typ_id) {
		this.bank_contact_typ_id = bank_contact_typ_id;
	}
	public String getTm_smp() {
		return tm_smp;
	}
	public void setTm_smp(String tm_smp) {
		this.tm_smp = tm_smp;
	}
	public String getGen_sts() {
		return gen_sts;
	}
	public void setGen_sts(String gen_sts) {
		this.gen_sts = gen_sts;
	}
	public String getStandby1() {
		return standby1;
	}
	public void setStandby1(String standby1) {
		this.standby1 = standby1;
	}
	public String getStandby2() {
		return standby2;
	}
	public void setStandby2(String standby2) {
		this.standby2 = standby2;
	}
	public String getStandby3() {
		return standby3;
	}
	public void setStandby3(String standby3) {
		this.standby3 = standby3;
	}
	public String getStandby4() {
		return standby4;
	}
	public void setStandby4(String standby4) {
		this.standby4 = standby4;
	}
	public String getStandby5() {
		return standby5;
	}
	public void setStandby5(String standby5) {
		this.standby5 = standby5;
	}
	public String getStandby6() {
		return standby6;
	}
	public void setStandby6(String standby6) {
		this.standby6 = standby6;
	}
	public String getStandby7() {
		return standby7;
	}
	public void setStandby7(String standby7) {
		this.standby7 = standby7;
	}
	public String getStandby8() {
		return standby8;
	}
	public void setStandby8(String standby8) {
		this.standby8 = standby8;
	}
	public String getStandby9() {
		return standby9;
	}
	public void setStandby9(String standby9) {
		this.standby9 = standby9;
	}
	public String getStandby10() {
		return standby10;
	}
	public void setStandby10(String standby10) {
		this.standby10 = standby10;
	}
	@Override
	public String toString() {
		return "GenInfo [gen_id=" + gen_id + ", contact_id=" + contact_id
				+ ", buss_id=" + buss_id + ", bank_id=" + bank_id
				+ ", bank_typ_id=" + bank_typ_id + ", pro_id=" + pro_id
				+ ", bank_contact_typ_id=" + bank_contact_typ_id + ", tm_smp="
				+ tm_smp + ", gen_sts=" + gen_sts + ", standby1=" + standby1
				+ ", standby2=" + standby2 + ", standby3=" + standby3
				+ ", standby4=" + standby4 + ", standby5=" + standby5
				+ ", standby6=" + standby6 + ", standby7=" + standby7
				+ ", standby8=" + standby8 + ", standby9=" + standby9
				+ ", standby10=" + standby10 + "]";
	}
	public GenInfo() {

	}
	public GenInfo(String gen_id, String contact_id, String buss_id,
			String bank_id, String bank_typ_id, String pro_id,
			String bank_contact_typ_id, String tm_smp, String gen_sts,
			String standby1, String standby2, String standby3, String standby4,
			String standby5, String standby6, String standby7, String standby8,
			String standby9, String standby10) {
		super();
		this.gen_id = gen_id;
		this.contact_id = contact_id;
		this.buss_id = buss_id;
		this.bank_id = bank_id;
		this.bank_typ_id = bank_typ_id;
		this.pro_id = pro_id;
		this.bank_contact_typ_id = bank_contact_typ_id;
		this.tm_smp = tm_smp;
		this.gen_sts = gen_sts;
		this.standby1 = standby1;
		this.standby2 = standby2;
		this.standby3 = standby3;
		this.standby4 = standby4;
		this.standby5 = standby5;
		this.standby6 = standby6;
		this.standby7 = standby7;
		this.standby8 = standby8;
		this.standby9 = standby9;
		this.standby10 = standby10;
	}
	
	

}
