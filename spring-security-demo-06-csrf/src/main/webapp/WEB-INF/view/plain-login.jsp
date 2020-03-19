<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
.failed{
color:red;

}
</style>
<meta charset="ISO-8859-1">
<title>Custome Login Page</title>
</head>
<body>
<h3>My Custome Login page</h3>




<form:form action="${pageContext.request.contextPath }/authenticateTheUser" method="post">
		
		<!-- check for error login -->
		<c:if test="${param.error!=null }"><i class="failed">Sorry you are entering wrong username/password</i></c:if>
<p>
    User Name: <input type="text" name="username"/>
</p>
<p>
    Password: <input type="password" name="password"/>
</p>

<input type="submit" value="Login"/>
</form:form>
</body>
</html>