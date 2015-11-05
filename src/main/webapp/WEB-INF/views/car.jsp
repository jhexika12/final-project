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
<title>Customer</title>
</head>
<body>

<h1>Welcome to customer page</h1><br>

<sec:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN" >
 <a href="/car-company/welcome"> Logout </a>
</sec:authorize>	

<sec:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN" >
 <a href="/car-company/login"> Login </a>
</sec:authorize>



<h2>
	<sec:authorize ifAnyGranted="ROLE_ADMIN" >
 <a href="/car-company/welcome"> Admin </a>
</sec:authorize>


	</h2>

<sec:authorize ifAnyGranted="ROLE_USER" >
<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	
	<div>
		<form:form method="POST" action="createCar" commandName="car" >
		
			<form:label path="brand">Brand:</form:label>
			<form:input path="brand"/>
			<form:errors path="brand"> </form:errors><br/>
			
			<form:label path="model" >Model:</form:label>
			<form:input path="model"/> 
			<form:errors path="model"> </form:errors><br/>
			
			<form:label path="color" >Color:</form:label>
			<form:input path="color"/> 
			<form:errors path="color"> </form:errors><br/>
			
		
			<input type="submit" value="Create Car">
		</form:form>
	</div>
</sec:authorize>

<c:if test="${not empty successMsg}">
<h2>${successMsg}</h2>
</c:if>


</body>
</html>