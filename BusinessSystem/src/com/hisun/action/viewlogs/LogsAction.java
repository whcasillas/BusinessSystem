package com.hisun.action.viewlogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.hisun.action.base.BaseAction;
import com.hisun.tools.SSHHelper;

public class LogsAction extends BaseAction {

	private String log_date;
	private String key_words;
	private String log_name;
	private String log_ip;
	private static String xmlURL = "IPConnection.xml";
	private static String testurl = "test.txt";

	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	public String getKey_words() {
		return key_words;
	}
	public void setKey_words(String key_words) {
		this.key_words = key_words;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	
	public String initLogsAction()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		URL connPropertyUrl = new LogsAction().getClass().getClassLoader()
				.getResource(xmlURL);
		
		JSONObject param = new JSONObject();
		SAXReader reader = new SAXReader();  
        Document document = reader.read(new File(connPropertyUrl.getPath()));  
        Element root = document.getRootElement(); 
        List<Element> nodeList = root.elements();
        for (Element a : nodeList){  
        	param.put(a.getName(), a.getText());
        }
        request.setAttribute("SERVER", param);
		return "SUCCESS";
	}
	
	public void queryLogs()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter pw  = response.getWriter();
		String command = "";
		
		String logdate = request.getParameter("log_date");
		String logip = request.getParameter("log_ip");
		String keywords = request.getParameter("key_words");
		String logname = request.getParameter("log_name");
		String logtype = request.getParameter("log_type");
		if("trc".equals(logtype)){
			command = "cd hu;sh ak.sh " + logip + " " + logdate + " " + keywords + " " + logname;
		}else if("log".equals(logtype)){
			command = "cd hu;sh akl.sh " + logip + " " + logdate + " " + keywords + " " + logname;
		}else if("btrc".equals(logtype)){
			command = "cd hu;sh akz.sh " + logip + " " + logdate + " " + keywords + " " + logname;
		}else if("act".equals(logtype)){
			command = "cd hu;sh act.sh " + logip;
		}
		String result = SSHHelper.exec("172.29.68.11", "root", "123", 22, command);
		
		pw.write(result);
		pw.flush();
		pw.close();
	}
	
}
