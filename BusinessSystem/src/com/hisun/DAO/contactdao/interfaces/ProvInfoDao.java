package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

public interface ProvInfoDao {
	/**
	 * 查询所有的省
	 * @return  返回所有的省
	 * @throws Exception
	 */
	public JSONObject queryProvList( )throws Exception; 
	/**
	 * 查询单个省
	 * @return  返回单个省
	 * @throws Exception
	 */
	public JSONObject queryProv( )throws Exception;
}
