<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/crupdateeventStyle.css">
  </head>
<body>

<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<jsp:include page="subPages/createEvent.jsp"></jsp:include>
<jsp:include page="subPages/updateEvent.jsp"></jsp:include>
</body>
</html>
