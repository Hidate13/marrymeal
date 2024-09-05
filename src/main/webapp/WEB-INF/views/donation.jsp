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


	<%@ include file="header.jsp"%>


	<!-- First Container -->
	<div class="container-fluid bg-1 text-center">
		<h3 class="margin">Donate Here !</h3>

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">


				<c:if test="${donation_success != null}">
					<div class="alert alert-success">
						<p>${donation_success}
							Click <a href="welcome"> here</a> back to home...
						</p>
					</div>
				</c:if>
				<div class="form-wrapper">
					<form:form action="donate" method="post" modelAttribute="donation">
						<div class="form-group">
							<label for="name">Your Full Name:</label>
							<form:input path="donorName" class="form-control" required="true" />
						</div>
						<div class="form-group">
							<label for="donationAmount">Enter Donation Amount:</label>
							<form:input path="amount" id="donationAmount"
								class="form-control" name="donationAmount" required="true" />
							<br /> <span id="amountError" style="color: red; display: none;">Please
								enter a valid numeric amount</span>
						</div>
						<br />
						<input type="submit" value="donate" class="btn btn-primary" />
						<br />

					</form:form>
				</div>

			</div>


			<div class="col-md-4"></div>

		</div>

	</div>


	<%@ include file="footer.jsp"%>
	<script>
    //validating the donation amount input
    document.getElementById('donationAmount').addEventListener('input', function () {
    	let donationInput = this.value;
        let regex = /^\d*\.?\d*$/; // Regular expression to allow numeric input

        if (!regex.test(donationInput)) {
            document.getElementById('amountError').style.display = 'inline'; // Show error message
            this.setCustomValidity('Invalid input'); // Set custom validation message
        } else {
            document.getElementById('amountError').style.display = 'none'; // Hide error message
            this.setCustomValidity(''); // Reset validation message
        }
    });
</script>
</body>
</html>
