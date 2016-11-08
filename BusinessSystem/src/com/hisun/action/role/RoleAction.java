package com.hisun.action.role;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.role.impl.RoleDAOImpl;
import com.hisun.DAO.role.interfaces.IRoleDAO;
import com.hisun.action.page.PageAction;
import com.hisun.bean.staff.PowerBean;
import com.hisun.bean.staff.RoleBean;

public class RoleAction extends PageAction {

	private String role_id;
	private String role_name;
	private String role_level;
	private String state;
	private String power_id;
	private String power_name;
	private String p_id;
	private String p_name;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_level() {
		return role_level;
	}
	public void setRole_level(String role_level) {
		this.role_level = role_level;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPower_id() {
		return power_id;
	}
	public void setPower_id(String power_id) {
		this.power_id = power_id;
	}
	public String getPower_name() {
		return power_name;
	}
	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}
	
	
	public String queryRoleList()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		
		super.init();
		HttpServletRequest request = ServletActionContext.getRequest();
		IRoleDAO dao = new RoleDAOImpl();
		String role_id = getRole_id();
		String role_name = getRole_name();
		JSONObject result = dao.queryRoleList(role_id, role_name, getStart(), getEnd());
		JSONArray array = result.getJSONArray("resultset");
		int count = result.getInt("count");
		List<RoleBean> list = new ArrayList<RoleBean>();
		for (int i = 0; i < array.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			RoleBean bean = (RoleBean) JSONObject.toBean(
					array.getJSONObject(i), RoleBean.class);
			list.add(bean);
		}
		request.setAttribute("rList", list);
		request.setAttribute("count", count);
		return "Success";
	}
	
	public String initPowerInfo()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		IRoleDAO dao = new RoleDAOImpl();
		String role = request.getParameter("role_id");
		JSONArray nop = dao.getPowerInfo(role);
		JSONArray rp = dao.getRolePowerInfo(role);
		RoleBean bean = dao.getRoleInfo(role);
		List<PowerBean> nopList = new ArrayList<PowerBean>();
		List<PowerBean> rpList = new ArrayList<PowerBean>();
		
		if(nop != null){
			for(int i=0; i<nop.size(); i++){
				PowerBean nopBean = (PowerBean)JSONObject.toBean(nop.getJSONObject(i), PowerBean.class);
				nopList.add(nopBean);
			}
		}
		
		if(rp != null){
			for(int i=0; i<rp.size(); i++){
				PowerBean rpBean = (PowerBean)JSONObject.toBean(rp.getJSONObject(i), PowerBean.class);
				rpList.add(rpBean);
			}
		}
		
		request.setAttribute("nopList", nopList);
		request.setAttribute("rpList", rpList);
		request.setAttribute("role_id", bean.getRole_id());
		request.setAttribute("role_name", bean.getRole_name());
		return "Success";
	}
	
	public void savePowerInfo()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw = response.getWriter();
		List<PowerBean> powers = new ArrayList<PowerBean>();
		String result = "";
		boolean flag = false;
		IRoleDAO dao = new RoleDAOImpl();
		String power_id = getPower_id();
		String power_name = getPower_name();
		power_id = power_id.substring(0, power_id.length() - 1);
		power_name = power_name.substring(0, power_name.length() - 1);
		String[] p = power_id.split(",");
		String[] n = power_name.split(",");
		for(int i=0; i<p.length; i++){
			PowerBean bean = new PowerBean(p[i],n[i],getRole_id(),"0");
			powers.add(bean);
		}
		flag = dao.savePowerInfo(powers);
		result = flag?"0":"-1";
		pw.write(result);
		pw.flush();
		pw.close();
	}
	
	public void insertPowerInfo()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw = response.getWriter();
		String pid = getP_id();
		String pname = getP_name();
		PowerBean power = new PowerBean(pid, pname, "SUPERUSR", "0");
		IRoleDAO dao = new RoleDAOImpl();
		pw.write(dao.insertPower(power));
		pw.flush();
		pw.close();
	}
}
