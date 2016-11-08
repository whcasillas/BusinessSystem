package com.hisun.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.impl.StaffDAOImpl;
import com.hisun.DAO.interfaces.IStaffDAO;
import com.hisun.bean.staff.StaffPwdBean;

public class StaffPwdAction {

	private String staff_id;
	private String old_staff_pwd;
	private String new_staff_pwd;
	private String again_staff_pwd;
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getOld_staff_pwd() {
		return old_staff_pwd;
	}
	public void setOld_staff_pwd(String old_staff_pwd) {
		this.old_staff_pwd = old_staff_pwd;
	}
	public String getNew_staff_pwd() {
		return new_staff_pwd;
	}
	public void setNew_staff_pwd(String new_staff_pwd) {
		this.new_staff_pwd = new_staff_pwd;
	}
	
	public void changePwd()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw = response.getWriter();
		String text = "";
		IStaffDAO dao = new StaffDAOImpl();
		StaffPwdBean bean = new StaffPwdBean();
		bean = dao.getStaffPwd(getStaff_id());
		String old = bean.getStaff_pwd();
		String oldp = getOld_staff_pwd();
		String newp = getNew_staff_pwd();
		String ap = getAgain_staff_pwd();
		if(!oldp.equals(old)){
			text = "-2";
		}else if (!ap.equals(newp)){
			text = "-3";
		}else{
			StaffPwdBean pwd = new StaffPwdBean();
			pwd.setStaff_id(bean.getStaff_id());
			pwd.setStaff_pwd(getNew_staff_pwd());
			boolean flag = dao.savePwd(pwd);
			if(flag){
				text = "0";
			}else{
				text = "-1";
			}
		}
		pw.print(text);
		pw.flush();
	}
	public String getAgain_staff_pwd() {
		return again_staff_pwd;
	}
	public void setAgain_staff_pwd(String again_staff_pwd) {
		this.again_staff_pwd = again_staff_pwd;
	}
}
