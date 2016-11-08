package com.hisun.DAO.contactdao.impl;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.hisun.DAO.contactdao.interfaces.ContactInfoDao;
import com.hisun.bean.contact.ContackInfoQueryBean;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.tools.DBUtil;

public class ContactInfoDaoImpl implements ContactInfoDao {

	
	@Override
	public JSONObject queryContactList(ContactInfo bean, int start,int end)
			throws Exception {
		String bank_name = bean.getBank_name(); // 银行名称
		String contact_name = bean.getContact_name(); // 联系人名称
		String bank_type = bean.getBank_type();// 银行业务类型
		String bank_contact_typ = bean.getBank_contact_typ(); // 银行联系人服务类型
		String contact_mbl = bean.getContact_mbl(); // 联系人电话
		String contact_email = bean.getContact_email(); // 联系人邮箱
		String contact_qq = bean.getContact_qq(); // 联系人qq
		String bank_address = bean.getBank_address(); // 银行地址
		String contact_remarks = bean.getContact_remarks();//备注
		
		StringBuffer condition = new StringBuffer("");
		condition.append("SELECT RV001 contact_id, RV002 bank_name,RV003 bank_type,RV004 bank_address,RV005 contact_name," +
				"RV006 contact_mbl,RV007 contact_email,RV008 contact_qq,RV009 contact_remarks,RV010 bank_contact_typ " +
				"FROM HS_M_CONNECT_INFO  where RV015='BANK' and   RV012='0' ");
		if(!("".equals(bank_name)||bank_name==null)){
			condition.append("and RV002='"+bank_name+"'");
		}
		if(!("".equals(bank_type)||bank_type==null)){
			condition.append("and RV003='"+bank_type+"'");
		}
		if(!("".equals(bank_address)||bank_address==null)){
			condition.append("and RV004  like '%"+bank_address+"%'");
		}
		if(!("".equals(contact_name)||contact_name==null)){
			condition.append("and RV005 like '%"+contact_name+"%'");
		}
		if(!("".equals(contact_mbl)||contact_mbl==null)){
			condition.append("and RV006 like '%"+contact_mbl+"%'");
		}
		if(!("".equals(contact_email)||contact_email==null)){
			condition.append("and RV007 like '%"+contact_email+"%'");
		}
		if(!("".equals(contact_qq)||contact_qq==null)){
			condition.append("and RV008 like '%"+contact_qq+"%'");
		}
		if(!("".equals(contact_remarks)||contact_remarks==null)){
			condition.append("and RV009 like '%"+contact_remarks+"%'");
		}
		if(!("".equals(bank_contact_typ)||bank_contact_typ==null)){
			condition.append("and RV010 like '%"+bank_contact_typ+"%'");
		}
		condition.append(" order by RV011 ");
		
		DBUtil db = new DBUtil();
		int count = db.getDataCount(condition.toString(), null);
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryPaging(condition, null, start,end);
		System.out.println(condition.toString());
		result.put("resultset", array);
		result.put("count", count);
		return result;
	}

	@Override
	public JSONObject queryContactselecttList(ContactInfo bean) throws Exception {
		String bank_name = bean.getBank_name(); // 银行名称
		String contact_name = bean.getContact_name(); // 联系人名称
		String bank_type = bean.getBank_type();// 银行业务类型
		String bank_contact_typ = bean.getBank_contact_typ(); // 银行联系人服务类型
		String contact_mbl = bean.getContact_mbl(); // 联系人电话
		String contact_email = bean.getContact_email(); // 联系人邮箱
		String contact_qq = bean.getContact_qq(); // 联系人qq
		String bank_address = bean.getBank_address(); // 银行地址
		String contact_remarks = bean.getContact_remarks();//备注
		
		StringBuffer condition = new StringBuffer("");
		condition.append("SELECT RV001 contact_id, RV002 bank_name,RV003 bank_type,RV004 bank_address,RV005 contact_name," +
				"RV006 contact_mbl,RV007 contact_email,RV008 contact_qq,RV009 contact_remarks,RV010 bank_contact_typ " +
				"FROM HS_M_CONNECT_INFO  where RV015='BANK' and RV012='0' ");
		if(!("".equals(bank_name)||bank_name==null)){
			condition.append("and RV002='"+bank_name+"'");
		}
		if(!("".equals(bank_type)||bank_type==null)){
			condition.append("and RV003='"+bank_type+"'");
		}
		if(!("".equals(bank_address)||bank_address==null)){
			condition.append("and RV004  like '%"+bank_address+"%'");
		}
		if(!("".equals(contact_name)||contact_name==null)){
			condition.append("and RV005 like '%"+contact_name+"%'");
		}
		if(!("".equals(contact_mbl)||contact_mbl==null)){
			condition.append("and RV006 like '%"+contact_mbl+"%'");
		}
		if(!("".equals(contact_email)||contact_email==null)){
			condition.append("and RV007 like '%"+contact_email+"%'");
		}
		if(!("".equals(contact_qq)||contact_qq==null)){
			condition.append("and RV008 like '%"+contact_qq+"%'");
		}
		if(!("".equals(contact_remarks)||contact_remarks==null)){
			condition.append("and RV009 like '%"+contact_remarks+"%'");
		}
		if(!("".equals(bank_contact_typ)||bank_contact_typ==null)){
			condition.append("and RV010 like '%"+bank_contact_typ+"%'");
		}
		
		DBUtil db = new DBUtil();
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryData(condition.toString(), null);
		result.put("resultset", array);
		return result;
	}

	@Override
	public boolean AddContact(ContactInfo bean) throws Exception {
		DBUtil db = new DBUtil();
		JSONObject json = new JSONObject();
		json.put("RV001", bean.getContact_id());
		json.put("RV002", bean.getBank_name());
		json.put("RV003", bean.getBank_type());
		json.put("RV004", bean.getBank_address());
		json.put("RV005", bean.getContact_name());
		json.put("RV006", bean.getContact_mbl());
		json.put("RV007", bean.getContact_email());
		json.put("RV008", bean.getContact_qq());
		json.put("RV009", bean.getContact_remarks());
		json.put("RV010", bean.getBank_contact_typ());
		json.put("RV011", bean.getTm_smp());
		json.put("RV012", "0");
		json.put("RV015", "BANK");
		
		return db.insert("HS_M_CONNECT_INFO", json);
	}

	@Override
	public boolean UpdContact(ContactInfo bean) throws Exception {
		///RV006 contact_mbl,RV007 contact_email,RV008 contact_qq,RV009 contact_remarks,RV010 bank_contact_typ
		StringBuffer  sql =new StringBuffer();
		sql.append("UPDATE  HS_M_CONNECT_INFO SET ");
		sql.append("RV004 = '"+bean.getBank_address()+"',");
		sql.append("RV005 = '"+bean.getContact_name()+"',");
		sql.append("RV006 = '"+bean.getContact_mbl()+"',");
		sql.append("RV007 = '"+bean.getContact_email()+"',");
		sql.append("RV008 = '"+bean.getContact_qq()+"',");
		sql.append("RV009 = '"+bean.getContact_remarks()+"',");
		sql.append("RV010 = '"+bean.getBank_contact_typ()+"',");
		sql.append("RV011 = '"+bean.getTm_smp()+"'");
		sql.append(" WHERE RV001 = '"+bean.getContact_id()+"' ");
		
		DBUtil db = new DBUtil();
		if (db.executeUpdate(sql.toString(), null)==1){
			return true;
		}
		return false;
	}

	@Override
	public ContactInfo selectContactBean(String id) throws Exception {
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT RV001 contact_id, RV002 bank_name,RV003 bank_type,RV004 bank_address,RV005 contact_name," +
				"RV006 contact_mbl,RV007 contact_email,RV008 contact_qq,RV009 contact_remarks,RV010 bank_contact_typ " +
				"FROM HS_M_CONNECT_INFO  where RV015='BANK' and   RV012='0' ");
		sql.append("and RV001='"+id+"'");
		
		DBUtil db = new DBUtil();
		JSONArray jarray = db.executeQueryData(sql.toString(), null	);
		if (jarray.isEmpty()){
			return null;
		}
		//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
		ContactInfo cib = (ContactInfo) JSONObject.toBean(jarray.getJSONObject(0), ContactInfo.class);
		return cib;
	}

	@Override
	public boolean deleteContact(JSONObject js) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		sql.append("update  HS_M_CONNECT_INFO set rv012='1'  where RV001 in (");
		
		String ids[] = ((String) js.get("ids")).split(",");
		for (int i = 0; i < ids.length; i++) {
			if(i==(ids.length-1)){
				sql.append("'"+ids[i]+"'");
			}else{
				sql.append("'"+ids[i]+"',");
			}
		}
		sql.append(")");
		
		int affectedLine = db.executeUpdate(sql.toString(), null);
		if(affectedLine>=1){
			return true;
		}else{return false;}
		
	}

}
