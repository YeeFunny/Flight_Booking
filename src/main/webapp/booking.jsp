<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"
	import="java.time.LocalDateTime, com.dto.Flight"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Ticket</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="css/navbar.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<main role="main" class="container">
	  <div class="col-md-12">
	    <h4 class="mb-3">Booking Ticket</h4>
	    <form class="needs-validation" action="booking" method="post">
	
	      <div class="row">
          	<input type="hidden" id="flightId" name="flightId" value="${seat.getFlightId()}">
          	<input type="hidden" id="oldVersion" name="oldVersion" value="${seat.getVersion()}">
	        <div class="col-md-3 mb-3">
	          <label for="business">Business (${seat.getBusinessLeft()} left)</label>
	          <input type="hidden" id="businessLeft" name="businessLeft" value="${seat.getBusinessLeft()}">
	          <input type="number" class="form-control" id="business" name="business" placeholder="Number of Tickets">
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="firstClass">First Class (${seat.getFirstLeft()} left)</label>
	          <input type="hidden" id="firstLeft" name="firstLeft" value="${seat.getFirstLeft()}">
	          <input type="number" class="form-control" id="firstClass" name="firstClass" placeholder="Number of Tickets">
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="economy">Economy (${seat.getEconomyLeft()} left)</label>
	          <input type="hidden" id="economyLeft" name="economyLeft" value="${seat.getEconomyLeft()}">
	          <input type="number" class="form-control" id="economy" name="economy" placeholder="Number of Tickets">
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="baggage">No. of Baggage</label>
	          <select class="custom-select d-block w-100" id="baggage" name="baggage" required>
	            <option value="1" selected>1</option>
	            <option value="2">2</option>
	            <option value="0">No Baggage</option>
	          </select>
	        </div>
	      </div>
	
	      <hr class="mb-4">
	
	      <h4 class="mb-3">Flight Information</h4>
	      <div class="row">
	        <div class="col-md-6 mb-3">
	          <label for="deptCity">Departure City</label>
	          <input type="text" class="form-control" id="deptCity" name="deptCity" 
	          	value="${flight.getDepartureCity()}" readonly>
	        </div>
	        <div class="col-md-6 mb-3">
	          <label for="arrCity">Arrival City</label>
	          <input type="text" class="form-control" id="arrCity" name="arrCity" 
	          	value="${flight.getArrivalCity()}" readonly>
	        </div>
	      </div>
	
	      <div class="row">
	        <div class="col-md-3 mb-3">
	          <label for="deptDate">Departure Date</label>
	          <input type="date" class="form-control" id="deptDate" name="deptDate" 
	          	value="${flight.getDepartureTime().toLocalDate()}" readonly>
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="deptTime">Departure Time</label>
	          <input type="time" class="form-control" id="deptTime" name="deptTime" 
	          	value="${flight.getDepartureTime().toLocalTime()}" readonly>
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="arrDate">Arrival Date</label>
	          <input type="date" class="form-control" id="arrDate" name="arrDate" 
	          	value="${flight.getArrivalTime().toLocalDate()}" readonly>
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="arrTime">Arrival Time</label>
	          <input type="time" class="form-control" id="arrTime" name="arrTime" 
	          	value="${flight.getArrivalTime().toLocalTime()}" readonly>
	        </div>
	      </div>
	
	      <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
	    </form>
	  </div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.79/jquery.form-validator.min.js"></script>
	<script>
	  $.validate({
	    modules : 'date, security'
	  });
	</script>
</body>
</html>