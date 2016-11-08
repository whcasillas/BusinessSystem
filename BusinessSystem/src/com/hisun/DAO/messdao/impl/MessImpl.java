package com.hisun.DAO.messdao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.messdao.interfaces.MessDao;
import com.hisun.bean.mess.MessInfo;
import com.hisun.tools.DBUtil;

public class MessImpl implements MessDao {

	/*
	 * 分页查询消息
	 * @see com.hisun.DAO.messdao.interfaces.MessDao#queryMessList(com.hisun.bean.mess.MessInfo, int, int)
	 */
	@Override
	public JSONObject queryMessList(MessInfo bean ,int start,int end) throws Exception {
		String opt_name=bean.getOpt_name();
		String mess_remarks = bean.getMess_remarks();
		String mess_date = bean.getMess_date();
		String mess_type = bean.getMess_type();
		String mess_status = bean.getMess_status();
		String event_id = bean.getEvent_id();
		
		StringBuffer sql  = new StringBuffer();
		sql.append("select * from opt_mess where mess_delstatus=0  ");
		if(!("".equals(mess_type)||mess_type==null)){
			sql.append(" and mess_type='"+mess_type.trim()+"'");
		}
		if(!("".equals(mess_date)||mess_date==null)){
			sql.append(" and mess_date='"+mess_date.trim()+"'");
		}
		if(!("".equals(opt_name)||opt_name==null)){
			sql.append(" and opt_name='"+opt_name.trim()+"'");
		}
		if(!("".equals(event_id)||event_id==null)){
			sql.append(" and event_id='"+event_id.trim()+"'");
		}
		if(!("".equals(mess_remarks)||mess_remarks==null)){
			sql.append(" and mess_remarks like '%"+mess_remarks.trim()+"%'");
		}
		if(!("".equals(mess_status)||mess_status==null)){
			sql.append(" and mess_status='"+mess_status.trim()+"'");
		}
		sql.append(" order by start_time desc");

		DBUtil db = new DBUtil();
		int count = db.getDataCount(sql.toString(), null);
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryPaging(sql, null, start,end);
		
		result.put("resultset", array);
		result.put("count", count);
		return result;
	}

	@Override
	public JSONObject queryMessselecttList(MessInfo bean) throws Exception {
		String opt_name=bean.getOpt_name();
		String opt_remarks = bean.getMess_remarks();
		String mess_date = bean.getMess_date();
		
		StringBuffer sql  = new StringBuffer();
		sql.append("select * from opt_mess where  mess_delstatus=0 and ");
		if(!("".equals(mess_date)||mess_date==null)){
			sql.append("and mess_date='"+mess_date.trim()+"'");
		}
		if(!("".equals(opt_name)||opt_name==null)){
			sql.append("and opt_name='"+opt_name.trim()+"'");
		}
		if(!("".equals(opt_remarks)||opt_remarks==null)){
		}
		
		DBUtil db = new DBUtil();
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryData(sql.toString(), null);
		result.put("resultset", array);
		return result;
	}

	@Override
	public boolean AddMess(MessInfo bean) throws Exception {
		DBUtil db = new DBUtil();
		JSONObject json = new JSONObject();
		json.put("mess_id", bean.getMess_id());
		json.put("mess_type", bean.getMess_type());
		json.put("opt_name", bean.getOpt_name());
		json.put("start_time", bean.getStart_time());
		json.put("end_time", bean.getEnd_time());
		json.put("mess_remarks", bean.getMess_remarks());
		json.put("mess_status", bean.getMess_status());
		json.put("mess_date", bean.getMess_date());
		json.put("mess_delstatus", bean.getMess_delstatus());
		json.put("event_id", bean.getEvent_id());
		return db.insert("OPT_MESS", json);
	}

	@Override
	public boolean UpdMess(MessInfo bean) throws Exception {
		StringBuffer  sql =new StringBuffer();
		sql.append("UPDATE OPT_MESS SET ");
		sql.append("end_time = '"+bean.getEnd_time().trim()+"',");
		sql.append("mess_remarks = '"+bean.getMess_remarks().trim()+"',");
		sql.append("event_id = '"+bean.getEvent_id().trim()+"',");
		sql.append("mess_status = '"+bean.getMess_status()+"'");
		sql.append(" WHERE mess_id = '"+bean.getMess_id()+"' ");
		DBUtil db = new DBUtil();
		if (db.executeUpdate(sql.toString(), null)==1){
			return true;
		}
		return false;
	}

	@Override
	public MessInfo selectMessBean(String id) throws Exception {
		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT * from OPT_MESS where mess_delstatus='0' ");
		sql.append("and mess_id='"+id+"'");
		
		DBUtil db = new DBUtil();
		JSONArray jarray = db.executeQueryData(sql.toString(), null	);
		if (jarray.isEmpty()){
			return null;
		}
		//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
		MessInfo cib = (MessInfo) JSONObject.toBean(jarray.getJSONObject(0), MessInfo.class);
		return cib;
	}

	@Override
	public boolean deleteMess(JSONObject js) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sql = new StringBuffer();
		sql.append("update  OPT_MESS set mess_delstatus='1'  where mess_id in (");
		
		String ids[] = ((String) js.get("ids")).split(",");
		for (int i = 0; i < ids.length; i++) {
			if(i==(ids.length-1)){
				sql.append("'"+ids[i]+"'");
			}else{
				sql.append("'"+ids[i]+"',");
			}
		}
		sql.append(")");
		
		int affectedLine = db.executeUpdate(sql.toString(), null);
		if(affectedLine>=1){
			return true;
		}else{return false;}
	}

	@Override
	public JSONObject queryMessListLastTwoDays(MessInfo bean)
			throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String  date = df.format(new Date()); //用时间戳来作为联系人的编号
		
		StringBuffer sql  = new StringBuffer();
		sql.append("select * from opt_mess where mess_delstatus =0 ");
		sql.append(" and (mess_date >= '"+(Integer.parseInt(date)-1) +"' ");
		sql.append("or mess_status =0) ");
		sql.append("order by start_time desc");
		
		DBUtil db = new DBUtil();
		int count = db.getDataCount(sql.toString(), null);
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryData(sql.toString(), null);
		
		result.put("resultset", array);
		result.put("count", count);
		return result;
	}
	
}
