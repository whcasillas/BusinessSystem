package com.hisun.action.contact;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.contactdao.impl.BankInfoDaoImpl;
import com.hisun.DAO.contactdao.impl.BankTypeDaoImpl;
import com.hisun.DAO.contactdao.impl.ContactInfoDaoImpl;
import com.hisun.DAO.contactdao.impl.ProvContactInfoDaoImpl;
import com.hisun.DAO.contactdao.impl.ProvInfoDaoImpl;
import com.hisun.action.page.PageAction;
import com.hisun.bean.contact.BankInfo;
import com.hisun.bean.contact.BankType;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.bean.contact.ProvInfo;
import com.hisun.tools.ContextParams;

public class ProvContactAction  extends PageAction{
	public String getaddProvContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = this.staticInfo();
		request.setAttribute("pilist",json.get("pilist"));
		return "SUCCESS";
	}
	
	public String addProvContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw  = response.getWriter();
		String contact_prov = request.getParameter("contact_prov");
		String contact_name = request.getParameter("contact_name");
		String contact_mbl = request.getParameter("contact_mbl");
		String contact_email = request.getParameter("contact_email");
		String contact_qq = request.getParameter("contact_qq");
		String contact_remarks = request.getParameter("contact_remarks");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //��ʱ�������Ϊ��ϵ�˵ı��
		
		ContactInfo ci = new ContactInfo( null,  null,
				null, contact_prov,  date,  contact_name,
				 contact_mbl,  contact_email,  contact_qq,
				 null,  contact_remarks, date) ; //��һ��dateΪ���(id)���ڶ���date��ʱ���������޸ĺ�ɾ�������䶯
		ProvContactInfoDaoImpl pcidi  = new ProvContactInfoDaoImpl();
		if (pcidi.AddProvContact(ci)){
			//pw.write("success");
			return "SUCCESS";
		}else{
			//pw.write("errror");
			return "error";
		}
		//pw.flush();
	}
	
	public String provContactList() throws Exception{
		
	/*	boolean flag = hasProv();
		if(!flag){
			return "error";
		}*/
		
		super.init();//��ҳ��ʼ��
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = this.staticInfo();
		request.setAttribute("pilist",json.get("pilist"));
		
		String contact_prov = request.getParameter("contact_prov");
		String contact_name = request.getParameter("contact_name");
		String contact_mbl = request.getParameter("contact_mbl");
		String contact_email = request.getParameter("contact_email");
		String contact_qq = request.getParameter("contact_qq");
		String contact_remarks = request.getParameter("contact_remarks");
		
		ContactInfo ci = new ContactInfo(null, null, null, contact_prov,null, contact_name, contact_mbl, contact_email, contact_qq, null, contact_remarks, null);
		ProvContactInfoDaoImpl pcidi  = new ProvContactInfoDaoImpl();
		JSONObject  contacts = pcidi.queryProvContactList(ci,this.getStart(),this.getEnd());
		JSONArray jaci = (JSONArray) contacts.get("resultset");
		int count = (Integer) contacts.get("count");
		
		
		
		List<ContactInfo> cilist = new ArrayList<ContactInfo>();
		for (int i = 0; i < jaci.size(); i++) {
			//JSONתjavaBeanע����������ݿ��������ֶ���������javaBean����������������ȣ�ת������Ч
			ContactInfo cib = (ContactInfo) JSONObject.toBean(jaci.getJSONObject(i), ContactInfo.class);
			cilist.add(cib);
		}	
		
		//�жϰ�ťȨ��
		boolean add = hasButtenProv(ContextParams.ADD_CONTACT_POWER);	
		boolean exp = hasButtenProv(ContextParams.EXP_CONTACT_POWER);
		boolean del = hasButtenProv(ContextParams.DEL_CONTACT_POWER);
		
		
		request.setAttribute("contact_prov", contact_prov);
		request.setAttribute("contact_name", contact_name);
		request.setAttribute("contact_mbl", contact_mbl);
		request.setAttribute("contact_email", contact_email);
		request.setAttribute("contact_qq", contact_qq);
		request.setAttribute("contact_remarks", contact_remarks);
	
		request.setAttribute("cilist", cilist);
		request.setAttribute("count", count);
		
		request.setAttribute("add", add);
		request.setAttribute("exp", exp);
		request.setAttribute("del", del);
		if(true){
			return "SUCCESS";
		}else{
			return "error";
		}
	}
	
	public  void delProvContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw  = response.getWriter();
		String text="";
		String ids =request.getParameter("str");
		ProvContactInfoDaoImpl pcidi  = new ProvContactInfoDaoImpl();
		JSONObject js = new JSONObject();
		js.put("ids", ids);
		
		if(pcidi.deleteProvContact(js)){
			text="success";
			//return "SUCCESS";
		}else{
			text="error";
			//return "ERROR";
		}
		pw.print(text);
		pw.flush();
	}
	
	
	/**
	 * �鿴ʡ��ϵ��
	 * @return
	 * @throws Exception
	 */
	public String getupdProvContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String contact_id= request.getParameter("contact_id");
		ProvContactInfoDaoImpl pcidi  = new ProvContactInfoDaoImpl();
		ContactInfo ci = pcidi.selectProvContactBean(contact_id);
		//�жϰ�ťȨ��
		boolean upd = hasButtenProv(ContextParams.UPD_CONTACT_POWER);
		request.setAttribute("upd", upd);
		
		request.setAttribute("ci", ci);
		return "SUCCESS";
	}
	
	/**
	 * �޸�ʡ��ϵ��
	 * @return
	 */
	public String updProvContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String contact_prov = request.getParameter("contact_prov");
		String contact_name = request.getParameter("contact_name");
		String contact_id = request.getParameter("contact_id");
		String contact_mbl = request.getParameter("contact_mbl");
		String contact_email = request.getParameter("contact_email");
		String contact_qq = request.getParameter("contact_qq");
		String contact_remarks = request.getParameter("contact_remarks");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //��ʱ�������Ϊ��ϵ�˵ı��
		
		
		ProvContactInfoDaoImpl pcidi  = new ProvContactInfoDaoImpl();
		ContactInfo bean = new ContactInfo();
		

		bean.setContact_name(contact_name);
		bean.setContact_prov(contact_prov);
		bean.setContact_mbl(contact_mbl);
		bean.setContact_email(contact_email);
		bean.setContact_qq(contact_qq);
		bean.setContact_remarks(contact_remarks);
		bean.setTm_smp(date);
		bean.setContact_id(contact_id);
		
		if(pcidi.UpdProvContact(bean)){
			return "SUCCESS";
		}
		return "error";
	}
	
	/**
	 * ������ʼ�����е�ʡ��ʡҵ�����ͣ�ʡ
	 * @return ���� ���� bilist btlist pilist ��JSONObject ���� 
	 * @throws Exception
	 */
	public JSONObject  staticInfo() throws Exception{
		ProvInfoDaoImpl pidi = new ProvInfoDaoImpl(); //�������ʡ
		JSONObject  jpi = pidi.queryProvList();
		JSONArray japi =  (JSONArray) jpi.get("result");
		List<ProvInfo> pilist = new ArrayList<ProvInfo>();
			for (int i = 0; i < japi.size(); i++) {
				//JSONתjavaBeanע����������ݿ��������ֶ���������javaBean����������������ȣ�ת������Ч
				ProvInfo pi = (ProvInfo) JSONObject.toBean(
						japi.getJSONObject(i), ProvInfo.class);
				pilist.add(pi);
			}	
		JSONObject json = new JSONObject();
		json.put("pilist", pilist);

		return json;
	} 
}
