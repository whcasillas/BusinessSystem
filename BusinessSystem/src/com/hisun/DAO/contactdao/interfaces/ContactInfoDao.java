package com.hisun.DAO.contactdao.interfaces;

import com.hisun.bean.contact.ContackInfoQueryBean;
import com.hisun.bean.contact.ContactInfo;

import net.sf.json.JSONObject;



public interface ContactInfoDao {
	/**
	 * 分页查询银行联系人信息（查询条件在bean中）
	 * @param  联系人查询BankInfoQueryBean
	 * @return 通过json返回符合条件的联系人信息
	 * @throws Exception
	 */
	public JSONObject queryContactList(ContactInfo bean ,int start , int end )throws Exception;
	/**
	 * 查询联系人信息（查询条件在bean中）
	 * @param  联系人查询BankInfoQueryBean
	 * @return 通过json返回符合条件的联系人信息
	 * @throws Exception
	 */
	public JSONObject queryContactselecttList(ContactInfo bean)throws Exception ;
	/**
	 * 添加银行联系人
	 * @param 联系人beanbean
	 * @return 添加成功返回true 否则返回false
	 * @throws Exception
	 */
	public boolean AddContact(ContactInfo bean)throws Exception ;
	/**
	 * 更新联系人
	 * @param 联系人bean
	 * @return 返回更新后的联系人bean
	 * @throws Exception
	 */
	public boolean UpdContact(ContactInfo bean)throws Exception ;
	/**
	 * 查询单个联系人信息
	 * @param 联系人id
	 * @return	联系人bean
	 * @throws Exception
	 */
	public ContactInfo selectContactBean(String id)throws Exception;
	/**
	 *删除联系人信息 ，软删除（跟新标志位）
	 * @param 
	 * @return 删除成功返回true 否则返回false
	 * @throws Exception
	 */
	public boolean deleteContact(JSONObject js) throws Exception; 
}
