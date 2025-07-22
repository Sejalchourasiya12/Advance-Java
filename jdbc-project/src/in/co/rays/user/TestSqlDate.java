package in.co.rays.user;

import java.util.Date;

public class TestSqlDate {
	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println(d);
		
		System.out.println(d.getTime());
		java.sql.Date dsql = new java.sql.Date(d.getTime());
		System.out.println(dsql);
		
		
	}

}
