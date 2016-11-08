package com.hisun.DAO.EvenInfoDao.interfaces;

import com.hisun.bean.even.Eventinfo;

import net.sf.json.JSONObject;

public interface IEvenInfoExcelDao {
	//获取要导出excel的事件集合接口
	public JSONObject queryEventListExcel(String event_no, String person, String start_dt, String ent_dt,String key,String event_mod_id,String event_sts,int start,int end )throws Exception;
	//获取选中的要导出excel的事件集合接口
	public JSONObject queryEvenselecttListExcel()throws Exception ;


}
