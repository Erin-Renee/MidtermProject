<div>
  <form action="updateEvent.do" method="post">
    <label for="title">Title:</label>
    <input type="text" name="title" value="${event.title }"><br>
    
    <label for="hook">Hook:</label>
    <input type="text" name="hook" value="${event.hook }"><br>
    
    <label for="description">Description:</label>
    <input type="text" name="description" value="${event.description }" ><br>
    
    <label for="eventDate">Event Date:</label>
    <input type="date" name="eventDate" value="${event.eventDate }"><br>
    
    <label for="eventTime">Time:</label>
    <input type="time" name="eventTime" value="${event.eventTime }"><br>
    
    <label for="imgUrl">Event Photo URL:</label>
    <input type="url" name="imgUrl" value="${event.imgUrl }"><br>
    
    <label for="eventUrl">Event URL:</label>
    <input type="url" name="eventUrl" value="${event.eventUrl }"><br>
    
    <input type="hidden" name="id" value="${event.id }"><br>
    
    
    <button type="submit" name="submit">Update Event</button>
  </form>
</div>