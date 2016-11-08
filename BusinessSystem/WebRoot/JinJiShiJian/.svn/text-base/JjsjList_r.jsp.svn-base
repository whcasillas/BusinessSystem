<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
</script>
</head>

<body>
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;运维管理系统&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;<img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;紧急事件管理&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;紧急事件列表
				</td>
			</tr>
			<tr>
				<td style="height:34px; background-image:url(images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34"><img
								src="images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color:#90c8e8;"><img
								src="images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>紧急事件管理</strong>
							</td>
							<td align="right" class="white" style="padding-right:20px"> </td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<form action="<%=request.getContextPath()%>/JjsjList.action" method=get id="JjsjListForm">
						<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
							<TR>
								<th width="30" align="center" >序号</th>
								<th width="150" align="center">登记时间</th>
								<th width="70" align="center">事件编号</th>
								<th width="360" align="center">事件类型</th>
								<th width="*" align="center">事件标题</th>
								<th width="60" align="center" >催办次数</th>
								<th width="60" align="center" >事件状态</th>
							</TR>
							
							<s:set name="n" value="'1'" />
							<s:iterator value="#request.sjlist" id="sj" >
								<tr class="BGCgray">
									<td align="center" > <s:property value="#sj.xuhao" /> </td>
									<td align="left" >&nbsp;<s:property value="#sj.tm_smp"></s:property> </td>
									<td align="left" >&nbsp;<s:property value="#sj.sj_id"></s:property></td>
									<td align="left" >&nbsp;<s:property value="#sj.sj_type"></s:property> </td>
									<td align="left" >&nbsp;<s:property value="#sj.sj_title"></s:property> </td>
									<td align="left" >&nbsp;<s:property value="#sj.cb_num"></s:property> </td>
									<td align="left" >&nbsp; 
										<s:if test="#sj.cl_sts==0">
												 未处理
										</s:if> 
										<s:else>已处理</s:else>
									</td>
								</tr>
							</s:iterator>
						</table>
						<input type="text" id="start" name="start" value="<%=request.getAttribute("start")%>" style="display:none" />
						<input type="text" id="end" name="end" value="<%=request.getAttribute("end")%>" style="display:none"/>
						<input type="text" id="nowPg" name="nowPg" value="<%=request.getAttribute("nowPg")%>" style="display:none"/>
						<input type="text" id="pgSize" value="10" name="pgSize" style="display:none"/>
						<input type="text" id="count" name=count value="<%=request.getAttribute("count")%>" style="display:none"/>
						<input type="text" id="pid" name=pid value="<%=request.getAttribute("pid")%>" style="display:none"/>
						</form>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%" height="25">
								<table border="0" cellspacing="0" cellpadding="3">
										<tr>
											<td>
												<a href="#" onClick="goTop('JjsjListForm')">
													<img src="images/prev_top.gif" width="16" height="16" border="0">
												</a>
											</td>
											<td>
												<a href="#" id="a2" onClick="setLastPage('JjsjListForm')">
													<img src="images/prev.gif" width="16" height="16" border="0">
												</a>
											</td>
											<td>
												<a href="#" id="a1" onClick="setNextPage('JjsjListForm')">
													<img src="images/next.gif" width="16" height="16" border="0">
												</a>
											</td>
											<td>
												<a href="#" onClick="goDown('JjsjListForm')">
													<img src="images/prev_end.gif" width="16" height="16" border="0">
												</a>
											</td>
										</tr>
									</table>
								</td>
								<td width="20%" align="center">
									<table border="0" cellspacing="0" cellpadding="3">
										<tr>
											<td>
												<a id="redirct" onClick="redirectTo('JjsjListForm')">
													<img src="images/next.gif" width="16" height="16" border="0">
												</a>
											</td>
											<td>
												<input type="text" size="3" style="width:25;height:18" id="pageNum" value="<%=request.getAttribute("nowPg")%>" /> /页
											</td>
										</tr>
									</table>
								</td>
								<td width="20%" align="right"><span id="s1">共${count}条</span></td>
							</tr>
						</table>
						
					</div>
				</td>
			</tr>
		</table>
		
</body>
</html>
