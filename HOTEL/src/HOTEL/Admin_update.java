package HOTEL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin_update {

	public void updatedata() throws ClassNotFoundException, SQLException {
		java.sql.Connection con22=null;
		con22=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the  Id to update");
		int id1=s.nextInt();
		System.out.println("Enter the new product id");
		int id=s.nextInt();
		System.out.println("Enter the new product name");
		String proname=s.next();
		System.out.println("Enter the new quantity");
		int  minsellquanty=s.nextInt();
		System.out.println("Enter the new price");
		int price=s.nextInt();
		PreparedStatement st=con22.prepareStatement("update addproduct set productid=?,proname=?,quantity=?,price=? where productid=?");
		//for updating the values that alredy exist
		st.setInt(1,id);
		st.setString(2, proname);
		st.setInt(3,minsellquanty );
		st.setInt(4,price);
		st.setInt(5,id1);
		st.executeUpdate();
		System.out.println("updated successfully");
		Hotel_manag first=new Hotel_manag();//moving to home page
		first.choice();
		
		
	}

}
