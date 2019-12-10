package HOTEL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Admin_login {
	Hotel_manag con=new Hotel_manag();
	public void log() throws SQLException, ClassNotFoundException {

			java.sql.Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the username");
			String name=s.next();//getting username from admin
			System.out.println("Enter the password");
			String pass=s.next();//getting password from admin
			int flag=0;
			Statement st=(Statement)con.createStatement();
			ResultSet set=st.executeQuery("select * from admin_login"); //to display all the details from admin table
			
			while(set.next()) {
				//to display the values
				String name1=set.getString(1);
				String pw1=set.getString(2);
			if(name1.contentEquals(name)&& pass.contentEquals(pw1)) 
				//for comparing the name and password
				flag=1;
			}
			if(flag==1) {
				System.out.println();
				System.out.println("Admin login successfull");
				System.out.println();
				System.out.println("****************************");
				Admin_ppts ad=new Admin_ppts();
				ad.properties();
			}
			else {
				System.out.println("invalid username or password");
			}
			Hotel_manag hm=new Hotel_manag();
			hm.choice();
	}
		
		}
