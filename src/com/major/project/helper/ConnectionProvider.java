package com.major.project.helper;
import java.sql.*;
public class ConnectionProvider {
private static Connection con;
	public static Connection getConnection()
	{
		if(con==null) 
		{		
			try 
			{
				//Driver class
				
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
			
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Vishal_9982");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return con;
	}

}
