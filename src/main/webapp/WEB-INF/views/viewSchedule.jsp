<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>Users</title>
</head>
<body>
<div class="container">
<h1>Welcome to Schedule page</h1><br>

	<sec:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
		<a href="/car-company/welcome"> Logout </a>
	</sec:authorize>

	<sec:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
		<a href="/car-company/login"> Login </a>
	</sec:authorize>



	<h2>
		<sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
			<a href="/car-company/welcome"> Back Home </a>
		</sec:authorize>
		
	</h2>


	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<sec:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
		<div>
		<c:forEach var="i" items="${schedules}">
			<h2>${i.userEntity.username}</h2>
			<h2>${i.description}</h2>
			<h2>${i.date_car}</h2>
		</c:forEach>

		</div>
	</sec:authorize>
</div>
 <script type="text/javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>