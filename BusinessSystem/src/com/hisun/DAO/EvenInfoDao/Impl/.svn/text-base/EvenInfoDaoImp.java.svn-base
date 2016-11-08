package com.hisun.DAO.EvenInfoDao.Impl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.hisun.DAO.EvenInfoDao.interfaces.IEvenInfoDao;
import com.hisun.bean.even.Eventinfo;
import com.hisun.tools.DBUtil;

public class EvenInfoDaoImp implements  IEvenInfoDao{

	@Override
	public JSONObject queryEventList(String event_no, String person, String start_dt, String ent_dt,String event_key,String event_mod_id,String event_sts,int start,int end) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer condition = new StringBuffer("");
		condition.append("select inf.event_no,inf.event_key,inf.tm_smp,inf.event_person,inf.cre_dt,cre_tm,mo.event_mod_nm from YW_EVENTINF inf, YW_EVENTMODE mo where inf.EVENT_MOD_ID= mo.EVENT_MOD_ID ");
		
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
		if(start_dt!=null&&!"".equals(start_dt)&& ent_dt!=null&&!"".equals(ent_dt)){
			condition.append(" and inf.cre_dt > = '" + start_dt + "' and inf.cre_dt <= '"+ ent_dt +"' ");
		}
		if(event_mod_id!=null&&!"".equals(event_mod_id)){
			condition.append(" and inf.event_mod_id  = '" + event_mod_id + "' ");
		}
		condition.append("order by  cre_dt desc ,cre_tm desc");
		System.out.println(condition);
		//查询总行数
		int count = db.getDataCount(condition.toString(), null);
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryPaging(condition, null, start, end);
		System.out.println(condition.toString());
		result.put("resultset", array);
		result.put("count", count);
		return result;
	}

	@Override
	public boolean AddEvent(Eventinfo bean) throws Exception {
		DBUtil db = new DBUtil();
		boolean falg=false;
		bean.setTm_smp(db.getSmpByDate());
		JSONObject ar=db.getSysTime();
		bean.setCre_dt(ar.getString("nowDate"));
		bean.setCre_tm(ar.getString("nowTime"));
		bean.setTm_smp(ar.getString("now"));
		if(bean.getEvent_no()==""||"".equals(bean.getEvent_no())){
			String seq_event_no =db.getSequenceByDate("SEQ_EVENT_NO");
			bean.setEvent_no(seq_event_no);
			}
		JSONObject JSON = JSONObject.fromObject(bean);
		
		JSON.remove("event_mod_nm");
		String sql="select * from YW_EVENTINF where event_no ='"+bean.getEvent_no()+"'";
		JSONArray result = db.executeQueryData(sql, null);
		if(result.size()>0){
		  return falg;
		}
		else{
		 falg=db.insert("YW_EVENTINF", JSON);
		  return falg;
		  
		}
	}

	@Override
	public boolean UpdEvent(Eventinfo bean) throws Exception {
		DBUtil db = new DBUtil();
		JSONObject ar=db.getSysTime();
		bean.setTm_smp(ar.getString("now"));
		bean.setUpd_dt(ar.getString("nowDate"));
		bean.setUpd_tm(ar.getString("nowTime"));
		JSONObject params = JSONObject.fromObject(bean);
		params.remove("event_mod_nm");
		boolean falg =db.save("YW_EVENTINF", params,new String [] {"event_no"},new String[]{ bean.getEvent_no()});
		return falg;
	}

	@Override
	public boolean deleteEvent(JSONObject js) throws Exception {
		DBUtil db = new DBUtil();
		JSONObject ar=db.getSysTime();
		js.put("tm_smp", ar.getString("now"));
		js.remove("even_mod_nm");
		boolean falg =db.save("YW_EVENTINF", js,new String [] {"event_no"},new String[]{js.getString("event_no")});
		return falg;
	}

	@Override
	public Eventinfo selectEventBean(String event_no) throws Exception {
		DBUtil db = new DBUtil();
		Eventinfo bean = new Eventinfo();
		StringBuffer sql = new StringBuffer("");
		sql.append(" select * from YW_EVENTINF where event_no = '" + event_no + "' ");
		System.out.print(sql);
		JSONArray array = db.executeQueryData(sql.toString(), null);
		JSONObject obj = new JSONObject();
		if(array.size() != 0){
			obj = array.getJSONObject(0);
			bean = (Eventinfo)JSONObject.toBean(obj, Eventinfo.class);
			return bean;
		}else{
			return null;
		}
	}

	@Override
	public JSONObject queryEvenselecttList() throws Exception {
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
