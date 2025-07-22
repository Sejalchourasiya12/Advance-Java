package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUserModel {

    public static void main(String[] args) throws Exception {
        addTest();
        updateTest();
        findByPkTest();
        findByLoginIdTest();
        deleteTest();
        searchTest();
    }

    public static void addTest() throws Exception {
        UserBean bean = new UserBean();
        bean.setFirstName("Alice");
        bean.setLastName("Wonderland");
        bean.setLoginId("alice@gmail.com");
        bean.setPassword("alice123");
        bean.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1995-06-15"));
        bean.setAddress("Fantasy Lane, Dream City");

        UserModel model = new UserModel();
        model.add(bean);
    }

    public static void updateTest() throws Exception {
        UserModel model = new UserModel();
        UserBean bean = model.findByLoginId("alice@gmail.com");
        if (bean != null) {
            bean.setFirstName("AliceUpdated");
            bean.setAddress("Updated Address, Dream City");
            model.update(bean);
        }
    }

    public static void findByPkTest() throws Exception {
        UserModel model = new UserModel();
        UserBean bean = model.findByPk(1); // Replace with valid ID
        if (bean != null) {
            System.out.println("Found by PK: " + bean.getFirstName() + " " + bean.getLastName());
        } else {
            System.out.println("User not found");
        }
    }

    public static void findByLoginIdTest() throws Exception {
        UserModel model = new UserModel();
        UserBean bean = model.findByLoginId("alice@gmail.com");
        if (bean != null) {
            System.out.println("Found by LoginId: " + bean.getFirstName() + " " + bean.getLastName());
        } else {
            System.out.println("User not found by LoginId");
        }
    }

    public static void deleteTest() throws Exception {
        UserModel model = new UserModel();
        UserBean bean = model.findByLoginId("alice@gmail.com");
        if (bean != null) {
            model.delete(bean.getId());
        }
    }

    public static void searchTest() throws Exception {
        UserModel model = new UserModel();
        UserBean searchBean = new UserBean();
        searchBean.setFirstName("Ali");

        List<UserBean> list = model.search(searchBean, 0, 0);
        for (UserBean bean : list) {
            System.out.println("Search Result: " + bean.getFirstName() + " " + bean.getLastName());
        }
    }
}
