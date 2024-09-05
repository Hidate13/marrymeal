<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<!--  Enable Bootstrap -->
<!-- Bootstrap CSS -->
<link href="/css/card.css" rel="stylesheet" />

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

	<%-- <sec:authorize access="hasRole('Volunteer')">
    <!--volunteers -->
    <%@ include file="all_user.jsp" %>
</sec:authorize> --%>

	<sec:authorize
		access="hasAnyRole('Member', 'Partner', 'Administrator')">


		<!-- First Container -->
		<div class="container-fluid bg-1">
			<div>
				<h2 class="text-center">Meal List</h2>

				<c:if test="${not empty error_message}">
					<p>${error_message}</p>
				</c:if>

				<c:if test="${empty meals}">
					<sec:authorize access="hasRole('Administrator')">
						<span> No Meals are added yet. </span>
					</sec:authorize>
					<sec:authorize access="hasRole('Partner')">
						<span> Please click on Post Menu to add Meals to the
							system. </span>
					</sec:authorize>
				</c:if>


				<!--  All Meal Lists  -->
				<div class="form-group">
					<label>Logged-in User: </label>
					<p>${pageContext.request.userPrincipal.name}</p>
					<p id="notif"></p>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="search-wrapper">
							<div class="btn-newmeal">
								<sec:authorize access="hasRole('Partner')">
									<a href="new_meal">
										<button class="btn btn-primary">Post Menu</button>
									</a>
								</sec:authorize>
							</div>
							<div class="search-container">
								<c:url var="get_search_url" value="search" />
								<form action="${get_search_url}" id="myform" method="get"
									class="form-inline text-right" style="padding: 20px;">

									<input class="form-control mr-sm-2" type="search"
										placeholder="Search" value="" name="keyword" /> <input
										type="submit" value="Search" class="btn btn-info" />
								</form>
							</div>
						</div>
					</div>
				</div>






				<div class="row">

					<div class="col-md-flex">

						<div class="card-group">

							<c:if test="${not empty meals}">



								<%
							int i = 1;
							%>
								<c:forEach var="meal" items="${meals}">

									<div class="card">
										<div class="card-body">
											<img src="/images/${meal.mealphoto}" class="card-img-top"
												style="height: 20rem; width: 23rem; object-fit: contain;">
											<%-- <div class="form-group">
					                            <label>Logged-in User:</label>
					                            <p>${pageContext.request.userPrincipal.name}</p>
	                        				</div> --%>
										</div>
										<div class="card-body">
											<h5 id="meal-name" class="card-title">${meal.name}</h5>
											<p class="card-text">
												<%-- <p>is Frozen : ${meal.isfrozen}</p> --%>
											<p class="card-text">
											<p>Description : ${meal.foodReference}</p>
											<p class="card-text"></p>
										</div>
										<div class="card-body">
											<small class="text-muted"> <%-- <c:if test="${empty meals}"> --%>
												<sec:authorize access="hasRole('Member')">
													<a onclick="return orderConf(event)" id="order-link"
														href="order?id=${meal.meal_id}&userId=${pageContext.request.userPrincipal.name}">
														<button class="btn btn-info">Order</button>
													</a>
												</sec:authorize> <sec:authorize access="hasRole('Partner')">
													<a href="edit?id=${meal.meal_id}">
														<button class="btn btn-info">Update</button>
													</a>
													<a href="delete?id=${meal.meal_id}">
														<button class="btn btn-danger">Delete</button>
													</a>
												</sec:authorize> <%-- </c:if> --%>
											</small>
										</div>
									</div>

									<%
								i++;
								%>
								</c:forEach>



							</c:if>

						</div>
						<!-- End of Card -->

					</div>
				</div>

				<!--  End Car Lists  -->

			</div>
		</div>
	</sec:authorize>


	<%@ include file="footer.jsp"%>
</body>
</html>