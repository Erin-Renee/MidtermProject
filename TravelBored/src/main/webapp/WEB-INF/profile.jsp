<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>

<style>
  body {
  background-image:
  linear-gradient(to bottom,rgba(245,246,252,0.52),rgba(30,19,30,0.73)),
          url('imgs/switzerland.JPG');
      min-height: 100%;
      width: 100%;
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: center;
      background-size: cover;
}
  #cover {
      text-align: center;
      display: flex;
      align-items: center;
      position: relative;
}

</style>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Travel Bored</title>


<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
crossorigin="anonymous">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
	<div>
    <form action="updateProfile.do" method="post">
        <input type="hidden" name="userId" value="${sessionScope.loggedInUser.id}">
      <label for="username">Screen Name:</label>
      <input type="text" name="username" value="${sessionScope.loggedInUser.username}"> <br>
      <label for="firstName">First Name:</label>
      <input type="text" name="firstName" value="${sessionScope.loggedInUser.firstName}"> <br>
      <label for="lastName">Last Name:</label>
      <input type="text" name="lastName" value="${sessionScope.loggedInUser.lastName}"> <br>

      <label for="email">Email:</label>
      <input type="email" name="email" value="${sessionScope.loggedInUser.email}"> <br>

      <label for="password">Password:</label>
      <input type="text" name="password" value="${sessionScope.loggedInUser.password}"><br>

      <label for="location">location:</label>
      <jsp:include page="subPages/locationDropDown.jsp"></jsp:include><br>

      <button type="submit" name="submit">edit Profile</button>
    </form>
  </div>


</body>
</html>
