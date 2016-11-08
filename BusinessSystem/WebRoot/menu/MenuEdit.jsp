<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.hisun.bean.menu.MenuBean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	MenuBean menu = (MenuBean) request.getAttribute("MENU");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../script/json2.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
            var tag = "<%=request.getAttribute("tag")%>";
            if(tag == "2"){
                var depart = "<%=menu.getDepart_id()%>";
                var ml = "<%=menu.getMenu_level()%>";
                var pm = "<%=menu.getParent_menu_id()%>";
                $("#depart_id").val(depart);
                $("#menu_level").val(ml);
                setParent();
                $("#menu_id").attr("disabled", true);
                $("#menu_level").attr("disabled", true);
                if(ml == "3"){
                    $("#menu_url").attr("disabled", false);
                }else{
                    $("#menu_url").attr("disabled", true);
                }
            }
        });

    function sub(){
        var mid = $("#menu_id").val();
        var pm = $("#parent_menu_id").val();
        var mn = $("#menu_name").val();
        var ml = $("#menu_level").val();
        var did = $("#depart_id").val();
        var url = $("#menu_url").val();
        var tag = $("#tag").val();
        
        if(mid == ""){
            alert("菜单ID不能为空！")
            $("#menu_id").focus();
            return;
        }
        if(mn == ""){
            alert("菜单名称不能为空！")
            $("#menu_name").focus();
            return;
        }
        if(ml == ""){
            alert("菜单级别不能为空！")
            $("#menu_level").focus();
            return;
        }
        
        if(ml != ""&&ml != "1"){
            if(pm==""){
                alert("上级菜单不能为空！")
                $("#parent_menu_id").focus();
                return;
            }
        }
        if(ml == "3"){
            if(url==""){
                alert("菜单URL不能为空！")
                $("#menu_url").focus();
                return;
            }
        }
        
        if(confirm("确定保存吗？")) {
                $.ajax({
                        url:'menu/saveMenu.action',
                        type:'post',
                        data:{menu_id:mid,parent_menu_id:pm,menu_name:mn,menu_level:ml,menu_url:url,depart_id:did,tag:tag},
                        dataType:'text',
                        success:function(text){
                            if(text=="0"){
                                alert("操作成功！");
                                window.location.href = "menuList.action?pid=201";
                            }else if(text == "1"){
                                alert("操作失败！");                        
                            }else if(text == "-2"){
                                alert("该菜单ID已存在，请重新输入");
                                $("#menu_id").focus();
                            }
                        }
                })
            }else return;
    }

	function setParent() {
		var ml = $("#menu_level").val();
		var tag = "<%=request.getAttribute("tag")%>"
		if(ml!=""){
		$.ajax({
			type : 'POST',
			url : 'menu/menuParent.action',
			data : {menu_level:ml},
			success : function(msg) {
				// 清空表格  
				$("#parent_menu_id").empty();
				var option = "<option value=\"\">--请选择--</option>";
				if(msg == ""){
                    $("#parent_menu_id").attr("disabled", true);
                }
				// 转换成json对象  
				var data = JSON.parse(msg);
				// 循环组装下拉框选项  
				if(msg!=null){
				    $("#parent_menu_id").attr("disabled", false);
					$.each(data, function(k, v) {
	                    option += "<option value=\"" + v + "\">"
	                            + k + "</option>";
	                });
				}
				
				$("#parent_menu_id").append(option);
				$("#parent_menu_id").val("<%=menu.getParent_menu_id()%>");
				
				if(tag == "2"){
				    $("#parent_menu_id").attr("disabled", true);
				}
			}
		});
		}
	}
</script>
</head>

<body>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;应用维护管理系统&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;配置管理&nbsp;&nbsp;
					<img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;菜单管理</td>
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
								align="absmiddle">&nbsp;&nbsp;<strong>菜单编辑</strong>
							</td>
							<td align="right" class="white" style="padding-right:20px">
								<a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
									src="../images/btn_left.gif" align="absmiddle"> 后退</a> <a
								href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
									src="../images/btn_right.gif" align="absmiddle"> 前进</a> <a
								href="#" class="barBtn"><img src="../images/btn_refresh.gif"
									align="absmiddle"> 刷新</a></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th align="center"><span class="">菜单级别</span>
								</th>
								<TD class="BGCgray"><select name="menu_level"
									id="menu_level" onchange="setParent()">
										<option value="">--请选择--</option>
										<option value="1">一级菜单</option>
										<option value="2">二级菜单</option>
										<option value="3">三级菜单</option>
								</select></TD>
							</TR>
							<TR>
								<th align="center"><span class="">上级菜单</span>
								</th>
								<TD class="BGCgray"><select name="parent_menu_id"
									id="parent_menu_id">
										<option value="">--请选择--</option>
								</select></TD>
							</TR>
							<TR>
								<th width="20%" align="center">菜单ID</th>
								<TD class="BGCgray"><input name="menu_id" type="text"
									id="menu_id" maxlength="10" value="<%=menu.getMenu_id()%>"></TD>
							</TR>
							<TR>
								<th width="20%" align="center">菜单名称</th>
								<TD class="BGCgray"><input name="menu_name" type="text"
									id="menu_name" maxlength="100" value="<%=menu.getMenu_name()%>"></TD>
							</TR>
							<TR>
								<th width="20%" align="center">URL</th>
								<TD class="BGCgray"><input name="menu_url" type="text"
									id="menu_url" maxlength="200" value="<%=menu.getMenu_url()%>"></TD>
							</TR>
							<TR>
								<th align="center"><span class="BGCgray">归属部门</span>
								</th>
								<TD class="BGCgray"><select name="depart_id" id="depart_id">
										<option value="">--请选择--</option>
										<s:iterator value="#request.departList" id="depart">
											<option value="<s:property value="#depart.depart_id"/>">
												<s:property value="#depart.depart_name" />
											</option>
										</s:iterator>
								</select> 
								</TD>
							</TR>
						</table>
						<input type="text" value="<%=request.getAttribute("tag")%>" id="tag" name="tag" style="display:none"/>
						<div style="width:100%; text-align:center; padding:5px">
							<BUTTON style="HEIGHT:25px" onClick="sub()">
								<img src="../images/btn_save.gif" width="16" height="16"
									align="absmiddle"> 保存
							</BUTTON>
						</div>
					</div></td>
			</tr>
		</table>
</body>
</html>
