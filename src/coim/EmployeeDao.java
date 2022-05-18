package coim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
	public void saveEmployee(Employee employee) {
		String s="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testyantraproject";
		String user_name="root";
		String password="root";
		String query="Insert into employee values(?,?,?)";
		try {
			//1.Load and Register Driver
			Class.forName(s);
			//2.Establish connection
			Connection connection= DriverManager.getConnection(url,user_name,password);
			//3.CREATE Statement
			Statement st= connection.createStatement();
			//4.Execute statement
			PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setDouble(3, employee.getNum());
			
			
			preparedStatement.execute();
			
			//5.close
			connection.close();
System.out.println("data saved");
				
		}

		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void getEmployee(int id) {
		String s="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testyantraproject";
		String user_name="root";
		String password="root";
		String query="Select * from employee where id=?";
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
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
			}
		
		preparedStatement.execute();
			
			//5.close
			connection.close();
System.out.println("data saved");
				
		}

		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


}
