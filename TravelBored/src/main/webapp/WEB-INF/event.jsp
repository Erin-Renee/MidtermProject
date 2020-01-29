<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/eventStyle.css">
     <style>
     .hero:before {
  content: '';
  width: 100%;
  height: 100%;
  position: absolute;
  overflow: hidden;
  top: 0;
  left: 0;
  background: red;
  background: url(${event.imgUrl});
      background-repeat: no-repeat;
    background-position: top;
    background-size: cover;
  z-index: -1;
  -webkit-transform: skewY(-2.2deg);
          transform: skewY(-2.2deg);
  -webkit-transform-origin: 0 0;
          transform-origin: 0 0;
  -webkit-backface-visibility: hidden;
}
     </style>   
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


<div class="movie-card">
  
  <div class="container">
    
    <div class="hero" >
            
      <div class="details">
      
        <div class="title1">${event.title }</div>

        <div class="title2">${event.hook }</div> 
      
        
      </div> <!-- end details -->
      
    </div> <!-- end hero -->
    
    <div class="description">
   
      <div class="column2">
        
        <p>${event.description}</p>
        
      </div> <!-- end column2 -->
    </div> <!-- end description -->
    
   
  </div> <!-- end container -->
</div> <!-- end movie-card -->



</div>
</body>
</html>
