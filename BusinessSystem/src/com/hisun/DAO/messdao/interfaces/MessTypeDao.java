package com.hisun.DAO.messdao.interfaces;

import net.sf.json.JSONObject;

public interface MessTypeDao {
	/**
	 * 查询所有消息类型信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryMessTypeList( )throws Exception;
	
	/**
	 * 根据银行id查看消息类型名称
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryMessType(String bank_id)throws Exception;
}
