function showSection(sectionNumber){
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
	  unactiveGroups.style.display = "none";
	  
	  
	  if(sectionNumber == 1){
		  activeEvents.style.display = "block";
	  }
	  if(sectionNumber == 2){
		  unactiveEvents.style.display = "block";
	  }
	  if(sectionNumber == 3){
		  activeUsers.style.display = "block";
	  }
	  if(sectionNumber == 4){
		  unactiveUsers.style.display = "block";
	  }
	  if(sectionNumber == 5){
		  activeGroups.style.display = "block";
	  }
	  if(sectionNumber == 6){
		  unactiveGroups.style.display = "block";
	  }
	 
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