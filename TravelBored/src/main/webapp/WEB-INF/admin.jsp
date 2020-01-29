<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/profileStyle.css">
	<script src="javascript/adminScript.js"></script>
</head>
<header>
  <jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<body onload="showSection('${sectionNumber}')">

 <div class="container-fluid">
    <div class="row content">
      <div class="col-sm-2 blank-sidenav">
      
      </div>
      <div class="col-sm-2 sidenav">
        <h4>${sessionScope.loggedInUser.username}</h4>
        <ul class="sidenav nav-pills nav-stacked">
          <li class="active"><button onclick="showSection(1)">Activated Events</button></li>
          <li><button onclick="showSection(2)">Deactivated Events</button></li>
          <li><button onclick="showSection(3)">Activated Users</button></li>
          <li><button onclick="showSection(4)">Deactivated Users</button></li>
          <li><button onclick="showSection(5)">Activated Groups</button></li>
          <li><button onclick="showSection(6)">Deactivated Groups</button></li>
        </ul><br>
      </div>
<div class="col-sm-10">
      <div id="section1">
       <h4><small>Activated Events</small></h4>
                <h2>Admin</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Event</th>
              <th>Created Date</th>
              <th>Deactivate</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="event" items="${activeEvents}">
                
              <tr>
                <td>${event.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${event.createDate }</td>
                <td>
                	<form action="deactivateEvent.do" class="needs-validation" novalidate method="POST">
                		<input id="eventId" type="hidden" name="eventId" value="${event.id}">
               			<button >Deactivate</button>
                	</form>
                </td>
                
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div id="section2">
       <h4><small>Deactivated Events</small></h4>
                <h2>Admin</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Event</th>
              <th>Created Date</th>
              <th>Activate</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="event" items="${deactivatedEvents}">
              <tr>
                <td>${event.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${event.createDate }</td>
                <td><form action="activateEvent.do" class="needs-validation" novalidate method="POST">
                		<input id="eventId" type="hidden" name="eventId" value="${event.id}">
               			<button >Activate</button>
                	</form></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      
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
                <td><form action="deactivateUser.do" class="needs-validation" novalidate method="POST">
                		<input id="userId" type="hidden" name="userId" value="${user.id}">
               			<button >Deactivate</button>
                	</form></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div id="section4">
       <h4><small>Deactivated Users</small></h4>
                <h2>Admin</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>User</th>
              <th>Created Date</th>
              <th>Activate</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="user" items="${deactivatedUsers}">
              <tr>
                <td>${user.username}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${user.createDate }</td>
                <td><form action="activateUser.do" class="needs-validation" novalidate method="POST">
                		<input id="userId" type="hidden" name="userId" value="${user.id}">
               			<button >Activate</button>
                	</form></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      
      <div id="section5">
      <h4><small>Activated Groups</small></h4>
                <h2>Admin</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Group</th>
              <th>Created Date</th>
              <th>Deactivate</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="group" items="${activeGroups}">
              <tr>
                <td>${group.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${group.createDate }</td>
                <td><form action="deactivateGroup.do" class="needs-validation" novalidate method="POST">
                		<input id="groupId" type="hidden" name="groupId" value="${group.id}">
               			<button >Deactivate</button>
                	</form></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div id="section6">
      <h4><small>Deactived Groups</small></h4>
                <h2>Admin</h2>
        <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Group</th>
              <th>Created Date</th>
              <th>Activate</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="group" items="${deactivatedGroups}">
              <tr>
                <td>${group.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${group.createDate }</td>
                <td><form action="activateGroup.do" class="needs-validation" novalidate method="POST">
                		<input id="groupId" type="hidden" name="groupId" value="${group.id}">
               			<button >Activate</button>
                	</form></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      </div>
      </div>
      </div>
    

</body>
</html>