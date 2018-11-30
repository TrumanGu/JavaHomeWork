package model;

import java.io.Reader;
import java.sql.*;

public class JDBC  {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://193.112.95.49:3306/eleme?useUnicode=true&characterEncoding=utf-8";
   static final String USER = "eleme";
   static final String PASS = "123123";
   static Connection conn = null;
   static Statement stmt = null;

	    public static JDBC singleton = null;
	    public JDBC(){
	    	try {
	  	      System.out.println("Connecting to database...");
				Class.forName("com.mysql.jdbc.Driver");
		    	conn  = DriverManager.getConnection(DB_URL,USER,PASS);
		    	stmt = conn.createStatement();
		  	      System.out.println("Connect successful");

			} catch (ClassNotFoundException |SQLException  e) {
				e.printStackTrace();
			} 
	    }
	    public static JDBC getSingleton() {
	        if(singleton == null) singleton = new JDBC();
	        return singleton;
	    }
   public static ResultSet query(String statement){
	   try{
	      ResultSet rs = stmt.executeQuery(statement);
	      return rs;
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }
	return null;
	 
   }
      
   public static int update(String statement){
	  
	   try{
	 

	      System.out.println("Creating statement...");
	           
	      int rs = stmt.executeUpdate(statement);
	      return rs;
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
//	   finally{
//	      //finally block used to close resources
//	      try{
//	         if(stmt!=null)
//	            stmt.close();
//	      }catch(SQLException se2){
//	      }// nothing we can do
//	      try{
//	         if(conn!=null)
//	            conn.close();
//	      }catch(SQLException se){
//	         se.printStackTrace();
//	      }//end finally try
//	   }//end try
	return 0;
	 
   }

   
}
