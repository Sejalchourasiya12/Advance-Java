package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestNextPk {
	public static void main(String[] args) throws Exception {
		
		int pk = getNextPk();
		System.out.println(pk);
		
	}
	
	public static Integer getNextPk() throws Exception {
		int pk = 0;
		
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement("select max(id) from marksheet");
	        ResultSet rs= pstmt.executeQuery();
	        
	        while(rs.next()) {
	        	pk = rs.getInt(1)+1;
	        }
		//pk = pk+1;(ye b krskte h pk m value set krne k liye)
		
		
		return pk;
		
	}
	
	

}
