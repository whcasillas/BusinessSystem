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
.color{color:#3399CC; text-decoration:none;font-weight:bold;}/*��������*/
.color:visited{color:#3399CC; text-decoration:none;font-weight:bold;}/*���ʹ�����������*/
.color:hover{color:#CF0000; text-decoration:underline;font-weight:bold;}/*�����ϵ���������*/
/*
ȡ���»���ֻҪ��text-decoration:underline�޸ĳ�text-decoration:none
���ּӴ�font-weight:bold �粻��Ҫ�Ӵ���ʾ����ôɾ��font-weight:bold;�Ϳ�����
��������Ĳ������òο���css2.0�ֲ� ���е�"α��"˵��
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
        $("#log_name").val("��������");
        $("#log_name").attr("disabled",true);
        $("#log_date").val("��������");
        $("#log_date").attr("disabled",true);
        $("#key_words").val("��������");
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
	        alert("��Ⱥ����Ϊ�գ�");
	        $("#log_ip").focus();
	        return;
	     }
	 if(log_type != "act"){
	     if(log_date==""){
	        alert("���ڲ���Ϊ�գ�");
	        $("#log_date").focus();
	        return;
	     }
	     if(key_words==""){
	        alert("�ؼ��ֲ���Ϊ�գ�");
	        $("#key_words").focus();
	        return;
	     }
	     if(log_name==""){
	        alert("��־������Ϊ�գ�");
	        $("#log_name").focus();
	        return;
	     }
	     if(log_type==""){
	        alert("��־���Ͳ���Ϊ�գ�");
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
    <div id="dataLoad" style="width:100%;height:100%;filter:alpha(opacity=75); background:#FFF; position:absolute;display:none"><!--ҳ��������ʾ-->
       <table width=100% height=100% border=0 align=center valign=middle>
        <tr height=50%><td align=center>&nbsp;</td></tr>
        <tr><td align=center><img src="<%=request.getContextPath()%>/images/loader.gif"/></td></tr>
        <tr><td align=center>���ڲ�ѯ��־�����Ժ�......</td></tr>
        <tr height=50%><td align=center>&nbsp;</td></tr>
       </table>
    </div>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã� <img
					src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;Ӧ��ά������ϵͳ&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��̨����&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�ճ�����&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;��־��ѯ</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>��־��ѯ</strong>
							</td>
							 <td align="right" class="white" style="padding-right:20px">
								<!--<a href="#" class="barBtn"><img src="../images/2.png"
									width="16" height="16" align="absmiddle"> ����</a> <a href="#"
								class="barBtn"><img src="../images/1.png" width="16"
									height="16" align="absmiddle"> ����</a> <a href="#"
								class="barBtn"><img src="../images/3.png" width="16"
									height="16" align="absmiddle"> ���</a> <a href="#"
								class="barBtn"><img src="../images/4.png" width="16"
									height="16" align="absmiddle"> ��ֹ</a>
								<s:if test="#request.add">
							    <a href="staffEdit.action?pid=402&tag=add"
								class="barBtn"><img src="../images/5.png" width="16" id="ADD_STAFF"
									height="16" align="absmiddle"> ���</a> 
								</s:if>
								<a href="#"
								class="barBtn"><img src="../images/6.png" width="16"
									height="16" align="absmiddle"> ɾ��</a> 
							    <a href="#"
								class="barBtn"><img src="../images/7.png" width="16"
									height="16" align="absmiddle"> ɸѡ</a> <a href="#"
								class="barBtn"><img src="../images/8.png" width="16"
									height="16" align="absmiddle"> ����</a></td> -->
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
						
						    <th align="center"><span class="BGCgray">��Ⱥ</span></th>
					          <TD class="BGCgray"><select name="log_ip" id="log_ip">
					                              <option value="">--��ѡ��--</option>
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
							<th width="10%" align="center">����</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="log_date" id="log_date" value="${log_date }">
								<span><font color="red">����0903</font></span>
							</td>
							<td width="10%" class="BGCgray" rowspan="3" align="center">
                                <BUTTON style="HEIGHT:25px; WIDTH:70px"  onclick="clickQuery()" id="showLoadingDiv">
                                        <img src="../images/btn_search.gif" width="16" height="16"  align="absmiddle"> ��ѯ
                                </BUTTON>
                            </td>
							</tr>
							<tr>
							<th width="10%" align="center">�ؼ���</th>
							<td width="20%" class="BGCgray"><input type="text"
                                name="key_words" id="key_words" value="${key_words }">
                            </td>
                            <th width="10%" align="center">��־�ļ���</th>
                            <td width="20%" class="BGCgray"><input type="text"
                                name="log_name" id="log_name" value="${log_name }">
                                <span><font color="red">֧��ͨ���</font></span>
                            </td>
						</TR>
						<tr>
						  <th align="center"><span class="BGCgray">��־����</span></th>
                              <TD class="BGCgray" colspan="3"><select name="log_type" id="log_type" onchange="checkIP()">
                                                  <option value="">--��ѡ��--</option>
                                                  <option value="trc">��TRC</option>
                                                  <option value="btrc">��TRC(����)</option>
                                                  <option value="log">��LOG</option>
                                                  <option value="act">�鿴active��</option>
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
                                        rows="23" id="logs_content" style="width:100%">��־��ʾ��</textarea>
                                </TD>
                            </TR>
                        </table>
                    </div>
			</tr>
		</table>
		
</body>
</html>
