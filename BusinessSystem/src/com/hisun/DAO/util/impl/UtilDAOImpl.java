package com.hisun.DAO.util.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.util.interfaces.IUtilDAO;
import com.hisun.bean.menu.MenuBean;
import com.hisun.tools.DBUtil;

public class UtilDAOImpl implements IUtilDAO {

	@Override
	public JSONArray getDepartList() throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from hs_m_depart";
		JSONArray array = db.executeQueryData(sql, null);
		return array;
	}

	@Override
	public JSONArray getRoleList() throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from hs_m_role";
		JSONArray array = db.executeQueryData(sql, null);
		return array;
	}

	@Override
	public List<MenuBean> getMenuList(String depart_id, String role_id) throws Exception {
		DBUtil db = new DBUtil();
		List<MenuBean> list = new ArrayList<MenuBean>();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from hs_m_menu where 1=1 ");
		if(!"SUPERUSR".equals(role_id)){
			sb.append(" and depart_id = '" + depart_id + "' ");
		}
		JSONArray array = db.executeQueryData(sb.toString(), null);
		if(array.size()!=0){
			for(int i=0; i<array.size(); i++){
				JSONObject obj = array.getJSONObject(i);
				MenuBean menu = (MenuBean)JSONObject.toBean(obj, MenuBean.class);
				list.add(menu);
			}
		}
		return list;
	}

	@Override
	public JSONObject queryMenuList(String menu_id, String menu_name,
			String menu_level,String depart_id, int start, int end) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select m.menu_id,m.parent_menu_id, m.menu_name, m.menu_url, ");
		sb.append(" (select depart_name from hs_m_depart d where d.depart_id = m.depart_id) as depart_id, ");
		sb.append(" decode(m.menu_level,'1','一级菜单','2','二级菜单','3','三级菜单') as menu_level ");
		sb.append(" from hs_m_menu m where 1=1 ");
		if(!"".equals(menu_id)&&null!=menu_id){
			sb.append(" and m.menu_id ='" + menu_id + "' ");
		}
		if(!"".equals(menu_name)&&null!=menu_name){
			sb.append(" and m.menu_name like '%'||'" + menu_name + "'||'%' ");
		}
		if(!"".equals(menu_level)&&null!=menu_level){
			sb.append(" and m.menu_level ='" + menu_level + "' ");
		}
		if(!"".equals(depart_id)&&null!=depart_id){
			sb.append(" and m.depart_id ='" + depart_id + "' ");
		}
		int count = db.getDataCount(sb.toString(), null);
		JSONArray array = db.executeQueryPaging(sb, null, start, end);
		
		JSONObject result = new JSONObject();
		result.put("resultset", array);
		result.put("count", count);
		
		return result;
	}

	@Override
	public JSONArray getParentMenuInfo(String menu_level) throws Exception {
		DBUtil db = new DBUtil();
		StringBuffer sb = new StringBuffer("");
		sb.append(" select * from hs_m_menu where 1=1 ");
		if("1".equals(menu_level)){
			return null;
		}else if("2".equals(menu_level)){
			sb.append(" and menu_level = '1' ");
		}else if("3".equals(menu_level)){
			sb.append(" and menu_level = '2' ");
		}
		return db.executeQueryData(sb.toString(), null);
	}

	@Override
	public boolean addMenuInfo(MenuBean bean) throws Exception {
		DBUtil db = new DBUtil();
		if("".equals(bean.getParent_menu_id())||bean.getParent_menu_id() == null){
			bean.setParent_menu_id("-1");
		}
		return db.insert("hs_m_menu", JSONObject.fromObject(bean));
	}
	
	public int getMenuCount(String menuid)throws Exception{
		DBUtil db = new DBUtil();
		String sql = "select * from hs_m_menu where menu_id = '" + menuid + "'";
		int count = db.getDataCount(sql, null);
		return count;
	}

	@Override
	public boolean saveMenuInfo(MenuBean bean) throws Exception {
		DBUtil db = new DBUtil();
		if("".equals(bean.getParent_menu_id())||bean.getParent_menu_id() == null){
			bean.setParent_menu_id("-1");
		}
		return db.save("hs_m_menu", JSONObject.fromObject(bean), new String[]{"menu_id"}, new String[]{bean.getMenu_id()});
	}

	@Override
	public MenuBean getMenuInfo(String menu_id) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from hs_m_menu where menu_id = '" + menu_id + "' ";
		JSONArray array = db.executeQueryData(sql, null);
		if(array.size() > 0){
			JSONObject obj = array.getJSONObject(0);
			return (MenuBean)JSONObject.toBean(obj, MenuBean.class);
		}else return null;
	}
	
	

}
