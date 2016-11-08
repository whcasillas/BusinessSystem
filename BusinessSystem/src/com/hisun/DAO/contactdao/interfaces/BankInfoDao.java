package com.hisun.DAO.contactdao.interfaces;

import net.sf.json.JSONObject;

import com.hisun.bean.contact.ContackInfoQueryBean;
import com.hisun.bean.contact.ContactInfo;

public interface BankInfoDao {
	/**
	 * 查询所有银行信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryBankList( )throws Exception;
	
	/**
	 * 根据银行id查看银行名称
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JSONObject queryBank(String bank_id)throws Exception;
}
