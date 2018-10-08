<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Booking History</title>

  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link href="css/navbar.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<main role="main" class="container">
		<div class="card mb-3">
		  <div class="card-header">
		    <i class="fas fa-table"></i>
		    Booking History
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