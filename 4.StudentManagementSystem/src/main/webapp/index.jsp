<%@page import="com.aot.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.aot.dao.StudentDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.aot.factory.DbCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Management System</title>
	<%@include file="allCss.jsp" %>
</head>
<body class="bg-light">

	<%@include file="NavBar.jsp" %>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">
				<p class="text-center fs-1">All Student Details</p>
				<table class="table table-hover">
				  <thead>
				  
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Date of Birth</th>
				      <th scope="col">Address</th>
				      <th scope="col">Qualification</th>
				      <th scope="col">Email</th>
				      <th scope="col">Action</th>
				    </tr>
				    
				  </thead>
				  <tbody>
				  <% 
				  	StudentDAO dao=new StudentDAO(DbCon.getConnection());
				  	List<Student> li=dao.selectStudent();
				  	for(Student s:li){
				  %>
				    <tr>
				      <th scope="row"><%=s.getName() %></th>
				      <td><%=s.getDob() %></td>
				      <td><%=s.getAddress() %></td>
				      <td><%=s.getQualification() %></td>
				      <td><%=s.getEmail() %></td>
				      <td>
				      	<a href="EditStudent.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-success"><i class="bi bi-pen-fill"></i>Edit</a>
				      	<a href="delete?id=<%=s.getId()%>" class="btn btn-sm btn-danger ms-1"><i class="bi bi-trash-fill"></i>Delete</a>
				      </td>
				    </tr>
				    <%} %>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>