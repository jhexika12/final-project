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
 <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>Customer</title>
</head>
<body>
<div class="container">
<h1>Welcome to customer page</h1><br>



<h2>
	<sec:authorize ifAnyGranted="ROLE_ADMIN" >
 <a href="/car-company/welcome"> Admin </a>
</sec:authorize>

<sec:authorize ifAnyGranted="ROLE_USER" >
 <a href="/car-company/welcome"> Back Home </a>
</sec:authorize>


	</h2>


<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	
	<div>
		<form:form method="POST" action="createCustomer" commandName="customer" >
		
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
			<form:errors path="name"> </form:errors><br/>
			
			<form:label path="lastName" >Last Name:</form:label>
			<form:input path="lastName"/> 
			<form:errors path="lastName"> </form:errors><br/>
			
			<form:label path="address" >Address:</form:label>
			<form:input path="address"/> 
			<form:errors path="address"> </form:errors><br/>
			
			<form:label path="phone" >Phone:</form:label>
			<form:input path="phone"/> 
			<form:errors path="phone"> </form:errors><br/>
			
			<form:label path="email" >Email:</form:label>
			<form:input path="email"/> 
			<form:errors path="email"> </form:errors><br/>
			
		
			<input type="submit" value="Create Customer">
		</form:form>
	</div>

<c:if test="${not empty successMsg}">
<h2>${successMsg}</h2>
<h2>${customer}</h2>
</c:if>

<sec:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN" >
 <a href="/car-company/welcome"> Logout </a>
</sec:authorize>	

<sec:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN" >
 <a href="/car-company/login"> Login </a>
</sec:authorize>
</div>
 <script type="text/javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>