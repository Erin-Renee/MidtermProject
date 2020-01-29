function showSection(sectionNumber){
	  var events = document.getElementById("section1");
	  var users = document.getElementById("section2");
	  var groups = document.getElementById("section3");
	  
	  events.style.display = "none";
	  users.style.display = "none";
	  groups.style.display = "none";
	  
	  
	  if(sectionNumber == 1){
		  events.style.display = "block";
	  }
	  if(sectionNumber == 2){
		  users.style.display = "block";
	  }
	  if(sectionNumber == 3){
		  groups.style.display = "block";
	  }
	 
}

  
  
  
////Disable form submissions if there are invalid fields
//  (function() {
//    'use strict';
//    window.addEventListener('load', function() {
//      // Get the forms we want to add validation styles to
//      var forms = document.getElementsByClassName('needs-validation');
//      // Loop over them and prevent submission
//      var validation = Array.prototype.filter.call(forms, function(form) {
//        form.addEventListener('submit', function(event) {
//          if (form.checkValidity() === false) {
//            event.preventDefault();
//            event.stopPropagation();
//          }
//          form.classList.add('was-validated');
//        }, false);
//      });
//    }, false);
//  })();