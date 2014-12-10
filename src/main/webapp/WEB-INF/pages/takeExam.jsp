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
	<h1>Questionnaire : ${session.getQuestions()}</h1>
	<form method="post" action="./examFinish.do">
		<table style="width: 333px;">
        <tr>
            <th>Questions</th>
            <th>Reponses</th>
        </tr>
        <c:forEach items="${session.getQuestions()}" var="question">
        	<h4>${question.getText()}</h4>
        	<c:forEach items="${question.getAnswers()}" var="answer">
				<tr>
					<td>${answer.getText()} <input type="checkbox" name="test" /></td>
				</tr>
			</c:forEach>
        </c:forEach>
    </table>

	</form>
</body>
</html>