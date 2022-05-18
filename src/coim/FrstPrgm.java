package coim;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FrstPrgm {
	public static void main(String[] args) {
		String s="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testyantraproject";
		String user_name="root";
		String password="root";
		String query="Insert into employee values(3,'uday',7019680169)";
		try {
			//1.Load and Register Driver
			Class.forName(s);
			//2.Establish connection
			Connection connection= DriverManager.getConnection(url,user_name,password);
			//3.CREATE Statement
			Statement st= connection.createStatement();
			//4.Execute statement
			st.execute(query);
			//5.close
			connection.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
	}

}
