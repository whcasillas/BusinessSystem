<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hisun.bean.even.Eventinfo"%>
<%@ page import="com.hisun.bean.even.EvenModBean"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Eventinfo eventinfo = (Eventinfo)request.getAttribute("eventinfo");
List<EvenModBean> list =(List)request.getAttribute("EventselectList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.ys {
	background-color: #E0E0E0;
}
-->
</style>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#event_mod_id").val($("#event_mod_id1").val());
	})
	function test() {
		//    var collid = document.getElementById("all");
		var kg1 = document.getElementById("kg1");
		var kg2 = document.getElementById("kg2");
		if (kg1.checked) {
			document.getElementById("event_no").disabled = true;
			kg2.checked = false;
		} else {
			document.getElementById("event_no").disabled = false;
			kg2.checked = true;
		}
	}
	function test1() {
		var kg1 = document.getElementById("kg1");
		var kg2 = document.getElementById("kg2");
		if (kg2.checked) {
			document.getElementById("event_no").disabled = false;
			kg1.checked = false;
		} else {
			document.getElementById("event_no").disabled = true;
			kg1.checked = true;

		}
	}
	function sub() {
		var kg2 = document.getElementById("kg2");
		//var kg1 = document.getElementById("kg1");
		var tag = $("#tag").val();
		var event_no = tag == "add" ? $("#event_no").val() : $("#event_no1")
				.val();
		var event_person = tag == "add" ? $("#event_person").val() : $(
				"#event_person1").val();
		var event_mod_id = $("#event_mod_id").val();
		var event_key = $("#event_key").val();
		var event_inf = $("#event_inf").val();
		var event_relust = $("#event_relust").val();
		var cre_tm = $("#cre_tm").val();
		var cre_dt = $("#cre_dt").val();
		if (tag == "add") {
			if (kg2.checked) {
				if (event_no == "") {
					alert("事件编号不能为空");
					$("#event_no").focus();
					return;
				}
			}		
			else{
			    event_no="";
			}
		}
		if (event_person == "") {
			alert("录入人不能为空");
			$("#event_person").focus();
			return;
		}
		if (event_mod_id == "") {
			alert("事件所属模块不能为空");
			$("#event_mod_id").focus();
			return;
		}
		if (event_key == "") {
			alert("事件内容关键字不能为空");
			$("#event_key").focus();
			return;
		}
		if (event_inf == "") {
			alert("事件内容不能为空");
			$("#event_inf").focus();
			return;
		}
		if (event_relust == "") {
			alert("处理结果不能为空");
			$("#event_relust").focus();
			return;
		}
		$.ajax({
			url : 'event/addUpd.action',
			type : 'post',
			data : {
				event_no : event_no,
				cre_tm : cre_tm,
				cre_dt : cre_dt,
				event_person : event_person,
				event_mod_id : event_mod_id,
				event_key : event_key,
				event_inf : event_inf,
				event_relust : event_relust,
				tag : tag
			},
			dataType : 'text',
			success : function(text) {
				alert(text);
				if (text == "Success!") {
					window.location.href = "query.action?pid=301";
				}
				if (text == "error!") {
					alert("该事件编号存在!");
				}
			}
		})
	}
</script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/staff/saveStaff.action"
		method=get id="staffForm">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;运维管理系统&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;日常工作
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;事件编辑</td>
			</tr>
			<tr>
				<td
					style="height:34px; background-image:url(../images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34"><img
								src="../images/main_headerL.gif" width="20" height="34"></td>
							<td style="color:#90c8e8;"><img
								src="../images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>事件编辑</strong></td>
							<td align="right" class="white" style="padding-right:20px">
								<a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
									src="../images/btn_left.gif" align="absmiddle"> 后退</a> <a
								href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
									src="../images/btn_right.gif" align="absmiddle"> 前进</a> <a
								href="#" class="barBtn"><img src="../images/btn_refresh.gif"
									align="absmiddle"> 刷新</a>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="20%" align="center">事件编号</th>
								<TD class="BGCgray">
									<%
										if (request.getAttribute("tag").equals("upd")) {
									%> <input name="event_no1" type="text" readonly="readonly"
									class="ys" id="event_no1" value="<%=eventinfo.getEvent_no()%>">
									<%
										} else if (request.getAttribute("tag").equals("add")) {
									%> <%-- <div id="textdiv" style="display:none;">
										<input name="event_no" type="text" id="event_no"
											maxlength="10" value="<%=eventinfo.getEvent_no()%>">
									</div>
									<div id="boxdiv">
										<input type="checkbox"  onclick="test()"
											id="kg" />
									</div>
									<div id="gzdiv">故障事件</div> --%> <input name="event_no"
									type="text" id="event_no" maxlength="10"
									value="<%=eventinfo.getEvent_no()%>"> <input
									type="checkbox" name="kg1" onclick="test()" id="kg1" /> 故障事件 <input
									type="checkbox" checked="checked" onclick="test1()" id="kg2"
									name="kg2" /> 工单事件 <%
 	}
 %>
								</TD>
							</TR>
							<TR>
								<th align="center">事件处理人</th>
								<TD width="80%" class="BGCgray">
									<%
										if (request.getAttribute("tag").equals("upd")) {
									%> <input name="event_person1" type="text" readonly="readonly"
									class="ys" id="event_person1"
									value="<%=eventinfo.getEvent_person()%>"> <%
 	} else if (request.getAttribute("tag").equals("add")) {
 %> <input name="event_person" type="text" maxlength="10"
									id="event_person" value="<%=eventinfo.getEvent_person()%>">
									<%
										}
									%>
								</TD>
							</TR>
							<TR>
								<th align="center">事件内容关键字</th>
								<TD class="BGCgray"><input name="event_key" type="text"
									id="event_key" maxlength="20"
									value="<%=eventinfo.getEvent_key()%>">
								</TD>
							</TR>
							<TR>
								<th align="center"><span class="BGCgray">事件模块</span></th>
								<TD class="BGCgray"><select name="event_mod_id"
									id="event_mod_id">
										<option value="">--请选择--</option>
										<%
											for (int i = 0; i < list.size(); i++) {
												EvenModBean mod = list.get(i);
										%>
										<option value="<%=mod.getEvent_mod_id()%>"><%=mod.getEvent_mod_nm()%></option>

										<%
											}
										%>
								</select> <input type="text" style="display:none" name="event_mod_id1"
									id="event_mod_id1" value="<%=eventinfo.getEvent_mod_id()%>" />
								</TD>
							</TR>

							<%
								if (request.getAttribute("tag").equals("upd")) {
							%>
							<TR>
								<th align="center">录入日期</th>
								<TD class="BGCgray"><input name="cre_dt" type="text"
									readonly="readonly" class="ys" id="cre_dt"
									value="<%=eventinfo.getCre_dt()%>">
								</TD>
							</TR>
							<%
								}
							%>
							<%
								if (request.getAttribute("tag").equals("upd")) {
							%>
							<TR>
								<th align="center">录入时间</th>
								<TD class="BGCgray"><input name="cre_tm" type="text"
									readonly="readonly" class="ys" id="cre_tm"
									value="<%=eventinfo.getCre_tm()%>">
								</TD>
							</TR>
							<%
								}
							%>
							<%
								if (request.getAttribute("tag").equals("upd")) {
							%>
							<TR>
								<th align="center">最后修改时间</th>
								<TD class="BGCgray"><input name="tm_smp" type="text"
									readonly="readonly" class="ys" id="tm_smp"
									value="<%=eventinfo.getTm_smp()%>">
								</TD>
							</TR>
							<%
								}
							%>
							<TR>
								<th align="center"><strong>事件内容</strong></th>
								<TD colspan="2" class="BGCgray"><textarea name="event_inf"
										rows="8" id="event_inf" style="width:70%"><%=eventinfo.getEvent_inf()%></textarea>
								</TD>
							</TR>
							<TR>
								<th align="center">处理方法</th>
								<TD colspan="2" class="BGCgray"><textarea
										name="event_relust" rows="8" id="event_relust"
										style="width:70%"><%=eventinfo.getEvent_relust()%></textarea>
								</TD>
							</TR>
						</table>
						<input type="text" value="<%=request.getAttribute("tag")%>"
							id="tag" name="tag" style="display:none" />
						<div style="width:100%; text-align:center; padding:5px">
							<BUTTON style="HEIGHT:25px" onClick="sub()">
								<img src="../images/btn_save.gif" width="16" height="16"
									align="absmiddle"> 保存
							</BUTTON>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
