<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="resources/css/bootstrap.min.css"> 
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery-1.11.3.min.js"></script>
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/bootstrap.min.js"></script>

</head>
<body onload='document.loginForm.username.focus();'>

	<div class="container">
		
		<form class="form-signin" name='loginForm'
				action="<c:url value='/j_spring_security_check' />" method='POST'>
			
			<h3 class="form-signin-heading">Login with Username and Password</h3>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
		</c:if>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
			</tr>
			</table>
	
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>