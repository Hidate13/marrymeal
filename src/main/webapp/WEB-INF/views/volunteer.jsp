<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<!-- Test My JS -->
	<!-- <input type="button" class="button" onclick="sayHello();" value="Click me!">  -->

	<%@ include file="header.jsp"%>




	<!-- First Container -->
	<div class="container-fluid bg-1">
		<div>
			<h2 class="text-center">Task of Order</h2>

			<c:if test="${not empty error_message}">
				<p>${error_message}</p>
			</c:if>

			<c:if test="${empty meals}">
				<span> No Orders are added yet. </span>
			</c:if>

			<div class="row">

				<div class="col-md-flex">

					<div class="card-group">

						<table class="table order">
							<thead>
								<tr>
									<th scope="col">No.</th>
									<th scope="col">Delivery ID</th>
									<th scope="col">Member Name</th>
									<th scope="col">Member Illness</th>
									<th scope="col">member Allergy</th>
									<th scope="col">Member Address</th>
									<th scope="col">Meal ID</th>
									<th scope="col">Meal Name</th>
									<th scope="col">Description</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<c:if test="${not empty meals}">
								<%
										int i = 1;
										%>
								<c:forEach var="del" items="${delivery}">
									<c:if test="${del.approval}">
										<tbody>
											<tr>
												<th scope="row"><%=i %></th>
												<td>${del.delivery_id}</td>
												<td id="member-name">${del.member_name}</td>
												<td>${del.illness}</td>
												<td>${del.foodref}</td>
												<td>${del.address}</td>
												<c:forEach var="meal" items="${meals}">
													<c:if test="${del.meal_id == meal}">
														<td>${meal.meal_id}</td>
														<td id="meal-name">${meal.name}</td>
														<td>${meal.foodReference}</td>
													</c:if>
												</c:forEach>
												<td><c:choose>
														<c:when test="${del.approval}">
							                                    Ready
							                            </c:when>
														<c:otherwise>
							                                    Not Ready
							                            </c:otherwise>
													</c:choose></td>
												<td><c:choose>
														<c:when test="${del.on_delivery}">
															<a onclick="return riderConf(event, 'cancel')"
																id="cancel-link" href="take_over?id=${del.delivery_id}">
																<button class="btn-rider">Cancel</button>
															</a>
														</c:when>
														<c:otherwise>
															<a onclick="return riderConf(event, 'approve')"
																id="approve-link" href="take_over?id=${del.delivery_id}">
																<button class="btn-rider">Approve</button>
															</a>
														</c:otherwise>
													</c:choose> <%-- <a onclick="return riderConf(event)" id="rider-link" href="take_over?id=${meal.meal_id}&userId=${pageContext.request.userPrincipal.name}" >
														<button class="btn btn-info">Delivery</button>
													</a> --%></td>
											</tr>
										</tbody>
										<%
											i++;
											%>
									</c:if>
								</c:forEach>
							</c:if>
						</table>


					</div>
					<!-- End of Card -->

				</div>
			</div>

			<!--  End Car Lists  -->

		</div>
	</div>




	<%@ include file="footer.jsp"%>

</body>
</html>
