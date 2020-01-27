  <div class="w3-bar w3-blue" style="position: fixed; z-index: 3; top: 0">
      <form action="gotoLanding.do" method="get">
      <button class="w3-bar-item w3-button"type="submit">Home</button>
      </form>
      <form action="search.do" method="get">
        <input class="w3-bar-item w3-input" type="text" placeholder="search...">
      <button class="w3-bar-item w3-button"type="submit">search</button>
      </form>
      <form action="gotoLanding.do" method="get">
      <button class="w3-bar-item w3-button w3-right"type="submit">login</button>
      </form>
  </div>
  
<!-- user -->
  <div class="w3-bar w3-red" style="position: fixed; z-index: 3; top: 0">
      <form action="gotoHome.do" method="get">
      <button class="w3-bar-item w3-button"type="submit">Home</button>
      </form>
      <form action="gotoCrUpdateEvent.do" method="get">
      <button class="w3-bar-item w3-button"type="submit">Create Event</button>
      </form>
      <form action="search.do" method="get">
        <input class="w3-bar-item w3-input" type="text" name="keyword" placeholder="search...">
      <button class="w3-bar-item w3-button"type="submit">search</button>
      </form>
      <form action="gotoProfile.do" method="get">
      <button class="w3-bar-item w3-button w3-right"type="submit">User Profile</button>
      </form>
      <form action="logout.do" method="get">
      <button class="w3-bar-item w3-button w3-right"type="submit">logout</button>
      </form>
      <div class="w3-bar-item w3-right">${sessionScope.loggedInUser.username}</div>
  </div>

