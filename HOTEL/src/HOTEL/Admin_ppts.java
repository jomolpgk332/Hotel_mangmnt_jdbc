package HOTEL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Admin_ppts {
	

	public void properties() throws SQLException, ClassNotFoundException {
		
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","");
		//for getting the connection	
		Scanner s=new Scanner(System.in);
			System.out.println("Enter your choice\n1)Add product\n2)View Products\n3)Remove Products\n4)Update Product\n5)Back to home page");
			int det=s.nextInt();
			switch(det)
			{
			case 1:
			System.out.println("Enter the Product Id");
			int pro_id=s.nextInt();
			System.out.println("Enter the Product Name");
			String pro_name=s.next();
			System.out.println("Enter the Quantity");
			int pro_quantity=s.nextInt();
			System.out.println("Enter the Price");
			int pro_price=s.nextInt();
			System.out.println("the product is added successfully");
			
				PreparedStatement st=con.prepareStatement("insert into addproduct(productid,productname,quantity,price) values(?,?,?,?)");
				//to add data into table
				st.setInt(1, pro_id);
				st.setString(2,pro_name);
				st.setInt(3, pro_quantity);
				st.setInt(4, pro_price);
				
				st.executeUpdate();//to update the table after entering details
				
				break;
			case 2:
				Statement s1=(Statement) con.createStatement();
				ResultSet set=s1.executeQuery("select * from addproduct"); 
				//for displaying all the details
				System.out.println("************DETAILS************");	
				while(set.next()) {
					//to display the values
					System.out.println("Product id\t-->"+set.getInt(1));
					System.out.println("Product name\t-->"+set.getString(2));
					System.out.println("Quantity\t-->" +set.getString(3));
					System.out.println("Price\t-->" +set.getString(4));
					System.out.println("*******************************");
				}
				break;
			case 3:
				System.out.println("Enter the product id to be deleted");
				int id=s.nextInt();
				PreparedStatement st1=con.prepareStatement("delete from addproduct where productid=?");
				//for deleeting the product
				st1.setInt(1,id);
				st1.executeUpdate();
				System.out.println("*********product is deleted***********");
				break;
			case 4:
				Admin_update upd =new Admin_update();
				upd.updatedata();//redirecting to update page
				break;
			case 5:
				System.out.println("Redirecting to home page...........");
				return;}
			Admin_ppts ad=new Admin_ppts();

				ad.properties();

	}
}
