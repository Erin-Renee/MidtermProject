<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<script src="javascript/profileScript.js"></script>
	<link rel="stylesheet" href="css/registerStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
 
  <div class="w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Register</h2>
          </div>
          <form action="register.do" class="needs-validation" novalidate method="POST">
          <input id="updateId" type="hidden" name="id" value="${user.id }">
            <div class="form-group">
              <label for="username">Screen Name:</label>
              <input type="text" class="w3-input form-control" id="username" placeholder="Enter screen name"   name="username" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="firstName">First Name:</label>
              <input type="text" class="w3-input form-control" id="firstName" placeholder="Enter first name"   name="firstName" >
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="lastName">Last Name:</label>
              <input type="text" class="w3-input form-control" id="lastName" placeholder="Enter last name"  name="lastName" >
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="email">Email:</label>
              <input type="email" class="w3-input form-control" id="email" placeholder="Enter email"  name="email" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="password">Password:</label>
              <input type="password" class="w3-input form-control" id="password" placeholder="Enter password" name="password" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
            	<label for="location">Location:</label>
           	 	<select name="locationId" required>
					
					<c:forEach var="location" items="${locations}">
						
							<option value="${location.id}" >${location.city} ${location.zipCode }</option>
						
					</c:forEach>
				</select>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
          </form>

        </div>
      </div>
</body>
</html>
