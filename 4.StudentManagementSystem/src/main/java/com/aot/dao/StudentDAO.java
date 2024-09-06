package com.aot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aot.bean.Student;

public class StudentDAO {
	private Connection con;
	
	private static final String INSERT_QUERY="INSERT INTO STUDENTDB VALUES(STUD_ID_SEQ.nextval,?,?,?,?,?)";
	private static final String UPDATE_QUERY="update STUDENTDB set name=?,dob=?,address=?,qualification=?,email_id=? where id=?";
	private static final String DELETE_QUERY="DELETE FROM STUDENTDB WHERE ID=?";
	private static final String SELECT_QUERY="Select * from studentdb";
	
	public StudentDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addStudent(Student s) {
		
		try {
			PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
			ps.setString(1, s.getName());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getQualification());
			ps.setString(5, s.getEmail());
			int count=ps.executeUpdate();
			if(count==1)
				return true;
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Student> selectStudent(){
		List<Student> li=new ArrayList<>();
		Student s=null;
		try {
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setQualification(rs.getString(5));
				s.setEmail(rs.getString(6));
				li.add(s);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	
	public boolean updateStudent(Student s) {
		try {
			PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, s.getName());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getQualification());
			ps.setString(5, s.getEmail());
			ps.setInt(6,s.getId());
			int count=ps.executeUpdate();
			if(count==1)
				return true;
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteStudent(int id) {
		try {
			PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
			ps.setInt(1,id);
			int count=ps.executeUpdate();
			if(count==1)
				return true;
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Student selectStudentById(int id){
		Student s=null;
		try {
//			System.out.println(id);
			PreparedStatement ps=con.prepareStatement("SELECT * FROM STUDENTDB WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setQualification(rs.getString(5));
				s.setEmail(rs.getString(6));
			}
//			System.out.println(s);
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println(s);
		return s;
	}
	
	
}
