<%@page import="com.hisun.bean.mess.MessTypeInfo"%>
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
		var mess_type = $("#mess_type").val();
		var mess_remarks = $("#mess_remarks").val();
		if(mess_type==""){
			alert("请选择公示类型！！！");
			return;
		} 
		if(mess_remarks==""){
			alert("公示内容必须不为空！！！");
			return;
		}
		redirectTo('messform');
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
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;公示编辑</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>公示编辑</strong>
							</td>
							<td align="right" class="white" style="padding-right:20px">
								</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			 <form action="<%=request.getContextPath()%>/addmess.action" method=post  id="messform">
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">

							<th align="center"><strong>公式类别</strong>
							</th>
							<TD width="35%" class="BGCgray">
								<select name="mess_type" id="mess_type">
									 <option value="">--请选择--</option>
                              <s:iterator value="#request.mtilist" id="mtype">
                              <option value="<s:property value="#mtype.mess_type_name"/>"><s:property value="#mtype.mess_type_name"/></option>
                              </s:iterator>
								</select> <a style="color:red; font-size:12px;">*</a>
							</TD>
							
								<th align="center"><strong>事件编号</strong>
							</th>
							<TD class="BGCgray">
									<input name="event_id" type="text"	id="event_id"> <a style="color:red; font-size:12px;">*</a>
								</TD>
							</TR>
							</TR>
							

							
							<!-- <TR>
								<th align="center"><strong>开始时间</strong>
								</th>
								<TD class="BGCgray">
									<input name="start_time" type="text" id="start_time"> <a style="color:red; font-size:12px;">* 格式20160620230000</a>
								</TD>
								<th class="BGCgray">预计结束时间</th>
								<TD class="BGCgray">
									<input name="end_time" type="text" id="end_time"><a style=" font-size:12px;"> 格式20160620230000</a>
								</TD>
							</TR> -->
                            
                            <TR>
                            <th align="center"><strong>公示内容</strong>
							</th>
							<TD colspan="4" class="BGCgray">
								<textarea id="mess_remarks" name="mess_remarks"  style="width:90%; height:120px; font-size:12px; line-height: 18px;"  ></textarea>
							</TD>
							</TR>
                            
							
						</table>
						<div style="width:100%; text-align:center; padding:5px">
						 <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('返回上一页？')) history.go(-1);else return;">
							 	<img src="images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回
							 </BUTTON>&nbsp;&nbsp;
							<BUTTON style="HEIGHT:25px"   onclick="jiaoyan('messform')">
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
