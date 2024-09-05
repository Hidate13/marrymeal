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
		<h3 class="margin">Register Here !</h3>

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">


				<c:if test="${register_success != null}">
					<div class="alert alert-success">
						<p>${register_success}
							Click <a href="cus_login_page"> Sign In</a> to use our portal...
						</p>
					</div>
				</c:if>
				<div class="form-wrapper">
					<form:form action="update" method="post"
						modelAttribute="registration">
						<div>
							<form:hidden path="user.id" />
						</div>
						<div class="form-group">
							<label for="name">Your Full Name:</label>
							<form:input path="user.name" class="form-control" required="true" />
						</div>
						<div class="form-group">
							<label for="username">Your Login User Name:</label>
							<form:input path="user.userName" class="form-control"
								required="true" />
						</div>
						<div class="form-group">
							<label for="password">Your Password:</label>
							<form:password path="user.password" class="form-control"
								required="true" />
						</div>
						<div id="div1">
							<label for="address">Address:</label>
							<form:input path="member.address" class="form-control" />
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${user.act == 'Administrator'}">
									<label for="role">Register as:</label>
									<br />
									<form:radiobutton path="user.act" value="Administrator"
										checked="checked" />
										Administrator<br>
								</c:when>
								<c:otherwise>
									<label for="role">Register as:</label>
									<br />
									<form:radiobutton path="user.act" value="Member"
										checked="checked" />
							            Member<br>
									<form:radiobutton path="user.act" value="Volunteer" />
										Volunteer<br>
									<form:radiobutton path="user.act" value="Partner" />
										Partner <br>
								</c:otherwise>
							</c:choose>
						</div>
						<div id="foodRefDiv">
							<label for="foodRef">food reference :</label><br />
							<form:textarea id="foodreference" path="member.foodref" rows="3"
								style="color: black;" cols="23" />
						</div>
						<div id="illnessDiv">
							<label for="illness">illness :</label><br />
							<form:textarea id="illness" path="member.illness" rows="3"
								style="color: black;" cols="23" />
						</div>
						<br />
						<input type="submit" value="Update" class="btn btn-primary" />
						<br />

					</form:form>
				</div>

			</div>


			<div class="col-md-4"></div>

		</div>

	</div>


	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
    const memberRadio = document.querySelector('input[value="Member"]');
    const foodRefDiv = document.getElementById('foodRefDiv');
    const illnessDiv = document.getElementById('illnessDiv');
    const div1 = document.getElementById('div1');

    // Function to toggle visibility
    function toggleVisibility(displayType) {
        foodRefDiv.style.display = displayType;
        illnessDiv.style.display = displayType;
        div1.style.display = displayType;
        
    }

    // Initial state based on the default value
    if (memberRadio.checked) {
        toggleVisibility('block');
    } else {
        toggleVisibility('none');
    }

    // Add event listeners for radio buttons change
    document.querySelectorAll('input[name="user.act"]').forEach(function(radioButton) {
        radioButton.addEventListener('change', function() {
            if (this.value === 'Member') {
                toggleVisibility('block');
            } else {
                toggleVisibility('none');
            }
        });
    });
});
</script>
</body>
</html>
