package com.sms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sms.entity.Students;
public class StudentsDaoImpl implements StudentsDao {
	Connection con=null;
	java.sql.PreparedStatement pstmt;
	public StudentsDaoImpl() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	}

	@Override
	public boolean addStudents(Students stu) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Add Student details");
		try {
			pstmt=(PreparedStatement)con.prepareStatement("insert into studnts values(?,?,?,?,?)");
			pstmt.setInt(1, stu.getId());
			pstmt.setString(2, stu.getName());
			pstmt.setInt(3, stu.getAge());
			pstmt.setString(4, stu.getEmail());
			pstmt.setString(5, stu.getAddress());
			int i=pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}

	@Override
	public void getStudentsList() {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("select * from studnts");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
	}

	@Override
	public void updateStudentsByName(String name) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("update studnts set name='Updated' where email=?");
			pstmt.setString(1, name);
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("Name Updated");
			}else {
				System.out.println("Name not updated");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateStudentsByAge(int age) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("update studnts set age=44 where age=?");
			pstmt.setInt(1, age);
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("Age Updated");
			}else {
				System.out.println("Age not updated");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteStudentsById(int id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("delete from studnts where id=?");
			pstmt.setInt(1, id);
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("deleted");
			}else {
				System.out.println("not deleted");
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
	

}
