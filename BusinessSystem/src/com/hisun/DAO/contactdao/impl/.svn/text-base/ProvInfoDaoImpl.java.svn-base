package com.hisun.DAO.contactdao.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.contactdao.interfaces.ProvInfoDao;
import com.hisun.tools.DBUtil;

public class ProvInfoDaoImpl implements ProvInfoDao {

	@Override
	public JSONObject queryProvList() throws Exception {
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		String sql = "select data_id prov_id,data_name prov_name from hs_m_static where TYPE_ID='PROV'";
		array = db.executeQueryData(sql, null);
		
		result.put("result", array);
		return result;
	}

	@Override
	public JSONObject queryProv() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
