package com.hisun.action.JinJiShiJian;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hisun.DAO.EvenInfoDao.Impl.EvenInfoExcelDaoImp;
import com.hisun.DAO.jinjishijianDao.impl.JjsjImpl;
import com.hisun.bean.even.Eventinfo;
import com.hisun.bean.jinjishijian.ExpJjsj;
import com.hisun.bean.jinjishijian.ExpJjsjzx;
import com.hisun.bean.jinjishijian.Jjsj;
import com.hisun.bean.jinjishijian.Jjsjzx;
import com.hisun.tools.ExportToExcel;

public class ExpJjsjAction extends JjsjAction implements ServletResponseAware{
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request= ServletActionContext.getRequest();
	@Override
	public void setServletResponse(HttpServletResponse response) {
	}
	public String expjjsj() throws Exception {
		//调用bean转excel格式方法
		ExportToExcel<ExpJjsj> ex = new ExportToExcel<ExpJjsj>();
		//excel文档内容的标题（第一行）
		String[] headers = {"编号","事件编号","事件类型","事件标题","登记时间","催办次数","事件状态"};
		//将要导出事件存入集合
		List<ExpJjsj> dataset = new ArrayList<ExpJjsj>();
		//新建一个输出流，用于导出excel文件
		OutputStream out  = null;
		JjsjImpl jjimpl= new JjsjImpl();
		JSONObject jobect  = jjimpl.qusertjjsjall();
		JSONArray array = jobect.getJSONArray("result");
		
		//迭代array数组取出里面的数据到dataset中
		Iterator iter = array.iterator();
		while (iter.hasNext()){
			Jjsj jj = (Jjsj) JSONObject.toBean((JSONObject) iter.next(), Jjsj.class);
			ExpJjsj ej = new ExpJjsj();
			ej.setSj_id(jj.getSj_id());
			ej.setSj_title(jj.getSj_title());
			ej.setSj_type(jj.getSj_type());
			ej.setCb_num(jj.getCb_num());
			ej.setTm_smp(jj.getTm_smp());
			if (jj.getCl_sts()==0){
				ej.setExp_cl_sts("未处理");	
			}else{
				ej.setExp_cl_sts("已处理");
			}
			System.out.println(ej.toString());
			dataset.add(ej);
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String title = "紧急事件导出"+df.format(new Date());
		String downloadFileName=new String(title.getBytes("gbk"), "iso8859-1");
		response.setContentType("octets/stream");
		response.setContentType("text/html;charset=gbk");
	    response.addHeader("Content-Disposition", "attachment;filename="+downloadFileName+".xls");
		out = response.getOutputStream();
		ex.ExportToExcel(headers, dataset, out);
		out.close();
		System.out.println("导出完成！！");
		return null;
	}
	
	
	//导出所有
	public String expjjsjzx() throws Exception {
		String exptype = request.getParameter("exptype");
		//调用bean转excel格式方法
		ExportToExcel<ExpJjsjzx> ex = new ExportToExcel<ExpJjsjzx>();
		//excel文档内容的标题（第一行）
		String[] headers = {"编号","事件编号","事件类型","事件标题","登记时间","催办次数","事件状态","反馈人","反馈时间"};
		//将要导出事件存入集合
		List<ExpJjsjzx> dataset = new ArrayList<ExpJjsjzx>();
		//新建一个输出流，用于导出excel文件
		OutputStream out  = null;
		JjsjImpl jjimpl= new JjsjImpl();
		JSONObject jobect= new JSONObject();
		String title_f="紧急事件导出";
		if("wcl".equals(exptype)){
			jobect = jjimpl.qusertjjsjWCL();	//导出未处理
			title_f="未处理紧急事件导出";
			System.out.println("-------------未处理紧急事件导出");
		}else if("ycl".equals(exptype)){
			jobect = jjimpl.qusertjjsjYCL();		//导出已处理
			title_f="已处理紧急事件导出";
			System.out.println("-------------已处理紧急事件导出");
		}else{
			jobect = jjimpl.qusertjjsjall();		//导出所有
			System.out.println("-------------默认非处理参数");
		}
		
		
		JSONArray array = jobect.getJSONArray("result");
		
		//迭代array数组取出里面的数据到dataset中
		Iterator iter = array.iterator();
		while (iter.hasNext()){
			Jjsjzx jj = (Jjsjzx) JSONObject.toBean((JSONObject) iter.next(), Jjsjzx.class);
			ExpJjsjzx ej = new ExpJjsjzx();
			ej.setSj_id(jj.getSj_id());
			ej.setSj_title(jj.getSj_title());
			ej.setSj_type(jj.getSj_type());
			ej.setCb_num(jj.getCb_num());
			ej.setTm_smp(jj.getTm_smp());
			ej.setJj_id(jj.getJj_id());
			ej.setOpt_name(jj.getOpt_name());
			ej.setCl_smp(jj.getCl_smp());
			if (jj.getCl_sts()==0){
				ej.setExp_cl_sts("未处理");	
			}else{
				ej.setExp_cl_sts("已处理");
			}
			dataset.add(ej);
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		
		String title =title_f +df.format(new Date());
		String downloadFileName=new String(title.getBytes("gbk"), "iso8859-1");
		response.setContentType("octets/stream");
		response.setContentType("text/html;charset=gbk");
	    response.addHeader("Content-Disposition", "attachment;filename="+downloadFileName+".xls");
		out = response.getOutputStream();
		ex.ExportToExcel(headers, dataset, out);
		out.close();
		System.out.println("导出完成！！");
		return null;
	}
	
	
}
