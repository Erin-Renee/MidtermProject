<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/registerStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
  <div>
    <form action="register.do" method="post">
      <label for="username">Screen Name:</label>
      <input type="text" name="username"> <br>
      <label for="firstName">First Name:</label>
      <input type="text" name="firstName"> <br>
      <label for="lastName">Last Name:</label>
      <input type="text" name="lastName"> <br>

      <label for="email">Email:</label>
      <input type="email" name="email"> <br>
      
      <label for="password">Password:</label>
      <input type="password" name="password"><br>
   <!--    <label for="passwordConfimation">Confirm Password:</label>
      <input type="password" name="password"><br> -->
      
      <button type="submit" name="submit">Sign Up</button>
    </form>
  </div>
</body>
</html>
