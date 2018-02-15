package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.DAO.Topic;
import fr.acceis.forum.Service.UtilisateurService;

@SuppressWarnings("serial")
public class VisualiserTopicServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String idCourant = req.getParameter("id");
		long id = Long.parseLong(idCourant);
		
		UtilisateurService utilisateurService = new UtilisateurService();
		Topic topic = utilisateurService.recupererTopic(id);
		
		req.setAttribute("topic",topic);
		System.out.println("Topic, id < " +id+ " > auteur < "+topic.getAuteur().getLogin()+" >");
		req.getRequestDispatcher("/WEB-INF/jsp/thread.jsp").forward(req, resp);
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
	}
	
}
