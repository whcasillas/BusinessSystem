package com.hisun.action.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hisun.action.base.BaseAction;

public class PageAction extends BaseAction{

	private int start;//从第几条数据开始
	private int end;//到第几条数据结束s
	private int nowPg;//当前页码
	private int pgSize;//一页显示多少条

	public int getPgSize() {
		return pgSize;
	}

	public void setPgSize(int pgSize) {
		this.pgSize = pgSize;
	}

	public int getNowPg() {
		return nowPg;
	}

	public void setNowPg(int nowPg) {
		this.nowPg = nowPg;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public boolean hasProv(){
		return super.hasProv();
	}

	/**
	 * 分页初始化
	 * @throws Exception
	 */
	public void init()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(getStart()!=0) 
			this.setStart((Integer) request.getAttribute("start")); 
		else 
			setStart(1);
		if(getEnd()!=0) 
			this.setEnd((Integer) request.getAttribute("end"));
		else 
			setEnd(10);
		if(getNowPg()!=0) 
			this.setNowPg((Integer) request.getAttribute("nowPg"));
		else 
			setNowPg(1);
		request.setAttribute("start", getStart());
		request.setAttribute("end", getEnd());
		request.setAttribute("nowPg", getNowPg());
	}
	
	@Override
	public String execute() throws Exception {
		
		return null;
	}
	
	
}
