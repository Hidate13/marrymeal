<!-- Navbar -->
<nav class="navbar navbar-primary">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="welcome"> Marry<span>Meal</span>
			</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">

				<sec:authorize access="!isAuthenticated()">
					<li><a href="cus_login_page">Login</a></li>
					<li><a href="new">Register</a></li>
					<li><a href="about">About Us</a></li>
					<li><a href="contact">Contact Us</a></li>
				</sec:authorize>


				<sec:authorize access="isAuthenticated()">

					<sec:authorize access="hasRole('Member')">
						<li><a href="meals">Order Meals</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('Partner')">
						<!-- <li><a href="meals_mng">Meals Management</a></li> -->
						<li><a href="meals">Meal Management</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('Volunteer')">
						<li><a href="volunteer">Rider Task</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('Administrator')">
						<li><a href="delivery">Delivery</a></li>
						<li><a href="users">User Management</a></li>
					</sec:authorize>


					<!-- /logout must be a POST request, as csrf is enabled.
			        This ensures that log out requires a CSRF token and that a malicious user cannot forcibly log out your users.-->

					<li>
						<form action="logout" method="post" style="padding: 7px;">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" name="Logout"
								value="Logout" class="btn btn-primary"></input>
						</form>
					</li>
				</sec:authorize>




			</ul>
		</div>
	</div>
</nav>
