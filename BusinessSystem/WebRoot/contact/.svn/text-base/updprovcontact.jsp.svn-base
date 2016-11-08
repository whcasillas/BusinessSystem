<%@page import="com.hisun.bean.contact.BankType"%>
<%@page import="com.hisun.bean.contact.BankInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>updprovcontact</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;运维管理系统&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;日常工作
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;省联系人编辑</td>
			</tr>
			<tr>
				<td
					style="height:34px; background-image:url(images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34"><img
								src="images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color:#90c8e8;"><img
								src="images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>省联系人编辑</strong>
							</td>
							<td align="right" class="white" style="padding-right:20px">
								
						    </td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			 <form action="<%=request.getContextPath()%>/updprovcontact.action" method=post  id="provcontactform">
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
							 <s:iterator value="#request.ci" id="ci" status="status">     
							 <input name="contact_id" type="hidden" id="contact_id" value="<s:property value="#ci.contact_id"/>" >
							<th align="center"><strong>省名称</strong>
							</th>
							<TD width="35%" class="BGCgray">
								<input name="contact_prov" type="text" id="contact_prov"  readonly="true" style="width:90%; background-color:#cccccc;" value="<s:property value="#ci.contact_prov"/> " >
							</TD>
							<th align="center"><strong>联系人</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_name" type="text" id="contact_name" value="<s:property value="#ci.contact_name"/>" >
								</TD>
							</TR>

						
						
							<TR>
								<th align="center"><strong>手机号码</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_mbl" type="text"	id="contact_mbl" value="<s:property value="#ci.contact_mbl"/>">
								</TD>
								<th class="BGCgray"><strong>电子邮件</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_email" type="text" id="contact_email" value="<s:property value="#ci.contact_email"/>">
								</TD>
							</TR>
							<TR>
								<th align="center"><strong>QQ</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_qq" type="text" id="contact_qq" value="<s:property value="#ci.contact_qq"/>">
								</TD>
								<th class="BGCgray"><strong>备注</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_remarks" type="text" id="contact_remarks" value="<s:property value="#ci.contact_remarks"/>">
								</TD>
							</TR>
							
							   </s:iterator>
						</table>
						<div style="width:100%; text-align:center; padding:5px">
							 <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('返回上一页？')) history.go(-1);else return;">
							 	<img src="images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回
							 </BUTTON>&nbsp;&nbsp;
							
							<s:if test="#request.upd"> 
							<BUTTON style="HEIGHT:25px"  type="submit">
								<img src="images/btn_save.gif" width="16" height="16" align="absmiddle"> 保存
							</BUTTON>
							</s:if>
							
						</div>
					</div>
					</td>
					</form>
			</tr>
		</table>

</body>
</html>
