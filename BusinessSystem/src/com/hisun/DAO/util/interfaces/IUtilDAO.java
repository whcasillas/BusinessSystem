package com.hisun.DAO.util.interfaces;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.bean.menu.MenuBean;

public interface IUtilDAO {

	public JSONArray getDepartList()throws Exception;
	
	public JSONArray getRoleList()throws Exception;
	
	public List<MenuBean> getMenuList(String depart_id, String role_id)throws Exception;
	
	public JSONObject queryMenuList(String menu_id, String menu_name, String menu_level, String depart_id, int start, int end) throws Exception;
	
	public JSONArray getParentMenuInfo(String menu_level)throws Exception;
	
	public boolean addMenuInfo(MenuBean bean)throws Exception;
	
	public boolean saveMenuInfo(MenuBean bean)throws Exception;
	
	public int getMenuCount(String menuid)throws Exception;
	
	public MenuBean getMenuInfo(String menu_id)throws Exception;
}
