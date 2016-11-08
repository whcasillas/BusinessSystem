package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

import com.hisun.bean.contact.ContactInfo;

public interface ProvContactInfoDao {
		/**
		 * 分页查询省联系人信息（查询条件在bean中）
		 * @param  联系人查询BankInfoQueryBean
		 * @return 通过json返回符合条件的联系人信息
		 * @throws Exception
		 */
		public JSONObject queryProvContactList(ContactInfo bean ,int start , int end )throws Exception;
		/**
		 * 查询联系人信息（查询条件在bean中）
		 * @param  联系人查询BankInfoQueryBean
		 * @return 通过json返回符合条件的联系人信息
		 * @throws Exception
		 */
		public JSONObject queryProvContactselectList(ContactInfo bean)throws Exception ;
		/**
		 * 添加省联系人
		 * @param 联系人beanbean
		 * @return 添加成功返回true 否则返回false
		 * @throws Exception
		 */
		public boolean AddProvContact(ContactInfo bean)throws Exception ;
		/**
		 * 更新联系人
		 * @param 联系人bean
		 * @return 返回更新后的联系人bean
		 * @throws Exception
		 */
		public boolean UpdProvContact(ContactInfo bean)throws Exception ;
		/**
		 * 查询单个联系人信息
		 * @param 联系人id
		 * @return	联系人bean
		 * @throws Exception
		 */
		public ContactInfo selectProvContactBean(String id)throws Exception;
		/**
		 *删除联系人信息 ，软删除（跟新标志位）
		 * @param 
		 * @return 删除成功返回true 否则返回false
		 * @throws Exception
		 */
		public boolean deleteProvContact(JSONObject js) throws Exception; 
}
