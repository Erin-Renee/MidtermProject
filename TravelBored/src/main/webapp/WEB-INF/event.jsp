<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/eventStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<div class="body">
<br>

<div class="event-title">
<h1> ${event.title}</h1>
</div>
<br>

<div class="upperContent">
<p>City: ${event.location.city}</p>
<br>
<p>Date: ${event.eventDate}</p>
<br>
<p>Time: ${event.eventTime}</p>
<br>
<c:if test="${!empty sessionScope.loggedInUser }">
<h4>RSVP</h4>
<br>
<span>
<label class="switch">
  <input type="checkbox" checked>
  <span class="slider round"></span>
</label>
</span>
</c:if>
</div>


<div class="event-img">
<img src="${event.imgUrl }"  style="width: 450px; height: 300px;">
</div>
<br>



<div class="description">
<p class="hook">${event.hook}</p>
<br>
<br>
<p>Description: ${event.description}</p>
<br>
<br>
<br>
<p>Create Date/Time: ${event.createDate}</p>

</div>



</div>
</body>
</html>
