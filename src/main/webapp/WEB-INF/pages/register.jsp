<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Sign-in</title>
</head>
<body>
	Tu peux créer ton compte ici, lache ton com sur mon skyblog :
	<form name='RegisterForm' TODO : action="<c:url value='HOME' />"
		method='POST'>
		<fieldset>
			<label>User:</label> <input type='text' name='j_username' value=''>
			<br /> <label>Password:</label> <input type='password'
				name='j_password' /> <br /> <input name="submit" type="submit"
				value="submit" />
		</fieldset>
	</form>
</body>
</html>