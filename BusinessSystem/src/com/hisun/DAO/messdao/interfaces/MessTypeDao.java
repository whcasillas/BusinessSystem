package com.hisun.DAO.messdao.interfaces;

import net.sf.json.JSONObject;

public interface MessTypeDao {
	/**
	 * ��ѯ������Ϣ������Ϣ
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryMessTypeList( )throws Exception;
	
	/**
	 * ��������id�鿴��Ϣ��������
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryMessType(String bank_id)throws Exception;
}
