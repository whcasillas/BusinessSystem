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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../script/pageScript.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		initPage("a1", "a2");
		initPageCnt("s1");
		 $("#event_mod_id").val($("#event_mod_id1").val());
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
		var tag = "delete";
		var str = "";
		for ( var i = 0; i <= test.length - 1; i++) {
			if (test[i].checked == true) {
				str += test[i].value + ",";
			}
		}
		str = str.substring(0, str.length - 1);
		if (str == "") {
			alert("请勾选你要删除的事件");
		} else {
			if (confirm('确定删除吗？')) {
				$.ajax({
					url : 'event/addUpd.action',
					type : 'post',
					data : {
						tag : tag,
						str : str
					},
					dataType : 'text',
					success : function(text) {
						if (text == "Success!") {
							alert("删除成功");
							window.location.href = "query.action?pid=301";

						}
					}
				})
			} else {
				return;
			}

		}
	}

	function jiaoyan(formName) {
		var starta = $("#start_dt").val();
		var end = $("#ent_dt").val();
		//var event_person = $("#event_person").val();
		//var event_no = $("#event_no").val();
		//var event_key = $("#event_key").val();
		var start1 = parseInt($("#start_dt").val());

		var end1 = parseInt($("#ent_dt").val());
		if (isNaN(starta) && starta != "") {
			alert("开始时间输入的字符不合法");
			$("#start_dt").focus();
			return;
		}
		if (isNaN(end) && end != "") {
			alert("结束时间输入的字符不合法");
			$("#ent_dt").focus();
			return;
		}
		if (starta != "" && end == "") {
			alert("请输入查询结束时间");
			$("#ent_dt").focus();
			return;
		}
		if (starta == "" && end != "") {
			alert("请输入查询开始时间");
			$("#start_dt").focus();
			return;
		}
		if (start1 > end1) {
			alert("开始时间不能大于结束时间");
			return;
		}
		document.getElementById('pageNum').value=1;
		redirectTo('evenForm');
	}
</script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/event/query.action"
		method=get id="evenForm">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;运维管理系统&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;日常工作&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;事件列表</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>经典事件管理</strong></td>
							<td align="right" class="white" style="padding-right:20px">
								<!--<a href="#" class="barBtn"><img src="../images/2.png"
                                    width="16" height="16" align="absmiddle"> 导入</a> <a href="#"
                                class="barBtn"><img src="../images/1.png" width="16"
                                    height="16" align="absmiddle"> 导出</a> <a href="#"
                                class="barBtn"><img src="../images/3.png" width="16"
                                    height="16" align="absmiddle"> 审核</a> <a href="#"
                                class="barBtn"><img src="../images/4.png" width="16"
                                    height="16" align="absmiddle"> 禁止</a> -->
                                    
                                     <a href="event/eee.action?event_no=${event_no}&event_key=${event_key }&event_person=${event_person }&start_dt=${start_dt }&ent_dt=${ent_dt }&event_mod_id=${event_mod_id}" class="barBtn">
                                    	<img src="../images/btn_save.gif" width="16" height="16" align="absmiddle"> 导出
                                    </a>
								<a href="getevent.action?pid=402&tag=add" class="barBtn"><img
									src="../images/5.png" width="16" height="16" align="absmiddle">添加</a>
								<s:if test="#request.del">
									<a href="#" class="barBtn"
										onclick="funconclickdelete('chekname')"> <img
										src="../images/6.png" width="16" height="16" align="absmiddle">
										删除</a>
								</s:if> <!--  <a href="#"
                                class="barBtn"><img src="../images/7.png" width="16"
                                    height="16" align="absmiddle"> 筛选</a> <a href="#"
                                class="barBtn"><img src="../images/8.png" width="16"
                                    height="16" align="absmiddle"> 设置</a></td> -->
						</tr>
					</table></td>
			</tr>
			<tr>
				<td
					style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1">
						<TR>
							<th width="8%" align="center">编号</th>
							<td width="10%" class="BGCgray"><input type="text" maxlength="14"
								name="event_no" id="event_no"
								value="${event_no }"></td>
							<th width="8%" align="center">关键字</th>
							<td width="15%" class="BGCgray"><input type="text" maxlength="30"
								name="event_key" id="event_key" value="${event_key }"></td>
							<th width="8%" align="center">处理人</th>
							<td width="15%" class="BGCgray"><input type="text"
								name="event_person" id="event_person" maxlength="14" value="${event_person }">
							</td>
							<td width="10%" class="BGCgray" rowspan="2" align="center">
							<BUTTON
									style="HEIGHT:25px; WIDTH:70px"
									onclick="jiaoyan('evenForm')">
									<!-- 查询页码设为1 -->
									<img src="../images/btn_search.gif" width="16" height="16"
										align="absmiddle"> 查询
								</BUTTON>
							</td>
							</tr>
							<tr>
							<th width="8%" align="center">模块</th>
							<td width="15%" class="BGCgray"><select name="event_mod_id" id="event_mod_id">
                              <option value="">--请选择--</option>
                              <s:iterator value="#request.EventselectList" id="event">
                              <option value="<s:property value="#event.event_mod_id"/>"><s:property value="#event.event_mod_nm"/></option>
                              </s:iterator>
                              <input type="text" style="display:none" name="event_mod_id1" id="event_mod_id1" value="<%=request.getAttribute("event_mod_id")  %>"/>
                              </select>
							</td>
							<th width="8%" align="center">开始日期</th>
							<td width="15%" class="BGCgray"><input type="text"
								maxlength="14" name="start_dt" id="start_dt"
								value="${start_dt }"></td>
							<th width="8%" align="center">结束日期</th>
							<td width="15%" class="BGCgray"><input type="text"
								 maxlength="14" name="ent_dt" id="ent_dt" value="${ent_dt }">
							</td>
							<!-- <td width="10%" align="center" ><BUTTON
									style="HEIGHT:25px; WIDTH:70px"
									onclick="jiaoyan('evenForm')">
									查询页码设为1
									<img src="../images/btn_search.gif" width="16" height="16"
										align="absmiddle"> 查询
								</BUTTON></td> -->
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
								<th align="center">事件编号</th>
								<th align="center">事件内容关键字</th>
								<th align="center">处理人</th>
								<th align="center">所属模块</th>
								<th align="center">录入日期</th>
								<th align="center">录入时间</th>
								<!-- <th width="180" align="center">操作</th> -->
							</TR>
							<s:iterator value="#request.EventInfoList" id="evevtinf">
								<tr class="BGCgray">
									<TD align="center" width="30"><input type="checkbox"
										name="chekname"
										value='<s:property value="#evevtinf.event_no"/>'>
									</TD>
									<td align="center" width="100"><a class="color"
										id="event_no"
										href=<s:url action="event/getevent.action?tag=upd">
                                       <s:param name="event_no" value="#evevtinf.event_no"> </s:param>
                                       <s:param name="pid" value="301"> </s:param>
                                    </s:url>><s:property
												value="#evevtinf.event_no"></s:property> </a></td>
									<td align="center"><s:property value="#evevtinf.event_key"></s:property>
									</td>
									<td align="center"><s:property
											value="#evevtinf.event_person"></s:property></td>
									<td align="center" width="100"><s:property
											value="#evevtinf.event_mod_nm"></s:property></td>
									<td align="center" width="100"><s:property
											value="#evevtinf.cre_dt"></s:property></td>
									<td align="center" width="100"><s:property
											value="#evevtinf.cre_tm"></s:property></td>
								</tr>
							</s:iterator>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%" height="25"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#" onclick="goTop('evenForm')"><img
													src="../images/prev_top.gif" width="16" height="16"
													border="0"> </a></td>
											<td><a href="#" id="a2"
												onclick="setLastPage('evenForm')"><img
													src="../images/prev.gif" width="16" height="16" border="0">
											</a></td>
											<td><a href="#" id="a1"
												onclick="setNextPage('evenForm')"><img
													src="../images/next.gif" width="16" height="16" border="0">
											</a></td>
											<td><a href="#" onclick="goDown('evenForm')"><img
													src="../images/prev_end.gif" width="16" height="16"
													border="0"> </a></td>
										</tr>
									</table></td>
								<td width="20%" align="center"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td><a href="#" id="redirct"
												onclick="redirectTo('evenForm')"><img
													src="../images/next.gif" width="16" height="16" border="0">
											</a></td>
											<td><input name="textfield23" type="text" size="3"
												style="width:25;height:18" id="pageNum"
												value="<%=request.getAttribute("nowPg")%>"> /页</td>
										</tr>
									</table></td>
								<td width="20%" align="right"><span id="s1">#</span>
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
