package fr.acceis.forum.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.acceis.forum.DAO.Topic;
import fr.acceis.forum.Service.UtilisateurService;

@SuppressWarnings("serial")
public class AccueilServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/WEB-INF/jsp/threads.jsp").forward(req, resp);
		UtilisateurService utilisateurService = new UtilisateurService();
		try {
			System.out.println("==================================\n methode listerTopic\n ==================================\n");
			List<Topic> listeTopics = utilisateurService.listerTopic();
			req.setAttribute("topics", listeTopics);
			req.getRequestDispatcher("/WEB-INF/jsp/threads.jsp").forward(req, resp);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("==================================\n Catch exception de methode listerTopic\n ==================================\n");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}

}
