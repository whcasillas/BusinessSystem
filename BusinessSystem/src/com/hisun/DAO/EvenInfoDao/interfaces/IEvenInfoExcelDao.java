package com.hisun.DAO.EvenInfoDao.interfaces;

import com.hisun.bean.even.Eventinfo;

import net.sf.json.JSONObject;

public interface IEvenInfoExcelDao {
	//��ȡҪ����excel���¼����Ͻӿ�
	public JSONObject queryEventListExcel(String event_no, String person, String start_dt, String ent_dt,String key,String event_mod_id,String event_sts,int start,int end )throws Exception;
	//��ȡѡ�е�Ҫ����excel���¼����Ͻӿ�
	public JSONObject queryEvenselecttListExcel()throws Exception ;


}
