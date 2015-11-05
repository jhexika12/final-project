<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<title> The Happy Car </title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="resources/css/bootstrap.min.css"> 
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery-1.11.3.min.js"></script>
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/bootstrap.min.js"></script>
        
	</head>
	<body>  
	
        
    <nav class="navbar navbar-default navbar-fixed-top">
    <sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	</sec:authorize>
  <div >
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="http://www.softtek.com/es/">Softtek</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">HOME</a></li>
        <li><a href="login">LOGIN</a></li>
        <li><a href="newUser">CREATE USER</a></li>
        <li><a href="newCar">CREATE CAR</a></li>
        <li><a href="#">SCHEDULE</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div>
  </div>
</nav>
            
                
        
 <div class="jumbotron text-center">
    <h1>Schedule</h1>
    <p>We specialize in the support of your car.</p>
  </div>
   
   
   <div class="container-fluid text-center">
    <h1>Here is gonna be the other things</h1>
  </div>
   
   
        
	</body>
</html>