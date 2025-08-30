package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Sample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Get the connection with database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "saiDATABASE123");

        // Create static SQL queries using Statement interface
        Statement s = con.createStatement();////it is used for to create static Dml and DDl queries.

        ////create the table statically
       // String q = "CREATE TABLE `java3_5pm` (sno INT, sname VARCHAR(40), smarks INT)";
       
        ////insert the data statically
       // String q1="insert into java3_5pm values(102,'saisandeep',90)";
       // String q1="insert into java3_5pm values(103,'sai',89)";
       // String q1="insert into java3_5pm values(101,'sandeep',96)";
        
        ////update the data statically
        //String q1="update java3_5pm set sname='ravi' where sno=103";
       
        ////delete the data from the database
        //String q1="delete from java3_5pm where sno=101";
       
        // Execute the SQL queries
       // s.executeUpdate(q1);////it is used for to execute static DDl and DML queries.

        ////retrive the data from the database statically by using Resultset interface
       ResultSet res=s.executeQuery("select * from java3_5pm");//it is used to execute static DRL queries.
     /*  System.out.println(res);//it gives the ton string representation of object referenece
       
       while(res.next()) {//while loop is used for to check rows
    	   for(int i=1;i<=3;i++) {//forloop is used for to check columns
    		   System.out.print(res.getString(i)+"\t");
    	   }
    	   System.out.println();
       }*/
       
       ///get meta data to dynamically  get the number of columns
       ResultSetMetaData rsmd=res.getMetaData();
       
       ///print total n.o of columns
       int cc=rsmd.getColumnCount();
       System.out.println(cc);//2
       
       ///print the column names
       for(int i=1;i<=cc;i++) {
    	   System.out.print(rsmd.getColumnName(i)+"\t\t");
       }
       System.out.println();
       
       ///Iterate through ResultSet and print each record
       while(res.next()) {
    	   for(int i=1;i<=cc;i++) {
        	   System.out.print(res.getString(i)+"\t\t");
           }
    	   System.out.println();
       }
        // Close the connection
       res.close();
       s.close();
        con.close();
    }
}
