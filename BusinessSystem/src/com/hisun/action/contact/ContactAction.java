package com.hisun.action.contact;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.DAO.contactdao.impl.BankInfoDaoImpl;
import com.hisun.DAO.contactdao.impl.BankTypeDaoImpl;
import com.hisun.DAO.contactdao.impl.ContactInfoDaoImpl;
import com.hisun.DAO.contactdao.impl.ProvInfoDaoImpl;
import com.hisun.action.page.PageAction;
import com.hisun.bean.contact.BankInfo;
import com.hisun.bean.contact.BankType;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.bean.contact.ProvInfo;
import com.hisun.tools.ContextParams;

public class ContactAction extends PageAction {


	
	public String getaddContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = this.staticInfo();
		request.setAttribute("bilist",json.get("bilist"));
		request.setAttribute("btlist",json.get("btlist"));
		request.setAttribute("pilist",json.get("pilist"));
		
		return "SUCCESS";
	}
	
	public String addContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String bank_name = request.getParameter("bank_name");
		String bank_typ = request.getParameter("bank_typ");
		String bank_address = request.getParameter("bank_address");
		String contact_name = request.getParameter("contact_name");
		String bank_contact_typ = request.getParameter("bank_contact_typ");
		String contact_mbl = request.getParameter("contact_mbl");
		String contact_email = request.getParameter("contact_email");
		String contact_qq = request.getParameter("contact_qq");
		String contact_remarks = request.getParameter("contact_remarks");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //用时间戳来作为联系人的编号
		
		ContactInfo ci = new ContactInfo( bank_name,  bank_typ,
				 bank_contact_typ, null,  date,  contact_name,
				 contact_mbl,  contact_email,  contact_qq,
				 bank_address,  contact_remarks, date) ; //第一个date为编号，第二个date是时间戳，如果修改和删除会做变动
		ContactInfoDaoImpl  cidi = new ContactInfoDaoImpl();
		if (cidi.AddContact(ci)){
			return "SUCCESS";
		}else{
			return "error";
		}
	}
	
	public String contactList() throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		super.init();//分页初始化
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = this.staticInfo();
		request.setAttribute("bilist",json.get("bilist"));
		request.setAttribute("btlist",json.get("btlist"));
		//request.setAttribute("pilist",json.get("pilist"));
		
		String bank_name = request.getParameter("bank_name");
		String bank_type = request.getParameter("bank_type");
		String bank_address = request.getParameter("bank_address");
		String contact_name = request.getParameter("contact_name");
		String bank_contact_typ = request.getParameter("bank_contact_typ");
		String contact_mbl = request.getParameter("contact_mbl");
		String contact_email = request.getParameter("contact_email");
		String contact_qq = request.getParameter("contact_qq");
		String contact_remarks = request.getParameter("contact_remarks");
		
		ContactInfo ci = new ContactInfo(bank_name, bank_type, bank_contact_typ, null,null, contact_name, contact_mbl, contact_email, contact_qq, bank_address, contact_remarks, null);
		ContactInfoDaoImpl  cidi = new ContactInfoDaoImpl();
		JSONObject  contacts = cidi.queryContactList(ci,this.getStart(),this.getEnd());
		JSONArray jaci = (JSONArray) contacts.get("resultset");
		int count = (Integer) contacts.get("count");
		
		List<ContactInfo> cilist = new ArrayList<ContactInfo>();
		for (int i = 0; i < jaci.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			ContactInfo cib = (ContactInfo) JSONObject.toBean(jaci.getJSONObject(i), ContactInfo.class);
			cilist.add(cib);
		}	
		//判断按钮权限
				boolean add = hasButtenProv(ContextParams.ADD_CONTACT_POWER);
				boolean exp = hasButtenProv(ContextParams.EXP_CONTACT_POWER);
				boolean del = hasButtenProv(ContextParams.DEL_CONTACT_POWER);
				
				request.setAttribute("add", add);
				request.setAttribute("exp", exp);
				request.setAttribute("del", del);
		
		request.setAttribute("bank_name", bank_name);
		request.setAttribute("bank_type", bank_type);
		request.setAttribute("bank_address", bank_address);
		request.setAttribute("contact_name", contact_name);
		request.setAttribute("bank_contact_typ", bank_contact_typ);
		request.setAttribute("contact_mbl", contact_mbl);
		request.setAttribute("contact_email", contact_email);
		request.setAttribute("contact_qq", contact_qq);
		request.setAttribute("contact_remarks", contact_remarks);
		
		request.setAttribute("cilist", cilist);
		request.setAttribute("count", count);
		
		return "SUCCESS";
	}
	
	public  void delContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw  = response.getWriter();
		String text="";
		String ids =request.getParameter("str");
		ContactInfoDaoImpl  cidi = new ContactInfoDaoImpl();
		JSONObject js = new JSONObject();
		js.put("ids", ids);
		
		if(cidi.deleteContact(js)){
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
	 * 查看银行联系人
	 * @return
	 * @throws Exception
	 */
	public String getupdContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String contact_id= request.getParameter("contact_id");
		ContactInfoDaoImpl cidi = new ContactInfoDaoImpl();
		ContactInfo ci = cidi.selectContactBean(contact_id);
		
		//判断按钮权限
		boolean upd = hasButtenProv(ContextParams.UPD_CONTACT_POWER);
		request.setAttribute("upd", upd);
		
		request.setAttribute("ci", ci);
		return "SUCCESS";
	}
	
	/**
	 * 修改银行联系人
	 * @return
	 */
	public String updContact() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String bank_name = request.getParameter("bank_name");
		String bank_type = request.getParameter("bank_type");
		String bank_address = request.getParameter("bank_address");
		String contact_name = request.getParameter("contact_name");
		String contact_id = request.getParameter("contact_id");
		String bank_contact_typ = request.getParameter("bank_contact_typ");
		String contact_mbl = request.getParameter("contact_mbl");
		String contact_email = request.getParameter("contact_email");
		String contact_qq = request.getParameter("contact_qq");
		String contact_remarks = request.getParameter("contact_remarks");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //用时间戳来作为联系人的编号

		ContactInfoDaoImpl cidi = new ContactInfoDaoImpl();
		ContactInfo bean = new ContactInfo();
		
		bean.setBank_address(bank_address);
		bean.setBank_name(bank_name);
		bean.setBank_type(bank_type);
		bean.setContact_name(contact_name);
		bean.setBank_contact_typ(bank_contact_typ);
		bean.setContact_mbl(contact_mbl);
		bean.setContact_email(contact_email);
		bean.setContact_qq(contact_qq);
		bean.setContact_remarks(contact_remarks);
		bean.setTm_smp(date);
		bean.setContact_id(contact_id);
		
		if(cidi.UpdContact(bean)){
			return "SUCCESS";
		}
		return "error";
	}
	
	/**
	 * 用来初始化所有的银行，银行业务类型，省
	 * @return 返回 包含 bilist btlist pilist 的JSONObject 对象 
	 * @throws Exception
	 */
	public JSONObject  staticInfo() throws Exception{
		ProvInfoDaoImpl pidi = new ProvInfoDaoImpl(); //获得所有省
		BankInfoDaoImpl bidi = new BankInfoDaoImpl();  //获得所有银行
		BankTypeDaoImpl btdi = new BankTypeDaoImpl();  //活动所有银行业务类型
		
		JSONObject  jbi = bidi.queryBankList();
		JSONArray jabi =  (JSONArray) jbi.get("result");
		List<BankInfo> bilist = new ArrayList<BankInfo>();
		for (int i = 0; i < jabi.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			BankInfo bi = (BankInfo) JSONObject.toBean(
			jabi.getJSONObject(i), BankInfo.class);
			bilist.add(bi);
		}	
		
		JSONObject  jbt = btdi.queryBankTypeList();
		JSONArray jabt = (JSONArray) jbt.get("result");
		List<BankType> btlist = new ArrayList<BankType>();
			for (int i = 0; i < jabt.size(); i++) {
				//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
				BankType bt = (BankType) JSONObject.toBean(jabt.getJSONObject(i), BankType.class);
				btlist.add(bt);
			}	

		JSONObject  jpi = pidi.queryProvList();
		JSONArray japi =  (JSONArray) jpi.get("result");
		List<ProvInfo> pilist = new ArrayList<ProvInfo>();
			for (int i = 0; i < japi.size(); i++) {
				//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
				ProvInfo pi = (ProvInfo) JSONObject.toBean(
						japi.getJSONObject(i), ProvInfo.class);
				pilist.add(pi);
			}	
		JSONObject json = new JSONObject();
		json.put("bilist", bilist);
		json.put("btlist", btlist);
		json.put("pilist", pilist);

		return json;
	} 
	
}
