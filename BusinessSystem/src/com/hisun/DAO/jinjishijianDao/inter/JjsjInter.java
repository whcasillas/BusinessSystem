package com.hisun.DAO.jinjishijianDao.inter;

import com.hisun.bean.jinjishijian.Jjsj;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface JjsjInter {
	/**
	 * 查询所有紧急事件信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryJinJiSJList(Jjsj bean, int start,int end )throws Exception;
	
	public JSONObject queryJinJiSJListzx(Jjsj bean, int start,int end )throws Exception;
	
	public boolean addJjsj(Jjsj bean)throws Exception;
	
	public JSONArray queryjjsjtype() throws Exception;
	
	public String CBjjsj(String jj_id)throws Exception;
	
	public String CLjjsj(String jj_id)throws Exception;
	
	public JSONObject  qusertjjsjall() throws Exception;
}
