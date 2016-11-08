package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

import com.hisun.bean.contact.ContackInfoQueryBean;
import com.hisun.bean.contact.ContactInfo;

public interface BankInfoDao {
	/**
	 * ��ѯ����������Ϣ
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryBankList( )throws Exception;
	
	/**
	 * ��������id�鿴��������
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryBank(String bank_id)throws Exception;
}
