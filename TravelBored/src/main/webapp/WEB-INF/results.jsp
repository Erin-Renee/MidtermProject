<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>	
  	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/resultsStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>

<div class="container">
<c:forEach var="event" items="${eventList}">
	
	
	<a class="event-item" href="gotoEvent.do?eventId=${event.id}">
      <img class="event-img" src="${event.imgUrl}" alt="">
      <h3 class="event-title">${event.title}</h3>
      <p class="event-hook">${event.hook}</p>
	</a>
	
</c:forEach>
</div>
</body>
</html>
