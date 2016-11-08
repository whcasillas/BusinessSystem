<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hisun.bean.staff.StaffBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

StaffBean bean = (StaffBean)session.getAttribute("STAFFINFO");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
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
    function sub(){
            var staff_id = $("#staff_id").val();
            var new_staff_pwd = $("#new_staff_pwd").val();
            var old_staff_pwd = $("#old_staff_pwd").val();
            var again_staff_pwd = $("#again_staff_pwd").val();
            if(old_staff_pwd==""){
                alert("原密码不能为空");
                $("#old_staff_pwd").focus();
                return;
            }
            
            if(new_staff_pwd==""){
                alert("新密码不能为空");
                $("#new_staff_pwd").focus();
                return;
            }
            
            if(again_staff_pwd==""){
                alert("密码确认不能为空");
                $("#again_staff_pwd").focus();
                return;
            }
            if (confirm("确认修改？")){
	            $.ajax({
	                    url:'staff/staffPwd.action',
	                    type:'post',
	                    data:{staff_id:staff_id,old_staff_pwd:old_staff_pwd,new_staff_pwd:new_staff_pwd,again_staff_pwd:again_staff_pwd},
	                    dataType:'text',
	                    success:function(text){
	                        if(text=="0"){
	                            alert("修改成功！");
	                            window.location.href = "StaffPwd.jsp";
	                        }else if(text == "-1"){
	                            alert("修改密码失败！");
	                        }else if(text == "-2"){
	                            alert("原密码不正确！");
	                        }else if(text == "-3"){
	                            alert("两次输入的密码不一致！");
	                        }
	                    }
	            })
            }else return;
        }
</script>
</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;成都市企业服务呼叫中心&nbsp;&nbsp; <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp; <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;帐号管理</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(../images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20" height="34"><img src="../images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="../images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>账户管理</strong></td>
          <td align="right" class="white" style="padding-right:20px">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top"><div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
        <TR>
          <th width="20%" align="center">用户ID</th>
          <TD width="80%" class="BGCgray">
            <input name="staff_id" type="text" readonly="readonly" id="staff_id"
            value="<%=bean.getStaff_id()%>" class="ys">
          </TD>
          </TR>
        <TR>
          <th align="center">原密码</th>
          <TD class="BGCgray"><input name="old_staff_pwd" type="password" maxlength="20" id="old_staff_pwd"></TD>
          </TR>
        <TR>
          <th align="center">新密码</th>
          <TD class="BGCgray"><input name="new_staff_pwd" type="password" maxlength="20" id="new_staff_pwd"></TD>
          </TR>
        <TR>
          <th align="center">确认密码</th>
          <TD class="BGCgray"><input name="again_staff_pwd" type="password" maxlength="20" id="again_staff_pwd"></TD>
          </TR>
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="sub()"><img src="../images/btn_save.gif" width="16" height="16" align="absmiddle"> 保存</BUTTON>
      </div>
    </div></td>
  </tr>
</table>
</body>
</html>
