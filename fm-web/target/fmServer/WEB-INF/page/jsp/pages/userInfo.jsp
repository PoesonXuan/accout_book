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
<h2 id="userInfo" class="sub-header">${title}</h2>
		<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
							<c:forEach items="${list}" var="obj">
								<th>${obj.title}</th>
							</c:forEach>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${datas}" var="data">
								<tr>
								<td>${data.name}</td>
								
								<td>${data.sex}</td>
								<td>${data.age}</td>
								<td>${data.type}</td>
								<td>${data.account}</td>
								<td>${data.tele}</td>
								<td>${data.mail}</td>
								<td>${data.status}</td>
								<td><span class="label label-success" onclick="update('${data.id}')">修改</span></td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
	
</body>
<script type="text/javascript">

function update(key){	
	alert(key);
}
</script>
</html>