<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>

<style>
  body {
  background: #222
          url('imgs/switzerland.jpg')
          center center no-repeat;
      min-height: 100vh;
      width: 100%;
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
    <title>Tavel Bored</title>


<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
crossorigin="anonymous">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<h1>${event.title}</h1>
</body>
</html>
