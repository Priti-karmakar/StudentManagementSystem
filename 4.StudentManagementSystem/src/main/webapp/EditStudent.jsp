<%@page import="com.aot.bean.Student"%>
<%@page import="com.aot.factory.DbCon"%>
<%@page import="com.aot.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Student</title>
	<%@include file="allCss.jsp" %>
</head>
<body class="bg-light">

	<%@include file="NavBar.jsp" %>
	
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>
						
						<%int id=Integer.parseInt(request.getParameter("id")); 
						   StudentDAO dao=new StudentDAO(DbCon.getConnection());
						   Student s=dao.selectStudentById(id);
						   
						%>
						
						<form action="edit" method="post">
						
						  <div class="mb-3">
						    <label class="form-label">Name</label>
						    <input type="text" value="<%=s.getName() %>" class="form-control" name="name">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Date of Birth</label>
						    <input type="date" value="<%=s.getDob() %>" class="form-control"  name="dob">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Address</label>
						    <input type="text" value="<%=s.getAddress() %>" class="form-control" name="addr">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Qualification</label>
						    <input type="text" value="<%=s.getQualification() %>" class="form-control" name="qualification">
						  </div>
						  
						  <div class="mb-3">
						    <label class="form-label">Email address</label>
						    <input type="email"  value="<%=s.getEmail() %>" class="form-control" name="email">
						  </div>
						  
						  <input type="hidden" name="id" value="<%=s.getId() %>">
						  
						  <button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
	
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>