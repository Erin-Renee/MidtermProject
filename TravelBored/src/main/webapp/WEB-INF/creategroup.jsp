<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/crupdateeventStyle.css">
	<script src="javascript/profileScript.js"></script>
  </head>
<body>

<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>

      <div class="w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Create Event</h2>
          </div>
          <form action="createEvent.do" class="needs-validation" novalidate method="POST">
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
           	 	<select name="locationId" required>
					<option selected value="${sessionScope.loggedInUser.location.id}">${sessionScope.loggedInUser.location.city} ${sessionScope.loggedInUser.location.zipCode }</option>
					<c:forEach var="location" items="${locations}">
						<c:if test="${location.id !=  sessionScope.loggedInUser.location.id}">
							<option value="${location.id}" >${location.city} ${location.zipCode }</option>
						</c:if>
					</c:forEach>
				</select>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
          </form>

        </div>
      </div>
</body>
</html>
