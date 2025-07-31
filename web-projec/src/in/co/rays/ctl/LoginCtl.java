package in.co.rays.ctl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if(op!=null && op.equalsIgnoreCase("logout") ) {
			HttpSession session = req.getSession();
			session.invalidate();
			req.setAttribute("success", "Logout successfully ");
		}
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String op = req.getParameter("operation");
		UserModel model = new UserModel();

		if (op.equalsIgnoreCase("signIn")) {
			System.out.println("login Id: " + loginId);
			System.out.println("password: " + password);
			try {
				UserBean bean = model.authenticate(loginId, password);
				if (bean != null) {
					HttpSession session = req.getSession();
					session.setAttribute("user", bean);
					RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
					rd.forward(req, resp);
				} else {
					req.setAttribute("error", "login id does not Exist");
					RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
					rd.forward(req, resp);

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (op.equalsIgnoreCase("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
			return;
		}
	}
}
