package com.hisun.DAO.contactdao.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.contactdao.interfaces.BankInfoDao;
import com.hisun.bean.contact.ContackInfoQueryBean;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.tools.DBUtil;

public class BankInfoDaoImpl implements BankInfoDao {

	@Override
	public JSONObject queryBankList( ) throws Exception {
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		String sql = "select data_id bank_id,data_name bank_name from hs_m_static where TYPE_ID='BANK'";
		array = db.executeQueryData(sql, null);
		
		result.put("result", array);
		return result;
	}

	@Override
	public JSONObject queryBank(String bank_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
