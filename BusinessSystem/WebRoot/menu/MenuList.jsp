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
$(document).ready(function(){
    initPage("a1","a2");
    initPageCnt("s1");
    
    var ml = "<%=request.getParameter("menu_level")%>";
    var depart = "<%=request.getParameter("depart_id")%>";
    if(ml != null){
        $("#menu_level").val(ml);
    }
    if(depart != null){
        $("#depart_id").val(depart);
    }
    
 });
 
  function clickTable(obj){
    var a = $(obj).parents("tr").children(0).html();
    var h = "#h" + a;
    var hurl = $(h).val();
    window.location.href = hurl;
 }

/*function clickTableDel(obj, xtag){
    var staff_id = $.trim($(obj).parents("tr").children(0).html());
    $.ajax({
            url:'staff/delStaff.action',
            type:'post',
            data:{staff_id:staff_id,xtag:xtag},
            dataType:'text',
            success:function(text){
                if(text=="0"){
                    alert("�����ɹ���");
                    window.location.href = "staffList.action?pid=401";
                }else if(text == "-1"){
                    alert("����ʧ�ܣ�");
                }
            }
    })
} */
</script>
</head>

<body>
    <form action="<%=request.getContextPath()%>/menu/menuList.action" method=get  id="menuForm">
        <table width="100%" height="100%" border="0" cellspacing="0"
            cellpadding="3">
            <tr>
                <td style="height:25px; background-color:#f3f3f3; font-weight:bold"
                    valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã� <img
                    src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;Ӧ��ά������ϵͳ&nbsp;&nbsp;
                    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;���ù���&nbsp;&nbsp;
                    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�˵�����</td>
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
                                align="absmiddle">&nbsp;&nbsp;<strong>�˵��б�</strong>
                            </td>
                             <td align="right" class="white" style="padding-right:20px">
                                <!--<a href="#" class="barBtn"><img src="../images/2.png"
                                    width="16" height="16" align="absmiddle"> ����</a> <a href="#"
                                class="barBtn"><img src="../images/1.png" width="16"
                                    height="16" align="absmiddle"> ����</a> <a href="#"
                                class="barBtn"><img src="../images/3.png" width="16"
                                    height="16" align="absmiddle"> ���</a> <a href="#"
                                class="barBtn"><img src="../images/4.png" width="16"
                                    height="16" align="absmiddle"> ��ֹ</a> -->
                                <a href="addMenu.action?tag=1"
                                class="barBtn"><img src="../images/5.png" width="16" id="ADD_STAFF"
                                    height="16" align="absmiddle"> ���</a> 
                                <!--<a href="#"
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
                            <th width="10%" align="center">�˵�ID</th>
                            <td width="13%" class="BGCgray"><input type="text"
                                name="menu_id" id="menu_id" value="${menu_id }">
                            </td>
                            <th width="10%" align="center">�˵�����</th>
                            <td width="13%" class="BGCgray"><input type="text"
                                name="menu_name" id="menu_name" value="${menu_name }">
                            </td>
                            <th width="10%" align="center"><span class="">�˵�����</span></th>
				            <TD width="13%" class="BGCgray"><select name="menu_level" id="menu_level">
				                                <option value="">--��ѡ��--</option>
				                                <option value="1">һ���˵�</option>
				                                <option value="2">�����˵�</option>
				                                <option value="3">�����˵�</option>
				                                </select>
				            </TD>
                                <th align="center"><span class="BGCgray">��������</span>
                                </th>
                                <TD class="BGCgray"><select name="depart_id" id="depart_id">
                                        <option value="">--��ѡ��--</option>
                                        <s:iterator value="#request.departList" id="depart">
                                            <option value="<s:property value="#depart.depart_id"/>">
                                                <s:property value="#depart.depart_name" />
                                            </option>
                                        </s:iterator>
                                </select> 
                                </TD>
                            <th width="10%" align="center"><BUTTON style="HEIGHT:25px"
                             onclick="document.getElementById('pageNum').value=1;redirectTo('menuForm')"><!-- ��ѯҳ����Ϊ1 -->
                                    <img src="../images/btn_search.gif" width="16" height="16"
                                        align="absmiddle"> ��ѯ
                                </BUTTON>
                            </th>
                        </TR>
                    </table>
                </td>
            </tr>
            <tr>
                <td height="100%" valign="top">
                    <div style="overflow:auto;height:100%; width:100%">
                        <table width="100%" border="0" cellpadding="3" cellspacing="1" id="staffTable"
                            class="table1">
                            <TR>
                                <!-- <th align="center"><input type="checkbox" name="checkbox"
                                    id="checkbox">
                                </th> -->
                                <th align="center">�˵�ID</th>
                                <th align="center">�˵�����</th>
                                <th align="center">�˵�URL</th>
                                <th align="center">�˵�����</th>
                                <th align="center">��������</th>
                                <th width="180" align="center">����</th>
                            </TR>
                            <s:iterator value="#request.mList" id="m" status="index">
                                <tr class="BGCgray">
                                    <!-- <TD align="center"><input type="checkbox" name="checkbox3"
                                        id="checkbox3">
                                    </TD> -->
                                    <td align="center"><s:property value="#m.menu_id"></s:property>
                                    </td>
                                    <td align="center"><s:property value="#m.menu_name"></s:property>
                                    </td>
                                    <td align="center"><s:property value="#m.menu_url"></s:property>
                                    </td>
                                    <td align="center"><s:property value="#m.menu_level"></s:property>
                                    </td>
                                    <td align="center"><s:property value="#m.depart_id"></s:property>
                                    </td>
                                    <td align="left">
                                        <BUTTON style="height:21px; font-size:12px" 
                                        onClick="clickTable(this)"><img src="../images/btn_edit.gif" width="16" id="ADD_MENU"
                                    height="16" align="absmiddle"> </BUTTON>
                                    <s:hidden id="h%{#m.menu_id}" value="menuEdit.action?tag=2&menu_id=%{#m.menu_id}&pid=202"></s:hidden>
                                     <!--   <s:if test="#staff.state=='����'">
                                            <BUTTON style="height:21px; font-size:12px" 
                                            onClick="if(confirm('ȷ��ע����')) clickTableDel(this,'1');else return;">
                                            <img src="../images/ico_no.png" width="16" id="ADD_STAFF"
                                    height="16" align="absmiddle"> </BUTTON>
                                        </s:if>
                                        <s:elseif test="#staff.state=='��ע��'">
                                            <BUTTON style="height:21px; font-size:12px" 
                                            onClick="if(confirm('��������뽫����ʼ���� ȷ��������')) clickTableDel(this,'0');else return;">
                                            <img src="../images/7.png" width="16" id="ADD_STAFF"
                                    height="16" align="absmiddle"> </BUTTON>
                                        </s:elseif>
                                    -->
                                    </td> 
                                                                   
                                </tr>
                            </s:iterator>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="20%" height="25"><table border="0"
                                        cellspacing="0" cellpadding="3">
                                        <tr>
                                            <td><a href="#" onclick="goTop('menuForm')"><img src="../images/prev_top.gif"
                                                    width="16" height="16" border="0">
                                            </a>
                                            </td>
                                            <td><a href="#" id="a2"
                                                onclick="setLastPage('menuForm')"><img
                                                    src="../images/prev.gif" width="16" height="16"
                                                    border="0">
                                            </a>
                                            </td>
                                            <td><a href="#" id="a1"
                                                onclick="setNextPage('menuForm')"><img
                                                    src="../images/next.gif" width="16" height="16"
                                                    border="0">
                                            </a>
                                            </td>
                                            <td><a href="#" onclick="goDown('menuForm')"><img src="../images/prev_end.gif"
                                                    width="16" height="16" border="0">
                                            </a>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                                <td width="20%" align="center"><table border="0"
                                        cellspacing="0" cellpadding="3">
                                        <tr>
                                            <td><a href="#" id="redirct"
                                                onclick="redirectTo('menuForm')"><img
                                                    src="../images/next.gif" width="16" height="16"
                                                    border="0">
                                            </a>
                                            </td>
                                            <td><input name="textfield23" type="text" size="3"
                                                style="width:25;height:18" id="pageNum"
                                                value="<%=request.getAttribute("nowPg")%>"> /ҳ</td>
                                        </tr>
                                    </table>
                                </td>
                                <td width="20%" align="right"> <span id="s1">#</span></td>
                            </tr>
                        </table>
                        <input type="text" id="start" name="start" value="<%=request.getAttribute("start")%>" style="display:none" /> 
                        <input type="text" id="end" name="end" value="<%=request.getAttribute("end")%>" style="display:none" /> 
                        <input type="text" id="nowPg" name="nowPg" value="<%=request.getAttribute("nowPg")%>" style="display:none" /> 
                        <input type="text" id="pgSize" value="10" name="pgSize" style="display:none" /> 
                        <input type="text" id="count" name=count value="<%=request.getAttribute("count")%>" style="display:none" />
                        <input type="text" id="pid" name=pid value="<%=request.getAttribute("pid")%>" style="display:none" />
                    </div></td>
            </tr>
        </table>
        
    </form>
</body>
</html>
