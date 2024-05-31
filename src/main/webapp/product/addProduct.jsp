<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form - Add Product</title>
<%@ include file="../components/allcss.jsp"  %>
</head>
<body>
<%@ include file="../components/navbar.jsp" %>


<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						
						<p class="fs-4 text-center">Add Product</p>
						
						<form action="register_product" method="post">
						<p class="text-success text-center fs-5"> ${success}</p>
						<div class="mb-3">
								<label class="form-label">Name</label> <input
									name="name" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Price</label> <input
									name="price" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Category</label> <input
									name="category" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Quantity Left</label> <input
									name="stockLeft" type="text" class="form-control" required>
							</div>
							
							
							<%int id=(int)session.getAttribute("merchantObj"); %>
							<input type="hidden" name="m_id" value="<%=id%>">
				
							
							
							
							<button type="submit" class="btn bg-success text-white col-md-12">Add</button>
							
							
							
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>