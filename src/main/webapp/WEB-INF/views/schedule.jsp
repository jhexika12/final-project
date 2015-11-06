<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>Schedule</title>
</head>
<body>
<div class="container">
	<h1>Welcome to Schedule page</h1>
	<br>



	<sec:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
		<a href="/car-company/login"> Login </a>
	</sec:authorize>



	<h2>
		<sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
			<a href="/car-company/welcome"> BACK HOME </a>
		</sec:authorize>

	</h2>

	<sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<div>
		<form:form method="POST" action="createSchedule"
			commandName="schedule">

			<form:label path="date_car">Date:</form:label>
			<form:input path="date_car" />
			<form:errors path="date_car">
			</form:errors>
			<br />

			<form:label path="Description">Description:</form:label>
			<form:input path="Description" />
			<form:errors path="Description">
			</form:errors>
			<br />



			<input type="submit" value="Create Schedule">
		</form:form>
	</div>
	</sec:authorize>


	<c:if test="${not empty successMsg}">
		<h2>${successMsg}</h2>
		<h2>${schedule}</h2>
	</c:if>

	<sec:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
		<a href="/car-company/welcome"> Logout </a>
	</sec:authorize>
	</div>
	 <script type="text/javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>