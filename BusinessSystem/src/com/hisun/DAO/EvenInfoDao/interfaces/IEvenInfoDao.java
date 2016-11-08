package com.hisun.DAO.EvenInfoDao.interfaces;

import com.hisun.bean.even.Eventinfo;

import net.sf.json.JSONObject;

public interface IEvenInfoDao {
	public JSONObject queryEventList(String event_no, String person, String start_dt, String ent_dt,String key,String event_mod_id,String event_sts,int start,int end )throws Exception;
	public JSONObject queryEvenselecttList()throws Exception ;
	public boolean AddEvent(Eventinfo bean)throws Exception ;
	public boolean UpdEvent(Eventinfo bean)throws Exception ;
	public Eventinfo selectEventBean(String id)throws Exception;
	public boolean deleteEvent(JSONObject js) throws Exception; 

}
