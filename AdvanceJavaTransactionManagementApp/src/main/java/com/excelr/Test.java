package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		
		Connection con=null;
		try
		{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "saiDATABASE123");
			  Statement s = con.createStatement();
			  con.setAutoCommit(false);
			  s.executeUpdate("insert into java3_5pm values (501,'sandeep',56)");
			  s.executeUpdate("insert into java3_5pm values (502,'sangeetha',66)");
			  s.executeUpdate("insert into java3_5pm values (503,'saraswathi',76)");
			  s.executeUpdate("delete from java3_5pm where sno=503");//this statement is false eventhough above statements are correct,the whole data is not inserted because one opeeation is not done
			  con.commit();
			  System.out.println("Transaction successful");
			  con.close();
		}
		catch(Exception  e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			System.out.println("Transaction failed");
		}
	}
}
