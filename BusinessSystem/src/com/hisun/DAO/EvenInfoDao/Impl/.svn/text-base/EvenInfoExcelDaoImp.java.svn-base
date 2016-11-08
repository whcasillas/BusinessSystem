package com.hisun.DAO.EvenInfoDao.Impl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.hisun.DAO.EvenInfoDao.interfaces.IEvenInfoExcelDao;
import com.hisun.tools.DBUtil;

public class EvenInfoExcelDaoImp implements  IEvenInfoExcelDao{

	@Override
	public JSONObject queryEventListExcel(String event_no, String person, String start_dt, String ent_dt,String event_key,String event_mod_id,String event_sts,int start,int end) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer condition = new StringBuffer("");
		condition.append("select inf.* ,mo.event_mod_nm from YW_EVENTINF inf, YW_EVENTMODE mo where inf.EVENT_MOD_ID= mo.EVENT_MOD_ID ");
		
		if(event_no!=null&&!"".equals(event_no)){
			condition.append(" and inf.event_no like '%'||'" + event_no + "'||'%' ");
		}
		if(event_key!=null&&!"".equals(event_key)){
			condition.append(" and inf.event_key like '%'||'" + event_key + "'||'%' ");
		}
		if(person!=null&&!"".equals(person)){
			condition.append(" and inf.event_person = '" + person + "' ");
		}
		if(event_sts!=null&&!"".equals(event_sts)){
			condition.append(" and inf.event_sts = '" + event_sts + "' ");
		}
		if(event_sts==null||"".equals(event_sts)){
			condition.append(" and inf.event_sts = '" + 0 + "' ");
		}
		if(start_dt!=null&&!"".equals(start_dt)&& ent_dt!=null&&!"".equals(ent_dt)){
			condition.append(" and inf.cre_dt > = '" + start_dt + "' and inf.cre_dt <= '"+ ent_dt +"' ");
		}
		if(event_mod_id!=null&&!"".equals(event_mod_id)){
			condition.append(" and inf.event_mod_id  = '" + event_mod_id + "' ");
		}
		condition.append("order by  cre_dt desc ,cre_tm desc");
		System.out.println(condition);
		
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryData(condition.toString(), null);
		result.put("resultset", array);
		return result;
	}

	
	@Override
	public JSONObject queryEvenselecttListExcel() throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer condition = new StringBuffer("");
		condition.append("select * from  YW_EVENTMODE  where 1=1 ");
		//查询总行数
		JSONObject result = new JSONObject();
		JSONArray array=db.executeQueryData(condition.toString(), null);
		result.put("arrayselelct", array);
		return result;
	}

}
