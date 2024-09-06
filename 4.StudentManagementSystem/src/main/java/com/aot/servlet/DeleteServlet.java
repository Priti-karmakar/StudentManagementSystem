package com.aot.servlet;

import java.io.IOException;
import com.aot.dao.StudentDAO;
import com.aot.factory.DbCon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest hreq,HttpServletResponse hres) throws IOException,ServletException {
		
		int id=Integer.parseInt(hreq.getParameter("id"));
		
		StudentDAO dao=new StudentDAO(DbCon.getConnection());
		
		HttpSession session=hreq.getSession();
		
		boolean f=dao.deleteStudent(id);
		
		if(f==true) {
			session.setAttribute("succMsg","Student details submitted successfully..");
			hres.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg","Student details not submitted...Try again!");
			hres.sendRedirect("index.jsp");
		}
		
	}
}
