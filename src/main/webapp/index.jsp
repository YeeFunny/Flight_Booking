
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Flight Booking</title>

  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link href="css/navbar.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<main role="main" class="container">
		<form class="needs-validation" action="#" method="post">
	    <div style="padding: 2rem 1rem; margin-bottom: 2rem; background-color: #e9ecef; border-radius: .3rem;">
	      <h1>Hello travelers. Where would you like to go?</h1>
	      <div class="row mt-4">
	        <div class="col-md-3">
	          <label for="from">From</label>
	          <input type="text" class="form-control" id="from" name="from" placeholder="Departure"
	                 value="" data-validation="length" data-validation-length="min2" required>
	        </div>
	        <div class="col-md-3">
	          <label for="to">To</label>
	          <input type="text" class="form-control" id="to" name="to" placeholder="Destination"
	                 value="" data-validation="length" data-validation-length="min2" required>
	        </div>
	        <div class="col-md-3">
	          <label for="to">Date</label>
	          <input type="date" class="form-control" id="date" name="date" placeholder="Date"
	                 value="" required>
	        </div>
	        <div class="col-md-3 mt-2">
	          <label></label>
	          <button class="btn btn-primary btn-lg btn-block" style="padding: 1px 7px 2px;" type="submit">Search</button>
	        </div>
	      </div>
	    </div>
	  </form>
	  <div class="card mb-3">
	    <div class="card-header">
	      <i class="fas fa-table"></i>
	      Flight Information
	    </div>
	    <div class="card-body">
	      <div class="table-responsive">
	        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	          <thead>
	          <tr>
	            <th>Name</th>
	            <th>Position</th>
	            <th>Office</th>
	            <th>Age</th>
	            <th>Start date</th>
	            <th>Salary</th>
	          </tr>
	          </thead>
	          <tbody>
	          <tr>
	            <td>Tiger Nixon</td>
	            <td>System Architect</td>
	            <td>Edinburgh</td>
	            <td>61</td>
	            <td>2011/04/25</td>
	            <td>$320,800</td>
	          </tr>
	          <tr>
	            <td>Garrett Winters</td>
	            <td>Accountant</td>
	            <td>Tokyo</td>
	            <td>63</td>
	            <td>2011/07/25</td>
	            <td>$170,750</td>
	          </tr>
	          </tbody>
	        </table>
	      </div>
	    </div>
	  </div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
