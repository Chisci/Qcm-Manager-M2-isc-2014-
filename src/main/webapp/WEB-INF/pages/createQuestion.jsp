<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Create Question</title>
</head>
<body>
	<form method="post">
		<fieldset>
		<legend>Create Question</legend>

				<label for="question">Question :</label>
				<input id="question" name="question" type="text" />
				<br/>
			
				<label for="answer1">Answer 1 :</label>
				<input id="answer1" name="answer1" type="text" />
				<input id="answer1" name="answer1check" type="checkbox">
				<br/>
			
				<label for="answer2">Answer 2 :</label>
				<input id="answer2" name="answer2" type="text" />
				<input id="answer2" name="answer2check" type="checkbox">
			<br/>
			
				<label for="answer3">Answer 3 :</label>
				<input id="answer3" name="answer3" type="text" />
				<input id="answer3" type="checkbox">
			<br/>
			
				<label for="answer4">Answer 4 :</label>
				<input id="answer4" name="answer4" type="text" />
				<input id="answer4" type="checkbox">
			<br/>
			
				<a href="<c:url value="/exam/create.do"/>"><input type="button" value="Cancel" /></a>
				<input type="submit" name="submitQuestion" value="Submit Question">
			
		</fieldset>

	</form>
</body>
</html>