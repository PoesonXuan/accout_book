<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="登录认证界面">
<meta name="author" content="XuanZP">
<title>Insert title here</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/md5.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<input id="loginInfo" type="hidden" value="${loginInfo}"/>
	
	
    <div class="container">

      <form class="form-signin" method="post" action="${pageContext.request.contextPath}/web/authen/login">
        <h3 class="form-signin-heading">登录</h3>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input name="loginName" type="text" id="inputLoginName" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input name="passWord" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
       <!--  <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/js/bootstrap/ie10-viewport-bug-workaround.js"></script>
	<script type="text/javascript">
		function getMd5Pwd(){
			var pwd = $("#inputPassword").val();
			if(pwd && pwd != ''){
				//加密成md5
			    pwd = $.md5(pwd);
			    $("#inputPassword").val(pwd);
			}
		}
	
		$(function(){
			/* $("#inputLoginName").blur(getMd5Pwd); */
			$("#inputPassword").blur(getMd5Pwd);
			var loginInfo = $("#loginInfo").val();
			if(loginInfo  && '' != loginInfo){
				alert(loginInfo);
			}
		});
	
	</script>
</body>
</html>