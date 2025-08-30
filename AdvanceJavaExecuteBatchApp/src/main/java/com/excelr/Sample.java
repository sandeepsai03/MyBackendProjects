package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {
	
public static void main(String[] args) {
	///try and catch blocks are the recomended way
    Connection con=null;
    
    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "saiDATABASE123");
		 Statement s = con.createStatement();
		 
		 ///If we execute group of statements at a time without executebatch() then group of requests hit the mysql at a time it leads to performance down.
		    ///to overcame this problem executebatch() came into the picture 
		    //executeBatch() wiil execute the group of statements at atime,and it will send only single request to mysql.
		    
		    s.addBatch("insert into java3_5pm values(401,'mahesh',67)");
		    s.addBatch("insert into java3_5pm values(402,'venky',87)");
		    s.addBatch("insert into java3_5pm values(403,'teja',77)");
		    
		    s.executeBatch();
	} 
    catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
 finally {///note:closing statements are mentioned inside the finally block
	   try {
		con.close();
	   } 
	   catch (SQLException e) {
		   
		e.printStackTrace();
	   }
 }

   
 
}
}
