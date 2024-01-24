<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<!--  Enable Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<!--  Access the Static Resources without using spring URL -->
<link href="/css/style.css" rel="stylesheet" />
<script src="/js/custom.js"></script>


</head>

<body>

	<%@ include file="header.jsp"%>


	<!-- First Container -->
	<div class="container-fluid bg-1">
		<div>
			<h2 class="text-center">User List</h2>

			<div class="row">

				<div class="col-md-12">

					<c:if test="${not empty userlists}">

						<table class="table">

							<thead>
								<tr>
									<th scope="col">No.</th>
									<th scope="col">User ID</th>
									<th scope="col">Full Name</th>
									<th scope="col">User Name</th>
									<th scope="col">Password</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>

							<tbody>

								<% int i=1; %>
								<c:forEach var="user" items="${userlists}">
								<c:if test="${user.act != 'Administrator'}">
									<tr>
										<td><%=i %></td>
										<td>${user.id}</td>
										<td>${user.name}</td>
										<td>${user.userName}</td>
										<td>******</td>

										<td>
											<a href="edituser?id=${user.id}">
												<button class="btn btn-info">Update</button>
											</a>
											<%-- <a href="deleteuser?id=${user.id}">
												<button class="btn btn-danger">Delete</button>
											</a> --%>
										</td>
									</tr>
									<% i++; %>
								</c:if>
								</c:forEach>

							</tbody>
						</table>

					</c:if>

				</div>
			</div>

			<!--  End User Lists  -->

		</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>