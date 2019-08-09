<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
</head>
<body>

<input id="pwdSetSelect" type="hidden" value=""/>
<input id="sexSelect" type="hidden" value=""/>
<input id="accountSelect" type="hidden" value=""/>
<input id="accountLevSelect" type="hidden" value=""/>


<!-- Large button group -->
<div class="btn-group">
  <button id="pwdSetSelectLab" class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    初始密码选项 <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <li onclick="selectOnClick('0')"></li><br/>
    <li onclick="selectOnClick('1')">系统原始密码</li><br/>
    <li onclick="selectOnClick('2')">手动输入密码 </li>
  </ul>
</div>

<br/><br/>

<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">用&nbsp;户&nbsp;名</span>
  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
</div>
<br/><br/>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span>
  <input id="pwd" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
</div>
<br/><br/>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">确&nbsp;认&nbsp;密&nbsp;码</span>
  <input id="rePwd" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
</div>

</body>
<script type="text/javascript">
$(function(){
});

function selectOnClick(p){
	if("0" == p){
		$("#pwdSetSelect").val("");
	}else if("1" == p){
		alert($("#pwdSetSelectLab").val());
		$("#pwdSetSelectLab").val("系统原始密码<span class='caret'></span>");
		$("#pwd").attr('disabled',true);
		$("#rePwd").attr('disabled',true);
		$("#pwdSetSelect").val("1");
	}else if("2" == p){
		alert($("#pwdSetSelectLab").val());
		$("#pwdSetSelectLab").val("手动输入密码<span class='caret'></span>");
		$("#pwd").attr('disabled',false);
		$("#rePwd").attr('disabled',false);
		$("#pwdSetSelect").val("2");
	} 
}

</script>
</html>