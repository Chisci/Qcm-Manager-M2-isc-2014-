<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Take the exam</title>
</head>
<body>
	<h1>Questionnaire : ${session.exam.title}</h1>
	<form method="post">
		<fieldset>
			<c:forEach items="${session.questions}" var="question">
				<fieldset>
					<legend>Question : ${question.text}</legend>
					<c:forEach items="${question.getAnswers()}" var="answer">
						<label for="${ answer.myID }">${answer.text}</label>
						<input id="${ answer.myID }" type="checkbox" name="${ answer.myID }" />
						<br />
					</c:forEach>
				</fieldset>
			</c:forEach>
		</fieldset>
		<input id="examDone" name="examDone" type="submit" value="Done"
			class="sansLabel" />
	</form>
</body>
</html>