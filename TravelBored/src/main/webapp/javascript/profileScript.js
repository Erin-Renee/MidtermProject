







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


function showOverlay(id, title, hook, description, eventDate, eventTime, imgUrl, eventUrl,locationId,locationCity,locationZip) {
	// Get the container element
	console.log(id);
	console.log(title);
	document.getElementById('updateId').value = id;
	document.getElementById('updateTitle').value = title;
	document.getElementById('updateHook').value = hook;
	document.getElementById('updateDescription').value = description;
	document.getElementById('updateDate').value = eventDate;
	document.getElementById('updateTime').value = eventTime;
	document.getElementById('updateImgUrl').value = imgUrl;
	document.getElementById('updateEventUrl').value = eventUrl;
	document.getElementById('locId').value = locationId;
	document.getElementById('locId').innerHTML = locationCity + " " + locationZip;
	
//	var btnContainer = document.getElementById("event-update-table");

	// Get all buttons with class="btn" inside the container
//	var btns = btnContainer.getElementsByClassName("event-row");

	// Loop through the buttons and add the active class to the current/clicked button
//	for (var i = 0; i < btns.length; i++) {
//	  btns[i].addEventListener("click", function() {
//	    var current = document.getElementsByClassName("active2");
//	    current[0].className = current[0].className.replace(" active2", "");
//	    this.className += "active2";
//	  });
//	}
	
	
	  var Overlay = document.getElementById("overlay");
	 Overlay.style.display = "block";
	console.log(document.getElementsByClassName("active"));
	console.log(document.getElementById("updateTitle"));
	
}

function hideOverlay() {
	  var hideOverlay = document.getElementById("overlay");
	 hideOverlay.style.display = "none";
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
  
  
  
//Disable form submissions if there are invalid fields
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