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


</script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/messlist.action"  method="get" id="messform">
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
			
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
	
						</tr>
					</table></td>
			</tr>
			
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0"  class="table1">
							
							<s:iterator value="#request.milist" id="messinf">
								<tr>
									<td style="padding-bottom: 20px;">
										<table border="1"  width="100%" cellpadding="1" cellspacing="0" >
								            <tr>
								            	<td width="10%"  style="padding-left:5px;">
								                 <a style="font-size:16px; line-height:30px;  font-weight:bold"><s:property value="#messinf.mess_type"></s:property></a>
								                </td>
								                <td width="14%"  style="padding-left:5px;">
								                 <a style="font-size:16px; line-height:30px;  font-weight:bold">维护人：<s:property value="#messinf.opt_name"></s:property></a>
								                </td>
								                <td width="15%"  style="padding-left:5px;">
									                 <a style="font-size:16px; line-height:30px;  font-weight:bold">执行状态：
										                 <s:if test="%{#messinf.mess_status==0}">  
															 <a style="font-size:16px; line-height:30px; color:#000cff;  font-weight:bold">
	                                                           	正在执行
	                                                          </a>
														 </s:if>  
														 <s:else> 
                                                         	<a style="font-size:16px; line-height:30px; color:#ff1400;  font-weight:bold">
																已经完成
                                                             </a>
														</s:else> 
													</a>
								                </td>
								                <td width="14%"  style="padding-left:5px;">
								                 <a style="font-size:16px; line-height:30px;  font-weight:bold">事件编号：<s:property value="#messinf.event_id"></s:property></a>
								                </td>
								                <td width="25%" style="background-color:#000cff;padding-left:15px;">
								                    <a style="font-size:16px; line-height:30px; color:#FFF;  font-weight:bold">开始时间: &nbsp;<s:property value="#messinf.start_time"></s:property></a>
								                </td>
								                    <s:if test="%{#messinf.mess_status==0}">  
														  <td style="background-color:#16b76d;padding-left:15px;">
								                    	     <a style="font-size:16px; line-height:30px; color:#FFF;  font-weight:bold">
								                    	     	 结束时间:&nbsp;<s:property value="#messinf.end_time"></s:property>
								                    	    </a>
								                    	 </td>
													</s:if>
													<s:else>
														<td style="background-color:#ff1400;padding-left:15px;">
								                    	     <a style="font-size:16px; line-height:30px; color:#FFF;  font-weight:bold"> 
								                    	     	结束时间:&nbsp;<s:property value="#messinf.end_time"></s:property>
								                    	    </a>
								                    	 </td>
								                </s:else>
								            </tr>
								            <tr>
								            	<td valign="middle" style="padding-left:5px;">
								                	<div style="width:99%">
								                    	<a style="font-size:16px; line-height:30px; font-weight:bold">维护说明</a>
								                    </div>
								                </td>
								            	<td colspan="5" style="padding-left:10px;">
								                	<div style="width:99%">
								                    	<a style="font-size:16px; line-height:30px; font-weight:bold">
								                        	<s:property value="#messinf.mess_remarks"></s:property>
								                        </a>
								                    </div>
								                </td>
								            </tr>
								        </table>
									</td>
								</tr>
							</s:iterator>
						</table>
						
						
					</div>
				</td>
			</tr>
		</table>

	</form>
</body>
</html> 
