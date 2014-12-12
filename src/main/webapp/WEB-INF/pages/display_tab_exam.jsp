<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Display exam list</title>
</head>
<body>
	<p>User session : ${ session.currentUser }</p>
	<fieldset>
		<legend>Exam list : </legend>

		<c:forEach items="${exams}" var="exam">

			<label for="${ exam.id }">${ exam.title }</label>
			<label>created by ${ exam.author }</label>
			<c:if test="${ exam.author == session.currentUser }">
				<input type="button" value="See Result">
			</c:if>
			<c:if test="${ exam.author != session.currentUser }">
				<a href="<c:url value="/exam/take.do?id=${ exam.id }"/>"><input type="button" value="Take Exam"></a>
			</c:if>

			<br />
		</c:forEach>
	</fieldset>
	<a href="<c:url value="/exam/create.do"/>"><input type="button" value="Create Exam"/></a>
</body>
</html>