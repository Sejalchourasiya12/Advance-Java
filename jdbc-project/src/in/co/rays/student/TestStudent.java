package in.co.rays.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestStudent {
	public static void main(String[] args) throws Exception {
		//testNextPk();
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		//testFindByEmailId();
		testFindBySearch();
				
		
	}


    public static void testFindBySearch() throws Exception {
    	
		StudentModel model = new StudentModel();
		StudentBean bean =  new StudentBean();
		
		//bean.setEmail(email);
		//model.search(null, 5, 1);
		List list = model.search(null, 5, 1); 
		if(list.size()>0) {
			System.out.println(list);
		}
		
	}


	public static void testNextPk() throws  Exception {
		StudentModel model = new StudentModel();
		int pk = model.nextPk();
		System.out.println("Next PrimaryKey " +pk);
		
		
		
	}
	public static void testAdd() throws Exception{
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		bean.setId(1);
		bean.setFirstName("Sejal");
		bean.setLastName("Chourasiya");
		bean.setDob(sdf.parse("22-12-2000"));
		bean.setGender("female");
		bean.setMobileNo("8319070800");
		bean.setEmail("sejal@gmail.com");
		bean.setCollegeName("Acropolis");
		
		StudentModel model = new StudentModel();
		model.add(bean);
		
	}
	public static void testUpdate() throws Exception {
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		
		bean.setId(1);
		bean.setFirstName("Sejal");
		bean.setLastName("Chourasiya");
		bean.setDob(sdf.parse("22-12-2000"));
		bean.setGender("female");
		bean.setMobileNo("982359388");
		bean.setEmail("sejal@gmail.com");
		bean.setCollegeName("Acropolis");
		
		StudentModel model = new StudentModel();
		model.update(bean);
		
	}
	
	public static void testDelete() throws Exception {
		StudentModel model = new  StudentModel();
		model.delete(3);
		
	}
	
	
	
	public static void testFindByPk() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean = model.findByPk(1);
		
		if(bean != null) {
			System.out.println(bean.getId());
			System.out.println("\t" +bean.getFirstName());
			System.out.println("\t" +bean.getLastName());
			System.out.println("\t" +bean.getDob());
			System.out.println("\t" +bean.getGender());
			System.out.println("\t" +bean.getMobileNo());
			System.out.println("\t" +bean.getEmail());
			System.out.println("\t" +bean.getCollegeName());
		}else {
			System.out.println("Student id doesn't exists");
		}

			
		}
     public static void testFindByEmailId() {
		
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		
		if(bean != null) {
			System.out.println(bean.getId());
			System.out.println("\t" +bean.getFirstName());
			System.out.println("\t" +bean.getLastName());
			System.out.println("\t" +bean.getDob());
			System.out.println("\t" +bean.getGender());
			System.out.println("\t" +bean.getMobileNo());
			System.out.println("\t" +bean.getEmail());
			System.out.println("\t" +bean.getCollegeName());
		}else {
			System.out.println("Student Emailid doesn't exists");
		}
	
		
	}
	


}
