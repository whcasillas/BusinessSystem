package com.hisun.action.contact;

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

import com.hisun.DAO.contactdao.impl.ContactInfoDaoImpl;
import com.hisun.DAO.contactdao.impl.ProvContactInfoDaoImpl;
import com.hisun.bean.contact.BankContactInfo;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.bean.contact.ProvContactInfo;
import com.hisun.tools.ExportToExcel;

public class ExportProvContactExcelAction extends ContactAction  implements
		ServletResponseAware {
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
	}

	public String exportProvContactExcel() throws Exception {
		
		String contact_name  = request.getParameter("contact_name");
		String contact_prov  = request.getParameter("contact_prov");
		String contact_mbl  = request.getParameter("contact_mbl");
		String contact_email  = request.getParameter("contact_email");
		String contact_qq  = request.getParameter("contact_qq");
		String contact_remarks  = request.getParameter("contact_remarks");
	
		// 调用bean转excel格式方法
		ExportToExcel<ProvContactInfo> ex = new ExportToExcel<ProvContactInfo>();
		// excel文档内容的标题（第一行）
		String[] headers = { "省", "联系人","电话号码", "邮箱",	"QQ", "备注信息" };
		// 将要导出事件存入集合
		List<ProvContactInfo> dataset = new ArrayList<ProvContactInfo>();
		// 新建一个输出流，用于导出excel文件
		OutputStream out = null;

		ContactInfo ci = new ContactInfo();

		ci.setContact_prov(contact_prov);
		ci.setContact_name(contact_name);
		ci.setContact_prov(contact_prov);
		ci.setContact_mbl(contact_mbl);
		ci.setContact_email(contact_email);
		ci.setContact_qq(contact_qq);
		ci.setContact_remarks(contact_remarks);

		ProvContactInfoDaoImpl pcidi = new ProvContactInfoDaoImpl();
		JSONObject jobect = pcidi.queryProvContactselectList(ci);
		JSONArray array = jobect.getJSONArray("resultset");

		// 迭代array数组取出里面的数据到dataset中
		Iterator iter = array.iterator();
		while (iter.hasNext()) {
			ContactInfo cibean = (ContactInfo) JSONObject.toBean(
					(JSONObject) iter.next(), ContactInfo.class);
			ProvContactInfo bci = new ProvContactInfo(cibean.getContact_prov(),cibean.getContact_name(),cibean.getContact_mbl(),cibean.getContact_email(),cibean.getContact_qq(),cibean.getContact_remarks());
			dataset.add(bci);
		
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		String title = "省网关联系人导出" + df.format(new Date());
		String downloadFileName = new String(title.getBytes("gbk"), "iso8859-1");
		response.setContentType("octets/stream");
		response.setContentType("text/html;charset=gbk");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ downloadFileName + ".xls");
		out = response.getOutputStream();
		ex.ExportToExcel(headers, dataset, out);
		out.close();
		System.out.println("导出完成！！");
		return null;
	}

}
