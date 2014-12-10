<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Take the exam</title>
</head>
<body>
	<h1>Questionnaire : ${session.getExam().getTitle()}</h1>
	<form method="post" action="./examFinish.do">
	<table>
	 <c:forEach items="${session.getQuestions()}" var="question">
		<table style="width: 333px;">
		<c:out value="Question : '${question.getText()}'"></c:out>
        <tr>
            <th>Proposition</th>
            <th>?</th>
        </tr>
        	<c:forEach items="${question.getAnswers()}" var="answer">
				<tr>
					<td>${answer.getText()}</td>
					<td><input type="checkbox" name="test" /></td>
				</tr>
			</c:forEach>
    	</table>
    </c:forEach>
    </table>
	<input id="examDone" name="examDone"
				type="submit" value="Done" class="sansLabel" />
	</form>
</body>
</html>