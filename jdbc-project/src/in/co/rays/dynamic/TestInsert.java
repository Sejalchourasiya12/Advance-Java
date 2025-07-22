package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {

    public static void main(String[] args) throws Exception {
        
        // testInsert1();
        // testInsert2();
        //testInsert3(10, 108, "Rohit", 76, 89, 91); 
    	
    	
    	MarksheetBean bean = new MarksheetBean();
    	
    	
    	bean.setId(9);
    	bean.setRollNo(101);
    	bean.setName("priya");
    	bean.setPhysics(98);
    	bean.setChemistry(55);
    	bean.setMaths(88);
    	
    	
    	testInsert4(bean);
    }

   

	public static void testInsert1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(8, 107, 'Shreya', 98, 25, 50)");
        int i = pstmt.executeUpdate();

        System.out.println("Data inserted: " + i);

        
    }

    public static void testInsert2() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

        pstmt.setInt(1, 9); 
        pstmt.setInt(2, 101);
        pstmt.setString(3, "Sheetal");
        pstmt.setInt(4, 38);
        pstmt.setInt(5, 112);
        pstmt.setInt(6, 20);

        int i = pstmt.executeUpdate();
        System.out.println("Data inserted: " + i);

        
    }

    public static void testInsert3(int id, int rollNo, String name, int physics, int chemistry, int maths) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

        pstmt.setInt(1, id);
        pstmt.setInt(2, rollNo);
        pstmt.setString(3, name);
        pstmt.setInt(4, physics);
        pstmt.setInt(5, chemistry);
        pstmt.setInt(6, maths);

        int i = pstmt.executeUpdate();
        System.out.println("Data inserted: " + i);

        
    }
    public static void testInsert4(MarksheetBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");
        
        pstmt.setInt(1, TestNextPk.getNextPk());
        pstmt.setInt(2, bean.getRollNo());
        pstmt.setString(3, bean.getName());
        pstmt.setInt(4, bean.getPhysics());
        pstmt.setInt(5, bean.getChemistry());
        pstmt.setInt(6, bean.getMaths());
        
        int i = pstmt.executeUpdate();
        System.out.println("Data inserted: " + i);
        
        

		
		
   	}
    
    
}
