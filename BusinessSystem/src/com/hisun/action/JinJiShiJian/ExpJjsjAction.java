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
		//����beanתexcel��ʽ����
		ExportToExcel<ExpJjsj> ex = new ExportToExcel<ExpJjsj>();
		//excel�ĵ����ݵı��⣨��һ�У�
		String[] headers = {"���","�¼����","�¼�����","�¼�����","�Ǽ�ʱ��","�߰����","�¼�״̬"};
		//��Ҫ�����¼����뼯��
		List<ExpJjsj> dataset = new ArrayList<ExpJjsj>();
		//�½�һ������������ڵ���excel�ļ�
		OutputStream out  = null;
		JjsjImpl jjimpl= new JjsjImpl();
		JSONObject jobect  = jjimpl.qusertjjsjall();
		JSONArray array = jobect.getJSONArray("result");
		
		//����array����ȡ����������ݵ�dataset��
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
				ej.setExp_cl_sts("δ����");	
			}else{
				ej.setExp_cl_sts("�Ѵ���");
			}
			System.out.println(ej.toString());
			dataset.add(ej);
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//�������ڸ�ʽ
		String title = "�����¼�����"+df.format(new Date());
		String downloadFileName=new String(title.getBytes("gbk"), "iso8859-1");
		response.setContentType("octets/stream");
		response.setContentType("text/html;charset=gbk");
	    response.addHeader("Content-Disposition", "attachment;filename="+downloadFileName+".xls");
		out = response.getOutputStream();
		ex.ExportToExcel(headers, dataset, out);
		out.close();
		System.out.println("������ɣ���");
		return null;
	}
	
	
	//��������
	public String expjjsjzx() throws Exception {
		String exptype = request.getParameter("exptype");
		//����beanתexcel��ʽ����
		ExportToExcel<ExpJjsjzx> ex = new ExportToExcel<ExpJjsjzx>();
		//excel�ĵ����ݵı��⣨��һ�У�
		String[] headers = {"���","�¼����","�¼�����","�¼�����","�Ǽ�ʱ��","�߰����","�¼�״̬","������","����ʱ��"};
		//��Ҫ�����¼����뼯��
		List<ExpJjsjzx> dataset = new ArrayList<ExpJjsjzx>();
		//�½�һ������������ڵ���excel�ļ�
		OutputStream out  = null;
		JjsjImpl jjimpl= new JjsjImpl();
		JSONObject jobect= new JSONObject();
		String title_f="�����¼�����";
		if("wcl".equals(exptype)){
			jobect = jjimpl.qusertjjsjWCL();	//����δ����
			title_f="δ��������¼�����";
			System.out.println("-------------δ��������¼�����");
		}else if("ycl".equals(exptype)){
			jobect = jjimpl.qusertjjsjYCL();		//�����Ѵ���
			title_f="�Ѵ�������¼�����";
			System.out.println("-------------�Ѵ�������¼�����");
		}else{
			jobect = jjimpl.qusertjjsjall();		//��������
			System.out.println("-------------Ĭ�ϷǴ������");
		}
		
		
		JSONArray array = jobect.getJSONArray("result");
		
		//����array����ȡ����������ݵ�dataset��
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
				ej.setExp_cl_sts("δ����");	
			}else{
				ej.setExp_cl_sts("�Ѵ���");
			}
			dataset.add(ej);
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//�������ڸ�ʽ
		
		String title =title_f +df.format(new Date());
		String downloadFileName=new String(title.getBytes("gbk"), "iso8859-1");
		response.setContentType("octets/stream");
		response.setContentType("text/html;charset=gbk");
	    response.addHeader("Content-Disposition", "attachment;filename="+downloadFileName+".xls");
		out = response.getOutputStream();
		ex.ExportToExcel(headers, dataset, out);
		out.close();
		System.out.println("������ɣ���");
		return null;
	}
	
	
}
