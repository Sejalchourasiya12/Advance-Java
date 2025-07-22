package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.user.UserBean;


public class StudentModel {
	
	public Integer nextPk() throws  Exception {
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from student");
		
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
		
	
	public void add(StudentBean bean) throws Exception {
		int pk = nextPk();
		StudentBean exist = findByEmailId(bean.getEmail());
		if(exist != null) {
			throw new Exception("Email already exist");
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?, ?)");
		
		pstmt.setInt(1, pk );
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(5, bean.getGender());
		pstmt.setString(6, bean.getMobileNo());
		pstmt.setString(7, bean.getEmail());
		pstmt.setString(8, bean.getCollegeName());
		
		int i = pstmt.executeUpdate();
		System.out.println("Data inserted =>"  +i);
			
		}
	
	public void update(StudentBean bean) throws Exception {
		 int pk = nextPk();
		 StudentBean exist = findByEmailId(bean.getEmail());
			if(exist != null && exist.getId()== bean.getId()){
				throw new Exception("Email already exist");
			}
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("update student set id =?, first_name = ?, last_name = ?, dob = ?, gender = ?, mobile_no =  ?, email = ?, college_name = ?");
			pstmt.setInt(1, pk );
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getEmail());
			pstmt.setString(8, bean.getCollegeName());
			
			int i = pstmt.executeUpdate();
			System.out.println("Data Updated =>"  +i);
				
			}
	
	public void delete(int id)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		 
		 PreparedStatement pstmt = conn.prepareStatement("delete from student where id = ? ");
		 pstmt.setInt(1, id);
         int i = pstmt.executeUpdate();
         System.out.println("Data Deleted => " +i);
		
	}
	public StudentBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from student where id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		StudentBean bean = null;
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getDate(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			System.out.println(rs.getString(8));
			
			}
		
		
		return bean;
		
	}
	
	public StudentBean findByEmailId(String emailId) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from student where emai_id = ?");
		pstmt.setString(1, emailId);
		ResultSet rs = pstmt.executeQuery();
		StudentBean bean = null;
		

		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getDate(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			System.out.println(rs.getString(8));
			
			}
		
		
		return bean;
		
	}
	public List search(StudentBean bean, int pageSize, int pageNo) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
		if(bean != null) {
			if(bean.getFirstName() != null && bean.getFirstName().length()>0) {
				sql.append("and First_Name like' " +bean.getFirstName() + "%'");
				
				
			}
		}
		
		if(pageSize>0) {
			pageNo = (pageNo-1)*pageSize;
			sql.append("limit " +pageNo +", " +pageSize);
		}
		
		System.out.println("sql => " +sql);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollegeName(rs.getString(8));
			list.add(bean);
		}

		
		
		return list;
		

		
		
	}
	
		
	}


