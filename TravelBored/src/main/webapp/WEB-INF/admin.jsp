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

 <div class="container-fluid">
    <div class="row content">
      <div class="col-sm-2 blank-sidenav">
      
      </div>
      <div class="col-sm-2 sidenav">
        <h4>${sessionScope.loggedInUser.username}</h4>
        <ul class="nav nav-pills nav-stacked">
          <li class="active"><button onclick="showHome()">Home</button></li>
          <li><button onclick="showSettings()">Profile Settings</button></li>
          <li><button onclick="showEvents()">Activated Users</button></li>
          <li><button onclick="showGroups()">Groups</button></li>
          <li><button onclick="showPhotos()">Photos</button></li>
        </ul><br>
      </div>
      <div id="section1">
      </div>
      <div id="section2">
      </div>
      
<div class="col-sm-10">
 <div id="section3">
       <h4><small>Activated Users</small></h4>
                <h2>Admin</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>User</th>
              <th>Created Date</th>
              <th>Deactivate</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="user" items="${activeUsers}">
              <tr>
                <td>${user.username}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${user.createDate }</td>
                <td><button onclick="showOverlay()">Update</button></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      </div>
      <div id="section4">
      </div>
      <div id="section5">
      </div>
      </div>
      </div>

</body>
</html>