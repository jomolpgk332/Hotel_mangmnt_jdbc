package HOTEL;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



	public class ConnectionManager {

	public java.sql.Connection getconnect() throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=null;
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","");
			if(con!=null)//connection checking 
			{
				return con;
			}
			else {
				System.out.println("check connection");
				return null;
			}
			
		}



	

	}