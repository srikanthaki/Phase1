package com.amazon.pages;

import java.sql.*;
import java.util.Scanner;
import java.net.URL;
import java.net.URLClassLoader;

public class Db{
	private static final String db = "jdbc:mysql://localhost:3306/Shopping";
	private static final String dbserver = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String pwd = "root";
	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	
	public static void main(String args[])  {
		Db d1 = new Db();
		d1.retrieveData();
		
	}		
		
		
	public void retrieveData() {
		String query1 = "Select * from items_tbl";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con=DriverManager.getConnection(db, user, pwd);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			while (rs.next()) {
				System.out.println("");
				System.out.printf("items_tbl: %s", rs.getString("items_model"));
			}
			
			
			}
		catch (SQLException e1) {e1.printStackTrace();
		}
		finally {
			try {
			con.close();
			stmt.close();
			rs.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
	
	