package coim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class RetrivingData {
	public static void main(String[] args) {
		String s="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testyantraproject";
		String user_name="root";
		String password="root";
		String query="Select * from employee";
		try {
			//1.Load and Register Driver
			Class.forName(s);
			//2.Establish connection
			Connection connection= DriverManager.getConnection(url,user_name,password);
			//3.CREATE Statement
			Statement st= connection.createStatement();
			//4.Execute statement
			ResultSet result=st.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
				System.out.println(result.getDouble(3));
			}
			
			//5.close
			connection.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
	}

}
