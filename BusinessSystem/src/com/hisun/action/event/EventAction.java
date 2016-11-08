package com.hisun.action.event;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import com.hisun.DAO.EvenInfoDao.Impl.EvenInfoDaoImp;
import com.hisun.DAO.EvenInfoDao.interfaces.IEvenInfoDao;
import com.hisun.action.page.PageAction;
import com.hisun.bean.even.EvenModBean;
import com.hisun.bean.even.Eventinfo;
import com.hisun.tools.ContextParams;


public class EventAction extends PageAction {
	private String event_no;
	private String event_inf;
	private String event_person;
	private String event_relust;
	private String event_key;
	private String event_mod;
	private String event_mod_id;
	private String cre_dt;
	private String cre_tm;
	private String tm_smp;
	private String event_sts;
	private String start_dt;
	private String ent_dt;
	public String getEvent_no() {
		return event_no;
	}
	public void setEvent_no(String event_no) {
		this.event_no = event_no;
	}
	public String getEvent_inf() {
		return event_inf;
	}
	public void setEvent_inf(String event_inf) {
		this.event_inf = event_inf;
	}
	public String getEvent_person() {
		return event_person;
	}
	public void setEvent_person(String event_person) {
		this.event_person = event_person;
	}
	public String getEvent_relust() {
		return event_relust;
	}
	public void setEvent_relust(String event_relust) {
		this.event_relust = event_relust;
	}
	public String getEvent_key() {
		return event_key;
	}
	public void setEvent_key(String event_key) {
		this.event_key = event_key;
	}
	public String getEvent_mod() {
		return event_mod;
	}
	public void setEvent_mod(String event_mod) {
		this.event_mod = event_mod;
	}
	public String getEvent_mod_id() {
		return event_mod_id;
	}
	public void setEvent_mod_id(String event_mod_id) {
		this.event_mod_id = event_mod_id;
	}
	public String getCre_dt() {
		return cre_dt;
	}
	public void setCre_dt(String cre_dt) {
		this.cre_dt = cre_dt;
	}
	public String getCre_tm() {
		return cre_tm;
	}
	public void setCre_tm(String cre_tm) {
		this.cre_tm = cre_tm;
	}
	public String getTm_smp() {
		return tm_smp;
	}
	public void setTm_smp(String tm_smp) {
		this.tm_smp = tm_smp;
	}
	public String getEvent_sts() {
		return event_sts;
	}
	public void setEvent_sts(String event_sts) {
		this.event_sts = event_sts;
	}
	public String getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
	public String getEnt_dt() {
		return ent_dt;
	}
	public void setEnt_dt(String ent_dt) {
		this.ent_dt = ent_dt;
	}
	
	public String queryEventList()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		
		super.init();//分页初始化
		
		HttpServletRequest request = ServletActionContext.getRequest();
		IEvenInfoDao dao = new EvenInfoDaoImp();
		JSONObject result1 =dao.queryEvenselecttList();
		JSONArray array1=result1.getJSONArray("arrayselelct");
		List<EvenModBean> list1 = new ArrayList<EvenModBean>();
		for (int i = 0; i < array1.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			EvenModBean bean = (EvenModBean) JSONObject.toBean(
					array1.getJSONObject(i), EvenModBean.class);
			list1.add(bean);
		}
		String event_no = this.getEvent_no();
		String person = this.getEvent_person();
		String start_dt=this.getStart_dt();
		String ent_dt = this.getEnt_dt();
		String key = this.getEvent_key();
		String event_mod_id= this.getEvent_mod_id();
		JSONObject result = dao.queryEventList(event_no, person, start_dt, ent_dt,key,event_mod_id, ContextParams.ALL_STATE_NORMAL,this.getStart(),this.getEnd());
		JSONArray array = result.getJSONArray("resultset");
		boolean del = hasButtenProv(ContextParams.DELETE_EVENT_POWER);
		
		List<Eventinfo> list = new ArrayList<Eventinfo>();
		for (int i = 0; i < array.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			Eventinfo bean = (Eventinfo) JSONObject.toBean(
					array.getJSONObject(i), Eventinfo.class);
			list.add(bean);
		}
		request.setAttribute("EventselectList",list1);
		int count = result.getInt("count");
		request.setAttribute("event_mod_id",event_mod_id);
		request.setAttribute("EventInfoList", list);
		request.setAttribute("count", count);
		request.setAttribute("del", del);
		return "Success";
	}
	public String getaddEvent()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		IEvenInfoDao dao = new EvenInfoDaoImp();
		JSONObject result =dao.queryEvenselecttList();
		JSONArray array=result.getJSONArray("arrayselelct");
		List<EvenModBean> list = new ArrayList<EvenModBean>();
		for (int i = 0; i < array.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			EvenModBean bean = (EvenModBean) JSONObject.toBean(
					array.getJSONObject(i), EvenModBean.class);
			list.add(bean);
		}
		String  tag= request.getParameter("tag");
		request.setAttribute("tag", tag);
		request.setAttribute("EventselectList", list);
		//dao.queryEvenselecttList()
		
		if(tag.equals("add")){
			Eventinfo bean = new Eventinfo("","","","","","","","","","","","","");
			request.setAttribute("eventinfo", bean);
		   return "Success";
		}
		if (tag.equals("upd")){
			String event_no = request.getParameter("event_no");
			Eventinfo bean =dao.selectEventBean(event_no);
			request.setAttribute("eventinfo", bean);
		  return "Success";	
		}
		else{
			 return " ";	
		}
	}
	public void addUpdEvent() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		IEvenInfoDao dao = new EvenInfoDaoImp();
		Eventinfo bean = new Eventinfo();
        bean.setEvent_inf(this.getEvent_inf());
        bean.setEvent_key(this.getEvent_key());
        bean.setEvent_mod_id(this.getEvent_mod_id());
        bean.setEvent_no(this.getEvent_no());
        bean.setEvent_person(this.getEvent_person());
        bean.setEvent_relust(this.getEvent_relust());
        String str =request.getParameter("str");
        String tag=request.getParameter("tag");
		boolean flag =true;
		PrintWriter pw  = response.getWriter();
		String text = "";
		if(tag.equals("add")){
			 bean.setEvent_sts(ContextParams.ALL_STATE_NORMAL);
			//新增
			flag = dao.AddEvent(bean);
			if(flag){
				text = "Success!";
			}else{
				text = "error!";
			}
		}else if(tag.equals("upd")){
			bean.setEvent_sts(ContextParams.ALL_STATE_NORMAL);
			bean.setCre_dt(this.getCre_dt());
			bean.setCre_tm(this.getCre_tm());
			flag = dao.UpdEvent(bean);
			if(flag){
				text = "Success!";
			}else{
				text = "error!";
			}
		}else if(tag.equals("delete")){
			
			String [] st=str.split(",");
			for (int i=0;i<st.length;i++){
				JSONObject js=new JSONObject();
				js.put("event_no",st[i]);
				js.put("event_sts",ContextParams.ALL_STATE_CANCEL);
				flag =dao.deleteEvent(js);
			}
			if(flag){
				text = "Success!";
			}else{
				text = "error!";
			}
		}
		pw.print(text);
		pw.flush();
	}
}
