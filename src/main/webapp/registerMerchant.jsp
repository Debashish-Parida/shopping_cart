<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Sign-Up</title>
<%@ include file="components/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="components/navbar.jsp" %>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Register Merchant</p>
						<form action="register_merchant" method="post">
						<p class="text-success text-center fs-5"> ${registered }</p>
						<div class="mb-3">
								<label class="form-label">Name</label> <input
									name="name" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Shop Name</label> <input
									name="shopName" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input
									name="address" type="text" class="form-control" required>
							</div>
							
							<input type="hidden" name="status" value="active">
							
							<button type="submit" class="btn bg-success text-white col-md-12">Sign Up</button>
							
							<br>
							<br>
							<p class="text-success text-center fs-6">Already registered then <a href="loginMerchant.jsp"> Login</a> </p>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>