
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
  
      <!--  logged in ADMIN -->
 <c:if test="${!empty loggedInUser}">
       <c:if test="${loggedInUser.role == 'admin'}">
  <nav class="nav">
        <div class="container-nav">
            <div class="logo">
                <a href="gotoProfile.do">${loggedInUser.username}</a>
            </div>
            <div id="mainListDiv" class="main_list">
                <ul class="navlinks">
                    <li><a href="gotoCreateGroup.do">Create Group</a></li>
                    <li><a href="gotoCrUpdateEvent.do">Create Event</a></li>
                    <li><a href="adminSettings.do">Admin Controls</a></li>
                    <li><a href="logout.do">logout</a></li>
                    <li><div class="search-bar">
                    <form action="search.do" method="get">
        				<input type="text" name="keyword" placeholder="search...">
      					<button type="submit">
      						<svg xmlns="http://www.w3.org/2000/svg" height="512pt" viewBox="0 0 512 512.00049" width="512pt"><path d="m90.742188 180.734375c-5.519532 0-10 4.476563-10 9.996094s4.480468 10 10 10c5.519531 0 10-4.480469 10-10s-4.480469-9.996094-10-9.996094zm0 0"/><path d="m370.921875 300.21875c-1.871094-1.875-4.417969-2.929688-7.070313-2.929688-.101562.019532-3.945312-.195312-7.070312 2.929688l-7.066406 7.066406-22.976563-22.972656c50.703125-71.074219 42.992188-169.117188-19.449219-231.554688-70.335937-70.335937-184.1875-70.347656-254.53125 0-70.335937 70.332032-70.347656 184.1875 0 254.53125 62.285157 62.289063 160.289063 70.28125 231.550782 19.449219l22.976562 22.976563-7.066406 7.066406c-3.902344 3.902344-3.90625 10.238281 0 14.144531l126.421875 126.410157c19.535156 19.546874 51.15625 19.558593 70.695313.003906 19.546874-19.53125 19.554687-51.15625 0-70.695313zm-49.496094 35.355469-21.410156-21.410157c2.488281-2.230468 4.921875-4.519531 7.273437-6.875 2.355469-2.351562 4.644532-4.785156 6.875-7.269531l21.410157 21.410157zm-254.527343-42.425781c-62.523438-62.519532-62.53125-163.722657 0-226.25 62.519531-62.523438 163.722656-62.53125 226.25 0 62.382812 62.378906 62.699218 163.558593 0 226.25-63.40625 63.414062-164.582032 61.671874-226.25 0zm296.953124 28.28125 28.277344 28.28125-42.417968 42.417968-28.28125-28.277344zm119.34375 161.769531c-11.71875 11.730469-30.683593 11.734375-42.410156 0l-76.933594-76.929688 42.417969-42.417969 76.929688 76.9375c11.726562 11.714844 11.738281 30.679688-.003907 42.410157zm0 0"/><path d="m279.011719 81.042969c-54.683594-54.683594-143.273438-54.714844-197.980469-.007813-54.570312 54.582032-54.570312 143.394532 0 197.980469 54.714844 54.710937 143.253906 54.714844 197.972656 0 54.582032-54.585937 54.585938-143.394531.007813-197.972656zm-14.148438 183.828125c-46.894531 46.894531-122.785156 46.90625-169.691406.003906-46.773437-46.789062-46.773437-122.914062 0-169.703125 46.871094-46.867187 122.8125-46.878906 169.699219.011719 46.78125 46.78125 46.777344 122.902344-.007813 169.6875zm0 0"/><path d="m180.023438 80.042969c-26.726563 0-51.835938 10.398437-70.703126 29.277343-10.9375 10.9375-18.988281 23.859376-23.925781 38.414063-1.773437 5.226563 1.023438 10.90625 6.253907 12.679687 5.238281 1.777344 10.910156-1.035156 12.683593-6.253906 3.941407-11.621094 10.378907-21.949218 19.128907-30.703125 15.09375-15.097656 35.179687-23.414062 56.5625-23.414062 5.523437 0 10-4.476563 10-10 0-5.523438-4.476563-10-10-10zm0 0"/></svg>
      					</button>
     				 </form>
     				 </div>
     				 </li>
                </ul>
            </div>
            <span class="navTrigger">
                <i></i>
                <i></i>
                <i></i>
            </span>
        </div>
    </nav>
    </c:if>
    
    <!-- logged in USER -->
         <c:if test="${loggedInUser.role != 'admin'}">
     <nav class="nav">
        <div class="container-nav">
            <div class="logo">
                <a href="gotoProfile.do">${loggedInUser.username}</a>
            </div>
            <div id="mainListDiv" class="main_list">
                <ul class="navlinks">
               <li> <a>Travel Bored</a></li>
                    <li><a href="gotoCreateGroup.do">Create Group</a></li>
                    <li><a href="gotoCrUpdateEvent.do">Create Event</a></li>
                    <li><a href="logout.do">logout</a></li>
                    <li><div class="search-bar">
                    <form action="search.do" method="get">
        				<input type="text" name="keyword" placeholder="search...">
      					<button type="submit">
      						<svg xmlns="http://www.w3.org/2000/svg" height="512pt" viewBox="0 0 512 512.00049" width="512pt"><path d="m90.742188 180.734375c-5.519532 0-10 4.476563-10 9.996094s4.480468 10 10 10c5.519531 0 10-4.480469 10-10s-4.480469-9.996094-10-9.996094zm0 0"/><path d="m370.921875 300.21875c-1.871094-1.875-4.417969-2.929688-7.070313-2.929688-.101562.019532-3.945312-.195312-7.070312 2.929688l-7.066406 7.066406-22.976563-22.972656c50.703125-71.074219 42.992188-169.117188-19.449219-231.554688-70.335937-70.335937-184.1875-70.347656-254.53125 0-70.335937 70.332032-70.347656 184.1875 0 254.53125 62.285157 62.289063 160.289063 70.28125 231.550782 19.449219l22.976562 22.976563-7.066406 7.066406c-3.902344 3.902344-3.90625 10.238281 0 14.144531l126.421875 126.410157c19.535156 19.546874 51.15625 19.558593 70.695313.003906 19.546874-19.53125 19.554687-51.15625 0-70.695313zm-49.496094 35.355469-21.410156-21.410157c2.488281-2.230468 4.921875-4.519531 7.273437-6.875 2.355469-2.351562 4.644532-4.785156 6.875-7.269531l21.410157 21.410157zm-254.527343-42.425781c-62.523438-62.519532-62.53125-163.722657 0-226.25 62.519531-62.523438 163.722656-62.53125 226.25 0 62.382812 62.378906 62.699218 163.558593 0 226.25-63.40625 63.414062-164.582032 61.671874-226.25 0zm296.953124 28.28125 28.277344 28.28125-42.417968 42.417968-28.28125-28.277344zm119.34375 161.769531c-11.71875 11.730469-30.683593 11.734375-42.410156 0l-76.933594-76.929688 42.417969-42.417969 76.929688 76.9375c11.726562 11.714844 11.738281 30.679688-.003907 42.410157zm0 0"/><path d="m279.011719 81.042969c-54.683594-54.683594-143.273438-54.714844-197.980469-.007813-54.570312 54.582032-54.570312 143.394532 0 197.980469 54.714844 54.710937 143.253906 54.714844 197.972656 0 54.582032-54.585937 54.585938-143.394531.007813-197.972656zm-14.148438 183.828125c-46.894531 46.894531-122.785156 46.90625-169.691406.003906-46.773437-46.789062-46.773437-122.914062 0-169.703125 46.871094-46.867187 122.8125-46.878906 169.699219.011719 46.78125 46.78125 46.777344 122.902344-.007813 169.6875zm0 0"/><path d="m180.023438 80.042969c-26.726563 0-51.835938 10.398437-70.703126 29.277343-10.9375 10.9375-18.988281 23.859376-23.925781 38.414063-1.773437 5.226563 1.023438 10.90625 6.253907 12.679687 5.238281 1.777344 10.910156-1.035156 12.683593-6.253906 3.941407-11.621094 10.378907-21.949218 19.128907-30.703125 15.09375-15.097656 35.179687-23.414062 56.5625-23.414062 5.523437 0 10-4.476563 10-10 0-5.523438-4.476563-10-10-10zm0 0"/></svg>
      					</button>
     				 </form>
     				 </div>
     				 </li>
                </ul>
            </div>
            <span class="navTrigger">
                <i></i>
                <i></i>
                <i></i>
            </span>
        </div>
    </nav>
    
    </c:if>
      </c:if>
    
  <!--  NOT LOGGED IN nav -->
     <c:if test="${empty loggedInUser}">
  <nav class="nav">
        <div class="container-nav">
            <div class="logo">
                <a href="gotoLanding.do">Travel Bored</a>
            </div>
            <div id="mainListDiv" class="main_list">
                <ul class="navlinks">
                    <li><a href="gotoLanding.do">login</a></li>
                    <li>
                    <div class="search-bar">
                    <form action="search.do" method="get">
        				<input type="text" name="keyword" placeholder="search...">
      					<button type="submit">
      						<svg xmlns="http://www.w3.org/2000/svg" height="512pt" viewBox="0 0 512 512.00049" width="512pt"><path d="m90.742188 180.734375c-5.519532 0-10 4.476563-10 9.996094s4.480468 10 10 10c5.519531 0 10-4.480469 10-10s-4.480469-9.996094-10-9.996094zm0 0"/><path d="m370.921875 300.21875c-1.871094-1.875-4.417969-2.929688-7.070313-2.929688-.101562.019532-3.945312-.195312-7.070312 2.929688l-7.066406 7.066406-22.976563-22.972656c50.703125-71.074219 42.992188-169.117188-19.449219-231.554688-70.335937-70.335937-184.1875-70.347656-254.53125 0-70.335937 70.332032-70.347656 184.1875 0 254.53125 62.285157 62.289063 160.289063 70.28125 231.550782 19.449219l22.976562 22.976563-7.066406 7.066406c-3.902344 3.902344-3.90625 10.238281 0 14.144531l126.421875 126.410157c19.535156 19.546874 51.15625 19.558593 70.695313.003906 19.546874-19.53125 19.554687-51.15625 0-70.695313zm-49.496094 35.355469-21.410156-21.410157c2.488281-2.230468 4.921875-4.519531 7.273437-6.875 2.355469-2.351562 4.644532-4.785156 6.875-7.269531l21.410157 21.410157zm-254.527343-42.425781c-62.523438-62.519532-62.53125-163.722657 0-226.25 62.519531-62.523438 163.722656-62.53125 226.25 0 62.382812 62.378906 62.699218 163.558593 0 226.25-63.40625 63.414062-164.582032 61.671874-226.25 0zm296.953124 28.28125 28.277344 28.28125-42.417968 42.417968-28.28125-28.277344zm119.34375 161.769531c-11.71875 11.730469-30.683593 11.734375-42.410156 0l-76.933594-76.929688 42.417969-42.417969 76.929688 76.9375c11.726562 11.714844 11.738281 30.679688-.003907 42.410157zm0 0"/><path d="m279.011719 81.042969c-54.683594-54.683594-143.273438-54.714844-197.980469-.007813-54.570312 54.582032-54.570312 143.394532 0 197.980469 54.714844 54.710937 143.253906 54.714844 197.972656 0 54.582032-54.585937 54.585938-143.394531.007813-197.972656zm-14.148438 183.828125c-46.894531 46.894531-122.785156 46.90625-169.691406.003906-46.773437-46.789062-46.773437-122.914062 0-169.703125 46.871094-46.867187 122.8125-46.878906 169.699219.011719 46.78125 46.78125 46.777344 122.902344-.007813 169.6875zm0 0"/><path d="m180.023438 80.042969c-26.726563 0-51.835938 10.398437-70.703126 29.277343-10.9375 10.9375-18.988281 23.859376-23.925781 38.414063-1.773437 5.226563 1.023438 10.90625 6.253907 12.679687 5.238281 1.777344 10.910156-1.035156 12.683593-6.253906 3.941407-11.621094 10.378907-21.949218 19.128907-30.703125 15.09375-15.097656 35.179687-23.414062 56.5625-23.414062 5.523437 0 10-4.476563 10-10 0-5.523438-4.476563-10-10-10zm0 0"/></svg>
      					</button>
     				 </form>
     				 </div>
     				 </li>
                </ul>
            </div>
            <span class="navTrigger">
                <i></i>
                <i></i>
                <i></i>
            </span>
        </div>
    </nav>
    </c:if>
  

<!-- Jquery needed -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="../javascript/navbar.js"></script>

<!-- Function used to shrink nav bar removing paddings and adding black background -->
    <script>
        $(window).scroll(function() {
            if ($(document).scrollTop() > 50) {
                $('.nav').addClass('affix');
                console.log("OK");
            } else {
                $('.nav').removeClass('affix');
            }
        });
    </script>


      <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


