<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Dojo and Ninjas</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1 style="color: blue;">New Dojo</h1>
			<h2>
				<a href="/dojos">Go back</a>
			</h2>
		</div>
		<div class="card-body mt-5">
			<form:form class="mt-4" action="/dojos" method="post"
				modelAttribute="dojo">
				<div class="form-group mt-3">
					<form:label path="name">Name:</form:label>
					<form:errors style="color:red;" path="name" />
					<form:input class="form-control mt-1" path="name" />
				</div>
				<div class="d-flex justify-content-end">
					<input class="btn btn-success mt-3" type="submit"
						value="Create Dojo">
				</div>

			</form:form>

		</div>
	</div>
</body>
</html>