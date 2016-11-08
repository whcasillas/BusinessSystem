package com.hisun.DAO.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.interfaces.IStaffDAO;
import com.hisun.action.user.StaffPwdAction;
import com.hisun.bean.staff.DepartBean;
import com.hisun.bean.staff.RoleBean;
import com.hisun.bean.staff.StaffBean;
import com.hisun.bean.staff.StaffPwdBean;
import com.hisun.tools.ContextParams;
import com.hisun.tools.DBUtil;

public class StaffDAOImpl implements IStaffDAO {

	@Override
	public StaffBean getStaffInfo(String staff_id, String staff_pwd)
			throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from HS_M_STAFF s, HS_M_STAFF_PASSWORD p where s.staff_id = p.staff_id ");
		sb.append(" and state = '0' ");
		sb.append(" and s.staff_id = ? ");
		sb.append(" and p.staff_pwd = ? ");
		Object[] params = {staff_id, staff_pwd};
		JSONArray result = db.executeQueryData(sb.toString(), params);
		if(result.size() != 0){
			return (StaffBean)JSONObject.toBean(result.getJSONObject(0), StaffBean.class);
		}else{
			return null;
		}
	}

	@Override
	public DepartBean getDepartInfo(String depart_id) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from HS_M_DEPART where depart_id = ? and state = '0' ");
		Object[] params = {depart_id};
		JSONArray result = db.executeQueryData(sb.toString(), params);
		if(result.size() != 0){
			return (DepartBean)JSONObject.toBean(result.getJSONObject(0), DepartBean.class);
		}else{
			return null;
		}
	}

	@Override
	public RoleBean getRoleInfo(String role_id) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from HS_M_ROLE where role_id = ? and state = '0' ");
		Object[] params = {role_id};
		JSONArray result = db.executeQueryData(sb.toString(), params);
		if(result.size() != 0){
			return (RoleBean)JSONObject.toBean(result.getJSONObject(0), RoleBean.class);
		}else{
			return null;
		}
	}

	@Override
	public JSONArray getPowerInfo(String role_id) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from HS_M_POWER where role_id = ? and state = '0' ");
		Object[] params = {role_id};
		JSONArray result = db.executeQueryData(sb.toString(), params);
		if(result.size() != 0){
			
			return result;
		}else{
			return new JSONArray();
		}
	}

	@Override
	public JSONObject queryStaffList(String staff_id, String staff_name, int start, int end)
			throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select s.staff_id, s.staff_name, phone_number, e_mail, ");
		sb.append(" (select depart_name from hs_m_depart d where d.depart_id = s.depart_id) as depart_id, ");
		sb.append(" decode(s.state, '0', '正常', '1', '已注销') as state, ");
		sb.append(" (select role_name from hs_m_role r where r.role_id = s.role_id) as role_id, s.tm_smp ");
		sb.append(" from HS_M_STAFF s where 1=1 and role_id <> 'SUPERUSR' ");
		if(staff_id!=null&&!"".equals(staff_id))
			sb.append(" and staff_id = '" + staff_id + "' ");
		if(staff_name!=null&&!"".equals(staff_name))
			sb.append(" and staff_name like '%" + staff_name + "%' ");
		int count = db.getDataCount(sb.toString(), null);
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		array = db.executeQueryPaging(sb, null, start, end);
		System.out.println(sb.toString());
		result.put("resultset", array);
		result.put("count", count);
		return result;
		
	}

	@Override
	public StaffBean getStaffById(String staff_id) throws Exception {
		DBUtil db = new DBUtil();
		StaffBean bean = new StaffBean();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from hs_m_staff where staff_id = '" + staff_id + "' ");
		JSONArray array = db.executeQueryData(sb.toString(), null);
		JSONObject obj = new JSONObject();
		if(array.size() != 0){
			obj = array.getJSONObject(0);
			bean = (StaffBean)JSONObject.toBean(obj, StaffBean.class);
			return bean;
		}else{
			return null;
		}
	}

	
	
	@Override
	public boolean insertStaff(StaffBean staffInfo) throws Exception {
		DBUtil db = new DBUtil();
		
		String tm_smp = db.getSmpByDate();
		staffInfo.setTm_smp(tm_smp);
		staffInfo.setUpdate_time(tm_smp);
		StaffPwdBean bean = new StaffPwdBean();
		bean.setStaff_id(staffInfo.getStaff_id());
		bean.setStaff_pwd("123456");
		bean.setTm_smp(tm_smp);
		JSONObject param = JSONObject.fromObject(staffInfo);
		JSONObject pwd = JSONObject.fromObject(bean);
		boolean flag = db.insert("HS_M_STAFF", param);
		boolean flag1 = db.insert("HS_M_STAFF_PASSWORD", pwd);//设置初始密码;
		return flag&&flag1;
	}

	@Override
	public boolean saveStaff(StaffBean staffInfo) throws Exception {
		DBUtil db = new DBUtil();
		String tm_smp = db.getSmpByDate();
		staffInfo.setTm_smp(tm_smp);
		staffInfo.setUpdate_time(tm_smp);
		JSONObject param = JSONObject.fromObject(staffInfo);
		boolean flag = db.save("HS_M_STAFF", param, new String[]{"staff_id"}, new String[]{staffInfo.getStaff_id()});
		System.out.println("更新员工信息结果" + flag);
		return flag;
	}

	@Override
	public StaffPwdBean getStaffPwd(String staff_id) throws Exception {
		DBUtil db = new DBUtil();
		StaffPwdBean pwd = new StaffPwdBean();
		String sql = "select * from hs_m_staff_password where staff_id = '" + staff_id + "' ";
		JSONArray result = db.executeQueryData(sql, null);
		if(result.size() != 0){
			pwd = (StaffPwdBean)JSONObject.toBean(result.getJSONObject(0), StaffPwdBean.class);
			return pwd;
		}else{
			return null;
		}
		
	}

	@Override
	public boolean savePwd(StaffPwdBean bean) throws Exception {
		DBUtil db = new DBUtil();
		String tm_smp = db.getSmpByDate();
		bean.setTm_smp(tm_smp);
		JSONObject param = JSONObject.fromObject(bean);
		boolean flag = db.save("hs_m_staff_password", param, new String[]{"staff_id"}, new String[]{bean.getStaff_id()});
		return flag;
	}

	@Override
	public boolean deleteStaff(String staff_id, String doStaff, String xtag) throws Exception {
		DBUtil db = new DBUtil();
		JSONObject param = new JSONObject();
		param.put("update_time", db.getSmpByDate());
		param.put("update_staff", doStaff);
		if("1".equals(xtag)){
			param.put("state", ContextParams.ALL_STATE_CANCEL);
			db.delete("HS_M_STAFF_PASSWORD", new String[]{"staff_id"}, new String[]{staff_id});
		}else if("0".equals(xtag)){
			JSONObject obj = new JSONObject();
			obj.put("staff_id", staff_id);
			obj.put("staff_pwd", "123456");
			obj.put("tm_smp", db.getSmpByDate());
			db.insert("HS_M_STAFF_PASSWORD", obj);
			param.put("state", ContextParams.ALL_STATE_NORMAL);
		}
		
		boolean flag = db.save("HS_M_STAFF", param, new String[]{"staff_id"}, new String[]{staff_id});
		return flag;
	}

}
