package com.hisun.DAO.interfaces;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.bean.staff.DepartBean;
import com.hisun.bean.staff.RoleBean;
import com.hisun.bean.staff.StaffBean;
import com.hisun.bean.staff.StaffPwdBean;

public interface IStaffDAO {

	public StaffBean getStaffInfo(String staff_id, String staff_pwd) throws Exception;
	public DepartBean getDepartInfo(String depart_id)throws Exception;
	public RoleBean getRoleInfo(String role_id)throws Exception;
	public JSONArray getPowerInfo(String role_id)throws Exception;
	
	public JSONObject queryStaffList(String Staff_id, String staff_name, int start, int end)throws Exception;
	
	public StaffBean getStaffById(String staff_id)throws Exception;
	
	public boolean insertStaff(StaffBean staffInfo)throws Exception;
	
	public boolean saveStaff(StaffBean staffInfo)throws Exception;
	
	public StaffPwdBean getStaffPwd(String staff_id)throws Exception;
	
	public boolean savePwd(StaffPwdBean bean)throws Exception;
	
	public boolean deleteStaff(String staff_id, String doStaff, String xtag)throws Exception;
}
