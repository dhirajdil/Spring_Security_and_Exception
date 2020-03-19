<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
luv2code home page
</head>
<body>
<h2>welocme in luv2spring home page</h2>
<!-- Add logout button -->
<form:form action="${pageContext.request.contextPath }/logout" mrthod="">

<input type="submit" value="LogOut"/>

</form:form>
</body>
</html>