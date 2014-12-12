<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<p>BONJOUR : ${pageContext.request.userPrincipal.name}</p>
<a href="<c:url value="/exam/create.do" />">Create an exam</a>
<a href="<c:url value="/exam/display.do" />">Display an exam</a>
</body>
</html>