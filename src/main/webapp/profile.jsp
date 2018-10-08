<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pessenger Profile</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<main role="main" class="container">
	  <div class="col-md-12">
	    <h4 class="mb-3">Passenger Profile</h4>
	    <form class="needs-validation" action="updateprofile" method="post">
	
	      <div class="mb-3">
	        <label for="email">Email</label>
	        <input type="email" class="form-control" id="email" placeholder="you@example.com" value="" readonly>
	      </div>
	
	      <div class="row">
	        <div class="col-md-6 mb-3">
	          <label for="firstName">First name</label>
	          <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name" value=""
	                 data-validation="length" data-validation-length="min2" required>
	        </div>
	        <div class="col-md-6 mb-3">
	          <label for="lastName">Last name</label>
	          <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value=""
	                 data-validation="length" data-validation-length="min2" required>
	        </div>
	      </div>
	
	      <div class="d-block my-3">
	        <label>Gender</label>
	        <br>
	        <div class="form-check form-check-inline">
	          <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="MALE" required>
	          <label class="form-check-label" for="inlineRadio1">Male</label>
	        </div>
	        <div class="form-check form-check-inline">
	          <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="FEMALE">
	          <label class="form-check-label" for="inlineRadio2">Female</label>
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="ssn">SSN</label>
	        <input type="text" class="form-control" id="ssn" name="ssn" placeholder="SSN number" data-validation="length"
	          data-validation-length="9">
	      </div>
	
	      <div class="mb-3">
	        <label for="age">Age</label>
	        <input type="number" class="form-control" id="age" name="age" placeholder="Age">
	      </div>
	
	      <div class="mb-3">
	        <label for="address">Address</label>
	        <input type="text" class="form-control" id="address" name="address" placeholder="Your address">
	      </div>
	
	      <div class="mb-3">
	        <label for="aptNumber">Apartment Number</label>
	        <input type="text" class="form-control" id="aptNumber" name="aptNumber" placeholder="Apartment or suite">
	      </div>
	
	      <div class="row">
	        <div class="col-md-5 mb-3">
	          <label for="city">City</label>
	          <input type="text" class="form-control" id="city" name="city" placeholder="City">
	        </div>
	        <div class="col-md-4 mb-3">
	          <label for="state">State</label>
	          <input type="text" class="form-control" id="state" name="state" placeholder="State">
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="zip">Zip</label>
	          <input type="number" class="form-control" id="zip" name="zip" placeholder="Zip Code">
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="telHome">Home Telephone</label>
	        <input type="text" class="form-control" id="telHome" name="telHome" placeholder="Home telephone number">
	      </div>
	
	      <div class="mb-3">
	        <label for="telOffice">Office Telephone</label>
	        <input type="text" class="form-control" id="telOffice" name="telOffice" placeholder="Office telephone number">
	      </div>
	
	      <hr class="mb-4">
	      <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
	    </form>
	  </div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.79/jquery.form-validator.min.js"></script>
	<script>
	  $.validate({
	    modules : 'date, security'
	  });
	</script>
</body>
</html>