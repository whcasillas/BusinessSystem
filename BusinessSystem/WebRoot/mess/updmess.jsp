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
		
		redirectTo('messform');
	}
	
</script>

</head>

<body>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã� <img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��ά����ϵͳ&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��̨����&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�ճ�����
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��ʾ�༭</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>��ʾ�༭</strong>
							</td>
							<td align="right" class="white" style="padding-right:20px">
								</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			 <form action="<%=request.getContextPath()%>/updmess.action" method="post"  id="messform">
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
							<TR>
	 							<s:iterator value="#request.mi" id="mi" status="status">
	 							<input name="mess_id" type="hidden" id="mess_id" value="<s:property value="#mi.mess_id"/>">
								<th width="80" align="center">
									<strong>��ʽ���</strong>
								</th>
								<TD width="100" class="BGCgray">
									<input name="mess_type"  type="text" id="mess_type" style="background-color:#eaeaea"  readonly="readonly" value="<s:property value="#mi.mess_type"/>">
								</TD>
								<th align="center"><strong>��ʾ�����</strong>
								</th>
								<TD class="BGCgray">
									<input name="opt_name"  type="text"	id="opt_name"  style="background-color:#eaeaea" readonly value="<s:property value="#mi.opt_name"/>">
								</TD>
								<th align="center"><strong>�¼����</strong>
							</th>
							<TD class="BGCgray">
									<input name="event_id"  type="text"	id="event_id"    value="<s:property value="#mi.event_id"/>">
								</TD>
							</TR>
							</TR>
							
						<%-- 	<TR>
								<th align="center"><strong>��ʼʱ��</strong>
								</th>
								<TD class="BGCgray">
									<input name="start_time"  type="text"	id="start_time" style="background-color:#eaeaea" readonly value="<s:property value="#mi.start_time"/>">
								</TD>
								<th class="BGCgray">����ʱ��</th>
								<TD class="BGCgray">
									<input name="end_time"  type="text"	id="end_time"  value="<s:property value="#mi.end_time"/>"> <a style="color:red; font-size:12px;">������֮�󽫽���ʱ������ ��ʽ��201606200300</a>
								</TD>
							</TR> --%>
                            
                            <TR>
                            <th align="center"><strong>��ʾ����</strong>
							</th>
							<TD align="left" colspan="5" class="BGCgray">
								<textarea id="mess_remarks" name="mess_remarks" style="text-align:left;  width:90%; height:120px; font-size:12px; line-height:18px;"><s:property value="#mi.mess_remarks"/></textarea>
							</TD>
							</TR>
							 <TR>
                            <th align="center"><strong>�Ƿ������</strong>
							</th>
							<TD align="left" colspan="5" class="BGCgray">
								<select name="mess_status" id="mess_status">
									<s:set name="mess_status" value="#request.mess_status"/>
											<s:if test="#mess_status==0">
												<option value="0">����ִ��</option>
												<option value="1">ִ�����</option>    
											</s:if> 
											<s:if test="#mess_status==1">
												<option value="1">ִ�����</option>
												<option value="0">����ִ��</option>    
											</s:if> 
										
									
								</select>
							</TD>
							</TR>
                            </s:iterator> 
							
						</table>
						<div style="width:100%; text-align:center; padding:5px">
						 <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('������һҳ��')) history.go(-1);else return;">
							 	<img src="images/btn_back.gif" width="16" height="16" align="absmiddle"> ����
							 </BUTTON>&nbsp;&nbsp;
							<BUTTON style="HEIGHT:25px"   onclick="jiaoyan('messform')">
								<img src="images/btn_save.gif" width="16" height="16" align="absmiddle"> ȷ��
							</BUTTON>
							
						</div>
					</div>
					</td>
					</form>
			</tr>
		</table>

</body>
</html>
