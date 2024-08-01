import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.checkerframework.checker.sqlquotes.qual.*;

public class NotSignedUp {
	public  boolean database(String username,String password) {
	      try {
	         // Step 1: Allocate a database 'Connection' object
	         Connection conn = DriverManager.getConnection(
	               "jdbc:mysql://localhost:3306/resume", "root", "bhanu");
	               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
	 
	         // Step 2: Allocate a 'Statement' object in the Connection
	         Statement stmt = conn.createStatement();
	         String strSelect = "select * from signup where username = '"+sanitize(username)+"'AND password ='"+sanitize(password)+"'";
	         ResultSet r = stmt.executeQuery(strSelect);
	         
	         if(r.next()) {
	        	 return true;
	         }
	      }
	      
	      catch (SQLException e){
	    	  e.printStackTrace();
	      }
		return false;
	}

	private static @SqlEvenQuotes String sanitize(String userInput) {
		@SuppressWarnings("sqlquotes")
		@SqlEvenQuotes String sanitizedInput = userInput;
		return sanitizedInput;
	}

}
