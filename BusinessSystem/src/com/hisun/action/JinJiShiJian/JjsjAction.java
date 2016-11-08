package com.hisun.action.JinJiShiJian;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.jinjishijianDao.impl.JjsjImpl;
import com.hisun.action.page.PageAction;
import com.hisun.bean.jinjishijian.JjsjRead;
import com.hisun.bean.jinjishijian.JjsjType;
import com.hisun.bean.jinjishijian.Jjsj;
import com.hisun.bean.jinjishijian.Jjsjzx;
import com.hisun.bean.jinjishijian.JjsjzxRead;
import com.hisun.bean.staff.StaffBean;

public class JjsjAction extends PageAction {
/**
 * 查询所有紧急事件信息
 * @return
 * @throws Exception
 */
	public String JjsjList() throws Exception {
		boolean flag = hasProv();
		if (!flag) {
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
//		System.out.println("~~~~~~~~~~~~~~"+request.getAttribute("start"));
		super.init();//分页初始化
		
		String jj_id = request.getParameter("jj_id");
		String sj_id = request.getParameter("sj_id");
		String sj_type = request.getParameter("sj_type");
		String sj_title = request.getParameter("sj_title");
		String tm_smp = request.getParameter("tm_smp");
		String cb_num_s = request.getParameter("cb_num");
		String cl_sts_s = request.getParameter("cl_sts");
		int cb_num=0; 
		int cl_sts=-1; //-1代表页面没有传值
		if(!("".equals(cb_num_s)||cb_num_s==null)){
			cb_num=Integer.parseInt(cb_num_s);
		}
		if(!("".equals(cl_sts_s)||cl_sts_s==null)){
			cl_sts=Integer.parseInt(cl_sts_s);
		}	
		
		Jjsj sj = new Jjsj(jj_id, sj_id, sj_type, sj_title, tm_smp, cb_num, cl_sts);
		JjsjImpl jjsjImpl = new JjsjImpl();
//		System.out.println("-----------"+this.getStart()+"++++++++++++++++++"+this.getEnd());

		JSONObject jjsj = jjsjImpl.queryJinJiSJList(sj,this.getStart(),this.getEnd());
		JSONArray jaci = (JSONArray) jjsj.get("result");
		int count = (Integer) jjsj.get("count");
		
		List<Jjsj> sjlist = new ArrayList<Jjsj>();
		for (int i = 0; i < jaci.size(); i++) {
			// JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			Jjsj jjsj2 = (Jjsj) JSONObject.toBean(jaci.getJSONObject(i), Jjsj.class);
			jjsj2.setTm_smp(myDateFormat(jjsj2.getTm_smp()));
			JjsjRead jjr = new  JjsjRead();
			jjr.setXuhao(i+this.getStart());
			jjr.setCb_num(jjsj2.getCb_num());
			jjr.setCl_sts(jjsj2.getCl_sts());
			jjr.setJj_id(jjsj2.getJj_id());
			jjr.setSj_id(jjsj2.getSj_id());
			jjr.setSj_title(jjsj2.getSj_title());
			jjr.setSj_type(jjsj2.getSj_type());
			jjr.setTm_smp(jjsj2.getTm_smp());
			
			sjlist.add(jjr);
		}
		
		JSONArray jjtype= jjsjImpl.queryjjsjtype();
		
		List<JjsjType> jjtyplist = new ArrayList<JjsjType>();
		for (int i = 0; i < jjtype.size(); i++) {
			// JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			JjsjType jjtyp = (JjsjType) JSONObject.toBean(jjtype.getJSONObject(i), JjsjType.class);
			jjtyplist.add(jjtyp);
		}
		
		request.setAttribute("sjlist", sjlist);
		request.setAttribute("count", count);
		request.setAttribute("jtlist", jjtyplist);
		return "success";

	}
	
	
	public String JjsjListzx() throws Exception {
		boolean flag = hasProv();
		if (!flag) {
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
//		System.out.println("~~~~~~~~~~~~~~"+request.getAttribute("start"));
		super.init();//分页初始化
		
		String jj_id = request.getParameter("jj_id");
		String sj_id = request.getParameter("sj_id");
		String sj_type = request.getParameter("sj_type");
		String sj_title = request.getParameter("sj_title");
		String tm_smp = request.getParameter("tm_smp");
		String cb_num_s = request.getParameter("cb_num");
		String cl_sts_s = request.getParameter("cl_sts");
		int cb_num=0; 
		int cl_sts=-1; //-1代表页面没有传值
		if(!("".equals(cb_num_s)||cb_num_s==null)){
			cb_num=Integer.parseInt(cb_num_s);
		}
		if(!("".equals(cl_sts_s)||cl_sts_s==null)){
			cl_sts=Integer.parseInt(cl_sts_s);
		}	
		
		Jjsj sj = new Jjsj(jj_id, sj_id, sj_type, sj_title, tm_smp, cb_num, cl_sts);
		JjsjImpl jjsjImpl = new JjsjImpl();
//		System.out.println("-----------"+this.getStart()+"++++++++++++++++++"+this.getEnd());

		JSONObject jjsj = jjsjImpl.queryJinJiSJListzx(sj,this.getStart(),this.getEnd());
		JSONArray jaci = (JSONArray) jjsj.get("result");
		int count = (Integer) jjsj.get("count");
		
		List<JjsjzxRead> sjlist = new ArrayList<JjsjzxRead>();
		for (int i = 0; i < jaci.size(); i++) {
			// JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			Jjsjzx jjsj2 = (Jjsjzx) JSONObject.toBean(jaci.getJSONObject(i), Jjsjzx.class);
			jjsj2.setTm_smp(myDateFormat(jjsj2.getTm_smp()));
			JjsjzxRead jjr = new  JjsjzxRead();
			jjr.setXuhao(i+this.getStart());
			jjr.setCb_num(jjsj2.getCb_num());
			jjr.setCl_sts(jjsj2.getCl_sts());
			jjr.setJj_id(jjsj2.getJj_id());
			jjr.setSj_id(jjsj2.getSj_id());
			jjr.setSj_title(jjsj2.getSj_title());
			jjr.setSj_type(jjsj2.getSj_type());
			jjr.setTm_smp(jjsj2.getTm_smp());
			
			sjlist.add(jjr);
		}
		
		JSONArray jjtype= jjsjImpl.queryjjsjtype();
		
		List<JjsjType> jjtyplist = new ArrayList<JjsjType>();
		for (int i = 0; i < jjtype.size(); i++) {
			// JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			JjsjType jjtyp = (JjsjType) JSONObject.toBean(jjtype.getJSONObject(i), JjsjType.class);
			jjtyplist.add(jjtyp);
		}
		
		request.setAttribute("sjlist", sjlist);
		request.setAttribute("count", count);
		request.setAttribute("jtlist", jjtyplist);
		return "success";

	}
	
	
	/**
	 * 添加紧急事件信息
	 * @return
	 * @throws Exception
	 */

	public String addJjsj() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String sj_id = request.getParameter("sj_id");
		String sj_type = request.getParameter("sj_type");
		String sj_title = request.getParameter("sj_title");

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String  date = df.format(new Date()); //用时间戳来作为联系人的编号
		Jjsj  jjsj = new Jjsj("JJSJ"+date, sj_id, sj_type, sj_title, date.substring(0, 14), 0, 0);
		JjsjImpl jjsjImpl = new JjsjImpl();
		if(jjsjImpl.addJjsjzx(jjsj)){
			return "success";
		}
		return "error";
	}
	
	public String cuibjjsj() throws Exception{
		boolean flag = hasProv();
		if (!flag) {
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String jj_id = request.getParameter("jj_id");
		JjsjImpl jjsjImpl = new JjsjImpl();
		jjsjImpl.CBjjsjzx(jj_id);
		return "success";
	}
	
	public String chuljjsj() throws Exception{
		boolean flag = hasProv();
		if (!flag) {
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		StaffBean staff = (StaffBean) request.getSession().getAttribute("STAFFINFO");
		String opt_name = staff.getStaff_name();
		String jj_id = request.getParameter("jj_id");
		JjsjImpl jjsjImpl = new JjsjImpl();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		jjsjImpl.CLjjsjzx(jj_id,opt_name, df.format(new Date()));
		return "success";
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
