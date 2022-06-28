package user.servlet;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/loginUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlogAccount account = new BlogAccount(request.getParameter("username"),request.getParameter("password"), "");
		if(account.getUsername()!=null&&account.getPassword()!=null) {
			
		}
	}

}
