<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	JSONObject param = (JSONObject)request.getAttribute("SERVER");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.color{color:#3399CC; text-decoration:none;font-weight:bold;}/*链接设置*/
.color:visited{color:#3399CC; text-decoration:none;font-weight:bold;}/*访问过的链接设置*/
.color:hover{color:#CF0000; text-decoration:underline;font-weight:bold;}/*鼠标放上的链接设置*/
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

/* document.onkeydown = function(event) {
        e = event ? event : (window.event ? window.event : null);
        if (e.keyCode == 13) {
            $("#dataLoad").show();
            clickQuery;
        }
    } */
    
function checkIP(){
    var log_type = $("#log_type").val();
    if(log_type == "act"){
        $("#log_name").val("不可输入");
        $("#log_name").attr("disabled",true);
        $("#log_date").val("不可输入");
        $("#log_date").attr("disabled",true);
        $("#key_words").val("不可输入");
        $("#key_words").attr("disabled",true);
    }else{
        $("#log_name").val("");
        $("#log_name").attr("disabled",false);
        $("#log_date").val("");
        $("#log_date").attr("disabled",false);
        $("#key_words").val("");
        $("#key_words").attr("disabled",false);
    }
}

function clickQuery(){
    var log_ip = $("#log_ip").val();
    var log_name = $("#log_name").val();
    var log_date = $("#log_date").val();
    var key_words = $("#key_words").val();
    var log_type = $("#log_type").val();
    
	     if(log_ip==""){
	        alert("集群不能为空！");
	        $("#log_ip").focus();
	        return;
	     }
	 if(log_type != "act"){
	     if(log_date==""){
	        alert("日期不能为空！");
	        $("#log_date").focus();
	        return;
	     }
	     if(key_words==""){
	        alert("关键字不能为空！");
	        $("#key_words").focus();
	        return;
	     }
	     if(log_name==""){
	        alert("日志名不能为空！");
	        $("#log_name").focus();
	        return;
	     }
	     if(log_type==""){
	        alert("日志类型不能为空！");
	        $("#log_type").focus();
	        return;
	     }
	 }
    
    
    $("#showLoadingDiv").click(function(){$("#dataLoad").show();});
    $.ajax({
            url:'viewLogs/queryLogs.action',
            type:'post',
            data:{log_ip:log_ip,log_name:log_name,log_date:log_date,key_words:key_words,log_type:log_type},
            dataType:'text',
            success:function(text){
                $("#logs_content").val(text);
                $("#dataLoad").hide(); 
            }
    })
}
</script>
</head>

<body>
    <div id="dataLoad" style="width:100%;height:100%;filter:alpha(opacity=75); background:#FFF; position:absolute;display:none"><!--页面载入显示-->
       <table width=100% height=100% border=0 align=center valign=middle>
        <tr height=50%><td align=center>&nbsp;</td></tr>
        <tr><td align=center><img src="<%=request.getContextPath()%>/images/loader.gif"/></td></tr>
        <tr><td align=center>正在查询日志，请稍后......</td></tr>
        <tr height=50%><td align=center>&nbsp;</td></tr>
       </table>
    </div>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;应用维护管理系统&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;日常工作&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;日志查询</td>
			</tr>
			<tr>
				<td
					style="height:34px; background-image:url(../images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34"><img
								src="../images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color:#90c8e8;"><img
								src="../images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>日志查询</strong>
							</td>
							 <td align="right" class="white" style="padding-right:20px">
								<!--<a href="#" class="barBtn"><img src="../images/2.png"
									width="16" height="16" align="absmiddle"> 导入</a> <a href="#"
								class="barBtn"><img src="../images/1.png" width="16"
									height="16" align="absmiddle"> 导出</a> <a href="#"
								class="barBtn"><img src="../images/3.png" width="16"
									height="16" align="absmiddle"> 审核</a> <a href="#"
								class="barBtn"><img src="../images/4.png" width="16"
									height="16" align="absmiddle"> 禁止</a>
								<s:if test="#request.add">
							    <a href="staffEdit.action?pid=402&tag=add"
								class="barBtn"><img src="../images/5.png" width="16" id="ADD_STAFF"
									height="16" align="absmiddle"> 添加</a> 
								</s:if>
								<a href="#"
								class="barBtn"><img src="../images/6.png" width="16"
									height="16" align="absmiddle"> 删除</a> 
							    <a href="#"
								class="barBtn"><img src="../images/7.png" width="16"
									height="16" align="absmiddle"> 筛选</a> <a href="#"
								class="barBtn"><img src="../images/8.png" width="16"
									height="16" align="absmiddle"> 设置</a></td> -->
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td
					style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1">
						<TR>
						
						    <th align="center"><span class="BGCgray">集群</span></th>
					          <TD class="BGCgray"><select name="log_ip" id="log_ip">
					                              <option value="">--请选择--</option>
					                              <%
					                                Iterator it = param.keys();
					                                while(it.hasNext()){
											            String key = (String) it.next();
											            String value = param.getString(key);
					                               %>
					                              <option value="<%=key%>"><%=value%></option>
					                              <%} %>
					                              </select>
					          </TD>
							<th width="10%" align="center">日期</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="log_date" id="log_date" value="${log_date }">
								<span><font color="red">例：0903</font></span>
							</td>
							<td width="10%" class="BGCgray" rowspan="3" align="center">
                                <BUTTON style="HEIGHT:25px; WIDTH:70px"  onclick="clickQuery()" id="showLoadingDiv">
                                        <img src="../images/btn_search.gif" width="16" height="16"  align="absmiddle"> 查询
                                </BUTTON>
                            </td>
							</tr>
							<tr>
							<th width="10%" align="center">关键字</th>
							<td width="20%" class="BGCgray"><input type="text"
                                name="key_words" id="key_words" value="${key_words }">
                            </td>
                            <th width="10%" align="center">日志文件名</th>
                            <td width="20%" class="BGCgray"><input type="text"
                                name="log_name" id="log_name" value="${log_name }">
                                <span><font color="red">支持通配符</font></span>
                            </td>
						</TR>
						<tr>
						  <th align="center"><span class="BGCgray">日志类型</span></th>
                              <TD class="BGCgray" colspan="3"><select name="log_type" id="log_type" onchange="checkIP()">
                                                  <option value="">--请选择--</option>
                                                  <option value="trc">查TRC</option>
                                                  <option value="btrc">查TRC(并发)</option>
                                                  <option value="log">查LOG</option>
                                                  <option value="act">查看active数</option>
                                                  </select>
                              </TD>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				    <td height="100%" valign="top">
                    <div style="overflow:auto;height:100%; width:100%">
                        <table width="100%" border="0" cellpadding="3" cellspacing="1" id="staffTable"
                            class="table1">
                            <TR>
                                <TD colspan="3" class="BGCgray"><textarea name="logs_content" readonly="readonly"
                                        rows="23" id="logs_content" style="width:100%">日志显示区</textarea>
                                </TD>
                            </TR>
                        </table>
                    </div>
			</tr>
		</table>
		
</body>
</html>
