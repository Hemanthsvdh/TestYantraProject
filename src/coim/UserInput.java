package coim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		String s="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testyantraproject";
		String user_name="root";
		String password="root";
		String query="Insert into employee values(?,?,?)";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter phone");
		double num=sc.nextDouble();
try {
			//1.Load and Register Driver
			Class.forName(s);
			//2.Establish connection
			Connection connection= DriverManager.getConnection(url,user_name,password);
			//3.CREATE Statement
			Statement st= connection.createStatement();
			//4.Execute statement
			PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, num);
			
			
			preparedStatement.execute();
			
			//5.close
			connection.close();
		}

		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
System.out.println("data saved");
				
	}

}
