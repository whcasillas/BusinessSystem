package com.hisun.action.user;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.impl.StaffDAOImpl;
import com.hisun.DAO.interfaces.IStaffDAO;
import com.hisun.DAO.util.impl.UtilDAOImpl;
import com.hisun.DAO.util.interfaces.IUtilDAO;
import com.hisun.action.page.PageAction;
import com.hisun.bean.menu.MenuBean;
import com.hisun.bean.staff.DepartBean;
import com.hisun.bean.staff.RoleBean;
import com.hisun.bean.staff.StaffBean;
import com.hisun.tools.ContextParams;
import com.opensymphony.xwork2.ActionContext;

public class StaffAction extends PageAction {

	private String staff_id;
	private String staff_id1;
	private String staff_name;
	private String staff_pwd;
	private String depart_id;
	private String state;
	private String role_id;
	private String tm_smp;
	private String phone_number;
	private String e_mail;
	
	public String getStaff_id1() {
		return staff_id1;
	}
	public void setStaff_id1(String staff_id1) {
		this.staff_id1 = staff_id1;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(String depart_id) {
		this.depart_id = depart_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getTm_smp() {
		return tm_smp;
	}
	public void setTm_smp(String tm_smp) {
		this.tm_smp = tm_smp;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_pwd() {
		return staff_pwd;
	}
	public void setStaff_pwd(String staff_pwd) {
		this.staff_pwd = staff_pwd;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public void staffLogin()throws Exception{
		ActionContext context = ServletActionContext.getContext();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter pw  = response.getWriter();
		String text = "";
		StaffBean staff = new StaffBean();
		DepartBean depart = new DepartBean();
		RoleBean role = new RoleBean();
		List<MenuBean> menu = new ArrayList<MenuBean>();
		JSONArray powers = new JSONArray();
		IStaffDAO dao = new StaffDAOImpl();
		IUtilDAO util = new UtilDAOImpl();
		staff = dao.getStaffInfo(getStaff_id(), getStaff_pwd());
		if(staff != null){
			menu = util.getMenuList(staff.getDepart_id(), staff.getRole_id());
			depart = dao.getDepartInfo(staff.getDepart_id());
			role = dao.getRoleInfo(staff.getRole_id());
			powers = dao.getPowerInfo(staff.getRole_id());
			request.getSession().setMaxInactiveInterval(3600*8);
			context.getSession().put("STAFFINFO", staff);
			context.getSession().put("DEPARTINFO", depart);
			context.getSession().put("ROLEINFO", role);
			context.getSession().put("POWERINFO", powers);
			context.getSession().put("MENULIST", menu);
			text = "0";
		}else{
			text = "-1";
		}
		pw.print(text);
		pw.flush();
		
	}
	
	public String queryStaffList()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		
		super.init();//分页初始化
		HttpServletRequest request = ServletActionContext.getRequest();
		IStaffDAO dao = new StaffDAOImpl();
		String staff_id = getStaff_id();
		String staff_name = getStaff_name();
		JSONObject result = dao.queryStaffList(staff_id, staff_name, getStart(), getEnd());
		JSONArray array = result.getJSONArray("resultset");
		//判断按钮权限
		boolean add = hasButtenProv(ContextParams.ADD_STAFF_POWER);
		boolean edit = hasButtenProv(ContextParams.EDIT_STAFF_POWER);
		List<StaffBean> list = new ArrayList<StaffBean>();
		for (int i = 0; i < array.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			StaffBean bean = (StaffBean) JSONObject.toBean(
					array.getJSONObject(i), StaffBean.class);
			list.add(bean);
		}
		int count = result.getInt("count");
		request.setAttribute("StaffList", list);
		request.setAttribute("count", count);
		request.setAttribute("add", add);
		request.setAttribute("edit", edit);
		return "Success";
	}
	
	public void deleteStaff()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		StaffBean nowStaff = (StaffBean)request.getSession().getAttribute("STAFFINFO");
		String text = "";
		PrintWriter pw = response.getWriter();
		String xtag = request.getParameter("xtag");
		String staff_id = request.getParameter("staff_id");
		IStaffDAO dao = new StaffDAOImpl();
		boolean flag = dao.deleteStaff(staff_id, nowStaff.getStaff_id(), xtag);
		if(flag){
			text = "0";
		}else{
			text = "-1";
		}
		pw.print(text);
		pw.flush();
	}
	
	public String getStaffInfo()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		IStaffDAO dao = new StaffDAOImpl();
		IUtilDAO util = new UtilDAOImpl();
		List<DepartBean> departList = new ArrayList<DepartBean>();
		List<RoleBean> roleList = new ArrayList<RoleBean>();
		String tag = request.getParameter("tag");
		request.setAttribute("tag", tag);
		
		JSONArray dpt = util.getDepartList();
		JSONArray role = util.getRoleList();
		//部门动态下拉框
		for(int i=0; i<dpt.size(); i++){
			JSONObject obj = dpt.getJSONObject(i);
			DepartBean debean = (DepartBean)JSONObject.toBean(obj, DepartBean.class);
			departList.add(debean);
		}
		//角色动态下拉框
		for(int i=0; i<role.size(); i++){
			JSONObject obj = role.getJSONObject(i);
			RoleBean rbean = (RoleBean)JSONObject.toBean(obj, RoleBean.class);
			roleList.add(rbean);
		}
		request.setAttribute("departList", departList);
		request.setAttribute("roleList", roleList);
		if(tag.equals("add")){
			StaffBean bean = new StaffBean("","","","","","","","","","");
			request.setAttribute("STAFF_INFO", bean);
			
			return "Success";
		}else if(tag.equals("upd")){
			String staff_id = request.getParameter("staff_id");
			StaffBean bean = dao.getStaffById(staff_id);
			if(bean != null){
				request.setAttribute("STAFF_INFO", bean);
				return "Success";
			}else{
				return "error";
			}
		}
		return "";
	}
	
	public void addModifyStaff()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String tag = request.getParameter("tag");
		IStaffDAO dao = new StaffDAOImpl();
		String text = "";
		PrintWriter pw  = response.getWriter();
		if("SUPERUSR".equals(getRole_id())){
			text = "-2";
			pw.print(text);
			pw.flush();
			return;
		}
		String state = "".equals(getState())?ContextParams.ALL_STATE_NORMAL:getState();
		StaffBean nowStaff = (StaffBean)request.getSession().getAttribute("STAFFINFO");
		StaffBean bean = new StaffBean(getStaff_id(),getStaff_name(),getDepart_id(),state,getRole_id(),"",nowStaff.getStaff_id(), "",getPhone_number(), getE_mail());
		
		boolean flag = false;
		if(tag.equals("add")){
			//新增
			if(dao.getStaffById(bean.getStaff_id())!=null){
				text = "-3";
				pw.print(text);
				pw.flush();
				return;
			}
			
			flag = dao.insertStaff(bean);
			if(flag){
				text = "0";
			}else{
				text = "-1";
			}
		}else if(tag.equals("upd")){
			flag = dao.saveStaff(bean);
			if(flag){
				text = "0";
			}else{
				text = "-1";
			}
		}
		pw.print(text);
		pw.flush();
	}
	
	public String staffLogout()throws Exception{
		ActionContext atx = ServletActionContext.getContext();
		atx.getSession().clear();
		return "Success";
	}
}
