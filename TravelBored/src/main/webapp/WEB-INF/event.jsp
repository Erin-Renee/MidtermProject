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
    <link rel="stylesheet" href="css/eventStyle.css">
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
</div>


<div class="event-img">
<img src="${event.imgUrl }"  style="width: 450px; height: 300px;">
</div>
<br>


<div class="description">
<p class="hook">${event.hook}</p>
<br>
<br>
<p>Description: ${event.description}</p>
<br>
<br>
<br>
<p>Create Date/Time: ${event.createDate}</p>
</div>



</div>
</body>
</html>
