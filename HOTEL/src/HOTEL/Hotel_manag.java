package HOTEL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Hotel_manag {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("***********************************");
		System.out.println("\tHOTEL BLUEBERRY'S");
		System.out.println("************************************");
		Hotel_manag first=new Hotel_manag();
		first.choice();
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","");

	}

	public void choice() throws ClassNotFoundException, SQLException {
		
		Scanner s=new Scanner(System.in);
		System.out.println("\t1)Admin Login\n\t2)Agent Login\n\t3)Exit");
		System.out.println("Enter the choice");
		int n=s.nextInt();
		switch(n) {
		case 1:
			Admin_login login =new Admin_login();
			login.log();
			break;
			
		case 2:
			Agent_login ag =new Agent_login();
			ag.login();
			ag.option();
			break;
		case 3:
			return;
			
				
			
			
}
		}
	}


