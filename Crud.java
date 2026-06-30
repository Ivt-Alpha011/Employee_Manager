package tech.codehunt.crud;
import tech.codehunt.dto.*;
import tech.codehunt.crud.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {
public Crud() {
	createTable();
}
public void createTable() {
	Connection connection=null;
	Statement statement=null;
	try {
		connection=ConnectionFactory.getConnection();
		String sql="CREATE TABLE IF NOT EXISTS employee(sn INT AUTO_INCREMENT PRIMARY KEY,"+"USERNAME varchar(30) NOT NULL UNIQUE,"+"PASSWORD varchar(30),"+"FULLNAME varchar(100),"+"ADDRESS varchar(200),"+"SALARY int)";
		statement=connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("TABLE CREATED");
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}
}
public void insert(EmployeeDTO employeeDTO) {
	Connection connection=null;
	Statement statement=null;
	try {
		String sql="insert into employee(username,password,fullname,address,salary)"+"values('"+employeeDTO.getUsername()+"','"+employeeDTO.getPassword()+"','"+employeeDTO.getFullname()+"','"+employeeDTO.getAddress()+"',"+employeeDTO.getSalary()+")";
		connection=ConnectionFactory.getConnection();
		statement=connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("DATA INSERTED");
		}
	catch(SQLException e) {
		e.printStackTrace();
		
	}
	finally{
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}
}
public void read(String username,String password) {
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	try {
		String sql="select * from employee where username='"+username+"' and password='"+password+"'";
		connection=ConnectionFactory.getConnection();
		statement=connection.createStatement();
		resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			int getSn=resultSet.getInt("sn");
			String getUsername=resultSet.getString("username");
			String getPassword=resultSet.getString("password");
			String getFullname=resultSet.getString("fullname");
			int getSalary=resultSet.getInt("salary");
			System.out.println("SN: " + getSn);
			System.out.println("USERNAME: "+getUsername);
			System.out.println("PASSWORD: "+getPassword);
			System.out.println("FULLNAME: "+getFullname);
			System.out.println("Salary: "+getSalary);
			
		}
		else {
			System.out.println("USER NOT FOUND");
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.close(resultSet);
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}
}
public void update(String username,int salary) {
	Connection connection=null;
	Statement statement=null;
	try {
		String sql="update employee set salary="+ salary +" where username='"+ username+"'";
		 connection=ConnectionFactory.getConnection();
		 statement=connection.createStatement();
		int executeUpdate=statement.executeUpdate(sql);
		if(executeUpdate>0)
		{
			System.out.println("DATA UPDATED");
		}
		else
			System.out.println("DATA NOT FOUND");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}
}
public void delete(String username)
{
	Connection connection=null;
	Statement statement=null;
	try {
		
		String sql="delete from employee where username='"+ username+"'";
		connection=ConnectionFactory.getConnection();
		statement=connection.createStatement();
		int executeUpdate=statement.executeUpdate(sql);
		if(executeUpdate>0)
		{
			System.out.println("DATA DELETED");
		}
		else
		{
			System.out.println("USER NOT FOUND");
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}
}
}
