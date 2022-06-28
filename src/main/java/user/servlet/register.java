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
 * Servlet implementation class register
 */
@WebServlet("/user/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogWebService ser;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        ser = new BlogWebService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Register
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Process Register = true/false
		BlogAccount account = new BlogAccount(request.getParameter("username"),request.getParameter("password"), request.getParameter("email"));
		if(account.getUsername()!=null&&account.getPassword()!=null&&account.getEmail()!=null) {
			if(ser.findAccount(account.getUsername())==null) {
				ser.addAccount(account);
				request.getRequestDispatcher("/WEB-INF/views/registerSuscess.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/views/registerFaild.jsp").forward(request, response);
			}	
		}
	}

}
