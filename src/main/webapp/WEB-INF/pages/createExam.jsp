<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/style.css" />
<title>Create a new Exam</title>
</head>
<body>
	<form method="post" action="./createExam.do">
		<table>
			<tr>
				<td><label for="title">Title</label></td>
				<td><input id="title" name="title" type="text"
					value="${ exam.title }" /></td>
			</tr>
			<tr>
				<td><label for="date">Start date</label></td>
				<td><input id="date" name="date" type="text"
					value="${ exam.startDate }" /></td>
			</tr>
			<tr>
				<td><label for="addQuestion">Your exam have
						${exam.getNbQuestion()} question(s).</label></td>
				<td><input id="addQuestion" name="addQuestion" type="submit"
					value="Add Question" /></td>
			</tr>
			<tr>
				<td><input id="submitExam" name="submitExam" type="submit"
					value="Publish Exam" /></td>
			</tr>
		</table>
	</form>
</body>
</html>