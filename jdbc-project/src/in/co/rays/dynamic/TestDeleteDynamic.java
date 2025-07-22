package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDeleteDynamic {
	
	public static void main(String[] args) throws Exception {
		//testDelete1();
		//testDelete2();
		testDelete3(4);
		
	}
        public static void testDelete1() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = 9");
        int i = pstmt.executeUpdate();

        System.out.println("Data Deleted: " + i);
        

        
    }
	public static void testDelete2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
        pstmt.setInt(1, 7);
        int i = pstmt.executeUpdate();

        System.out.println("Data Deleted: " + i);
		
	}
	
	public static void testDelete3(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
        pstmt.setInt(1, id);
        int i = pstmt.executeUpdate();

        System.out.println("Data Deleted: " + i);
		
	
		
	}
		
	}


