<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>高阳通联运维知识库</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="js/main.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    
    $(document).ready(function() {
	    $("#dataLoad").hide(); 
	    $("#staff_id").focus();
	});
    
	document.onkeydown = function(event) {
		e = event ? event : (window.event ? window.event : null);
		if (e.keyCode == 13) {
		    $("#dataLoad").show();
			sub();
		}
	}

	function sub() {
		var staff_id = $("#staff_id").val();
		var staff_pwd = $("#staff_pwd").val();
		if (staff_id == "") {
			alert("用户名不能为空");
			$("#staff_id").focus();
			return;
		}
		if (staff_pwd == "") {
			alert("密码不能为空");
			$("#staff_pwd").focus();
			return;
		}
        $("#showLoadingDiv").click(function(){$("#dataLoad").show();});
		$.ajax({
			url : 'staff/login.action',
			type : 'post',
			data : {
				staff_id : staff_id,
				staff_pwd : staff_pwd
			},
			dataType : 'text',
			success : function(text) {
				if (text == "0") {
				    $("#dataLoad").hide(); 
					window.location.href = "index.jsp";
				} else {
				    $("#dataLoad").hide(); 
					alert("用户名或密码错误，请重新输入！");
				}
			}
		})
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	scroll="no">
    <div id="dataLoad" style="width:100%;height:100%;filter:alpha(opacity=75); background:#FFF; position:absolute;display:none"><!--页面载入显示-->
	   <table width=100% height=100% border=0 align=center valign=middle>
	    <tr height=50%><td align=center>&nbsp;</td></tr>
	    <tr><td align=center><img src="<%=request.getContextPath()%>/images/loader.gif"/></td></tr>
	    <tr><td align=center>数据载入中，请稍后......</td></tr>
	    <tr height=50%><td align=center>&nbsp;</td></tr>
	   </table>
	</div>
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td height="100%" align="center" bgcolor="#e3efff">

				<table width="606" height="269" border="0" cellpadding="0"
					cellspacing="0" background="images/login-main.png">
					<tr>
						<td>
							<div style="margin:220px 0px 0px 70px;">
								<form action="<%=request.getContextPath()%>/login.action"
									method="post">
									<table>
										<tr>
											<td width="24"><img src="images/login-user.png"
												width="14" height="14" border="0" />
											</td>
											<td width="132"><input type="text" name="staff_id"
												id="staff_id"
												style="border:none;padding-left:5px; line-height:24px;  background-image:url(images/login-input.png); width:122px; height:24px">
											</td>
											<td width="24"><img src="images/login-pwd.png"
												width="14" height="14" border="0" />
											</td>
											<td width="132"><input type="password" name="staff_pwd"
												id="staff_pwd"
												style="border:none;padding-left:5px; line-height:24px;  background-image:url(images/login-input.png); width:122px; height:24px"">
											</td>
											<td><input type="button"
												style="background-image:url(images/login-button.png); border:none; width:62px; height:24px; color:#ffffff"
												value="提 交" onclick="sub()" id="showLoadingDiv">
											</td>
										</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
