package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

public interface BankTypeDao {
	/**
	 * ��ѯ��������ҵ������
	 * @return ����������������
	 * @throws Exception
	 */
	public JSONObject queryBankTypeList( )throws Exception;
	/**
	 * ��ѯ������������
	 * @return  ���ص�����������
	 * @throws Exception
	 */
	public JSONObject queryBankType( )throws Exception;
}
