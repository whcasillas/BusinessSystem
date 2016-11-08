package com.hisun.DAO.upDown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hisun.bean.FileItem;
import com.hisun.tools.DBUtil;

public class DataDao{
    
    
    public Map<String, FileItem> getFileInfo(String[] files)throws Exception{
    	DBUtil db = new DBUtil();
    	Map<String, FileItem> fileMap = new HashMap<String, FileItem>();
    	String file_id = "";
    	for(int i=0; i<files.length; i++){
    		file_id += "'" + files[i] + "',";
    	}
    	file_id = file_id.substring(0, file_id.length() - 1);
    	String sql = "select * from hs_m_file where file_id in(" + file_id  + ")";
    	JSONArray array = db.executeQueryData(sql, null);
    	for(int i=0; i<array.size(); i++){
    		FileItem f = (FileItem)JSONObject.toBean(array.getJSONObject(i), FileItem.class);
    		fileMap.put(f.getFile_id(), f);
    	}
    	return fileMap;
    }
    
    public String getTime()throws Exception{
    	DBUtil db = new DBUtil();
    	return db.getSmpByDate();
    }
    
    public JSONObject queryFileList(String file_name, String file_type, String update_staff)throws Exception{
    	DBUtil db = new DBUtil();
    	StringBuffer sb = new StringBuffer("");
    	sb.append(" select * from hs_m_file where 1=1 ");
    	if(!"".equals(file_name)&&null!=file_name){
    		sb.append(" and file_name like '%'||'" + file_name + "'||'%'");
    	}
    	if(!"".equals(file_type)&&null!=file_type){
    		sb.append(" and file_type ='" + file_name + "' ");
    	}
    	if(!"".equals(update_staff)&&null!=update_staff){
    		sb.append(" and update_staff like '%'||'" + update_staff + "'||'%'");
    	}
    	sb.append(" order by update_time desc ");
    	int count = db.getDataCount(sb.toString(), null);
    	JSONArray array = db.executeQueryData(sb.toString(), null);
    	JSONObject result = new JSONObject();
    	
    	result.put("resultset", array);
		result.put("count", count);
    	return result;
    }
    
    public void saveFileInfo(FileItem f)throws Exception{
    	DBUtil db = new DBUtil();
    	f.setFile_id(db.getSequenceByDate("SEQ_FILE_ID"));
    	f.setUpdate_time(db.getSmpByDate());
    	JSONObject obj = JSONObject.fromObject(f);
    	db.insert("hs_m_file", obj);
    }
    
    //获得文件下载列表
    public List<FileItem> getFileList(String[] files) throws Exception
    {
        return new ArrayList<FileItem>(getFileInfo(files).values());
    }
    
    
    //根据id获得单个文件
    public FileItem getFileItem(String fileName) throws Exception
    {
        return getFileInfo(new String[]{fileName}).get(fileName);
    }
}
