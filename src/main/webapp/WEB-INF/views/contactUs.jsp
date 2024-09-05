<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<!-- FONTS -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;1,700&display=swap"
	rel="stylesheet">

<!-- feather icons -->
<script src="https://unpkg.com/feather-icons"></script>

<link href="/css/style.css" rel="stylesheet" />
<link href="/css/contactus.css" rel="stylesheet" />
<script src="/js/custom.js"></script>

</head>

<body>


	<%@ include file="header.jsp"%>


	<!-- First Container -->
	<div id="contactUs" class="contactUs">
		<h2>
			<span>Contact</span> Us
		</h2>
		<p>A Contact Us page is essential for your site to engage with
			visitors and customers. Check out these helpful tips and contact us
			page examples.</p>
		<div class="row">
			<
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d255281.19051494342!2d103.67943493762235!3d1.3143378894806843!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31da11238a8b9375%3A0x887869cf52abf5c4!2sSingapura!5e0!3m2!1sid!2sid!4v1684151492377!5m2!1sid!2sid"
				width="70%" style="border: 0;" allowfullscreen="" loading="lazy"
				referrerpolicy="no-referrer-when-downgrade"></iframe>
			<form action="">
				<label class="lab">Name</label>
				<div class="input-group">
					<i data-feather="user"></i> <input style="" placeholder="name">
				</div>
				<label class="lab">e-mail</label>
				<div class="input-group">
					<i data-feather="mail"></i> <input style="" placeholder="e-mail">
				</div>
				<label class="lab">Subject</label>
				<div class="input-group">
					<textarea id="subject" name="subject"
						placeholder="Write something.." style="height: 200px"></textarea>
				</div>
				<button class="btn" type="submit">send</button>
			</form>
		</div>
	</div>


	<%@ include file="footer.jsp"%>

</body>
</html>
