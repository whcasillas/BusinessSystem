package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

import com.hisun.bean.contact.ContactInfo;

public interface ProvContactInfoDao {
		/**
		 * ��ҳ��ѯʡ��ϵ����Ϣ����ѯ������bean�У�
		 * @param  ��ϵ�˲�ѯBankInfoQueryBean
		 * @return ͨ��json���ط�����������ϵ����Ϣ
		 * @throws Exception
		 */
		public JSONObject queryProvContactList(ContactInfo bean ,int start , int end )throws Exception;
		/**
		 * ��ѯ��ϵ����Ϣ����ѯ������bean�У�
		 * @param  ��ϵ�˲�ѯBankInfoQueryBean
		 * @return ͨ��json���ط�����������ϵ����Ϣ
		 * @throws Exception
		 */
		public JSONObject queryProvContactselectList(ContactInfo bean)throws Exception ;
		/**
		 * ���ʡ��ϵ��
		 * @param ��ϵ��beanbean
		 * @return ��ӳɹ�����true ���򷵻�false
		 * @throws Exception
		 */
		public boolean AddProvContact(ContactInfo bean)throws Exception ;
		/**
		 * ������ϵ��
		 * @param ��ϵ��bean
		 * @return ���ظ��º����ϵ��bean
		 * @throws Exception
		 */
		public boolean UpdProvContact(ContactInfo bean)throws Exception ;
		/**
		 * ��ѯ������ϵ����Ϣ
		 * @param ��ϵ��id
		 * @return	��ϵ��bean
		 * @throws Exception
		 */
		public ContactInfo selectProvContactBean(String id)throws Exception;
		/**
		 *ɾ����ϵ����Ϣ ����ɾ�������±�־λ��
		 * @param 
		 * @return ɾ���ɹ�����true ���򷵻�false
		 * @throws Exception
		 */
		public boolean deleteProvContact(JSONObject js) throws Exception; 
}
