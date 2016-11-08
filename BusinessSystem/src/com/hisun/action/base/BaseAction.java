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
	 * ҳ��Ȩ���ж�
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
		log.debug("===================�û�Ȩ�޼���======================" + powers);
		//���ܣ������ж�Ȩ��
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
	 * ��ťȨ���ж�
	 * @param p(��ťȨ��ID)
	 * @return
	 */
	public boolean hasButtenProv(String p){
		boolean flag = false;
		//Ȩ��Bean����
		HttpSession session = ServletActionContext.getRequest().getSession();
		JSONArray powers = (JSONArray)session.getAttribute("POWERINFO");
		//���ܣ������ж�Ȩ��
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
