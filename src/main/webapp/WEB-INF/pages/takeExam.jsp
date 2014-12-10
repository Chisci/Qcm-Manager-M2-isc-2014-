<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Take the exam</title>
</head>
<body>
<form method="post" action="./examFinish.do">
		<table>
			<tr>
				<td><label for="question">Question :</label></td>
				<td><input id="question" name="question" type="text"/></td>
			</tr>
			<tr>
				<td><label for="answer1">Answer 1 :</label></td>
				<td><input id="answer1" name="answer1" type="text" /></td>
				<td><input id="answer1" type="checkbox"></td>
			</tr>
			<tr>
				<td><label for="answer2">Answer 2 :</label></td>
				<td><input id="answer2" name="answer2" type="text" /></td>
				<td><input id="answer2" type="checkbox"></td>
			</tr>
			<tr>
				<td><label for="answer3">Answer 3 :</label></td>
				<td><label for="answer3">Answer 3</label></td>
				<td><input id="answer3" type="checkbox" value="answer x" name="answer y"></td>
			</tr>
			<tr>
				<td><label for="answer4">Answer 4 :</label></td>
				<td><input id="answer4" name="answer4" type="text" /></td>
				<td><input id="answer4" type="checkbox"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" name="submitQuestion" value="Submit Question"></td>
			</tr>
		</table>

	</form>
</body>
</html>