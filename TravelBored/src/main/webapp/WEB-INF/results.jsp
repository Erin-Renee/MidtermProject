<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>	
  	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/resultsStyle.css">
	 <meta http-equiv="X-UA-Compatible" content="ie=edge">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>

<div class="container">
<c:forEach var="event" items="${eventList}">
	
	
	<a class="event-item" href="gotoEvent.do?eventId=${event.id}">
<div class="card">
    <div class="poster"><img src = "${event.imgUrl}"></div>
    <div class="details">
      <h2>${event.title}<br></h2>

     


      <div class="info">
        <p>${event.hook}</p>
      </div>

     
    </div>
  </div>
      
	</a>
	
</c:forEach>
</div>

</body>
</html>
