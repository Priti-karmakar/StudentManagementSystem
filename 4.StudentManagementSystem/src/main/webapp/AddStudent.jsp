<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Student</title>
	<%@include file="allCss.jsp" %>
</head>
<body class="bg-light">

	<%@include file="NavBar.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card m-2">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student</p>
						
						<form action="register" method="post">
						
						  <div class="mb-3">
						    <label class="form-label">Name</label>
						    <input type="text" class="form-control" name="name">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Date of Birth</label>
						    <input type="date" class="form-control"  name="dob">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Address</label>
						    <input type="text" class="form-control" name="addr">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Qualification</label>
						    <input type="text" class="form-control" name="qualification">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Email address</label>
						    <input type="email" class="form-control" name="email">
						  </div>
						  
						  <button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
	
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>