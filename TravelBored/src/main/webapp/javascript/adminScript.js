

function showAEvents() {
	  var activeEvents = document.getElementById("section1");
	  var unactiveEvents = document.getElementById("section2");
	  var activeUsers = document.getElementById("section3");
	  var unactiveUsers = document.getElementById("section4");
	  var activeGroups = document.getElementById("section5");
	  var unactiveGroups = document.getElementById("section6");
	  
	  activeEvents.style.display = "block";
	  unactiveEvents.style.display = "none";
	  activeUsers.style.display = "none";
	  unactiveUsers.style.display = "none";
	  activeGroups.style.display = "none";
	  unactiveGroups.style.display = "none";
  }
function showDEvents() {
	var activeEvents = document.getElementById("section1");
	var unactiveEvents = document.getElementById("section2");
	var activeUsers = document.getElementById("section3");
	var unactiveUsers = document.getElementById("section4");
	var activeGroups = document.getElementById("section5");
	var unactiveGroups = document.getElementById("section6");
	
	activeEvents.style.display = "none";
	unactiveEvents.style.display = "block";
	activeUsers.style.display = "none";
	unactiveUsers.style.display = "none";
	activeGroups.style.display = "none";
	unactiveGroups.style.display = "none";
}
function showAUsers() {
	var activeEvents = document.getElementById("section1");
	var unactiveEvents = document.getElementById("section2");
	var activeUsers = document.getElementById("section3");
	var unactiveUsers = document.getElementById("section4");
	var activeGroups = document.getElementById("section5");
	var unactiveGroups = document.getElementById("section6");
	
	activeEvents.style.display = "none";
	unactiveEvents.style.display = "none";
	activeUsers.style.display = "block";
	unactiveUsers.style.display = "none";
	activeGroups.style.display = "none";
	unactiveGroups.style.display = "none";
}
function showDUsers() {
	var activeEvents = document.getElementById("section1");
	var unactiveEvents = document.getElementById("section2");
	var activeUsers = document.getElementById("section3");
	var unactiveUsers = document.getElementById("section4");
	var activeGroups = document.getElementById("section5");
	var unactiveGroups = document.getElementById("section6");
	
	activeEvents.style.display = "none";
	unactiveEvents.style.display = "none";
	activeUsers.style.display = "none";
	unactiveUsers.style.display = "block";
	activeGroups.style.display = "none";
	unactiveGroups.style.display = "none";
}
function showAGroups() {
	console.log("show group");
	var activeEvents = document.getElementById("section1");
	var unactiveEvents = document.getElementById("section2");
	var activeUsers = document.getElementById("section3");
	var unactiveUsers = document.getElementById("section4");
	var activeGroups = document.getElementById("section5");
	var unactiveGroups = document.getElementById("section6");
	
	activeEvents.style.display = "none";
	unactiveEvents.style.display = "none";
	activeUsers.style.display = "none";
	unactiveUsers.style.display = "none";
	activeGroups.style.display = "block";
	unactiveGroups.style.display = "none";
}
function showDGroups() {
	var activeEvents = document.getElementById("section1");
	var unactiveEvents = document.getElementById("section2");
	var activeUsers = document.getElementById("section3");
	var unactiveUsers = document.getElementById("section4");
	var activeGroups = document.getElementById("section5");
	var unactiveGroups = document.getElementById("section6");
	
	activeEvents.style.display = "none";
	unactiveEvents.style.display = "none";
	activeUsers.style.display = "none";
	unactiveUsers.style.display = "none";
	activeGroups.style.display = "none";
	unactiveGroups.style.display = "block";
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