<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.hisun.bean.staff.StaffBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

StaffBean staffInfo = (StaffBean)request.getAttribute("STAFF_INFO");
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
        $(document).ready(function(){
            $("#depart_id").val($("#dvalue").val());
            $("#role_id").val($("#rvalue").val());
            var role = $("#rvalue").val();
            if(role == "SUPERUSR"){
                $("#role_id").attr("disabled", true);
            }
        });
        
        function sub(){
            var tag = $("#tag").val();
            var staff_id = tag=="add"?$("#staff_id").val():$("#staff_id1").val();
            var staff_name = $("#staff_name").val();
            var phone = $("#phone_number").val();
            var e_mail = $("#e_mail").val();
            var depart_id = $("#depart_id").val();
            var role_id = $("#role_id").val();
            var state = $("#state").val();
            
            if(staff_id==""){
                alert("员工ID不能为空");
                $("#staff_id").focus();
                return;
            }
            if(staff_name==""){
                alert("员工姓名不能为空");
                $("#staff_name").focus();
                 return;
            }
            if(phone==""){
                alert("联系电话不能为空");
                $("#phone_number").focus();
                 return;
            }
            if(e_mail==""){
                alert("E-MAIL不能为空");
                $("#e_mail").focus();
                 return;
            }
            if(depart_id==""){
                alert("归属部门不能为空");
                $("#depart_id").focus();
                 return;
            }
            if(role_id==""){
                alert("角色不能为空");
                $("#role_id").focus();
                return;
            }
            if(confirm("确定保存吗？")) {
	            $.ajax({
	                    url:'staff/saveStaff.action',
	                    type:'post',
	                    data:{staff_id:staff_id,staff_name:staff_name,phone_number:phone,e_mail:e_mail,depart_id:depart_id,role_id:role_id,tag:tag,state:state},
	                    dataType:'text',
	                    success:function(text){
	                        if(text=="0"){
	                            alert("操作成功！");
	                            window.location.href = "staffList.action?pid=401";
	                        }else if(text == "-1"){
	                            alert("操作失败！");                        
	                        }else if(text == "-2"){
	                            alert("不能新增或编辑超级管理员！");
	                        }else if(text == "-3"){
	                            alert("该员工ID已存在，请重新输入");
	                            $("#staff_id").focus();
	                        }
	                    }
	            })
            }else return;
        }
    </script>
  </head>
  
  <body>
  <form action="<%=request.getContextPath()%>/staff/saveStaff.action" method=get  id="staffForm">
    <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： 
    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;应用维护管理系统&nbsp;&nbsp; 
    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp; 
    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;员工管理</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(../images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20" height="34"><img src="../images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="../images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>员工编辑</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          <a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img src="../images/btn_left.gif" align="absmiddle"> 后退</a>
          <a href="#" class="barBtn" onClick="javascript:history.go(+1);"><img src="../images/btn_right.gif" align="absmiddle"> 前进</a>
          <a href="#" class="barBtn"><img src="../images/btn_refresh.gif" align="absmiddle"> 刷新</a>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
        <TR>
          <th width="20%" align="center">员工ID</th>
          <TD class="BGCgray">
            <s:if test="#request.tag=='upd'">
                <input name="staff_id1" type="text" readonly="readonly" class="ys" id="staff_id1" maxlength="10" value="<%=staffInfo.getStaff_id() %>">
            </s:if>
            <s:elseif test="#request.tag=='add'">
                <input name="staff_id" type="text" id="staff_id" maxlength="10" value="<%=staffInfo.getStaff_id() %>">
            </s:elseif>
          </TD>
        </TR>
        <TR>
          <th align="center">员工姓名</th>
          <TD width="80%" class="BGCgray"><input name="staff_name" type="text" id="staff_name" maxlength="20" value="<%=staffInfo.getStaff_name() %>"></TD>
        </TR>
        <TR>
          <th align="center">联系电话</th>
          <TD width="80%" class="BGCgray"><input name="phone_number" type="text" id="phone_number" maxlength="20" value="<%=staffInfo.getPhone_number() %>"></TD>
        </TR>
        <TR>
          <th align="center">E-MAIL</th>
          <TD width="80%" class="BGCgray"><input name="e_mail" type="text" id="e_mail" maxlength="100" value="<%=staffInfo.getE_mail() %>"></TD>
        </TR>
        <TR>
          <th align="center"><span class="BGCgray">归属部门</span></th>
          <TD class="BGCgray"><select name="depart_id" id="depart_id">
                              <option value="">--请选择--</option>
                              <s:iterator value="#request.departList" id="depart">
                              <option value="<s:property value="#depart.depart_id"/>"><s:property value="#depart.depart_name"/></option>
                              </s:iterator>
                              </select>
          <input type="text" style="display:none" name="dvalue" id="dvalue" value="<%=staffInfo.getDepart_id()%>"/>                    
          </TD>
        </TR>
        <TR>
          <th align="center">角色</th>
          <TD class="BGCgray"><select name="role_id" id="role_id">
                              <option value="">--请选择--</option>
                              <s:iterator value="#request.roleList" id="role">
                              <option value="<s:property value="#role.role_id"/>"><s:property value="#role.role_name"/></option>
                              </s:iterator>
                              </select>
          <input type="text" style="display:none" name="rvalue" id="rvalue" value="<%=staffInfo.getRole_id()%>"/>      
          <input type="text" style="display:none" name="state" id="state" value="<%=staffInfo.getState()%>"/>               
          </TD>
        </TR>
        
      </table>
      <input type="text" value="<%=request.getAttribute("tag")%>" id="tag" name="tag" style="display:none"/>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="sub()"><img src="../images/btn_save.gif" width="16" height="16" align="absmiddle"> 保存</BUTTON>
      </div>
    </div>
  </td>
  </tr>
</table>
</form>
  </body>
</html>
