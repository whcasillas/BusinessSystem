<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.hisun.bean.staff.StaffBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
        });
        
    </script>
  </head>
  
  <body>
  <s:form action="upload" method="post" enctype="multipart/form-data" theme="simple">
    <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã� 
    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;Ӧ��ά������ϵͳ&nbsp;&nbsp; 
    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�ļ�����&nbsp;&nbsp; 
    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;�ļ��ϴ�</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(../images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20" height="34"><img src="../images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="../images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>Ա���༭</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          <a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img src="../images/btn_left.gif" align="absmiddle"> ����</a>
          <a href="#" class="barBtn" onClick="javascript:history.go(+1);"><img src="../images/btn_right.gif" align="absmiddle"> ǰ��</a>
          <a href="#" class="barBtn"><img src="../images/btn_refresh.gif" align="absmiddle"> ˢ��</a>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
        <TR>
          <th width="20%" align="center">�����ļ�1</th>
          <TD class="BGCgray">
            <s:file name="image" label="Data1"></s:file>
          </TD>
        </TR>
        <TR>
          <th width="20%" align="center">�����ļ�2</th>
          <TD class="BGCgray">
            <s:file name="image" label="Data2"></s:file>
          </TD>
        </TR>
        <TR>
          <th width="20%" align="center">�����ļ�3</th>
          <TD class="BGCgray">
            <s:file name="image" label="Data3"></s:file>
          </TD>
        </TR>
        <TR>
          <th width="20%" align="center">�����ļ�4</th>
          <TD class="BGCgray">
            <s:file name="image" label="Data4"></s:file>
          </TD>
        </TR>
        <TR>
          <th width="20%" align="center">�����ļ�5</th>
          <TD class="BGCgray">
            <s:file name="image" label="Data5"></s:file>
          </TD>
        </TR>
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <s:submit value="�ϴ�"></s:submit>
      </div>
      <font color="red">
                        ע��1�������ļ��ϴ���С����Ϊ10M������10M�ϴ����ɹ���<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                2���ϴ��ļ���ʽΪ��*.png,*.bmp,*.jpg,*.doc,*.xls,*.docx,*.xlsx,*.cvs,*.gif
      </font>
    </div>
    
  </td>
  </tr>
  
</table>

</s:form>
  </body>
</html>
