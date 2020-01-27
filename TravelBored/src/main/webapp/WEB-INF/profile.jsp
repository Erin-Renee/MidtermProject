<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <title>Profile Settings</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2019.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {
      height: 1500px
    }

    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #0000;
      height: 90vh;
      position: fixed;
      z-index: 2;
      top: 10vh;
      left: 0;
    }

    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }

      .row.content {
        height: auto;
      }
    }
  </style>
  <style>
    body {
      background-image:
        linear-gradient(to bottom, rgba(245, 246, 252, 0.52), rgba(30, 19, 30, 0.73)),
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

    .w3-card-4 {
      background-color: #ffffff77;
      border-radius: 20px;
      padding: 20px;
      margin: 250px;
      margin-top: 0px;
    }

    .w3-input {
      background-color: #ffffff88;
      border: 0px;
      border-radius: 0px;
      border-bottom: 2px;
      border-color: #888888;
      border-style: solid;
    }

    .w3-container {
      border-radius: 10px 10px 0px 0px;
      padding: 5px;
    }
    #rsvpTable {
      background-color: #ffffff77;
      border-radius: 20px;
      padding: 20px;
      margin: auto;
      margin-top: 0px;
      table-layout: auto;
      width: 90%;  
    }
    #rsvpTable tr:hover {
      border-radius: 20px;
    }
    #section2 {
    display: none;
    }
    #section3 {
    display: none;
    }
    #section4 {
    display: none;
    }
    #section5 {
    display: none;
    }
  </style>
  <script>
  function showHome() {
	  var home = document.getElementById("section1");
	  var profileSettings = document.getElementById("section2");
	  var events = document.getElementById("section3");
	  var groups = document.getElementById("section4");
	  var photos = document.getElementById("section5");
	  
	 home.style.display = "block";
	 profileSettings.style.display = "none";
	 events.style.display = "none";
	 groups.style.display = "none";
	 photos.style.display = "none";
  }
  function showSettings() {
	  var home = document.getElementById("section1");
	  var profileSettings = document.getElementById("section2");
	  var events = document.getElementById("section3");
	  var groups = document.getElementById("section4");
	  var photos = document.getElementById("section5");
	  
	 home.style.display = "none";
	 profileSettings.style.display = "block";
	 events.style.display = "none";
	 groups.style.display = "none";
	 photos.style.display = "none";
  }
  function showEvents() {
	  var home = document.getElementById("section1");
	  var profileSettings = document.getElementById("section2");
	  var events = document.getElementById("section3");
	  var groups = document.getElementById("section4");
	  var photos = document.getElementById("section5");
	  
	 home.style.display = "none";
	 profileSettings.style.display = "none";
	 events.style.display = "block";
	 groups.style.display = "none";
	 photos.style.display = "none";
  }
  function showGroups() {
	  var home = document.getElementById("section1");
	  var profileSettings = document.getElementById("section2");
	  var events = document.getElementById("section3");
	  var groups = document.getElementById("section4");
	  var photos = document.getElementById("section5");
	  
	 home.style.display = "none";
	 profileSettings.style.display = "none";
	 events.style.display = "none";
	 groups.style.display = "block";
	 photos.style.display = "none";
  }
  function showPhotos() {
	  var home = document.getElementById("section1");
	  var profileSettings = document.getElementById("section2");
	  var events = document.getElementById("section3");
	  var groups = document.getElementById("section4");
	  var photos = document.getElementById("section5");
	  
	 home.style.display = "none";
	 profileSettings.style.display = "none";
	 events.style.display = "none";
	 groups.style.display = "none";
	 photos.style.display = "block";
  }
  </script>
</head>
<header>
  <jsp:include page="subPages/header.jsp"></jsp:include>
</header>

<body>

  <div class="container-fluid">
    <div class="row content">
      <div class="col-sm-2" style="background-color: #111; height: 100%; z-index: 1">
      
      </div>
      <div class="col-sm-2 sidenav">
        <h4>${sessionScope.loggedInUser.username}</h4>
        <ul class="nav nav-pills nav-stacked">
          <li class="active"><button onclick="showHome()">Home</button></li>
          <li><button onclick="showSettings()">Profile Settings</button></li>
          <li><button onclick="showEvents()">Events</button></li>
          <li><button onclick="showGroups()">Groups</button></li>
          <li><button onclick="showPhotos()">Photos</button></li>
        </ul><br>
      </div>
    <div class="col-sm-10">
      <div  id="section1">
        <h4><small>RECENT EVENTS</small></h4>
                <h2>Event Page</h2>
        <table class="table table-hover" id="rsvpTable">
          <thead>
            <tr>
              <th>Event</th>
              <th>Date</th>
              <th>RSVP</th>
            </tr>
          </thead>
          <tbody>

            <c:forEach var="uEvent" items="${sessionScope.loggedInUser.userEvents}">
              <tr>
                <td>${uEvent.event.title}</td>
                <td><span class="glyphicon glyphicon-time"></span> ${uEvent.event.createDate }</td>
                <td>Button</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>

      <br><br>
      <div id="section2" class="w3-card-4">
        <div>
          <div class="w3-container w3-2019-eden">
            <h2>Update Account Information</h2>
          </div>
          <form action="/action_page.php" class="needs-validation" novalidate>
            <div class="form-group">
              <label for="screenName">Screen Name:</label>
              <input type="text" class="w3-input form-control" id="screenName" placeholder="Enter screen name" name="screenName" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="firstName">First Name:</label>
              <input type="text" class="w3-input form-control" id="firstName" placeholder="Enter first name" name="firstName" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="lastName">First Name:</label>
              <input type="text" class="w3-input form-control" id="lastName" placeholder="Enter last name" name="lastName" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="email">Email:</label>
              <input type="text" class="w3-input form-control" id="email" placeholder="Enter email" name="email" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="form-group">
              <label for="password">Password:</label>
              <input type="password" class="w3-input form-control" id="password" placeholder="Enter password" name="passwordd" required>
              <div class="valid-feedback">Valid.</div>
              <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
          </form>

        </div>

        <script>
          // Disable form submissions if there are invalid fields
          (function() {
            'use strict';
            window.addEventListener('load', function() {
              // Get the forms we want to add validation styles to
              var forms = document.getElementsByClassName('needs-validation');
              // Loop over them and prevent submission
              var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                  if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                  }
                  form.classList.add('was-validated');
                }, false);
              });
            }, false);
          })();
        </script>
      </div>
      <div id="section3">

      </div>
      <div id="section4">
        <p>hello</p>
      </div>
      <div id="section5">
        <p>hello</p>
      </div>
    </div>
   </div>
  </div>



</body>

</html>