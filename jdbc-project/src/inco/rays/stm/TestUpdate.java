package inco.rays.stm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception{

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		
		Statement stmt = conn.createStatement();
          int i = stmt.executeUpdate("update emp set name = 'smght' where id =21");
          
          System.out.println("Data Update " +i);
	}



	}


