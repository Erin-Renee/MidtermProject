<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/profileStyle.css">
	<script src="javascript/profileScript.js"></script>
</head>
<header>
  <jsp:include page="subPages/header.jsp"></jsp:include>
</header>

<body>

<div id="overlay">

<div class="update-event-class w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Update Event</h2>
          </div>
          <form action="updateEvent.do" class="needs-validation" novalidate method="POST">
          <input id="updateId" type="hidden" name="id" value="${event.id }">
            <div class="form-group">
              <label for="title">Title:</label>
              <input type="text" class="w3-input form-control" id="updateTitle" placeholder="Enter title"   name="title" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="hook">Hook:</label>
              <input type="text" class="w3-input form-control" id="updateHook" placeholder="Enter hook"  name="hook" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="description">Description:</label>
              <input type="text" class="w3-input form-control" id="updateDescription" placeholder="Enter description"  name="description">
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="eventDate">Event Date:</label>
              <input type="date" class="w3-input form-control" id="updateDate" placeholder="Enter event date" name="eventDate" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="time">Time:</label>
              <input type="time" class="w3-input form-control" id="updateTime" placeholder="Enter time" name="eventTime" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="imgUrl">Photo URL:</label>
              <input type="url" class="w3-input form-control" id="updateImgUrl" placeholder="Enter photo URL" name="imgUrl" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="eventUrl">Event URL:</label>
              <input type="url" class="w3-input form-control" id="updateEventUrl" placeholder="Enter event URL" name="eventUrl">
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
            	<label for="location">Location:</label>
           	 	<select name="locationId" >
					<option id="locId" selected value="${sessionScope.loggedInUser.location.id}" ></option>
						<c:forEach var="location" items="${locations}">
							<option value="${location.id}" >${location.city} ${location.zipCode }</option>
						</c:forEach>
				</select>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
          </form>
          <button onclick="hideOverlay()" id="close-button">X</button>

        </div>
      </div>



</div>



  <div class="container-fluid">
    <div class="row content">
      <div class="col-sm-2 blank-sidenav">
      
      </div>
      <div class="col-sm-2 sidenav">
        <h4>${sessionScope.loggedInUser.username}</h4>
        <ul class="sidenav nav-pills nav-stacked">
          <li class="active"><button onclick="showHome()">Home</button></li>
          <li><button onclick="showSettings()">Profile Settings</button></li>
          <li><button onclick="showEvents()">Events</button></li>
          <li><button onclick="showGroups()">Groups</button></li>
          <li><button onclick="showPhotos()">Photos</button></li>
        </ul><br>
      </div>
    <div class="col-sm-10">
      <div  id="section1">
        <h4><small>RECENT EVENTS</small></h4>
                <h2>Event Page</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Event</th>
              <th>Date</th>
              <th>RSVP</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="event" items="${eventList}">
              <tr>
                <td>${event.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${event.createDate }</td>
                <td >Button</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>

      <br><br>
      <div id="section2" class="w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Update Account Information</h2>
          </div>
          <form action="updateProfile.do" class="needs-validation" novalidate method="POST">
            <div class="form-group">
              <label for="username">Screen Name:</label>
              <input type="text" class="w3-input form-control" id="username" placeholder="Enter screen name" value="${sessionScope.loggedInUser.username }"  name="username" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="firstName">First Name:</label>
              <input type="text" class="w3-input form-control" id="firstName" placeholder="Enter first name" value="${sessionScope.loggedInUser.firstName }" name="firstName" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="lastName">Last Name:</label>
              <input type="text" class="w3-input form-control" id="lastName" placeholder="Enter last name" value="${sessionScope.loggedInUser.lastName }" name="lastName" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
            	<label for="location">Location:</label>
           	 	<select name="locationId" required>
					<option selected value="${sessionScope.loggedInUser.location.id}" >${sessionScope.loggedInUser.location.city} ${sessionScope.loggedInUser.location.zipCode }</option>
					<c:forEach var="location" items="${locations}">
						<c:if test="${location.id !=  sessionScope.loggedInUser.location.id}">
							<option value="${location.id}" >${location.city} ${location.zipCode }</option>
						</c:if>
					</c:forEach>
				</select>
            </div>
            <div class="form-group">
              <label for="email">Email:</label>
              <input type="text" class="w3-input form-control" id="email" placeholder="Enter email" value="${sessionScope.loggedInUser.email }" name="email" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="password">Password:</label>
              <input type="password" class="w3-input form-control" id="password" placeholder="Enter password" name="password" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
          </form>

        </div>
      </div>
      <div id="section3">
       <h4><small>MY EVENTS</small></h4>
                <h2>Creator</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Event</th>
              <th>Date</th>
              <th>Update</th>
            </tr>
          </thead>
          <tbody id="event-update-table">

            <c:forEach var="event" items="${creatorEvents}">
              <tr class="event-row">
                <td>${event.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${event.createDate }</td>
                <%-- <input type="hidden" value="${event }" name = "event"> --%>
                <td><button onclick="showOverlay('${event.id}','${event.title }', '${event.hook }', '${event.description}', '${event.eventDate}', '${event.eventTime}', '${event.imgUrl}', '${event.eventUrl}', '${event.location.id}', '${event.location.city}', '${event.location.zipCode}')">Update</button></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div id="section4">
        <p>hello</p>
      </div>
      <div id="section5">
        <p>hello</p>
      </div>
    </div>
   </div>
  </div>



</body>

</html>