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


function showOverlay() {
	  var Overlay = document.getElementById("overlay");
	 Overlay.style.display = "block";
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
