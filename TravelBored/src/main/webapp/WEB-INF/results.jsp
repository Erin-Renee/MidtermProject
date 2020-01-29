<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>	
  	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
  	<link rel="stylesheet" href="css/profileStyle.css">
	<link rel="stylesheet" href="css/resultsStyle.css">
	<script src="javascript/resultsScript.js"></script>
	 <meta http-equiv="X-UA-Compatible" content="ie=edge">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>

<div class="container-fluid">
    <div class="row content">
      <div class="col-sm-2 blank-sidenav">
      
      </div>
      <div class="col-sm-2 sidenav">
        <h4>Search</h4>
        <ul class="sidenav nav-pills nav-stacked">
          <li class="active"><button onclick="showSection(1)">Events</button></li>
          <li><button onclick="showSection(2)">Users</button></li>
          <li><button onclick="showSection(3)">Groups</button></li>
        </ul><br>
      </div>
<div class="col-sm-10">
      <div id="section1">
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
      	</div>
      	<div id="section2">
       <div class="container">
			<c:forEach var="user" items="${userList}">
			<a class="event-item" href="gotoUser.do?userId=${user.id}">
		<div class="card">
    		<div class="poster"><img src = "${user.userImgUrl}"></div>
    		<div class="details">
      		<h2>${user.username}<br></h2>
      			<div class="info">
       				 <p>${user.firstName}</p>
      			</div>
   		 </div>
  	</div>
      
	</a>
	
			</c:forEach>
				</div>
      	</div>
      	<div id="section3">
       <div class="container">
			<c:forEach var="group" items="${groupList}">
			<a class="event-item" href="gotoGroup.do?groupId=${group.id}">
		<div class="card">
    		<div class="poster"><img src = "imgs/switzerland.JPG"></div>
    		<div class="details">
      		<h2>${gruop.title}<br></h2>
      			<div class="info">
       				 <p>${group.hook}</p>
      			</div>
   		 </div>
  	</div>
      
	</a>
	
			</c:forEach>
				</div>
      	</div>
      </div>
    </div>
 </div>
      

</body>
</html>
