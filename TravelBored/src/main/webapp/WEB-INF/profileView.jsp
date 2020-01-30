<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/eventStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<div class="body">


<div class="card-container">
  <div class="card u-clearfix">
    <div class="card-body">
      <h2 class="card-title">${sessionScope.loggedInUser.username}</h2>
      <div class="card-read">   </div>
      <br>
      <br>
      <div class="upperContent">
	<p>First Name: ${sessionScope.loggedInUser.firstName}</p>
	<br>
	<p>Last Name: ${sessionScope.loggedInUser.lastName}</p>
	<br>
	<p>E-mail: ${sessionScope.loggedInUser.email}</p>
	<br>
</div>
    </div>
 <%--    <img src="${sessionScope.loggedInUser.userDetails.userDetailUrl }" alt="" class="card-media" /> --%>
  </div>
  <div class="card-shadow"></div>
</div>


</div>
</body>
</html>