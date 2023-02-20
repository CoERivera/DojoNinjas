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
		<h1 style="color: blue;">Dojos</h1>
		<table class="table table-striped table-bordered mt-5">
			<thead>
				<tr>
					<th scope="col">Dojo</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dojo" items="${dojos}">
					<tr>
						<td><a href="/dojos/${dojo.getId()}"><c:out
									value="${dojo.getName()}" /></a></td>
						<td class="d-flex justify-content-around"><a
							href="dojos/${dojo.getId()}/edit">
								<button class="btn btn-warning">Edit</button>
						</a> <form:form action="/dojos/${dojo.getId()}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input class="btn btn-danger" type="submit" value="Delete">
							</form:form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-flex justify-content-end">
			<a href="dojos/new">
				<button class="btn btn-primary">Add a Dojo!</button>
			</a>
		</div>
		<div class="d-flex justify-content-end mt-3">
			<a href="/ninjas/new">
				<button class="btn btn-dark">Add a Ninja!</button>
			</a>
		</div>
	</div>
</body>
</html>