<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.hisun.bean.menu.MenuBean"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	/*弹出层的STYLE*/
	html,body {height:100%; margin:0px; font-size:12px;}
	
	.mydiv {
	background-color: #e3efff;
	border: 1px solid black;
	z-index:99;
	width: 300px;
	height: 120px;
	left:50%;/*FF IE7*/
	top: 50%;/*FF IE7*/
	
	margin-left:-150px!important;/*FF IE7 该值为本身宽的一半 */
	margin-top:-60px!important;/*FF IE7 该值为本身高的一半*/
	
	margin-top:0px;
	
	position:fixed!important;/*FF IE7*/
	position:absolute;/*IE6*/
	
	_top:       expression(eval(document.compatMode &&
	            document.compatMode=='CSS1Compat') ?
	            documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/
	            document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/
	
	}
	
	
	.bg {
	background-color: #e3efff;
	width: 100%;
	height: 100%;
	left:0;
	top:0;/*FF IE7*/
	filter:alpha(opacity=50);/*IE*/
	opacity:0.5;/*FF*/
	z-index:1;
	
	position:fixed!important;/*FF IE7*/
	position:absolute;/*IE6*/
	
	_top:       expression(eval(document.compatMode &&
	            document.compatMode=='CSS1Compat') ?
	            documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/
	            document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/
	
	}
	/*The END*/
</style>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../script/json2.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
            
    });
    
    $(function(){
   //全部移到右边
       $('#alladd').click(function() {
    $('#leftselect option').remove().appendTo('#power_id');
    });
    //全部移动左边
   $('#allremove').click(function() {
    $('#power_id option').remove().appendTo('#leftselect');
    });
       //移到右边
    $('#add').click(function() {
    $('#leftselect option:selected').remove().appendTo('#power_id');
    });
    //移到左边
    $('#remove').click(function() {
    $('#power_id option:selected').remove().appendTo('#leftselect');
    });
       //双击选项
    $('#leftselect').dblclick(function(){
        $("option:selected",this).remove().appendTo('#power_id');
    });
    //双击选项
       $('#power_id').dblclick(function(){
        $("option:selected",this).remove().appendTo('#leftselect');
    });
    //左边向上按钮
    $('#left_up').click(function(){
       var index = $('#leftselect option').index($('#leftselect option:selected:first'));
    var $recent = $('#leftselect option:eq('+(index-1)+')');
    if(index>0){
       var $options = $('#leftselect option:selected').remove();
    setTimeout(function(){
      $recent.before($options )
    },10);
    }
    });
    //左边向下按钮
    $('#left_down').click(function(){
       var index = $('#leftselect option').index($('#leftselect option:selected:last'));
    var len = $('#leftselect option').length-1;
    var $recent = $('#leftselect option:eq('+(index+1)+')');
    if(index<len ){
   var $options = $('#leftselect option:selected').remove();
    setTimeout(function(){
     $recent.after( $options )
    },10);
     }
    });
    //右边向上按钮
    $('#right_up').click(function(){
       var index = $('#power_id option').index($('#power_id option:selected:first'));
    var $recent = $('#power_id option:eq('+(index-1)+')');
    if(index>0){
       var $options = $('#power_id option:selected').remove();
    setTimeout(function(){
      $recent.before($options )
    },10);
    }
    });
    //右边向下按钮
    $('#right_down').click(function(){
       var index = $('#power_id option').index($('#power_id option:selected:last'));
    var len = $('#power_id option').length-1;
    var $recent = $('#power_id option:eq('+(index+1)+')');
    if(index<len ){
   var $options = $('#power_id option:selected').remove();
    setTimeout(function(){
     $recent.after( $options )
    },10);
     }
    });
});

function sub(){
    var all = "";
    var name = "";
    var role_id = $("#role_id").val();
    var role_name = $("#role_name").val();
    $("#power_id option").each(function() {
    all += $(this).attr("value")+",";
    name += $(this).html()+",";
    });
    
    if(confirm("确定保存吗？")) {
                $.ajax({
                        url:'role/savePower.action',
                        type:'post',
                        data:{role_id:role_id,role_name:role_name,power_id:all,power_name:name},
                        dataType:'text',
                        success:function(text){
                            if(text=="0"){
                                alert("操作成功！");
                                window.location.reload();
                            }else if(text == "-1"){
                                alert("操作失败！");                        
                            }
                        }
                })
            }else return;
}

function addPower(){
    var pid = $("#p_id").val();
    var pname = $("#p_name").val();
    
    if(pid == ""){
        alert("权限ID不能为空！");
        $("#p_id").focus();
        return;
    }
    if(pname == ""){
        alert("权限名称不能为空！");
        $("#p_name").focus();
        return;
    }
    if(confirm("确定保存吗？")) {
                $.ajax({
                        url:'role/addPower.action',
                        type:'post',
                        data:{p_id:pid,p_name:pname},
                        dataType:'text',
                        success:function(text){
                            if(text=="0"){
                                alert("操作成功！");
                                window.location.reload();
                            }else if(text == "-1"){
                                alert("操作失败！");                        
                            }else if(text == "-2"){
                                alert("已经有此权限ID，请重新输入！");  
                                $("#p_id").focus();                      
                            }
                        }
                })
            }else return;
}


function showDiv(){
document.getElementById('popDiv').style.display='block';
document.getElementById('bg').style.display='block';
}

function closeDiv(){
document.getElementById('popDiv').style.display='none';
document.getElementById('bg').style.display='none';
}
</script>
</head>

<body>

        <div id="popDiv" class="mydiv" style="display:none;" ondblclick="closeDiv()">
            <table width="100%" height="70%" border="0" cellspacing="1" cellpadding="3" class="table1">
                    <TR style="height:10px;">
                        <th width="30%" align="center"><font color="black">权限ID</font></th>
                        <TD class="BGCgray"><input name="p_id" type="text"
                            id="p_id" maxlength="10" value=""></TD>
                    </TR>
                    <TR style="height:10px;">        
                        <th width="30%" align="center"><font color="black">权限名称</font></th>
                        <TD class="BGCgray"><input name="p_name" type="text" 
                            id="p_name" maxlength="20" value=""></TD>
                    </TR>
            </table>
            <div style="width:100%; text-align:center; padding:5px">
                            <BUTTON style="HEIGHT:25px" onClick="addPower()">
                                <img src="../images/btn_save.gif" width="16" height="16"
                                    align="absmiddle"> 新增权限
                            </BUTTON>
                        </div>
            <font color="red">&nbsp;&nbsp;双击关闭该窗口</font>
        </div>
		<div id="bg" class="bg" style="display:none;"></div>
		
        <table width="100%" height="100%" border="0" cellspacing="0"
            cellpadding="3">
            <tr>
                <td style="height:25px; background-color:#f3f3f3; font-weight:bold"
                    valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
                    src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;应用维护管理系统&nbsp;&nbsp;
                    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;配置管理&nbsp;&nbsp;
                    <img src="../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;角色管理</td>
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
                                align="absmiddle">&nbsp;&nbsp;<strong>权限编辑</strong>
                            </td>
                            <td align="right" class="white" style="padding-right:20px">
                                <a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
                                    src="../images/btn_left.gif" align="absmiddle"> 后退</a> <a
                                href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
                                    src="../images/btn_right.gif" align="absmiddle"> 前进</a> <a
                                href="#" class="barBtn" onclick="showDiv()"><img src="../images/btn_save.gif"
                                    align="absmiddle"> 新增</a></td>
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
                                <th width="20%" align="center">角色ID</th>
                                <TD class="BGCgray"><input name="role_id" type="text" disabled="disabled"
                                    id="role_id" maxlength="10" value="<%=request.getAttribute("role_id") %>"></TD>
                            </TR>
                            <TR>        
                                <th width="20%" align="center">角色名称</th>
                                <TD class="BGCgray"><input name="role_name" type="text" disabled="disabled"
                                    id="role_name" maxlength="20" value="<%=request.getAttribute("role_name") %>"></TD>
                            </TR>
                            <TR>
                                <th width="20%" align="center">权限编辑</th>
                                <TD class="BGCgray">
                                <table width="50%" border="0" cellpadding="3" cellspacing="1" class="table1">
                                    <tr>
                                    <TD class="BGCgray">
                                    <strong><font color="blue" size="3">未选权限：</font></strong>
                                    <select multiple="multiple" id="leftselect" name="leftselect" style="width: 300px;height:160px;">
								      <s:iterator value="#request.nopList" id="nop">
								      <option value="<s:property value="#nop.power_id"/>">
								                <s:property value="#nop.power_name" />
								      </option>
								      </s:iterator>
								     </select>
								     <td class="BGCgray">
	                                    <a href="#" id="add"><img src="../images/next.gif" width="16" border="0"></a><br><br>
	                                    <a href="#" id="remove"><img src="../images/prev.gif" width="16" border="0"></a><br><br>
	                                    <a href="#" id="alladd"><img src="../images/prev_end.gif" width="16" border="0"></a><br><br>
	                                    <a href="#" id="allremove"><img src="../images/prev_top.gif" width="16" border="0"></a>
                                     </td>
                                     <td class="BGCgray">
                                     <strong><font color="blue"  size="3">已选权限：</font></strong>
                                     <select multiple="multiple" id="power_id" name="power_id" style="width: 300px;height:160px;">
                                        <s:iterator value="#request.rpList" id="rp">
	                                      <option value="<s:property value="#rp.power_id"/>">
	                                                <s:property value="#rp.power_name" />
	                                      </option>
                                      </s:iterator>
                                     </select>
								     </TD>
								     </tr>
								   </table>
								    </td>
                            </TR>
                        </table>
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
