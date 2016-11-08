package com.hisun.action.event;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.hisun.DAO.EvenInfoDao.Impl.EvenInfoExcelDaoImp;
import com.hisun.bean.even.Eventinfo;
import com.hisun.tools.ExportToExcel;


public class ExportEventExcelAction extends EventAction implements ServletResponseAware{
	HttpServletResponse response = ServletActionContext.getResponse();
	@Override
	public void setServletResponse(HttpServletResponse response) {
	}
	public String exportEventExcel() throws Exception {
		//调用bean转excel格式方法
		ExportToExcel<Eventinfo> ex = new ExportToExcel<Eventinfo>();
		//excel文档内容的标题（第一行）
		String[] headers = {"事件编号","事件内容关键字","事件内容","处理方法","处理人","所属模块","录入日期","录入时间","修改日期","修改时间","时间戳","事件状态","所属模块ID"};
		//将要导出事件存入集合
		List<Eventinfo> dataset = new ArrayList<Eventinfo>();
		//新建一个输出流，用于导出excel文件
		OutputStream out  = null;
		EvenInfoExcelDaoImp eifdi= new EvenInfoExcelDaoImp();
		JSONObject jobect  = eifdi.queryEventListExcel(this.getEvent_no(), this.getEvent_person(), this.getStart_dt(), this.getEnt_dt(), this.getEvent_key(),this.getEvent_mod_id(), this.getEvent_sts(), this.getStart(),this.getEnd());
		JSONArray array = jobect.getJSONArray("resultset");
		
		//迭代array数组取出里面的数据到dataset中
		Iterator iter = array.iterator();
		while (iter.hasNext()){
			Eventinfo bean = (Eventinfo) JSONObject.toBean((JSONObject) iter.next(), Eventinfo.class);
			dataset.add(bean);
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String title = "事件导出"+df.format(new Date());
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
