package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdateDynamic {
	
	public static void main(String[] args) throws Exception {
		
		//testUpdate1();
		testUpdate2();
		//testUpdate3();
		//testUpdate4();
	}

	public static void testUpdate2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollNo = ?, name = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

        pstmt.setInt(1, 9); 
        pstmt.setInt(2, 101);
        pstmt.setString(3, "Sheetal");
        pstmt.setInt(4, 38);
        pstmt.setInt(5, 112);
        pstmt.setInt(6, 20);

        int i = pstmt.executeUpdate();
        System.out.println("Data inserted: " + i);

        
    }
		
	

	public static void testUpdate1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollNo = 112, name = 'maya', physics = 11, chemistry = 11, maths = 11 where id = 4");
        int i = pstmt.executeUpdate();

        System.out.println("Data inserted: " + i);

        
    }
		
	}


