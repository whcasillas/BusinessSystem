package com.hisun.action.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.hisun.bean.staff.StaffBean;
import com.opensymphony.xwork2.Action;

public class BaseAction implements Action{
	protected Logger log = Logger.getLogger(getClass());
	/**
	 * 页面权限判断
	 * @return
	 */
	public boolean hasProv(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = null; 
		response = ServletActionContext.getResponse(); 
		response.setCharacterEncoding("gbk"); 
		response.setContentType("text/html;charset=gbk");
		String pid = (String)request.getParameter("pid");
		boolean flag = false;
		JSONArray powers = (JSONArray)request.getSession().getAttribute("POWERINFO");
		log.debug("===================用户权限集合======================" + powers);
		//超管，无需判断权限
		StaffBean staffinfo = (StaffBean)request.getSession().getAttribute("STAFFINFO");
		if(staffinfo == null){
			try {
				response.sendRedirect("../404.html");
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(staffinfo.getRole_id().equals("SUPERUSR")){
			return true;
		}
		for(int i=0; i<powers.size(); i++){
			String power_id = powers.getJSONObject(i).getString("power_id");
			if(power_id.equals(pid)){
				flag = true;
				request.setAttribute("pid", pid);
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 按钮权限判断
	 * @param p(按钮权限ID)
	 * @return
	 */
	public boolean hasButtenProv(String p){
		boolean flag = false;
		//权限Bean集合
		HttpSession session = ServletActionContext.getRequest().getSession();
		JSONArray powers = (JSONArray)session.getAttribute("POWERINFO");
		//超管，无需判断权限
		StaffBean staffinfo = (StaffBean)session.getAttribute("STAFFINFO");
		if(staffinfo.getRole_id().equals("SUPERUSR")){
			return true;
		}
		for(int i=0; i<powers.size(); i++){
			JSONObject obj = powers.getJSONObject(i);
			String pr = obj.getString("power_id");
			if(pr.equals(p)){
	            flag = true;
	            break;
	        } 
		}
		return flag;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
