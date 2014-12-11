<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Create a new Exam</title>
</head>
<body>
	<form method="post">
		<fieldset>
			<legend>Create Exam</legend>
			<p>You could create a new Exam thanks to this formulaire</p>

			<label for="title">Title</label> <input id="title" name="title"
				type="text" value="${ exam.title }" size="30" /> <br /> <label
				for="date">Start date</label> <input id="date" name="date"
				type="text" value="${ exam.getSimpleDate() }" size="30" /> <br />
			<label for="addQuestion">Your exam has ${session.questions.size()} question(s).</label> 
			<a href="<c:url value="/question/create.do"/>">Manage questions</a>
			<br />
			<br /> 
			<a href="<c:url value="/exam/take.do"/>"><input type="button" value="Take" /></a>
			<input id="submitExam" name="submitExam" type="submit" value="Save Exam" class="sansLabel" />
		</fieldset>
	</form>
</body>
</html>