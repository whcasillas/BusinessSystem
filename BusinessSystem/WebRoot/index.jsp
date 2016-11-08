<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hisun.bean.staff.StaffBean" %>
<%@ page import="com.hisun.bean.menu.MenuBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

if (session.getAttribute("STAFFINFO") == null) { 
response.sendRedirect("login.jsp"); 
return; 
}

List<MenuBean> menuList = (List<MenuBean>)session.getAttribute("MENULIST");
StaffBean bean = (StaffBean)session.getAttribute("STAFFINFO");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>应用维护管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/dtree.js"></script>
<script type="text/javascript">
    function logout(){
        if(confirm("确定退出吗？")){
            $("#logoutA").attr("href", "logout.action")
        }else{
            return;
        }
        
    }
</script>
</head>
<body scroll="no">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="79" background="images/top_bg.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="500"><img src="images/bg-top.jpg" width="350" height="79"></td>
          <td>&nbsp;</td>
          <td width="500" height="79"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/top_right_a.gif" width="500" height="47"></td>
              </tr>
              <tr>
                <td><table width="500" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="150"><img src="images/top_right_b1.gif" width="150" height="32"></td>
                    <td width="146" height="32" background="images/top_right_b2.gif" class="white">用户：<%=bean.getStaff_name() %></td>
                    <td width="74"><a href="staff/StaffPwd.jsp" target="page"><img src="images/top_right_b6.gif" width="74" height="32" border="0"></a></td>
                    <td width="50"><a href="#" id="logoutA" onclick="logout()"><img src="images/top_right_b3.gif" width="50" height="32" border="0"></a></td>
                    <td width="50"><a href="#"><img src="images/top_right_b4.gif" width="50" height="32" border="0"></a></td>
                    <td width="30"><img src="images/top_right_b5.gif" width="30" height="32"></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="100%"><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="background-repeat: repeat-x;">
        <tr>
          <td width="175" height="100%" valign="top"><table width="175" height="100%" border="0" cellspacing="0" cellpadding="0" background="images/menu_bg.gif">
              <tr>
                <td height="25"><img src="images/menu_top.gif" width="175" height="25"></td>
              </tr>
              <tr>
                <td height="100%" style="background-image:url(images/menu_bgT.gif); background-repeat:no-repeat" valign="top"><div class="dtree">
                    <script type="text/javascript">
                    d = new dTree('d');
                    d.config.stepDepth = 1;
                    d.config.useStatusText = true;
                    <%
                        for(int i=0; i<menuList.size(); i++){
                            MenuBean menu = menuList.get(i);
                    %>
                    d.add('<%=menu.getMenu_id()%>', '<%=menu.getParent_menu_id()%>', '<%=menu.getMenu_name()%>', '<%=menu.getMenu_url()==null?"":menu.getMenu_url()%>', "", "page");
                    <%}%>
                    document.writeln(d);
                    </script>
                </div></td>
              </tr>
              <tr>
                <td height="31"><img src="images/menu_foot.gif" width="175" height="31"></td>
              </tr>
            </table></td>
          <td><iframe src="welcome.jsp" width="100%" height="100%" frameborder="0" scrolling="no" name="page"></iframe></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
