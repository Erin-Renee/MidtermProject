<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/crupdateeventStyle.css">
	<script src="javascript/profileScript.js"></script>
  </head>
<body>

<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>

      <div class="w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Create Group</h2>
          </div>
          <form action="createGroup.do" class="needs-validation" novalidate method="POST">
            <div class="form-group">
              <label for="title">Title:</label>
              <input type="text" class="w3-input form-control" id="updateTitle" placeholder="Enter title"   name="title" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="hook">Hook:</label>
              <input type="text" class="w3-input form-control" id="updateHook" placeholder="Enter hook"  name="hook" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
          </form>

        </div>
      </div>
</body>
</html>
