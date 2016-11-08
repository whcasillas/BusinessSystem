package com.hisun.DAO.role.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.role.interfaces.IRoleDAO;
import com.hisun.bean.staff.PowerBean;
import com.hisun.bean.staff.RoleBean;
import com.hisun.tools.DBUtil;

public class RoleDAOImpl implements IRoleDAO {

	@Override
	public JSONObject queryRoleList(String role_id, String role_name, int start, int end)
			throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select role_id, role_name, role_level, ");
		sb.append(" decode(state,'0','ÔÚÓÃ','1','×÷·Ï') as state ");
		sb.append(" from hs_m_role where 1=1 ");
		if(!"".equals(role_id)&&null!=role_id){
			sb.append(" and role_id = '" + role_id + "' ");
		}
		if(!"".equals(role_name)&&null!=role_name){
			sb.append(" and role_name like '%'||'" + role_name + "'||'%' ");
		}
		System.out.println("===========SQL===============" + sb.toString());
		JSONArray array = db.executeQueryPaging(sb, null, start, end);
		int count = db.getDataCount(sb.toString(), null);
		JSONObject result = new JSONObject();
		result.put("resultset", array);
		result.put("count", count);
		
		return result;
	}

	@Override
	public JSONArray getPowerInfo(String role_id) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select distinct power_id, power_name from hs_m_power ");
		sb.append(" where power_id not in (select distinct p.power_id ");
		sb.append(" from hs_m_power p where 1 = 1 and p.role_id = '" + role_id + "') ");
		System.out.println(sb.toString());
		JSONArray array = db.executeQueryData(sb.toString(), null);
		return array.size()>0?array:null;
	}

	@Override
	public JSONArray getRolePowerInfo(String role_id) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select distinct p.power_id, p.power_name ");
		sb.append(" from hs_m_power p where 1 = 1 and p.role_id = '" + role_id + "' ");
		System.out.println(sb.toString());
		JSONArray array = db.executeQueryData(sb.toString(), null);
		return array.size()>0?array:null;
	}

	@Override
	public RoleBean getRoleInfo(String role_id) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from hs_m_role where role_id ='" + role_id + "'";
		JSONArray array = db.executeQueryData(sql, null);
		RoleBean bean = null;
		if(array.size() != 0){
			bean = (RoleBean)JSONObject.toBean(array.getJSONObject(0), RoleBean.class);
		}
		return bean;
	}

	@Override
	public boolean savePowerInfo(List<PowerBean> powers) throws Exception {
		DBUtil db = new DBUtil();
		boolean flag1 = false;
		boolean flag2 = false;
		flag1 = db.delete("hs_m_power", new String[]{"role_id"}, new String[]{powers.get(0).getRole_id()});
		for(int i=0; i<powers.size(); i++){
			JSONObject obj = JSONObject.fromObject(powers.get(i));
			flag2 = db.insert("hs_m_power", obj);
			if(!flag2) return false;
		}
		return flag1&&flag2;
	}

	@Override
	public String insertPower(PowerBean power) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from hs_m_power where power_id = '" + power.getPower_id() + "' ";
		int count = db.getDataCount(sql, null);
		if(count > 0){
			return "-2";
		}
		boolean flag = db.insert("hs_m_power", JSONObject.fromObject(power));
		return flag?"0":"-1";
	}
	
	

}
