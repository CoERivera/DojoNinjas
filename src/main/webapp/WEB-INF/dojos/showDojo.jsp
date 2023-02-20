<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
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
			<h1 style="color: blue;">
				<c:out value="${dojo.getName()}" />
				Location Details
			</h1>
			<h2>
				<a href="/dojos">Go back</a>
			</h2>
		</div>
		<div class="card-body mt-5">
			<h2 style="color: blue;">Ninjas</h2>
			<table class="table table-striped table-bordered mt-5">
				<thead>
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Age</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${dojo.getNinjas()}">
						<tr>
							<td><c:out value="${ninja.getFirstName()}" /></td>
							<td><c:out value="${ninja.getLastName()}" /></td>
							<td><c:out value="${ninja.getAge()}" /></td>
							<td class="d-flex justify-content-around">
								<a href="/ninjas/${ninja.getId()}/edit">
									<button class="btn btn-warning">
										Edit
									</button>
								</a>
								<form:form action="/ninjas/${ninja.getId()}" method="post">
									<input type="hidden" name="_method" value="delete">
									<input class="btn btn-danger" type="submit" value="Delete">
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>