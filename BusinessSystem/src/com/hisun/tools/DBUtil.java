package com.hisun.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DBUtil {
	protected Logger log = Logger.getLogger(getClass());
	private static String propertyURL = "config.properties";
	private static String url = null;
	private static String userName = null;
	private static String pwd = null;
	private static String driver = null;
	// ��ʼ��������Ϣ
	static {
		init();
	}

	static void init() {
		URL connPropertyUrl = new DBUtil().getClass().getClassLoader()
				.getResource(propertyURL);
		java.util.Properties pros = new java.util.Properties();
		try {
			pros.load(new java.io.FileInputStream(new File(connPropertyUrl
					.getPath())));
			driver = (String) pros.get("db.driverClassName");
			url = (String) pros.get("db.url");
			userName = (String) pros.get("db.username");
			pwd = (String) pros.get("db.password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get connection
	 * 
	 * @return
	 */
	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, pwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �Զ�����16λ�����ڵ�����
	 * @param seqName(������)
	 * @return
	 * @throws Exception
	 */
	public String getSequenceByDate(String seqName)throws Exception{
		ResultSet resultSet = null;
		Connection conn = null;
		Statement stmt = null;
		String seq = "";
		String sql = "select to_char(sysdate,'yyyyMMdd')||lpad(" + seqName + ".Nextval,8,0) as seqValue from dual";
		log.debug("=============����SQL===========" + sql);
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()){
				seq = resultSet.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());		
		}finally {
			if (resultSet != null) {
				resultSet.getStatement().close();
				resultSet.close();
			}
			stmt.close();
			if (conn != null)
				conn.close();
		}
		return seq;
	}
	/**
	 * �Զ�����ʱ���
	 * @return
	 * @throws Exception
	 */
	public String getSmpByDate()throws Exception{
		ResultSet resultSet = null;
		Connection conn = null;
		Statement stmt = null;
		String seq = "";
		String sql = "select to_char(sysdate, 'yyyyMMddHHmmss') sys_date from dual";
		log.debug("=============ʱ���SQL===========" + sql);
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()){
				seq = resultSet.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());		
		}finally {
			if (resultSet != null) {
				resultSet.getStatement().close();
				resultSet.close();
			}
			stmt.close();
			if (conn != null)
				conn.close();
		}
		return seq;
	}

	/**
	 * ͨ�ó־û�������
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int executeUpdate(String sql, Object[] params) throws Exception {
		ResultSet resultSet = null;
		Connection connnection = null;
		PreparedStatement preparedStatement = null;
		int affectedLine = 0;
		try {
			connnection = getDBConnection();
			preparedStatement = connnection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);
				}
			}

			affectedLine = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultSet != null) {
				resultSet.getStatement().close();
				resultSet.close();
			}
			if (connnection != null)
				connnection.close();
		}
		return affectedLine;
	}
	/**
	 * ͨ��insert����
	 * @param table_name(����)
	 * @param params(��Ҫ������ֶ�)
	 * @return
	 * @throws Exception
	 */
	public boolean insert(String table_name, JSONObject params) throws Exception{
		Connection conn = null;
		String keys = "";
		String values = "";
		log.debug(">>>>>>>>>>PARAMS>>>>>>>>>>" + params);
		log.debug(">>>>>>>>>>TABLE_NAME>>>>>>>>>>" + table_name);
		List key = params.names();
		Object[] value = params.values().toArray();
		for(int i=0; i<key.size(); i++){
			keys += key.get(i) + ",";
			values += "'" + value[i] + "'" + ",";
		}
		
		keys = keys.substring(0, keys.length() - 1);
		values = values.substring(0,values.length() - 1);
		
		String sql = "insert into " + table_name + "(" + keys + ") values (" + values + ")";
		System.out.println("----------------sql="+sql);
		log.debug("=============insert  SQL===========" + sql);
		Statement stmt = null;
		try {
			conn = this.getDBConnection();
			stmt = conn.createStatement();
			boolean flag = !stmt.execute(sql);
			conn.commit();
			return flag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
			return false;
		}finally{
			conn.close();
			stmt.close();
		}
		
	}
	
	/**
	 * ͨ��update����
	 * @param table_name(����)
	 * @param params(��Ҫ�޸ĵ��ֶ�)
	 * @param keys(����key)
	 * @param values(����value)
	 * @return
	 * @throws Exception
	 */
	public boolean save(String table_name,  JSONObject params, String[] keys, String[] values)throws Exception{
		Connection conn = null;
		
		int k = keys.length;
		int v = values.length;
		log.debug(">>>>>>>>>>PARAMS>>>>>>>>>>" + params);
		log.debug(">>>>>>>>>>TABLE_NAME>>>>>>>>>>" + table_name);
		log.debug(">>>>>>>>>>KEYS>>>>>>>>" + keys.toString());
		log.debug(">>>>>>>>>>VALUES>>>>>>>>" + values.toString());
		if(k != v){
			System.out.println("�����������ֵ����Ŀ�����");
			return false;
		}
		
		if(keys.length == 0||values.length == 0){
			System.out.println("����������Ϊ��");
			return false;
		}
		
		String sql = "update " + table_name + " set ";
		
		List key = params.names();
		Object[] value = params.values().toArray();
		
		for(int i=0; i<key.size(); i++){
			sql += key.get(i) + "='" + value[i] + "',";
		}
		sql = sql.substring(0, sql.length() - 1);
		
		sql += " where 1=1 ";
		
		for(int i=0; i<keys.length; i++){
			sql += " and " + keys[i] + "='" + values[i] + "' ";
		}
		
		log.debug("=============update  SQL===========" + sql);
		Statement stmt = null;
		try {
			conn = this.getDBConnection();
			stmt = conn.createStatement();
			boolean flag = !stmt.execute(sql);
			conn.commit();
			return flag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
			return false;
		}finally{
			conn.close();
			stmt.close();
		}
	}
	
	/**
	 * ɾ��ͨ�÷�������ϵͳ������Ӳɾ����
	 * @param table_name ����
	 * @param keys ����key
	 * @param values  ����value
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String table_name, String[] keys, String[] values)throws Exception{
		Connection conn = null;
		
		int k = keys.length;
		int v = values.length;
		
		if(k != v){
			System.out.println("�����������ֵ����Ŀ�����");
			return false;
		}
		
		if(keys.length == 0||values.length == 0){
			System.out.println("����������Ϊ��");
			return false;
		}
		String sql = "delete " + table_name + " where 1=1 ";
		for(int i=0; i<keys.length; i++){
			sql += " and " + keys[i] + "='" + values[i] + "' ";
		}
		log.debug("=============delete  SQL===========" + sql);
		Statement stmt = null;
		try {
			conn = this.getDBConnection();
			stmt = conn.createStatement();
			boolean flag = !stmt.execute(sql);
			conn.commit();
			return flag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
			return false;
		}finally{
			conn.close();
			stmt.close();
		}
	}
	/**
	 * �õ���Ҫ��ѯ���ݵ�������
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getDataCount(String sql, Object[] params)throws Exception{
		StringBuffer sb = new StringBuffer("");
		Connection conn = null;
		int count = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		sb.append(" select count(0) from (" + sql + ")");
		try {
			conn = getDBConnection();
			preparedStatement = conn.prepareStatement(sb.toString());
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);
				}
			}
			resultset = preparedStatement.executeQuery();
			while(resultset.next()){
				count = resultset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (resultset != null) {
				resultset.getStatement().close();
				resultset.close();
			}
			if (conn != null)
				conn.close();
			preparedStatement.close();
		}
		return count;
	}
	
	/**
	 * ͨ�ò�ѯ����������JSONArray����
	 * 
	 * @param sql
	 * @param params
	 *            �������������
	 * @throws Exception
	 */
	public JSONArray executeQueryData(String sql, Object[] params)
			throws Exception {
		JSONArray array = new JSONArray();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			conn = getDBConnection();
			preparedStatement = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);
				}
			}
			resultset = preparedStatement.executeQuery();
			ResultSetMetaData md = resultset.getMetaData();
			int num = md.getColumnCount();

			while (resultset.next()) {
				JSONObject colValues = new JSONObject();
				for (int j = 1; j <= num; j++) {
					colValues.put(md.getColumnName(j).toLowerCase(),
							resultset.getObject(j));
				}
				array.add(colValues);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null) {
				resultset.getStatement().close();
				resultset.close();
			}
			if (conn != null)
				conn.close();
			preparedStatement.close();
		}
		return array;
	}
	
	
	/**
	 * ��װ��ҳsql����ҳ��ѯ����׼��
	 * @param condition
	 * @param params
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public JSONArray executeQueryPaging(StringBuffer condition, Object[] params, int start, int end) throws Exception {
		JSONArray array = new JSONArray();
		Connection conn = null;
		ResultSet resultset = null;
		PreparedStatement preparedStatement = null;
		if (start >= 0 || end >= 0) {
			condition.insert(0,
					"select * from (select B.*,rownum as row_index from ( ");
			condition.append(" ) B) where ");
			if (start >= 0) {
				condition.append(" row_index >=").append(start);
				if (end >= 0)
					condition.append(" and row_index <= ").append(end);
			} else
				condition.append(" row_index >=0 and row_index <= ")
						.append(end);
		}
		log.debug("===============Query SQL===============" + condition.toString());
		try {
			conn = getDBConnection();
			preparedStatement = conn.prepareStatement(condition.toString());
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);
				}
			}
			resultset = preparedStatement.executeQuery();
			ResultSetMetaData md = resultset.getMetaData();
			int num = md.getColumnCount();

			while (resultset.next()) {
				JSONObject colValues = new JSONObject();
				for (int j = 1; j <= num; j++) {
					colValues.put(md.getColumnName(j).toLowerCase(),
							resultset.getObject(j));
				}
				array.add(colValues);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null) {
				resultset.getStatement().close();
				resultset.close();
			}
			if (conn != null)
				conn.close();
			preparedStatement.close();
		}
		return array;
	}

	/**
	 * ��ȡ���ݿ⵱ǰʱ�䣬����JSONObject����
	 * getString("nowDate")��ȡ��ǰ������,
	 * getString("nowTime")��ȡ��ǰʱ����,
	 * getString("now")��ȡ��ǰʱ���
	 * @return
	 * @throws Exception
	 */
	public JSONObject getSysTime()throws Exception{

		JSONObject result = new JSONObject();
		Connection conn = null;
		ResultSet resultset = null;
		Statement stmt = null;
		String sys_date = "";
		String nowdate = "";
		String nowtime = "";
		String sql = " select to_char(sysdate, 'yyyyMMddHHmmss') as sys_date from dual ";
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();
			resultset = stmt.executeQuery(sql);
			while (resultset.next()) {
				sys_date = resultset.getString(1);
			}
			nowdate = sys_date.substring(0,8);
			nowtime = sys_date.substring(8, sys_date.length());
			result.put("nowDate", nowdate);
			result.put("nowTime", nowtime);
			result.put("now", sys_date);
		} catch (Exception e) {
			throw e;
		} finally {
			if (resultset != null) {
				resultset.getStatement().close();
				resultset.close();
			}
			if (conn != null)
				conn.close();
		}
	
		return result;
	}
}
