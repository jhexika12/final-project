<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Engineer</title>
</head>
<body>

<h3>Welcome to Engineer page</h3><br>

	<sec:authorize ifAnyGranted="ROLE_ADMIN">
		<a href="/car-company/welcome"> Logout </a>
	</sec:authorize>

	<sec:authorize ifNotGranted="ROLE_USER">
		<a href="/car-company/welcome"> Home Page </a>
	</sec:authorize>



	<h2>
		<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<a href="/car-company/welcome"> Admin </a>
		</sec:authorize>


	</h2>

	<sec:authorize ifAnyGranted="ROLE_ADMIN">
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<div>
			<form:form method="POST" action="createEngineer"
				commandName="engineer">

				<form:label path="name">Name:</form:label>
				<form:input path="name" />
				<form:errors path="name">
				</form:errors>
				<br />

				<form:label path="phone">Phone:</form:label>
				<form:input path="phone" />
				<form:errors path="phone">
				</form:errors>
				<br />

				<form:label path="email">Email:</form:label>
				<form:input path="email" />
				<form:errors path="email">
				</form:errors>
				<br />
				
				<form:label path="birthday">Birthday:</form:label>
				<form:input path="birthday" />
				<form:errors path="birthday">
				</form:errors>
				<br />
				
				<form:label path="description">Description:</form:label>
				<form:input path="description" />
				<form:errors path="description">
				</form:errors>
				<br />


				<input type="submit" value="Create Engineer">
			</form:form>
		</div>
	</sec:authorize>

	<c:if test="${not empty successMsg}">
		<h2>${successMsg}</h2>
	</c:if>


</body>
</html>