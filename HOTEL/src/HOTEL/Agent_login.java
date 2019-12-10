package HOTEL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agent_login {
	
	
	Scanner s=new Scanner(System.in);
	
     ConnectionManager con = new ConnectionManager();
     //for getting the connection
	public void login() throws SQLException, ClassNotFoundException {
		
		System.out.println("\n1.New Customer\n2.Already registered\n3.Back to homepage\n");
		int n=s.nextInt();
		if(n==1) {
			userinsert us=new userinsert();
			us.insertdata();
		}
		if(n==2) {
		System.out.println("Enter the username");
		String name=s.next();
		System.out.println("Enter the password");
		String pass=s.next();
		int flag=0;
		Statement st=con.getconnect().createStatement();
	
		
		ResultSet set1=st.executeQuery("select * from user_login"); 
		
		while(set1.next()) {
			//to display the values
			String name1=set1.getString(1);
			String pw1=set1.getString(2);
		
		if(name1.contentEquals(name)&& pw1.contentEquals(pass)) 
			flag=1;
		
	}
	if(flag==1) {
		System.out.println("welcome agent");
		Agent_login ag =new Agent_login();
	
		ag.option();
	}
	
	else {
		System.out.println("invalid");
	}
	Hotel_manag hm=new Hotel_manag();
	hm.choice();//moving to main page
	}
		else{return;}
	}
	public void option() throws ClassNotFoundException, SQLException {
	//here all of the functions are done
				System.out.println("\nEnter your choice\n1)BuySell\n2)View Product\n3)Logout");
				int num=s.nextInt();
				if(num==1)
				{//for getting the details from addproduct table
					Statement st1= con.getconnect().createStatement();

					ResultSet r=st1.executeQuery("select * from addproduct");

					while(r.next())//iterating the values of result
					{
						System.out.println("Product id\t-->\t " +r.getInt(1)+"\n"+"Product name\t-->\t "+r.getString(2)+"\n"+"Quantity\t-->\t"+r.getInt(3)+"\n"+"Price\t\t-->\t "+r.getInt(4)+" \n");
					}
					
					
					
					System.out.println("Enter the Product id you want to buy");
					int buy =s.nextInt();
					System.out.println("Quantity");
					int quan=s.nextInt();
					int pri,tot,qa;
					ResultSet resu=st1.executeQuery("select * from addproduct");
					while(resu.next()) {
						int id=resu.getInt(1);
						if(id==buy) {
							pri=resu.getInt(4);
							qa=resu.getInt(3);
							tot=pri*quan;
							System.out.println("Enter the option\n1)Take Away\n2)Home Delivery\n3)Table reservation");
							int option=s.nextInt();
							if(option==1) {
								System.out.println("cost-->"+tot);
							}
							else if(option==2) {
								tot=tot+50;;
								System.out.println("cost-->"+tot);
							}
							else if(option==3) {
								tot=tot+100;
								System.out.println("cost-->"+tot);
							}
							System.out.println("Enter 1 if you want to continue");
							int enter=s.nextInt();
							if(enter==1) {
								
								System.out.println("Your Bill");
								System.out.println("*******************************");
								System.out.println("Product id:    "+id+"Quantity:           "+qa+"Price:     "+pri);
								
								
								int ta=qa-quan;
								PreparedStatement sta=con.getconnect().prepareStatement("update addproduct set quantity=? where productid=?");
								sta.setInt(1, ta);
								sta.setInt(2,buy);
								sta.executeUpdate();
								
							}
							
						}
					}
					
					con.getconnect();
			
				}
				if(num==2) {
					Hotel_manag first1=new Hotel_manag();
					int i=1;
					System.out.println("List of products--->>");
					System.out.println("*******************************");
					Statement st1= con.getconnect().createStatement();

					ResultSet r=st1.executeQuery("select * from addproduct");//query to select the details of all students
					//objects returned from the query by repeatedly calling Statement
					System.out.println("Details-->");
					while(r.next())//iterating the values of result
					{
						System.out.println("Product details" +i);
						//for getting all of the details we want to increment value of i ie +i
						System.out.println("\tProduct id\t-->\t"+r.getInt(1)+"\n"+"\tProduct name\t-->\t"+r.getString(2)+"\n"+"\tQuantity\t-->\t"+r.getInt(3)+"\n"+"\tPrice\t\t-->\t"+r.getInt(4)+" \n");
						i++;
					}
					System.out.println("*******************************");
					}
					if(num==3) {
						return;
						
					}
	
					Agent_login ag=new Agent_login();
					ag.option();
	}
		
	}


