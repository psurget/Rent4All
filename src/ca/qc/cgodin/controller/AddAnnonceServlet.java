package ca.qc.cgodin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import ca.qc.cgodin.model.AnnManager;
import ca.qc.cgodin.model.Annonce;
import ca.qc.cgodin.model.UserManager;

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
		int userId = Integer.parseInt(request.getParameter("userId"));
		String titre = request.getParameter("titre");
		String cat = request.getParameter("category");
		String desc = request.getParameter("description");
		Double amnt = Double.parseDouble(request.getParameter("amount"));
		AnnManager AnnMan = new AnnManager();
		try {		
			Annonce ann = new Annonce();
			ann.setUserID(userId);
			ann.setTitre(titre);
			ann.setCategory(cat);
			ann.setDescription(desc);
			ann.setAmount(amnt);
					
			AnnMan.addAnnonce(ann);
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		
	}

}
