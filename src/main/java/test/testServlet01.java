package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.entity.BlogUser;
import blog.dao.BlogUserDao;
/**
 * Servlet implementation class testServlet01
 */
@WebServlet("/testServlet01")
public class testServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(request, response);
		BlogUserDao userdao = new BlogUserDao();
		BlogUser user = userdao.findOne(1);
//		System.out.println(user.getUserId());
//		System.out.println(user.getName());
//		System.out.println(user.getEmail());
//		request.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(request, response);
		request.setAttribute("id", user.getUserId());
		request.setAttribute("name", user.getName());
		request.setAttribute("email", user.getEmail());
		request.getRequestDispatcher("/WEB-INF/views/testServlet01.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
