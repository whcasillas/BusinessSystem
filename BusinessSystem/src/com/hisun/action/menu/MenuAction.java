package com.hisun.action.menu;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.util.impl.UtilDAOImpl;
import com.hisun.DAO.util.interfaces.IUtilDAO;
import com.hisun.action.page.PageAction;
import com.hisun.bean.menu.MenuBean;
import com.hisun.bean.staff.DepartBean;

public class MenuAction extends PageAction {

	private String menu_id;
	private String parent_menu_id;
	private String menu_name;
	private String menu_url;
	private String depart_id;
	private String menu_level;
	
	
	
	public String getParent_menu_id() {
		return parent_menu_id;
	}



	public void setParent_menu_id(String parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}



	public String getMenu_url() {
		return menu_url;
	}



	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}



	public String getDepart_id() {
		return depart_id;
	}



	public void setDepart_id(String depart_id) {
		this.depart_id = depart_id;
	}



	public String getMenu_id() {
		return menu_id;
	}



	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}



	public String getMenu_name() {
		return menu_name;
	}



	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}



	public String getMenu_level() {
		return menu_level;
	}



	public void setMenu_level(String menu_level) {
		this.menu_level = menu_level;
	}



	public String queryMenuList()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		
		super.init();//分页初始化
		HttpServletRequest request = ServletActionContext.getRequest();
		IUtilDAO util = new UtilDAOImpl();
		String menu_id = getMenu_id();
		String menu_name = getMenu_name();
		String menu_level = getMenu_level();
		String depart_id = getDepart_id();
		JSONObject result = util.queryMenuList(menu_id, menu_name, menu_level, depart_id,getStart(), getEnd());
		JSONArray array = result.getJSONArray("resultset");
		List<MenuBean> list = new ArrayList<MenuBean>();
		for (int i = 0; i < array.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			MenuBean bean = (MenuBean) JSONObject.toBean(
					array.getJSONObject(i), MenuBean.class);
			list.add(bean);
		}
		JSONArray dpt = util.getDepartList();
		List<DepartBean> departList = new ArrayList<DepartBean>();
		//部门动态下拉框
		for(int i=0; i<dpt.size(); i++){
			JSONObject obj = dpt.getJSONObject(i);
			DepartBean debean = (DepartBean)JSONObject.toBean(obj, DepartBean.class);
			departList.add(debean);
		}
		request.setAttribute("departList", departList);
		int count = result.getInt("count");
		request.setAttribute("mList", list);
		request.setAttribute("count", count);
		return "Success";
	}
	
	public String initAddMenu()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		IUtilDAO util = new UtilDAOImpl();
		JSONArray dpt = util.getDepartList();
		MenuBean menu = new MenuBean("","","","","","");
		List<DepartBean> departList = new ArrayList<DepartBean>();
		//部门动态下拉框
		for(int i=0; i<dpt.size(); i++){
			JSONObject obj = dpt.getJSONObject(i);
			DepartBean debean = (DepartBean)JSONObject.toBean(obj, DepartBean.class);
			departList.add(debean);
		}
		request.setAttribute("MENU", menu);
		request.setAttribute("departList", departList);
		request.setAttribute("tag", "1");
		return "SUCCESS";
	}
	
	public void getParentMenuInfo()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		IUtilDAO util = new UtilDAOImpl();
		String menu_level = getMenu_level();
		PrintWriter pw = response.getWriter();
		JSONObject parent = new JSONObject();
		JSONArray array = util.getParentMenuInfo(menu_level);
		if(array!=null){
			for(int i=0; i<array.size(); i++){
				JSONObject obj = array.getJSONObject(i);
				parent.put(obj.getString("menu_name"), obj.getString("menu_id"));
			}
			pw.write(parent.toString());
		}else{
			pw.write("");
		}
		pw.flush();
		pw.close();
	}
	
	public String getMenuInfo()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String menu_id = request.getParameter("menu_id");
		IUtilDAO util = new UtilDAOImpl();
		MenuBean menu = util.getMenuInfo(menu_id);
		if(menu.getMenu_url() == null){
			menu.setMenu_url("");
		}
		if(menu!=null){
			JSONArray dpt = util.getDepartList();
			List<DepartBean> departList = new ArrayList<DepartBean>();
			//部门动态下拉框
			for(int i=0; i<dpt.size(); i++){
				JSONObject obj = dpt.getJSONObject(i);
				DepartBean debean = (DepartBean)JSONObject.toBean(obj, DepartBean.class);
				departList.add(debean);
			}
			request.setAttribute("departList", departList);
			request.setAttribute("MENU", menu);
			request.setAttribute("tag", "2");
		}
		return "Success";
	}
	
	public void addAndModifyMenuInfo()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		IUtilDAO util = new UtilDAOImpl();
		String tag = request.getParameter("tag");
		PrintWriter pw = response.getWriter();
		MenuBean menu = new MenuBean(getMenu_id(),getParent_menu_id(),getMenu_name(), getMenu_url(),getDepart_id(),getMenu_level());
		String result = "";
		if("1".equals(tag)){
			//新增
			int count = util.getMenuCount(menu.getMenu_id());
			if(count > 0){
				result = "-2";
			}else{
				result = util.addMenuInfo(menu)?"0":"1";
			}
			
		}else if("2".equals(tag)){
			//修改
			result = util.saveMenuInfo(menu)?"0":"1";
		}
		pw.write(result);
		pw.flush();
		pw.close();
	}
}
