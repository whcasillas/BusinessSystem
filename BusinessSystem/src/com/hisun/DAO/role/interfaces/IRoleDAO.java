package com.hisun.DAO.role.interfaces;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.bean.staff.PowerBean;
import com.hisun.bean.staff.RoleBean;

public interface IRoleDAO {

	public JSONObject queryRoleList(String role_id, String role_name, int start, int end)throws Exception;
	
	public JSONArray getPowerInfo(String role_id)throws Exception;
	
	public JSONArray getRolePowerInfo(String role_id)throws Exception;
	
	public RoleBean getRoleInfo(String role_id)throws Exception;
	
	public boolean savePowerInfo(List<PowerBean> powers)throws Exception;
	
	public String insertPower(PowerBean power)throws Exception;
}
