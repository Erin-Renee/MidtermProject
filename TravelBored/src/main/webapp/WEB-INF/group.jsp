<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/groupStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<div class="body">


<div class="card-container">
  <div class="card u-clearfix">
    <div class="card-body">
      <h2 class="card-title">${group.title}</h2>
      <div class="card-read">   </div>
      <div class="upperContent">
</div>
    </div>

<h2>${group.title }</h2>
<h5><span >Owner: </span> ${group.user.username}</h5>
<p>${group.hook}</p>
<hr>

<h4>Let's Discuss:</h4>
<form role="form" action="createGroupComment.do" method="POST">
  <div class="form-group">
    <textarea class="form-control" rows="3" name="comment" required></textarea>
  </div>
  <input type="hidden" value="${group.id}" name="groupId">
  <button type="submit" class="btn btn-success">Submit</button>
</form>
<br><br>

<p><span class="badge">${commentList.size()}</span> Posts:</p><br>

<div class="row">

<c:forEach var="comment" items="${commentList}">
  <div class="col-sm-2 text-center">
    <img src="${comment.user.userImgUrl}" class="img-circle" height="65" width="65" alt="Avatar">
  </div>
  <div class="col-sm-10">
    <h4><a href="gotoUser.do?userId=${comment.user.id}">${comment.user.username}</a> <small>${comment.createDate}</small></h4>
    <p>${comment.content}</p>
    <br>
  </div>
  </c:forEach>
  
  
  </div>
  </div>
  <div class="card-shadow"></div>
</div>


</div>
</body>
</html>
