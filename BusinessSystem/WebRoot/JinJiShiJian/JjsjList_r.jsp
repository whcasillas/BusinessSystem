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
} /*��������*/
.color:visited {
	color: #3399CC;
	text-decoration: none;
	font-weight: bold;
} /*���ʹ�����������*/
.color:hover {
	color: #CF0000;
	text-decoration: underline;
	font-weight: bold;
} /*�����ϵ���������*/
/*
ȡ���»���ֻҪ��text-decoration:underline�޸ĳ�text-decoration:none
���ּӴ�font-weight:bold �粻��Ҫ�Ӵ���ʾ����ôɾ��font-weight:bold;�Ϳ�����
��������Ĳ������òο���css2.0�ֲ� ���е�"α��"˵��
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
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã� <img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��ά����ϵͳ&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��̨����&nbsp;&nbsp;<img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�����¼�����&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�����¼��б�
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
								align="absmiddle">&nbsp;&nbsp;<strong>�����¼�����</strong>
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
								<th width="30" align="center" >���</th>
								<th width="150" align="center">�Ǽ�ʱ��</th>
								<th width="70" align="center">�¼����</th>
								<th width="360" align="center">�¼�����</th>
								<th width="*" align="center">�¼�����</th>
								<th width="60" align="center" >�߰����</th>
								<th width="60" align="center" >�¼�״̬</th>
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
												 δ����
										</s:if> 
										<s:else>�Ѵ���</s:else>
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
												<input type="text" size="3" style="width:25;height:18" id="pageNum" value="<%=request.getAttribute("nowPg")%>" /> /ҳ
											</td>
										</tr>
									</table>
								</td>
								<td width="20%" align="right"><span id="s1">��${count}��</span></td>
							</tr>
						</table>
						
					</div>
				</td>
			</tr>
		</table>
		
</body>
</html>
