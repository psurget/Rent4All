package ca.qc.cgodin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.qc.cgodin.model.User;
import ca.qc.cgodin.model.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager u = new UserManager();
		boolean valid = u.IsValid(request.getParameter("email"),request.getParameter("pswd"));
		if(valid) {
			User account = u.getUserInfos(request.getParameter("email"));
			request.setAttribute("UserID",account.getUserID());
			RequestDispatcher rd = request.getRequestDispatcher("user_page.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("error_page.jsp");
			rd.forward(request, response);
		}
	}

}
