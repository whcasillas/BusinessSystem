package com.hisun.DAO.jinjishijianDao.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.jinjishijianDao.inter.JjsjInter;
import com.hisun.bean.jinjishijian.Jjsj;
import com.hisun.tools.DBUtil;

public class JjsjImpl implements JjsjInter {

	@Override
	public JSONObject queryJinJiSJList(Jjsj bean, int start,int end) throws Exception {
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		//CL_STS=0  未处理  CL_STS=1  已处理
		sql.append("select *  from jjsj_info where  CL_STS='0' ");
		
		if(!("".equals(bean.getSj_id())||bean.getSj_id()==null)){
			sql.append("and SJ_ID='"+bean.getSj_id()+"' ");
		}
		sql.append("order by  cl_sts ASC , cb_num DESC ,tm_smp  ASC");
		array = db.executeQueryPaging(sql, null, start, end);
		JSONArray acount_array = db.executeQueryData(sql.toString(), null);
		result.put("count", acount_array.size());
		result.put("result", array);
		return result;
	}

	
	public JSONObject queryJinJiSJListzx(Jjsj bean, int start,int end) throws Exception {
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		//CL_STS=0  未处理  CL_STS=1  已处理
		sql.append("select *  from jjsj_info where  CL_STS='0' ");
		
		if(!("".equals(bean.getSj_id())||bean.getSj_id()==null)){
			sql.append("and SJ_ID='"+bean.getSj_id()+"' ");
		}
		sql.append("order by  cl_sts ASC , cb_num DESC ,tm_smp  ASC");
		array = db.executeQueryPaging(sql, null, start, end);
		JSONArray acount_array = db.executeQueryData(sql.toString(), null);
		result.put("count", acount_array.size());
		result.put("result", array);
		return result;
	}
	
	public JSONObject  qusertjjsjall() throws Exception{
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		sql.append("select *  from jjsj_info order by  cl_sts ASC , cb_num DESC ,tm_smp  DESC");
		array = db.executeQueryData(sql.toString(), null);
		result.put("result", array);
		return result;
	}
	
	
	public JSONObject  qusertjjsjWCL() throws Exception{
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		sql.append("select *  from jjsj_info where cl_sts='0' order by  cl_sts ASC , cb_num DESC ,tm_smp  DESC");
		array = db.executeQueryData(sql.toString(), null);
		result.put("result", array);
		return result;
	}
	
	public JSONObject  qusertjjsjYCL() throws Exception{
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		sql.append("select *  from jjsj_info where cl_sts='1'  order by  cl_sts ASC , cb_num DESC ,tm_smp  DESC");
		array = db.executeQueryData(sql.toString(), null);
		result.put("result", array);
		return result;
	}
	
	public boolean addJjsj(Jjsj bean) throws Exception{
		DBUtil db = new DBUtil();
		JSONObject json = new JSONObject();
		json.put("JJ_ID", bean.getJj_id());
		json.put("SJ_ID", bean.getSj_id());
		json.put("SJ_TYPE", bean.getSj_type());
		json.put("SJ_TITLE", bean.getSj_title());
		json.put("TM_SMP", bean.getTm_smp());
		json.put("CB_NUM", bean.getCb_num());
		json.put("CL_STS", bean.getCl_sts());
		return db.insert("JJSJ_INFO", json);
	}
	
	public boolean addJjsjzx(Jjsj bean) throws Exception{
		DBUtil db = new DBUtil();
		JSONObject json = new JSONObject();
		json.put("JJ_ID", bean.getJj_id());
		json.put("SJ_ID", bean.getSj_id());
		json.put("SJ_TYPE", bean.getSj_type());
		json.put("SJ_TITLE", bean.getSj_title());
		json.put("TM_SMP", bean.getTm_smp());
		json.put("CB_NUM", bean.getCb_num());
		json.put("CL_STS", bean.getCl_sts());
		return db.insert("JJSJ_INFO", json);
	}
	
	
	//查紧急事件类型
	public JSONArray queryjjsjtype() throws Exception {
		JSONArray array = new JSONArray();
		DBUtil db = new DBUtil();
		String sql = "select * from jjsj_type";
		array = db.executeQueryData(sql, null);
		return array;
	}
	
	public String CBjjsj(String jj_id) throws Exception{
		DBUtil db = new DBUtil();
		String sql = "update  jjsj_info set cb_num=cb_num+1 where jj_id='"+jj_id+"'";
		int ret = db.executeUpdate(sql, null);
		return null;
	}

	public String CBjjsjzx(String jj_id) throws Exception{
		DBUtil db = new DBUtil();
		String sql = "update  jjsj_info set cb_num=cb_num+1 where jj_id='"+jj_id+"'";
		int ret = db.executeUpdate(sql, null);
		return null;
	}
	
	public String CLjjsj(String jj_id) throws Exception{
		DBUtil db = new DBUtil();
		String sql = "update  jjsj_info set cl_sts='1' where jj_id='"+jj_id+"'";
		int ret = db.executeUpdate(sql, null);
		
		return null;
	}

	
	public String CLjjsjzx(String jj_id,String option,String tm_smp) throws Exception{
		DBUtil db = new DBUtil();
		String sql = "update  jjsj_info set cl_sts='1', opt_name='"+option+"',cl_smp='"+tm_smp+"' where jj_id='"+jj_id+"'";
		int ret = db.executeUpdate(sql, null);
		
		return null;
	}

}
