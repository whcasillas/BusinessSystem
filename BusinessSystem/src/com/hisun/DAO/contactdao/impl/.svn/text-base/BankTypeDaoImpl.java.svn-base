package com.hisun.DAO.contactdao.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.contactdao.interfaces.BankTypeDao;
import com.hisun.tools.DBUtil;

public class BankTypeDaoImpl implements BankTypeDao {

	@Override
	public JSONObject queryBankTypeList() throws Exception {
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		String sql = "select data_id bank_typ_id  , data_name bank_typ_name   from hs_m_static where TYPE_ID='BTYP'";
		array = db.executeQueryData(sql, null);
		
		result.put("result", array);
		return result;
	}
	
	@Override
	public JSONObject queryBankType() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
