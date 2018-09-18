package ca.qc.cgodin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.qc.cgodin.model.Annonce;
import ca.qc.cgodin.model.UserManager;

/**
 * Servlet implementation class AddAnnonceServlet
 */
@WebServlet("/AddAnnonceServlet")
public class AddAnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnnonceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String cat = request.getParameter("category");
		String desc = request.getParameter("description");
		Double amnt = Double.parseDouble(request.getParameter("amount"));
		int userId = Integer.parseInt(request.getParameter("userID"));
		
		//(int userID, String titre, String descr, Double amount, String category) 
		Annonce ann = new Annonce(userId, titre, desc, amnt, cat);
		try {
			UserManager db = new UserManager();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
