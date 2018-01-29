<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Linkedin Profile Details</title>
</head>
<body>
	<c:forEach items="${peoples}" var="people">
${people.id}
${people.name}
${people.experience}
${people.education}
${people.profile}
${people.url}
${people.isactve}
</c:forEach>
</body>
</html>