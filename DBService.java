package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBService
{
	private static Connection con;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/polling";
			String user="root";
			String password="gipmr";
			con=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			System.err.println("Connection Error:"+e.getMessage());
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
	public static int updateData(String sql)
	{
		try
		{
			Statement st=con.createStatement();
			int ur=st.executeUpdate(sql);
			return ur;
		}
		catch(Exception e)
		{
			System.err.println("Update error:"+e.getMessage());
			return 0;
		}
	}
	public static ResultSet selectData(String sql)
	{
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			return rs;
		}
		catch(Exception e)
		{
			System.err.println("Select error:"+e.getMessage());
			return null;
		}
	}

}			