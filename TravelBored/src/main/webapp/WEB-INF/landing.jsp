<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/landingStyle.css">
	<script src="javascript/profileScript.js"></script>
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
      <div class="w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Login:</h2>
          </div>
          <form action="login.do" class="needs-validation" novalidate method="POST">
          <input id="updateId" type="hidden" name="id" value="${event.id }">
            <div class="form-group">
              <label for="title">E-mail:</label>
              <input type="email" class="w3-input form-control" id="email" placeholder="Email"   name="email" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="hook">Password:</label>
              <input type="password" class="w3-input form-control" id="password" placeholder="Password"  name="password" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
    
            <button type="submit" class="btn btn-primary">Login</button>
          </form>
          <form action="gotoRegister.do" method="get">
      		<button type="submit" name="submit">Sign Up</button>
    	  </form>
        </div>
      </div>
  	
</body>
</html>
