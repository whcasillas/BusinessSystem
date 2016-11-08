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
<title>addcontact</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="script/pageScript.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function jiaoyan(formName) {
		var bank_name = $("#bank_name").val();
		var bank_typ = $("#bank_typ").val();
		var contact_name = $("#contact_name").val();
		var contact_mbl = $("#contact_mbl").val();
		if(bank_name==""){
			alert("银行名称必须不为空！！！");
			return;
		}else if(bank_typ==""){
			alert("银行业务类型必须不为空！！！");
			return;
		}else if(contact_name==""){
			alert("联系人必须不为空！！！");
			return;
		} else if(contact_mbl==""){
			alert("联系人电话必须不为空！！！");
			return;
		}else {
			redirectTo('contactform');
		}
	}
	
</script>

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
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;银行联系人编辑</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>银行联系人编辑</strong>
							</td>
							<td align="right" class="white" style="padding-right:20px">
								</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			 <form action="<%=request.getContextPath()%>/addcontact.action?pid=601" method=get  id="contactform">
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">

							<th align="center"><strong>银行名称</strong>
							</th>
							<TD width="35%" class="BGCgray">
								<select name="bank_name" id="bank_name">
									 <option value="">--请选择--</option>
                              <s:iterator value="#request.bilist" id="bank">
                              <option value="<s:property value="#bank.bank_name"/>"><s:property value="#bank.bank_name"/></option>
                              </s:iterator>
								</select> <a style="color:red; font-size:12px;">*</a>
							</TD>
							<th width="15%" class="BGCgray"><strong>业务类型</strong>
							</th>
							<TD width="35%" class="BGCgray">
								<select name="bank_typ" id="bank_typ">
									<option value="">--请选择--</option>
                              <s:iterator value="#request.btlist" id="btyp">
                              <option value="<s:property value="#btyp.bank_typ_name"/>"><s:property value="#btyp.bank_typ_name"/></option>
                              </s:iterator>
								</select> <a style="color:red; font-size:12px;">*</a>
							</TD>
							</TR>

							<th align="center"><strong>银行地址</strong>
							</th>
							<TD colspan="3" class="BGCgray">
								<input name="bank_address" type="text" id="bank_address" style="width:90%">
							</TD>
							</TR>
							<TR>
								<th align="center"><strong>联系人</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_name" type="text" id="contact_name"> <a style="color:red; font-size:12px;">*</a>
								</TD>
								<th class="BGCgray">联系人服务类型</th>
								<TD class="BGCgray">
									<input name="bank_contact_typ" type="text" id="bank_contact_typ">
								</TD>
							</TR>
							<TR>
								<th align="center"><strong>手机号码</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_mbl" type="text"	id="contact_mbl"> <a style="color:red; font-size:12px;">*</a>
								</TD>
								<th class="BGCgray"><strong>电子邮件</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_email" type="text" id="contact_email">
								</TD>
							</TR>
							<TR>
								<th align="center"><strong>QQ</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_qq" type="text" id="contact_qq">
								</TD>
								<th class="BGCgray"><strong>备注</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_remarks" type="text" id="contact_remarks">
								</TD>
							</TR>
						</table>
						<div style="width:100%; text-align:center; padding:5px">
						 <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('返回上一页？')) history.go(-1);else return;">
							 	<img src="images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回
							 </BUTTON>&nbsp;&nbsp;
							<BUTTON style="HEIGHT:25px"   onclick="jiaoyan('contactform')">
								<img src="images/btn_save.gif" width="16" height="16" align="absmiddle"> 保存
							</BUTTON>
							
						</div>
					</div>
					</td>
					</form>
			</tr>
		</table>

</body>
</html>
