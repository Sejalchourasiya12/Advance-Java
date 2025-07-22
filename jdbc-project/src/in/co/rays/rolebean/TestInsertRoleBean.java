package in.co.rays.rolebean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsertRoleBean {
	


	

	public static void main(String[] args) throws Exception {
		//testInsert1();
		//testInsert2();
		//testInsert3(7 , "seeya", "teacher");
		RoleBean bean = new RoleBean();
		bean.setId(9);
		bean.setName("suhana");
		bean.setDescription("I am good");
		
	
		testInsert4(bean);
	}


	public static void testInsert4(RoleBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("insert into role values(?, ?, ?)");
        pstmt.setInt(1, bean.getId());
        pstmt.setString(2, bean.getName());
        pstmt.setString(3, bean.getDescription());
       
        
        
        int i = pstmt.executeUpdate();
        System.out.println("data inserted= " +i);
        
		
	}


	public static void testInsert1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("insert into role values(5, 'audience', 'judge the show')");
		
		
	}

	public static void testInsert2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("insert into role values(?, ?, ?)");
        pstmt.setInt(1, 6);
        pstmt.setString(2, "shy");
        pstmt.setString(3, "description");
        
        
        int i = pstmt.executeUpdate();
        System.out.println("Data inserted => " +i);
	}

	public static void testInsert3(int id, String name, String description) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("insert into role values(?, ?, ?)");
        
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, description);
        
        int i = pstmt.executeUpdate();
        System.out.println("data inserted= " +i);
        
		
		
	}
	
	
	

}
