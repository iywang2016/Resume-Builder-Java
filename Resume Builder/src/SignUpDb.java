import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.checkerframework.checker.sqlquotes.qual.*;

public class SignUpDb {
	
	public  void database(String fname,String username,String email,String phonenum,String password) {
	      try {
	         // Step 1: Allocate a database 'Connection' object
	         Connection conn = DriverManager.getConnection(
	               "jdbc:mysql://localhost:3306/resume", "root", "bhanu");
		        //example password - bhanu
	               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
	 
	         // Step 2: Allocate a 'Statement' object in the Connection
	         Statement stmt = conn.createStatement();
	         long phonenumber=Long.parseLong(phonenum);
	         String insert = "INSERT INTO signup(fullname, username, email, phone, password) values('"+sanitize(fname)+"','"+sanitize(username)+"','"+sanitize(email)+"','"+sanitize("" + phonenumber)+"','"+sanitize(password)+"')";
	         int count=stmt.executeUpdate(insert);
	         System.out.println(count);
	      }
	      
	      catch (SQLException e){
	    	  e.printStackTrace();
	      }
	}

	private static @SqlEvenQuotes String sanitize(String userInput) {
		@SuppressWarnings("sqlquotes")
		@SqlEvenQuotes String sanitizedInput = userInput;
		return sanitizedInput;
	}
}
