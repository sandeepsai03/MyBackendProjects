package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//1)loading the driver class
	Class.forName("com.mysql.jdbc.Driver");
	//2)get the connection
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","saiDATABASE123");
	//3)create statement
	Statement stmt=conn.createStatement();
	                         //4)execute the statement
//boolean result=stmt.execute("create table professor(pid int,pname varchar(30),psal int(5))");
	                         //inserting data into the database
//int inserted=stmt.executeUpdate("insert into professor values(324,'saisandeep',8000)");
	                         //fetch the data from database
//	ResultSet result1=stmt.executeQuery("select * from professor");
//	while(result1.next()) {
//		System.out.println(result1.getInt(1)+" "+result1.getString(2)+" "+result1.getInt(3));
//	}
	                         //update the data
//int updated=stmt.executeUpdate("update professor set pname='sandeepsai' where pid=123 ");
                             //delete the data in the database
	int deleted=stmt.executeUpdate("delete from professor where pid=123");
	//5)close the connection
	conn.close();
	//System.out.println("Table is created :"+result);
	//System.out.println("data is inserted :"+inserted);
    //System.out.println("data is updated :"+updated);
	System.out.println("data is deleted :"+deleted);
}
}
