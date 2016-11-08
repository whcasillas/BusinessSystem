<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.hisun.bean.contact.BankType"%>
<%@page import="com.hisun.bean.contact.BankInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.color:link {
	color: #3399CC;
	text-decoration: none;
	font-weight: bold;
} /*链接设置*/
.color:visited {
	color: #3399CC;
	text-decoration: none;
	font-weight: bold;
} /*访问过的链接设置*/
.color:hover {
	color: #CF0000;
	text-decoration: underline;
	font-weight: bold;
} /*鼠标放上的链接设置*/
/*
取消下划线只要把text-decoration:underline修改成text-decoration:none
文字加粗font-weight:bold 如不需要加粗显示，那么删除font-weight:bold;就可以了
其它更多的参数设置参考：css2.0手册 其中的"伪类"说明
*/ 
</style>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="script/pageScript.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
    initPage("a1","a2");
    initPageCnt("s1");
 });

	function funonclick(obj) {
		var collid = document.getElementById("all");
		var test = document.getElementsByName(obj);
		if (collid.checked) {
			for ( var i = 0; i <= test.length - 1; i++) {
				test[i].checked = true;
			}
		} else {
			for ( var i = 0; i <= test.length - 1; i++) {
				test[i].checked = false;
			}

		}
	}
	function funconclickdelete(obj) {
		var test = document.getElementsByName(obj);
		var str = "";
		for ( var i = 0; i <= test.length - 1; i++) {
			if (test[i].checked == true) {
				str += test[i].value + ",";
			}
		}
		str = str.substring(0, str.length - 1);
		if (str == "") {
			alert("请勾选你要删除的公示信息");
		} else {
			if (confirm('确定删除吗？')) {
				$.ajax({
					url : 'delmess.action',
					type : 'post',
					data : {
						str : str
					},
					dataType : 'text',
					success : function(text) {
						if (text == "success") {
							alert("删除成功");
							window.location.href = "messlist.action";

						}
					}
				})
			} else {
				return;
			}

		}
	}
	
	function jiaoyan(formName) {
		
		//document.getElementById('pageNum').value=1;
		redirectTo('messform');
	}
	
</script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/messlist.action"  method="post" id="messform">
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;运维管理系统&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;公示信息管理&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;公示信息列表</td>
			</tr>
			<tr>
				<td
					style="height:34px; background-image:url(images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34"><img
								src="images/main_headerL.gif" width="20" height="34"></td>
							<td style="color:#90c8e8;"><img
								src="images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>公示信息管理</strong></td>
							<td align="right" class="white" style="padding-right:20px">
								
                                    
                                 
								
						
									<a href="getaddmess.action" class="barBtn">
										<img src="images/5.png" width="16" height="16" align="absmiddle">添加
									</a>
						
								
								
									<a href="#" class="barBtn" onclick="funconclickdelete('chekname')"> 
											<img src="images/6.png" width="16" height="16" align="absmiddle"> 删除
									</a>
								
								
						</tr>
					</table></td>
			</tr>
			<tr>
				<td
					style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1">
						<TR>
							<th width="8%" align="center">公示类型</th>
							<td width="10%" class="BGCgray"><select name="mess_type" id="mess_type">
                             	<s:set name="mtype" value="#request.mess_type"/>
                             	<s:if test="#mtype==null||#mtype==''">  
								    <option value="">--请选择--</option>
								</s:if>  
								<s:else> 
									<option value="${mess_type }">${mess_type }</option>
									<option value="">--请选择--</option>  
								</s:else> 
                             <s:iterator value="#request.mtilist" id="mti">
                              <option value="<s:property value="#mti.mess_type_name"/>"><s:property value="#mti.mess_type_name"/></option>
                              </s:iterator>
                              </select></td>
                              <th width="8%" align="center">操作人</th>
							<td width="12%" class="BGCgray">
								<input type="text" name="opt_name" id="opt_name" size="12" value="${opt_name }">
							</td>
                              
							<th width="8%" align="center">事件编号</th>
							<td width="8%" class="BGCgray">
								<input type="text" name="event_id" id="event_id" size="12" value="${event_id }">
							</td>
							<th width="8%" align="center">公示日期</th>
							<td width="15%" class="BGCgray">
								<input type="text" name="mess_date" id="mess_date" size="10"   value="${mess_date }">
								<a style="color:red; font-size:12px;">格式：20160620</a>
							</td>
							<td width="10%" class="BGCgray" rowspan="2" align="center">
								<BUTTON style="HEIGHT:25px; WIDTH:70px"  onclick="jiaoyan('messform')">
										<img src="images/btn_search.gif" width="16" height="16"  align="absmiddle"> 查询
								</BUTTON>
							</td>
				  </tr>
							<tr>
							<th width="8%" align="center">执行状态</th>
							<td width="10%" class="BGCgray">
								
								<select name="mess_status" id="mess_status">
									<s:set name="mess_status" value="#request.mess_status"/>
									<s:if test="#mess_status==null||#mess_status==''">  
								   		<option value="">--请选择--</option>
									</s:if>  
									<s:else> 
									
									
										<option value="${mess_status }">
											<s:if test="#mess_status==0">
												正在执行
											</s:if> 
											<s:if test="#mess_status==1">
												执行完成
											</s:if> 
										</option>
										<option value="">--请选择--</option>
										
									</s:else> 
									<option value="0">正在执行</option>  
									<option value="1">执行完成</option>    
								</select>
								
							</td>
							<th width="8%" align="center">操作说明</th>
							<td  colspan="5" width="15%" class="BGCgray">
								<input type="text" name="mess_remarks" size="80" id="mess_remarks"  value="${mess_remarks }">
							</td>
							
							
						</TR>
                    
					</table></td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th align="center">
									<input type="checkbox" name="chekname1" id="all" onclick="funonclick('chekname')">
								</th>
								<th width="120"  align="center">公式类型</th>
								<th width="80"  align="center">操作人</th>
								<th width="120"  align="center">事件编号</th>
								<th width="120"  align="center">开始时间</th>
								<th width="120"   align="center">结束时间</th>
								<th width="80"  align="center">公示日期</th>
								<th width="80"  align="center">完成标志</th>
								<th align="center">操作说明</th>
								
								<!-- <th width="180" align="center">操作</th> -->
							</TR>
							<s:iterator value="#request.milist" id="messinf">
								<tr class="BGCgray">
									<TD align="center" width="30">
										<input type="checkbox" name="chekname" value='<s:property value="#messinf.mess_id"/>'>
									</TD>
									
									<td align="left" >&nbsp;
										<a class="color" id="mess_id" href=<s:url action="getupdmess.action">
	                                       <s:param name="mess_id" value="#messinf.mess_id"></s:param>
	                                    </s:url>> <s:property value="#messinf.mess_type"></s:property>
	                                    </a>
									</td>
                                    
									<td align="left" >&nbsp;<s:property value="#messinf.opt_name"></s:property></td>
									<td align="left" >&nbsp;<s:property value="#messinf.event_id"></s:property></td>
									<td align="left" >&nbsp;<s:property value="#messinf.start_time"></s:property></td>
									<td align="left" >&nbsp;<s:property value="#messinf.end_time"></s:property></td>
									<td align="left" >&nbsp;<s:property value="#messinf.mess_date"></s:property></td>
									<td align="left" >&nbsp;
										<s:if test="%{#messinf.mess_status==0}">  
										    正在执行
										</s:if>  
										<s:else> 
											执行完成
										</s:else> 
									</td>
									<td align="left" >&nbsp;<s:property value="#messinf.mess_remarks"></s:property></td>
								</tr>
							</s:iterator>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%" height="25"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#" onclick="goTop('messform')"><img
													src="images/prev_top.gif" width="16" height="16"
													border="0"> </a></td>
											<td><a href="#" id="a2"
												onclick="setLastPage('messform')"><img
													src="images/prev.gif" width="16" height="16" border="0">
											</a></td>
											<td><a href="#" id="a1"
												onclick="setNextPage('messform')"><img
													src="images/next.gif" width="16" height="16" border="0">
											</a></td>
											<td><a href="#" onclick="goDown('messform')"><img
													src="images/prev_end.gif" width="16" height="16"
													border="0"> </a></td>
										</tr>
									</table></td>
								<td width="20%" align="center"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#" id="redirct"
												onclick="redirectTo('messform')"><img
													src="images/next.gif" width="16" height="16" border="0">
											</a></td>
											<td><input name="textfield23" type="text" size="3"
												style="width:25;height:18" id="pageNum"
												value="<%=request.getAttribute("nowPg")%>"> /页</td>
										</tr>
									</table></td>
								<td width="20%" align="right"><span id="s1">共${count }条</span>
								</td>
							</tr>
						</table>
						<input type="text" id="start" name="start"
							value="<%=request.getAttribute("start")%>" style="display:none" />
						<input type="text" id="end" name="end"
							value="<%=request.getAttribute("end")%>" style="display:none" />
						<input type="text" id="nowPg" name="nowPg"
							value="<%=request.getAttribute("nowPg")%>" style="display:none" />
						<input type="text" id="pgSize" value="10" name="pgSize"
							style="display:none" /> <input type="text" id="count" name=count
							value="<%=request.getAttribute("count")%>" style="display:none" />
						<input type="text" id="pid" name=pid
							value="<%=request.getAttribute("pid")%>" style="display:none" />
					</div>
				</td>
			</tr>
		</table>

	</form>
</body>
</html> 
