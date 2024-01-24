<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ page import="com.lithan.ac.Marry_Meal.entities.Meal"%>
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
	<div class="container-fluid bg-1 text-center">
		<h3 class="margin">Post A Meal For Members.</h3>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
					<div class="form-wrapper">				
						<%-- <form:form method="POST" action="/meals" modelAttribute="meal"
							enctype="multipart/form-data">
		
							<input type="hidden" value="${_csrf.token}" />
							<form:hidden path="meal_id" />
		
							<div class="form-group">
								<label for="mealphoto">Upload Meal's Photo:</label><br/>
								<input	type="file" name="file" /><br/>
							</div> --%>

						
						<form:form action="/meal" method="post" modelAttribute="meal" enctype="multipart/form-data">
						<input type="hidden" value="${_csrf.token}" />
							<form:hidden path="meal_id" />
						<c:if test="${meal.meal_id>0}">
						<div class="form-group">
							<img src="/images/${meal.mealphoto}" width="300px">
							<form:hidden path="mealphoto" />
						</div>
						</c:if>
						<div class="form-group">
							<label for="mealphoto">Upload Meal's Photo:</label><br/>
							<input	type="file" name="file" /><br/>
						</div>
						<div class="form-group">
							<label for="name">Meal Name:</label>
							<form:input path="name" class="form-control" required="true" />
						</div>
						<div class="form-group">
							<label for="address">Description:</label>
							<form:textarea id="foodReference" class="form-control" path="foodReference" rows="3" cols="23" />
						</div>
						<%-- <div class="form-group">
							<label for="isfrozen">is Frozen :</label><br/>
							<form:radiobutton  path="isfrozen" value="yes" checked="true"/>Yes
							<form:radiobutton  path="isfrozen" value="no"/>No
						</div> --%>
						<br/>
						<input type="submit" value="Post" class="btn btn-primary" />
						<br/>

					</form:form>
					</div>
			<div class="col-md-4"></div>
			</div>
		</div>

	</div>


	<%@ include file="footer.jsp"%>

</body>
</html>
