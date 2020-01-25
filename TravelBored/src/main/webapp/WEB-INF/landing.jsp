<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>

<style>
  body {
  background: #222
          url('imgs/switzerland.JPG')
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
  <!-- anon user -->
  <div class="w3-bar w3-blue">
      <form action="gotolanding.do" method="post">
      <button class="w3-bar-item w3-button"type="submit" name="home">Home</button>
      </form>
      <form action="search.do" method="post">
        <input class="w3-bar-item w3-input" type="text" name="" placeholder="search...">
      <button class="w3-bar-item w3-button"type="submit" name="home">search</button>
      </form>
      <form action="login.do" method="post">
      <button class="w3-bar-item w3-button w3-right"type="submit" name="home">login</button>
      </form>
  </div>
<!-- user -->
  <div class="w3-bar w3-red">
      <form action="gotohome.do" method="post">
      <button class="w3-bar-item w3-button"type="submit" name="home">Home</button>
      </form>
      <form action="gotoCrUpdate.do" method="post">
      <button class="w3-bar-item w3-button"type="submit" name="home">Create Event</button>
      </form>
      <form action="search.do" method="post">
        <input class="w3-bar-item w3-input" type="text" name="" placeholder="search...">
      <button class="w3-bar-item w3-button"type="submit" name="home">search</button>
      </form>
      <form action="profile.do" method="post">
      <button class="w3-bar-item w3-button w3-right"type="submit" name="home">User Profile</button>
      </form>
      <form action="logout.do" method="post">
      <button class="w3-bar-item w3-button w3-right"type="submit" name="home">logout</button>
      </form>
  </div>


</body>
</html>
