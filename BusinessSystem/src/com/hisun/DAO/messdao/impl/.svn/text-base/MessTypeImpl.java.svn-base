package com.hisun.DAO.messdao.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.messdao.interfaces.MessTypeDao;
import com.hisun.tools.DBUtil;

public class MessTypeImpl implements MessTypeDao {
	public JSONObject queryMessTypeList( )throws Exception{
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		String sql = "select * from OPT_MESS_TYPE";
		array = db.executeQueryData(sql, null);
		
		result.put("result", array);
		return result;
		
	}
	
	public JSONObject queryMessType(String bank_id)throws Exception{
		return null;
		
	}
}
