package com.medinet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccessDB {

	static private AccessDB instance;
	private AccessDB(){}
	public static AccessDB getInstance()
	{
		instance = new AccessDB();
		return instance;
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/MusQL_test","root","root");
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return conn;
	}
}
