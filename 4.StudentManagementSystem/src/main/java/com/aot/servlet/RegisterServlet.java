package com.aot.servlet;

import java.io.IOException;
import com.aot.bean.Student;
import com.aot.dao.StudentDAO;
import com.aot.factory.DbCon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest hreq,HttpServletResponse hres) throws IOException,ServletException {
		
		String name=hreq.getParameter("name");
		String dob=hreq.getParameter("dob");
		String addr=hreq.getParameter("addr");
		String qualification=hreq.getParameter("qualification");
		String email=hreq.getParameter("email");
		
		Student s=new Student(name,dob,addr,qualification,email);
		
		StudentDAO dao=new StudentDAO(DbCon.getConnection());
		
		HttpSession session=hreq.getSession();
		
		boolean f=dao.addStudent(s);
		
		if(f==true) {
			session.setAttribute("succMsg","Student details submitted successfully..");
			hres.sendRedirect("AddStudent.jsp");
		}else {
			session.setAttribute("errorMsg","Student details not submitted...Try again!");
			hres.sendRedirect("AddStudent.jsp");
			System.out.println("Student details not submitted...Try again!!");
		}
		
		System.out.print(s);
		
	}
}
