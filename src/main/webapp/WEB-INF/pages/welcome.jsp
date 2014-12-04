<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Qcm Manager 2004</title>
</head>
<body> 
<% if (request.getUserPrincipal() == null) 
{
 %> Identifiez vous :
		<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>
		  <fieldset>
				<label>User:</label>
				<input type='text' name='j_username' value=''>
				<br/>
				<label>Password:</label>
				<input type='password' name='j_password' />
				<br/>
				<input name="submit" type="submit" value="submit" />
		  </fieldset>
		</form>
	Ou Enregistrez-vous : 
	<a href="<c:url value="/register.jsp" />">S'enregistrer</a>
 <%
}else{%>
<blink>Bonjour : </blink> ${pageContext.request.userPrincipal.name} 
 <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
<%}%>
</body>
</html>