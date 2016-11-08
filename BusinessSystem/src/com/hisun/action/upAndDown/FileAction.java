package com.hisun.action.upAndDown;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hisun.DAO.upDown.DataDao;
import com.hisun.action.page.PageAction;
import com.hisun.bean.FileItem;

public class FileAction extends PageAction {

	private String file_name;
	private String file_type;
	private String update_staff;
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getUpdate_staff() {
		return update_staff;
	}
	public void setUpdate_staff(String update_staff) {
		this.update_staff = update_staff;
	}
	
	public String queryFileList()throws Exception{
		boolean flag = hasProv();
		if(!flag){
			return "error";
		}
		super.init();
		HttpServletRequest request = ServletActionContext.getRequest();
		DataDao dao = new DataDao();
		JSONObject result = dao.queryFileList(getFile_name(), getFile_type(), getUpdate_staff());
		JSONArray array = result.getJSONArray("resultset");
		int count = result.getInt("count");
		List<FileItem> list = new ArrayList<FileItem>();
		for (int i = 0; i < array.size(); i++) {
			//JSON转javaBean注意事项：从数据库查出来的字段名必须与javaBean中声明的属性名相等，转化才有效
			FileItem bean = (FileItem) JSONObject.toBean(
					array.getJSONObject(i), FileItem.class);
			list.add(bean);
		}
		request.setAttribute("fList", list);
		request.setAttribute("count", count);
		return "Success";
	}
	
}
