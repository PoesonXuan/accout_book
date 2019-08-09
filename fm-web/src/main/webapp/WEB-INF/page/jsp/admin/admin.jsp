<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="登录认证界面">
<meta name="author" content="XuanZP">
<title>管理员页面</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap/dashboard.css"
	rel="stylesheet">


</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="#" onclick="navClick('userInfo')">用户管理</a></li>
					<li><a href="#" onclick="navClick('addUser')">用户添加</a></li>
				</ul>

			</div>
			<div id="content" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
			</div>
		</div>
	</div>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath}/js/bootstrap/ie10-viewport-bug-workaround.js"></script>

    <script src="${pageContext.request.contextPath}/js/bootstrap/holder.min.js"></script>
<script type="text/javascript">
	function navClick(param){
		var url = '${pageContext.request.contextPath}/index';
		if(param && 'userInfo'== param){
			url = '${pageContext.request.contextPath}/web/pages/userInfo';
		}else if(param && 'addUser' == param){
			url = '${pageContext.request.contextPath}/web/pages/addUser';
		}
		$("#content").load(url);
	}

	$(function(){
		
		
	});
</script>    
</body>
</html>