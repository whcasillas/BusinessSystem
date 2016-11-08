package com.hisun.DAO.messdao.interfaces;

import com.hisun.bean.contact.ContactInfo;
import com.hisun.bean.mess.MessInfo;

import net.sf.json.JSONObject;

public interface MessDao {
	//分页查询消息
	public JSONObject queryMessList(MessInfo bean ,int start , int end )throws Exception;
	//查询消息
	public JSONObject queryMessselecttList(MessInfo bean)throws Exception ;
	//添加消息
	public boolean AddMess(MessInfo bean)throws Exception ;
	//修改消息
	public boolean UpdMess(MessInfo bean)throws Exception ;
	//查询单个消息
	public MessInfo selectMessBean(String id)throws Exception;
	//删除消息
	public boolean deleteMess(JSONObject js) throws Exception; 
	
	//分页近两日查询消息
	public JSONObject queryMessListLastTwoDays(MessInfo bean )throws Exception;
}
