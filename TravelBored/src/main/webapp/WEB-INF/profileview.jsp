<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/profileviewStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<div class="body">


<div class="card-container">
  <div class="card u-clearfix">
    <img src="${user.userImgUrl }" alt="" class="card-media" />
    <div class="card-body">
      <h2 class="card-title">${user.username}</h2>
      <div class="card-read">   </div>
      <div class="card-read:after">
      <c:forEach var="detail" items="${user.userDetails}">
      <h3> <a href="${detail.userDetailUrl}">${detail.userDetailName}:</a></h3>
      <p>${detail.userDetailDescription }</p>
      </c:forEach>
      </div>
    </div>
    <div>
     <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Event</th>
              <th>Hook</th>
            </tr>
          </thead>
          <tbody id="event-update-table">

            <c:forEach var="userEvent" items="${userEvents}">
              <tr class="event-row">
                <td><a href="gotoEvent.do?eventId=${userEvent.event.id }">${userEvent.event.title}</a></td>
                <td>${userEvent.event.hook }</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
   <div>
   <br><br>
     <table class="table table-hover eventTable">
          <thead>
            <tr>
              <th>Group</th>
              <th>Comment</th>
            </tr>
          </thead>
          <tbody id="event-update-table">
          <c:set var = "groupId" value="0"/> 
            <c:forEach var="comment" items="${groupComments}">
            <c:choose>
            <c:when test="${groupId != comment.group.id}">
              <tr class="event-row">
                <td><a href="gotoGroup.do?groupId=${comment.group.id }">${comment.group.title}</a></td>
                <td>${comment.content}</td>
              </tr>
            </c:when>
            <c:otherwise>
            <tr class="event-row">
                <td>&emsp; ^</td>
                <td>${comment.content}</td>
              </tr>
            </c:otherwise>
            </c:choose>
              <c:set var = "groupId" value="${comment.group.id }"/> 
            </c:forEach>
          </tbody>
        </table>
    </div>
  </div>
  </div>
  <div class="card-shadow"></div>
</div>


</div>
</body>
</html>
