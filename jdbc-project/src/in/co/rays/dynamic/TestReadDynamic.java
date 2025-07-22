package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestReadDynamic {

	public static void main(String[] args) throws Exception {
		// testRead1();
		//testRead2();
		//testRead3(0,0, null, 0, 0, 0);
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(8);
		//bean.setRollNo(110);
		//bean.setName("suraj");
		//bean.setPhysics(55);
		//bean.setChemistry(85);
		//bean.setMaths(89);
		testRead4(bean);
		//testRead5(bean);
		//testRead6();
			
		
		
	}
        



	public static void testRead6(MarksheetBean bean,int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no = " + bean.getRollNo());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

		
	




	public static void testRead5(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		StringBuffer sql = new StringBuffer("select * from marksheet where 1 = 1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no = " + bean.getRollNo());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getPhysics() > 0) {
				sql.append(" and physics = " + bean.getPhysics());
			}
			if (bean.getChemistry() > 0) {
				sql.append(" and chemistry = " + bean.getChemistry());
			}
			if (bean.getMaths() > 0) {
				sql.append(" and maths = " + bean.getMaths());
			}
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}

        		
	




	public static void testRead2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
          //String sql = "select * from marksheet where 1 = 1";
		String sql = "select * from marksheet where id = 1";
		// String sql1 = "select * from marksheet where rollNo = 108";
		// String sql2 = "select * from marksheet where name = 'suma'";
		// String sql3 = "select * from marksheet where physics = 156";
		//String sql4 = "select * from marksheet where chemistry = 152";
		// String sql5 = "select * from marksheet where maths = 1";

		System.out.println("sql = >" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getInt(5));
			System.out.println(rs.getInt(6));
		}

	}

	public static void testRead1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {// ye check krega data h ya nhi next
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}
	public static void testRead3(int id, int rollNo, String name, int physics, int chemistry, int maths) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from marksheet ";
         
		if(id>0) {
			sql += " where id = " +id;
		}
		
		if(rollNo>0) {
			sql += " where rollNo =" +id;
		}
		if(name != null) {
			sql += " where name like =" +name +"%";
		}
		
		if(physics>0) {
			sql += " where physics =" +physics;
		}
		

		if(chemistry>0) {
			sql += " where chemistry =" +maths;
		}
		

		if(maths>0) {
			sql += " where maths =" +maths;
		}
		
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("sql===>"+ pstmt);
		
		while (rs.next()) {// ye check krega data h ya nhi next
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

		

}
	public static  void testRead4(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");		
	
	   String sql = "select * from marksheet ";
	   if(bean!=null) {
	   
	   if(bean.getId() >0) {
		   sql = sql+ "where id =" +bean.getId();
	   }
	   
	   if(bean.getRollNo()>0) {
		   sql = sql+ "where rollNo =" +bean.getRollNo();
	   }
	   
	   if(bean.getName()!=null) {
		  sql = sql+ "where name =" +bean.getName(); 
	   }
	   if(bean.getPhysics()>0) {
		   sql = sql+ "where physics =" +bean.getPhysics();
	   }
	   if(bean.getChemistry()>0) {
		   sql = sql+ "where chemistry =" +bean.getChemistry();
	   }
	   
	   if(bean.getMaths()>0) {
		   sql =  sql+ "where maths =" +bean.getMaths();
	   }
	   }
	   
	   System.out.println("sql =>" +sql);
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   
	  ResultSet rs =pstmt.executeQuery();
	  
	  while(rs.next()) {
		  System.out.println(rs.getInt(1));
		  System.out.println(rs.getInt(2));
		  System.out.println(rs.getString(3));
		  System.out.println(rs.getInt(4));
		  System.out.println(rs.getInt(5));
		  System.out.println(rs.getInt(6));
	  }
	   
	   
        }
	
	



}