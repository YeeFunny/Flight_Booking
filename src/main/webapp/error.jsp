<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Information</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<main role="main" class="container">
		<div class="jumbotron">
			<h1>Something went wrong. Please try again later.</h1>
		    <p class="lead">${param.exception}</p>
		</div>
	</main>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>