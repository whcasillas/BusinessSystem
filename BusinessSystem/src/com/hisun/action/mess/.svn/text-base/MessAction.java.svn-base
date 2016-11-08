package com.hisun.action.mess;

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


import com.hisun.DAO.messdao.impl.MessImpl;
import com.hisun.DAO.messdao.impl.MessTypeImpl;
import com.hisun.action.page.PageAction;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.bean.mess.MessInfo;
import com.hisun.bean.mess.MessInfoRead;
import com.hisun.bean.mess.MessTypeInfo;
import com.hisun.bean.staff.StaffBean;
import com.hisun.tools.ContextParams;

public class MessAction extends PageAction {

	public String getaddMess() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = this.staticInfo();
		request.setAttribute("mtilist",json.get("mtilist"));
		return "SUCCESS";
	}
	
	public String addMess() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		StaffBean staff = (StaffBean) request.getSession().getAttribute("STAFFINFO");
		String opt_name = staff.getStaff_name();
		String mess_type = request.getParameter("mess_type");
		//String start_time = request.getParameter("start_time");
		//String end_time = request.getParameter("end_time");
		String mess_remarks = request.getParameter("mess_remarks");
		String event_id = request.getParameter("event_id");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //用时间戳来作为联系人的编号
		
		MessInfo mi = new MessInfo(date, mess_type, opt_name, date.substring(0, 14), null, mess_remarks, "0", date.substring(0, 8), "0",event_id);
		
		MessImpl mimpl = new MessImpl();
		if (mimpl.AddMess(mi)){
			return "SUCCESS";
		}
		return "ERROR";
	}
	
	public String getupdMess() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String mess_id= request.getParameter("mess_id");
		MessImpl mimpl = new MessImpl();
		MessInfo mi = mimpl.selectMessBean(mess_id);
		request.setAttribute("mi", mi);
		if(!("".equals(mi.getMess_id())||mi.getMess_id()==null)){
			return "SUCCESS";
		}else{
			return "ERROR";
		}
	}

	public String updMess() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		String mess_id = request.getParameter("mess_id");
		//String end_time = request.getParameter("end_time");
		String mess_remarks = request.getParameter("mess_remarks");
		String mess_status = request.getParameter("mess_status");
		String event_id = request.getParameter("event_id");
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //用时间戳来作为联系人的编号
		
		
		MessImpl mimpl = new MessImpl();
		MessInfo mi = mimpl.selectMessBean(mess_id);
		
		mi.setEnd_time(date.substring(0, 14));
		mi.setMess_remarks(mess_remarks);
		mi.setMess_status(mess_status);
		mi.setMess_id(mess_id);
		mi.setEvent_id(event_id);
		
		if(mimpl.UpdMess(mi)){
			return "SUCCESS";
		}
		return "ERROR";
	}
	
	
	public String showMessList() throws Exception{
		
		super.init();//分页初始化
		HttpServletRequest request = ServletActionContext.getRequest();

		MessInfo mi  = new MessInfo();
		MessImpl mimpl = new MessImpl();
		JSONObject  messes =mimpl.queryMessList(mi,this.getStart(),this.getEnd());
		JSONArray jaci = (JSONArray) messes.get("resultset");
		int count = (Integer) messes.get("count");
		
		List<MessInfo> milist = new ArrayList<MessInfo>();
		
		for (int i = 0; i < jaci.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			MessInfo mib = (MessInfo) JSONObject.toBean(jaci.getJSONObject(i), MessInfo.class);
			mib.setStart_time(myDateFormat(mib.getStart_time()));
			mib.setEnd_time(myDateFormat(mib.getEnd_time()));
			milist.add(mib);
		}	

		request.setAttribute("milist", milist);
		request.setAttribute("count", count);
		return "SUCCESS";
	}
	
public String showMessListLastTwoDays() throws Exception{
		
		super.init();//分页初始化
		HttpServletRequest request = ServletActionContext.getRequest();

		MessInfo mi  = new MessInfo();
		MessImpl mimpl = new MessImpl();
		JSONObject  messes =mimpl.queryMessListLastTwoDays(mi);
		JSONArray jaci = (JSONArray) messes.get("resultset");
		int count = (Integer) messes.get("count");
		
		List<MessInfo> milist = new ArrayList<MessInfo>();
		
		for (int i = 0; i < jaci.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			MessInfo mib = (MessInfo) JSONObject.toBean(jaci.getJSONObject(i), MessInfo.class);
			if(!("".equals(mib.getStart_time())||mib.getStart_time()==null)){
				mib.setStart_time(myDateFormat(mib.getStart_time()));
			}
			
			if(!("".equals(mib.getEnd_time())||mib.getEnd_time()==null)){
				mib.setEnd_time(myDateFormat(mib.getEnd_time()));
			}
			
			milist.add(mib);
		}	

		request.setAttribute("milist", milist);
		request.setAttribute("count", count);
		return "SUCCESS";
	}
	
	public String messList() throws Exception{
		
		super.init();//分页初始化
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = this.staticInfo();
		request.setAttribute("mtilist",json.get("mtilist"));

		String mess_type = request.getParameter("mess_type");
		String opt_name = request.getParameter("opt_name");
		String mess_remarks = request.getParameter("mess_remarks");
		String mess_status = request.getParameter("mess_status");
		String mess_date = request.getParameter("mess_date");
		String event_id = request.getParameter("event_id");
		
		MessInfo mi  = new MessInfo(null, mess_type, opt_name, null, null, mess_remarks, mess_status, mess_date, "0",event_id);
		MessImpl mimpl = new MessImpl();
		JSONObject  messes =mimpl.queryMessList(mi,this.getStart(),this.getEnd());
		JSONArray jaci = (JSONArray) messes.get("resultset");
		int count = (Integer) messes.get("count");
		
		List<MessInfo> milist = new ArrayList<MessInfo>();
		for (int i = 0; i < jaci.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			MessInfo mib = (MessInfo) JSONObject.toBean(jaci.getJSONObject(i), MessInfo.class);
			MessInfoRead mir = new MessInfoRead();
			mir.setXuhao(i+this.getStart());
			mir.setEnd_time(mib.getEnd_time());
			mir.setEvent_id(mib.getEvent_id());
			mir.setMess_date(mib.getMess_date());
			mir.setMess_delstatus(mib.getMess_delstatus());
			mir.setMess_id(mib.getMess_id());
			mir.setMess_remarks(mib.getMess_remarks());
			mir.setMess_status(mib.getMess_status());
			mir.setMess_type(mib.getMess_type());
			mir.setOpt_name(mib.getOpt_name());
			mir.setStart_time(mib.getStart_time());
			milist.add(mir);
		}	

		
		request.setAttribute("mess_type", mess_type);
		request.setAttribute("opt_name", opt_name);
		request.setAttribute("mess_remarks", mess_remarks);
		request.setAttribute("mess_status", mess_status);
		request.setAttribute("mess_date", mess_date);
		request.setAttribute("event_id", event_id);
		
		request.setAttribute("milist", milist);
		request.setAttribute("count", count);
		return "SUCCESS";
	}
	
	public  void delMess() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw  = response.getWriter();
		String text="";
		String ids =request.getParameter("str");
		MessImpl mimpl = new  MessImpl();
		JSONObject js = new JSONObject();
		js.put("ids", ids);
		
		if(mimpl.deleteMess(js)){
			text="success";
			//return "SUCCESS";
		}else{
			text="error";
			//return "ERROR";
		}
		pw.print(text);
		pw.flush();
	}
	
	public JSONObject  staticInfo() throws Exception{
		MessTypeImpl mti = new MessTypeImpl(); //获得所有信息类别
		JSONObject  jbi = mti.queryMessTypeList();
		JSONArray jabi =  (JSONArray) jbi.get("result");
		List<MessTypeInfo> mtilist = new ArrayList<MessTypeInfo>();
		for (int i = 0; i < jabi.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			MessTypeInfo bean = (MessTypeInfo) JSONObject.toBean(
			jabi.getJSONObject(i), MessTypeInfo.class);
			mtilist.add(bean);
		}	
		
		
		JSONObject json = new JSONObject();
		json.put("mtilist", mtilist);

		return json;
	} 
	
	public String myDateFormat(String date){
		String year = date.substring(0,4 );
		String month = date.substring(4,6 );
		String day = date.substring(6,8 );
		String hour = date.substring(8,10);
		String min = date.substring(10,12);
		
		return year+"年"+month+"月"+day+"日 "+hour+"时"+min+"分";
	}

}
