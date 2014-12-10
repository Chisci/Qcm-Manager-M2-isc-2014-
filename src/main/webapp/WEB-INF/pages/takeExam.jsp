<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Question</title>
</head>
<body>
<center>
<h1>Passer un examen</h1>
<c:forEach items="${takingExamBean.getExam}" var="offerWithCharges">
    <c:forEach items="${offerWithCharges}" var="charge">
        <td><tr></tr></td>
    </c:forEach>
</c:forEach>
</body>
</html>