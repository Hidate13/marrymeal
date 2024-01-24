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



</head>

<body>

	<!-- Test My JS -->
	<!-- <input type="button" class="button" onclick="sayHello();" value="Click me!">  -->

	<%@ include file="header.jsp"%>




	<!-- First Container -->
	<div class="container-fluid bg-1">
		<div>
			<h2 class="text-center">Deliver Meal For Member</h2>

			<c:if test="${not empty error_message}">
				<p>${error_message}</p>
			</c:if>

			<c:if test="${empty meals}">
				<sec:authorize access="hasRole('Administrator')">
					<span> No Meals are added yet. </span>
				</sec:authorize>
				<sec:authorize access="hasRole('Partner')">
					<span> Please click on Post Menu to add Meals to the system.
					</span>
				</sec:authorize>
			</c:if>


			<!--  All Meal Lists  -->

			<%-- <div class="row">
				<div class="col-md-12">
				<div class="search-wrapper">
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
			</div> --%>



<%-- <sec:authorize access="hasRole('Volunteer')">
    <!--volunteers -->
    <%@ include file="volunteer.jsp" %>
</sec:authorize> --%>

<%-- <sec:authorize access="hasAnyRole('Member', 'Partner', 'Administrator')"> --%>
			<div class="row">

				<div class="col-md-flex">

					<div class="card-group">

								<table class="table">
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
									      <th scope="col">Approval</th>
									    </tr>
									  </thead>
									<c:if test="${not empty meals}">
										<%
										int i = 1;
										%>
										<c:forEach var="del" items="${delivery}">								
											  <tbody>
											    <tr>
											      <th scope="row"><%=i %></th>
											      <td>${del.delivery_id}</td>
											      <td>${del.member_name}</td>
											      <td>${del.illness}</td>
											      <td>${del.foodref}</td>
											      <td>${del.address}</td>
											      <c:forEach var="meal" items="${meals}">
									                  <c:if test="${del.meal_id == meal}">
									                      <td>${meal.meal_id}</td>
									                      <td>${meal.name}</td>
									                      <td>${meal.foodReference}</td>
									                  </c:if>
		                						  </c:forEach>
											      <td>
											      	<c:choose>
							                            <c:when test="${del.approval}">
							                                <a onclick="return approvalMeal(event, 'cancel', '${del.delivery_id}')" id="cancel-link">
							                                    <button class="btn btn-danger">Cancel</button>
							                                </a>
							                            </c:when>
							                            <c:otherwise>
							                                <a onclick="return approvalMeal(event, 'approve', '${del.delivery_id}')" id="approve-link">
							                                    <button class="btn btn-info">Approve</button>
							                                </a>
							                            </c:otherwise>
							                        </c:choose>
											      </td>
											    </tr>
											  </tbody>
											<%
											i++;
											%>
										</c:forEach>
									</c:if>
									</table>


					</div>
					<!-- End of Card -->

				</div>
			</div>

			<!--  End Car Lists  -->

<%-- </sec:authorize> --%>
		</div>
	</div>



	<%@ include file="footer.jsp"%>
<script src="/js/custom.js"></script>
</body>
</html>
