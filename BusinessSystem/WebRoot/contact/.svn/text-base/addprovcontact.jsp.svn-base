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
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function jiaoyan1(formName) {
		var contact_prov = $("#contact_prov").val();
		var contact_name = $("#contact_name").val();
		var contact_mbl = $("#contact_mbl").val();
		var contact_email = $("#contact_email").val();
		var contact_qq = $("#contact_qq").val();
		var contact_remarks = $("#contact_remarks").val();
		
	
		
		if(contact_prov==""){
			alert("省名称必须不为空！！！");
			return;
		}else if(contact_name==""){
			alert("联系人必须不为空！！！");
			return;
		}else if(contact_mbl==""){
			alert("联系人电话必须不为空！！！");
			return;
		}
		this.redirectTo('provcontactform');
		
		/* $.ajax({
			url : 'addprovcontact.action',
			type : 'post',
			data : {
				contact_prov : contact_prov,
				contact_name : contact_name,
				contact_mbl : contact_mbl,
				contact_email : contact_email,
				contact_qq : contact_qq,
				contact_remarks : contact_remarks
			},
			dataType : 'text',
			success : function(text) {
				if (text == "success") {
					window.location.href = "provcontactlist.action?pid=602";
				}
				if (text == "error") {
					alert("添加省网关联系人失败");
				}
			}
		}) */
		
	}
	
	
	function jiaoyan(formName) { 
		var submitForm = document.getElementById('provcontactform');
		getresult=true; 
		if (!check_empty(document.provcontactform.contact_prov.value))  { 
			getresult=false 
			alert("省名称必须不为空！") ;
			document.provcontactform.contact_prov.focus() ;
		}else if (!check_empty(document.provcontactform.contact_name.value)) { 
			getresult=false 
			alert("联系人必须不为空！") ;
			document.provcontactform.contact_name.focus() ;
		}else if (!check_empty(document.provcontactform.contact_mbl.value)) { 
			getresult=false 
			alert("联系人电话必须不为空！") ;
			document.provcontactform.contact_mbl.focus() ;
		} 
		
		
		if(getresult){
		submitForm.submit();
		}else {
		return getresult; 
		}
	} 
		
	function check_empty(intext){ 
		return (intext.length > 0); 
	} 
	
	
	
	
	
</script>

</head>

<body>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： 
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;运维管理系统&nbsp;&nbsp;
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
			 <form action="<%=request.getContextPath()%>/addprovcontact.action" method=post  id="provcontactform"  name="provcontactform" onSubmit="return validateform()">
				
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">

							<th align="center"><strong>省名称</strong>
							</th>
							<TD width="35%" class="BGCgray">
								<select name="contact_prov" id="contact_prov">
									 <option value="">--请选择--</option>
                              <s:iterator value="#request.pilist" id="prov">
                              <option value="<s:property value="#prov.prov_name"/>"> <s:property value="#prov.prov_name"/> </option>
                              </s:iterator>
								</select> <a style="color:red; font-size:12px;">*</a>
							</TD>
							<th align="center"><strong>联系人</strong>
								</th>
								<TD class="BGCgray">
									<input name="contact_name" type="text" id="contact_name"> <a style="color:red; font-size:12px;">*</a>
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
							<BUTTON style="HEIGHT:25px"   onclick="jiaoyan('provcontactform')">
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
