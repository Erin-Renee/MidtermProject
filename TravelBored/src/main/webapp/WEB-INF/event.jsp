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


<div class="card-container">
  <div class="card u-clearfix">
    <div class="card-body">
      <h2 class="card-title">${event.title}</h2>
      <span class="card-description subtle">${event.hook}</span>
      <div class="card-read">   </div>
      <div class="card-read:after">${event.description }</div>
      <br>
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
	
	<form class="rsvpButton" action="attend.do" method="POST">
	<button class="attend" type="submit">Attend</button>
	<input type="hidden" value="${event.id}" name="eventId">
	</form>
	
	<form class="rsvpButton" action="unattend.do" method="POST">
	<button class="unattend" type="submit">unAttend</button>
	<input type="hidden" value="${event.id}" name="eventId">
	</form>
	
</c:if>
</div>
    </div>
    <img src="${event.imgUrl }" alt="" class="card-media" />
  </div>
  <div class="card-shadow"></div>
</div>


</div>
</body>
</html>
