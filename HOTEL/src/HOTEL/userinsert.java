package HOTEL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userinsert {
	ConnectionManager con=new ConnectionManager();

public void insertdata() throws SQLException, ClassNotFoundException {

int i=1;
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String reg1 = "^[0-9]*$";
		Pattern regno = Pattern.compile(reg1);
		System.out.println("\nEnter your ID");
		int ID=s.nextInt();
		int flag=0;
		
		String regex= "[A-Z][a-z]*";
		//string regex-regular expression email validation code
		
		Pattern pswd= Pattern.compile("[a-z]*");
		//pattern pswd-regular expression password validation code
		
		Pattern pattern=Pattern.compile(regex);
			//Pattern -class  pattern-object for email
		
		System.out.println("Enter the username:( starting letter in upper case) ");
			String emails=s.next();//email inputting in string format
			Matcher email=pattern.matcher(emails);//checking if input matches email pattern
			System.out.println("Enter the password (should contain only small letters): ");
			String password=s.next();
			Matcher mtch=pswd.matcher(password);//checking if user entered password---->>
			//--->> matches password pattern
			
			if(email.matches())//matches-->stores result state of email
			{//here checking if stored result is true,if yes print valid
				System.out.println("*****VALID USER NAME*****");
			}
			else
			{
				System.out.println("###INVALID USER NAME###");flag=1;
			}
			if(mtch.matches())//matches-->stores result state of password
			{//here checking if stored result is true,if yes print valid
				System.out.println("*****VALID PASSWORD*****");
			}
			else
			{
				System.out.println("###INVALID PASSWORD###");flag=1;
			}
		if(flag==0) {
		PreparedStatement st=(PreparedStatement) con.getconnect().prepareStatement("insert into user_login(username,password) values(?,?)");
		//prepare statement
		//we are passing parameter (?) for the values. 
		//Its value will be set by calling the setter methods of PreparedStatement.
		st.setString(1, emails);
		st.setString(2, password);
		st.executeUpdate();//value will be updated to the database
		i++;
		con.getconnect().close();
		System.out.println("Data saved");
		}
		else {
			con.getconnect().close();
			System.out.println("Data not saved");	
		}
		Agent_login ag=new Agent_login();
		ag.option();
		
		//Returns an integer representing the number of rows affected by the SQL statement.
Hotel_manag first=new Hotel_manag();
first.choice();
}


}
