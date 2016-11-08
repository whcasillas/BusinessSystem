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
import com.hisun.bean.contact.BankContactInfo;
import com.hisun.bean.contact.ContactInfo;
import com.hisun.tools.ExportToExcel;

public class ExportContactExcelAction extends ContactAction  implements
		ServletResponseAware {
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
	}

	public String exportBankContactExcel() throws Exception {
		
		String bank_name = request.getParameter("bank_name");
		String bank_type = request.getParameter("bank_type");
		String bank_address =  request.getParameter("bank_address");
		String bank_contact_typ  = request.getParameter("bank_contact_typ");
		String contact_name  = request.getParameter("contact_name");
		String contact_prov  = request.getParameter("contact_prov");
		String contact_mbl  = request.getParameter("contact_mbl");
		String contact_email  = request.getParameter("contact_email");
		String contact_qq  = request.getParameter("contact_qq");
		String contact_remarks  = request.getParameter("contact_remarks");
	
		// ����beanתexcel��ʽ����
		ExportToExcel<BankContactInfo> ex = new ExportToExcel<BankContactInfo>();
		// excel�ĵ����ݵı��⣨��һ�У�
		String[] headers = { "��������", "����ҵ������", "��ϵ��", "������ϵ������", "�绰����", "����",
				"QQ", "���е�ַ", "��ע��Ϣ" };
		// ��Ҫ�����¼����뼯��
		List<BankContactInfo> dataset = new ArrayList<BankContactInfo>();
		// �½�һ������������ڵ���excel�ļ�
		OutputStream out = null;

		ContactInfo ci = new ContactInfo();

		ci.setBank_name(bank_name);
		ci.setBank_type(bank_type);
		ci.setBank_address(bank_address);
		ci.setBank_contact_typ(bank_contact_typ);
		ci.setContact_name(contact_name);
		ci.setContact_prov(contact_prov);
		ci.setContact_mbl(contact_mbl);
		ci.setContact_email(contact_email);
		ci.setContact_qq(contact_qq);
		ci.setContact_remarks(contact_remarks);

		ContactInfoDaoImpl cidi = new ContactInfoDaoImpl();
		JSONObject jobect = cidi.queryContactselecttList(ci);
		JSONArray array = jobect.getJSONArray("resultset");

		// ����array����ȡ����������ݵ�dataset��
		Iterator iter = array.iterator();
		while (iter.hasNext()) {
			ContactInfo cibean = (ContactInfo) JSONObject.toBean(
					(JSONObject) iter.next(), ContactInfo.class);
			BankContactInfo bci = new BankContactInfo(cibean.getBank_name(),
					cibean.getBank_type(), cibean.getContact_name(),
					cibean.getBank_contact_typ(), cibean.getContact_mbl(),
					cibean.getContact_email(), cibean.getContact_qq(),
					cibean.getBank_address(), cibean.getContact_remarks());
			dataset.add(bci);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// �������ڸ�ʽ
		String title = "������ϵ�˵���" + df.format(new Date());
		String downloadFileName = new String(title.getBytes("gbk"), "iso8859-1");
		response.setContentType("octets/stream");
		response.setContentType("text/html;charset=gbk");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ downloadFileName + ".xls");
		out = response.getOutputStream();
		ex.ExportToExcel(headers, dataset, out);
		out.close();
		System.out.println("������ɣ���");
		return null;
	}

}
