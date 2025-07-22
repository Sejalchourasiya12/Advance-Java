package inco.rays.stm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	

	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		Statement stmt = conn.createStatement();
          int i = stmt.executeUpdate("insert into marksheet values(7, 107, 'Sejal', 200, 100, 200)");
          
          System.out.println("Data insert " +i);
	}

}
