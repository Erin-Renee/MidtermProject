<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<select name="locationId" >
	<option selected value="${sessionScope.loggedInUser.location.id}" >${sessionScope.loggedInUser.location.city} ${sessionScope.loggedInUser.location.zipCode }</option>

<c:forEach var="location" items="${locations}">
<c:if test="${location.id !=  sessionScope.loggedInUser.location.id}">
	
	<option value="${location.id}" >${location.city} ${location.zipCode }</option>
	
	</c:if>
	
</c:forEach>
</select>



