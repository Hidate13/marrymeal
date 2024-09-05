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
<link href="/css/hero.css" rel="stylesheet" />
<script src="/js/custom.js"></script>


</head>

<body>
	<%@ include file="header.jsp"%>

	<div class="hero" id="home">
		<div class="content">
			<div class="content-division-left">
				<h1>
					<span>Marry </span>Meal
				</h1>
				<p>Thank you for joining us. Marry Meal is your go-to platform
					for delicious and healthy meals. Explore our menu, place orders,
					and enjoy a delightful culinary experience.</p>
				<a href="donation" class="cta">Donate</a>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>