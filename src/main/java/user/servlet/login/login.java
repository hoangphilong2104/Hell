package user.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.entity.BlogAccount;
import blog.service.BlogWebService;

/**
 * Servlet implementation class login
 */
@WebServlet("/user/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogWebService ser;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		ser = new BlogWebService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Login
		int istrue = 0;
		request.setAttribute("istrue", istrue);
		request.getRequestDispatcher("/WEB-INF/views/users/login/loginUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// process Login = true/false
		if (request.getParameter("username") != null && request.getParameter("password") != null) {
			BlogAccount account = new BlogAccount(request.getParameter("username"), request.getParameter("password"),
					"");
			if (ser.findAccount(account.getUsername(), account.getPassword()) == null) {
				int istrue = 1;
				request.setAttribute("istrue", istrue);
				request.getRequestDispatcher("/WEB-INF/views/users/login/loginUser.jsp").forward(request, response);
			} else {
				account = ser.findAccount(request.getParameter("username"), request.getParameter("password"));
				request.setAttribute("email", account.getEmail());
				request.getRequestDispatcher("/WEB-INF/views/users/login/loginSuscess.jsp").forward(request, response);
			}
		}
	}

}
