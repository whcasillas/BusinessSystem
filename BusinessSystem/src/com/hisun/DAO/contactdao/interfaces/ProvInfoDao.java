package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

public interface ProvInfoDao {
	/**
	 * ��ѯ���е�ʡ
	 * @return  �������е�ʡ
	 * @throws Exception
	 */
	public JSONObject queryProvList( )throws Exception; 
	/**
	 * ��ѯ����ʡ
	 * @return  ���ص���ʡ
	 * @throws Exception
	 */
	public JSONObject queryProv( )throws Exception;
}
