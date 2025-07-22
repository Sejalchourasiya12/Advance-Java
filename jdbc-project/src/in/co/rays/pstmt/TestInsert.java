package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		 
   Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into emp values(23, 'Sejal', 20000, 2)");
          int i = pstmt.executeUpdate();
          
          System.out.println("Data insert " +i);
	}


	}


