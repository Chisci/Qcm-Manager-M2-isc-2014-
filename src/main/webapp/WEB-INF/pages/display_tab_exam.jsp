<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display exam list</title>
</head>
<body>
	<p>User session : ${ session.user.username }</p>
	<fieldset>
		<legend>Exam list : </legend>

		<c:forEach items="${exams}" var="exam">

			<label for="${ exam.id }">${ exam.title }</label>
			<c:if test="${ exam.user } == ${ request.getUserPrincipal() }">
				<label>Modifier</label>
			</c:if>
			<c:if test="${ exam.user } != ${ request.getUserPrincipal() }">
				<label>Take</label>
			</c:if>
		</c:forEach>
	</fieldset>
</body>
</html>