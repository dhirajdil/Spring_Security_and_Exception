<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
luv2code home page
</head>
<body>
<h2>welocme in luv2spring home page</h2>

<hr>
<!-- Display usename and Roles  -->
<p>
User:<security:authentication property="principal.username"/>
Role(s):<security:authentication property="principal.authorities"/>
</p>
<hr>
<!-- Add a link to point to/leaders..this is for managers -->

<security:authorize access="hasRole('MANAGER')">

<a href="${pageContext.request.contextPath }/leaders">Leadership meeting</a>
(Only for Manager peeps)
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath }/systems">IT systems meeting</a>
(Only for Admin peeps)
</security:authorize>
</hr>
</hr>

<!-- Add logout button -->
<form:form action="${pageContext.request.contextPath }/logout" mrthod="">

<input type="submit" value="LogOut"/>

</form:form>
</body>
</html>