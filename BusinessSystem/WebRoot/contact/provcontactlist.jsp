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
			alert("�빴ѡ��Ҫɾ������ϵ��");
		} else {
			if (confirm('ȷ��ɾ����')) {
				$.ajax({
					url : 'delprovcontact.action',
					type : 'post',
					data : {
						str : str
					},
					dataType : 'text',
					success : function(text) {
						if (text == "success") {
							alert("ɾ���ɹ�");
							window.location.href = "provcontactlist.action?pid=602";

						}
					}
				})
			} else {
				return;
			}

		}
	}
	
	function jiaoyan(formName) {
		
		document.getElementById('pageNum').value=1;
		redirectTo('provcontactform');
	}
	
</script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/provcontactlist.action"  method=get id="provcontactform">
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã� <img
					src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��ά����ϵͳ&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��̨����&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��ϵ�˹���&nbsp;&nbsp;
					<img src="images/arrow.gif" align="absmiddle">&nbsp;&nbsp;������ϵ���б�</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>������ϵ�˹���</strong></td>
							<td align="right" class="white" style="padding-right:20px">
								<!--<a href="#" class="barBtn"><img src="images/2.png"
                                    width="16" height="16" align="absmiddle"> ����</a> <a href="#"
                                class="barBtn"><img src="images/1.png" width="16"
                                    height="16" align="absmiddle"> ����</a> <a href="#"
                                class="barBtn"><img src="images/3.png" width="16"
                                    height="16" align="absmiddle"> ���</a> <a href="#"
                                class="barBtn"><img src="images/4.png" width="16"
                                    height="16" align="absmiddle"> ��ֹ</a> -->
                                    
                                
                                 <s:if test="#request.add"> 
								<a href="getaddprovcontact.action?pid=602" class="barBtn">
									<img src="images/5.png" width="16" height="16" align="absmiddle">���
								</a>
								</s:if>
								<s:if test="#request.del"> 
								<a href="#" class="barBtn" onclick="funconclickdelete('chekname')"> 
										<img src="images/6.png" width="16" height="16" align="absmiddle"> ɾ��
								</a>
								</s:if>
								 <s:if test="#request.exp"> 
                                 <a href="epce.action?contact_prov=${contact_prov }&contact_name=${contact_name}&contact_mbl=${contact_mbl}&contact_email=${contact_email}&contact_qq=${contact_qq}&contact_remarks=${contact_remarks}" class="barBtn">
                                    <img src="images/btn_save.gif" width="16" height="16" align="absmiddle"> ����
                                 </a>
                                 </s:if>
								
						</tr>
					</table></td>
			</tr>
			<tr>
				<td
					style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1">
						<TR>
							<th width="15%" align="center">ʡ����</th>
							<td width="10%" class="BGCgray">
								<select name="contact_prov" id="contact_prov">
	                             	<s:set name="pname" value="#request.contact_prov"/>
	                             	<s:if test="#pname==null||#pname==''">  
									    <option value="">--��ѡ��--</option>
									</s:if>  
									<s:else> 
										<option value="${contact_prov }">${contact_prov }</option>
										<option value="">--��ѡ��--</option>  
									</s:else> 
	                             <s:iterator value="#request.pilist" id="prov">
	                              <option value="<s:property value="#prov.prov_name"/>"><s:property value="#prov.prov_name"/></option>
	                              </s:iterator>
	                              </select>
                              </td>
							<th width="8%" align="center">ʡ��ϵ��</th>
							<td width="15%" class="BGCgray">
								<input type="text" name="contact_name" id="contact_name" maxlength="14" value="${contact_name }">
							</td>
							<th width="8%" align="center">�绰</th>
							<td width="15%" class="BGCgray">
								<input type="text" maxlength="14" name="contact_mbl" id="contact_mbl" value="${contact_mbl }">
							</td>
							<td width="10%" class="BGCgray" rowspan="2" align="center">
								<BUTTON style="HEIGHT:25px; WIDTH:70px"  onclick="jiaoyan('provcontactform')">
										<img src="images/btn_search.gif" width="16" height="16"  align="absmiddle"> ��ѯ
								</BUTTON>
							</td>
							</tr>
							<th width="8%" align="center">����</th>
							<td width="15%" class="BGCgray">
								<input type="text"  maxlength="14" name="contact_email" id="contact_email" value="${contact_email }">
							</td>
							<th width="8%" align="center">QQ</th>
							<td width="15%" class="BGCgray">
								<input type="text"  maxlength="14" name="contact_qq" id="contact_qq" value="${contact_qq }">
							</td>
							<th width="8%" align="center">��ע</th>
							<td width="15%" class="BGCgray"><input type="text"
								 maxlength="14" name="contact_remarks" id="contact_remarks" value="${contact_remarks }">
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
								<th align="center"><input type="checkbox" name="chekname1"
									id="all" onclick="funonclick('chekname')"></th>
								<th align="center">ʡ����</th>
								
								<th align="center">��ϵ��</th>
								
								<th align="center">�绰</th>
								<th align="center">����</th>
								<th align="center">QQ</th>
								<th align="center">��ע</th>
								<!-- <th width="180" align="center">����</th> -->
							</TR>
							<s:iterator value="#request.cilist" id="contactinf">
								<tr class="BGCgray">
									<TD align="center" width="30">
										<input type="checkbox" name="chekname" value='<s:property value="#contactinf.contact_id"/>'>
									</TD>
									
									<td align="left" width="200">
									<a class="color" id="event_no" href=<s:url action="getupdprovcontact.action">
                                       <s:param name="contact_id" value="#contactinf.contact_id"></s:param>
                                    </s:url>> <s:property value="#contactinf.contact_prov"></s:property></a>
									</td>
                                    
									<td align="left" width="200">&nbsp;<s:property value="#contactinf.contact_name"></s:property>
									</td>
									<td align="left" width="150">&nbsp;<s:property value="#contactinf.contact_mbl"></s:property></td>
									<td align="left" width="100">&nbsp;<s:property value="#contactinf.contact_email"></s:property></td>
									<td align="left" width="100">&nbsp;<s:property value="#contactinf.contact_qq"></s:property></td>
									<td align="left" width="100">&nbsp;<s:property value="#contactinf.contact_remarks"></s:property></td>
									
								</tr>
							</s:iterator>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%" height="25"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#" onclick="goTop('provcontactform')"><img
													src="images/prev_top.gif" width="16" height="16"
													border="0"> </a></td>
											<td><a href="#" id="a2"
												onclick="setLastPage('provcontactform')"><img
													src="images/prev.gif" width="16" height="16" border="0">
											</a></td>
											<td><a href="#" id="a1"
												onclick="setNextPage('provcontactform')"><img
													src="images/next.gif" width="16" height="16" border="0">
											</a></td>
											<td><a href="#" onclick="goDown('provcontactform')"><img
													src="images/prev_end.gif" width="16" height="16"
													border="0"> </a></td>
										</tr>
									</table></td>
								<td width="20%" align="center"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#" id="redirct"
												onclick="redirectTo('provcontactform')"><img
													src="images/next.gif" width="16" height="16" border="0">
											</a></td>
											<td><input name="textfield23" type="text" size="3"
												style="width:25;height:18" id="pageNum"
												value="<%=request.getAttribute("nowPg")%>"> /ҳ</td>
										</tr>
									</table></td>
								<td width="20%" align="right"><span id="s1">��${count }��</span>
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
